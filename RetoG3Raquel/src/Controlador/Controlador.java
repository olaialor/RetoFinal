package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;

public class Controlador {
	private Connection con;
	private PreparedStatement stmt;
	final String OBTENERusername = " SELECT username FROM Usuario ";
	final String OBTENERemail = " SELECT email FROM Usuario ";
	final String OBTENERtelefono = " SELECT telefono FROM Usuario ";
	
	


	private void openConnection() {
		try {
			// String url = "jdbc:mysql://localhost/nombreBaseDatos";
			String url = "jdbc:mysql://localhost:3306/Sanrio?serverTimezone=Europe/Madrid&useSSL=false";
			// con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
			con = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}
	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}
	
	
	// Métodos para verificar si el usuario, correo electrónico o teléfono ya existen en la base de datos
		public static boolean existeUsuario(String username) {
			return false;
		    // Lógica para verificar si el usuario ya existe en la base de datos
		    // Retorna true si el usuario ya existe, de lo contrario retorna false
		}

		public static boolean existeEmail(String email) {
			return false;
		    // Lógica para verificar si el correo electrónico ya existe en la base de datos
		    // Retorna true si el correo electrónico ya existe, de lo contrario retorna false
		}

		public static boolean existeTelefono(int telefono) {
			return false;
		    // Lógica para verificar si el teléfono ya existe en la base de datos
		    // Retorna true si el teléfono ya existe, de lo contrario retorna false
		}
		
	
}
