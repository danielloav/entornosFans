package main;

import modelo.modelo;
import vista.tabla;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tabla tabla = new tabla ();
		modelo modelo =new modelo();
		tabla.setmod(modelo);
		modelo.settabla(tabla);
		modelo.conectarse();
		tabla.setVisible(true);
	}

}
