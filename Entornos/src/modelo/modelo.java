package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.tabla;

public class modelo {
	private tabla vista;
	private Connection conexion;
	private int resultado;
	private int usuariocodigo;
	
	public void settabla(tabla tab){
		this.vista=tab;
	}
	public void conectarse() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String mi_url = "jdbc:oracle:thin:@localhost:1521:XE";

			conexion = DriverManager.getConnection(mi_url, "SYSTEM", "merchan");
			System.out.println("exito en la conexión");
		} catch (SQLException e) {
			System.out.println("error en la conexión de la base de datos");

		} catch (ClassNotFoundException e) {
			System.out.println("error en la conexión");
		}

	}
	
	public void Insertabla(String dato) {
		resultado = 0;
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(dato);
		} catch (SQLException e) {
			System.out.println("Error Insertabla");
		}
	}
	public int tratarcodigo(String query) {
		try {
			this.usuariocodigo = 0;
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				usuariocodigo = usuariocodigo + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en contar filas para código");
		}
		return usuariocodigo;
	}
	public void btnanadir(String alumno, String nota, String modulo){
		int cod_al = tratarcodigo("select * from ENTORNOS.ALUMNO")+1;
		int cod_mod = tratarcodigo("select * from ENTORNOS.modulo")+1;
		Insertabla("Insert into ENTORNOS.alumno (COD_ALUMNO,nombre) values ("+cod_al+" , '"+alumno+"'");
		Insertabla("Insert into ENTORNOS.TIENE_ALUMNO (COD_AL_fk,NOTA_COD_MOD,nota) values ("+cod_al+" , '"+cod_mod+"','"+nota+"'");
		Insertabla("Insert into ENTORNOS.modulo (COD_MOD,nombre) values ("+cod_mod+" , '"+modulo+"'");

	}

}
