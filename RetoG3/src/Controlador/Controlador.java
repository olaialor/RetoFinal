package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Modelo.Usuario;
import Modelo.Personaje;

public class Controlador implements Icontrolador {
    private Connection con;
    private PreparedStatement stmt;

    final String OBTENERusuario = "SELECT * FROM Usuario WHERE username=? AND password=?";
    
    private void openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/Sanrio?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Usuario logIn(String us, String pass) {
        ResultSet rs = null;
        Usuario u = null;
        // Abrimos la conexion
        this.openConnection();
        try {
            stmt = con.prepareStatement(OBTENERusuario);
            // Cargamos los parametros
            stmt.setString(1, us);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setUsername(us);
                u.setPassword(pass);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                this.closeConnection();
            } catch (SQLException e) {
                System.out.println("Error de SQL al cerrar la conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public Usuario SignUp(String username, int telefono, String direccion, String email, String nº_Cuenta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Personaje getPersonaje(int Codigo, String nombre, String descripcion, Date cumple, String curiosidad) {
        // TODO Auto-generated method stub
        return null;
    }
}