package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vista.tabla;

public class modelo {
	private tabla vista;
	private Connection conexion;
	
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
	
	public void btnanadir(String alumno, String nota, String modulo){
		
	}

}
