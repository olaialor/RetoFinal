package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Usuario;
import Modelo.Personaje;
import Modelo.Producto;

public class Controlador implements Icontrolador {
    private Connection con;
    private PreparedStatement stmt;

    final String OBTENERusuario = "SELECT * FROM Usuario WHERE username=? AND password=?";
    final String INNSERTuser = "INSERT INTO usuario VALUES (?,?,?,?,?)";
    final String INNSERTcliente = "INSERT INTO cliente VALUES (?, ?)";
    final String OBTENERusername = "SELECT COUNT(*) FROM usuario WHERE username = ?";
    final String OBTENERPersonajes = "SELECT * FROM personaje";
    final String OBTENERProductos = "SELECT * FROM producto";
    final String OBTENERNombrePersonaje = "Select nombre from personaje where codigo = ?";
    
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
            } catch (SQLException e) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
                e.printStackTrace();
            }
            this.closeConnection();
        }
        return u;
    }

    public boolean existeUsuario(String username) throws SQLException {
        ResultSet rs = null;
        boolean existe =false;
        this.openConnection();
        try {
            stmt = con.prepareStatement(OBTENERusername);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            this.closeConnection();
        }
        return existe;
    }

    @Override
    public boolean SignUp(Usuario user) {
        boolean introducido=false;
        this.openConnection();
        try {
            stmt = con.prepareStatement(INNSERTuser);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getN_telefono());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getDireccion());
            if (stmt.executeUpdate() > 0) {
                introducido=true;
                System.out.println("Usuario insertado correctamente");
            } else {
                System.out.println("Falló la inserción del usuario");
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL");
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return introducido;
    }

    @Override
    public List<Personaje> getPersonajes() {
        List<Personaje> listaPersonajes = new ArrayList<>();
        ResultSet rs = null;
        
        // Abrimos la conexión
        this.openConnection();
        
        try {
            stmt = con.prepareStatement(OBTENERPersonajes);
            rs = stmt.executeQuery();

            // Recorremos los resultados y creamos objetos Personaje
            while (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                Date cumpleaños = rs.getDate("Cumpleaños");
                String ruta_foto = rs.getString("ruta_foto");
                String curiosidad = rs.getString("Curiosidad");
                
                // Creamos el objeto Personaje y lo agregamos a la lista
                Personaje personaje = new Personaje(nombre, descripcion, cumpleaños, curiosidad, ruta_foto, codigo );
                listaPersonajes.add(personaje);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
                e.printStackTrace();
            }
            // Cerramos la conexión
            this.closeConnection();
        }
        
        return listaPersonajes;
    }
    @Override
	public List<Producto> getProducto() {
		// TODO Auto-generated method stub
		List<Producto> listaProducto = new ArrayList<>();
        ResultSet rs = null;
        
        // Abrimos la conexión
        this.openConnection();
        
        try {
            stmt = con.prepareStatement(OBTENERProductos);
            rs = stmt.executeQuery();

            // Recorremos los resultados y creamos objetos Personaje
            while (rs.next()) {
                int codigo = rs.getInt("Cod_producto");
                Double precio = rs.getDouble("Precio");
                String descripcion = rs.getString("Descrip_prod");
                int stock = rs.getInt("Stock");
                String ruta_foto = rs.getString("ruta_foto_prod");
                String nombre = rs.getString("Nombre");
                
               
                Producto producto = new Producto(nombre,codigo,precio, descripcion, stock, ruta_foto);
                listaProducto.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
                e.printStackTrace();
            }
            // Cerramos la conexión
            this.closeConnection();
        }
        
        return listaProducto;
	}

	@Override
	public String getNombre(int command) {
	    ResultSet rs = null;
	    
	    // Abrimos la conexión
	    this.openConnection();
	    
	    try {
	        // Preparamos la declaración SQL con el parámetro
	        stmt = con.prepareStatement(OBTENERNombrePersonaje);
	        stmt.setInt(1, command); // Setting the parameter
	        rs = stmt.executeQuery();

	        // Verificamos si hay un resultado y obtenemos el nombre
	        if (rs.next()) {
	            String nombre = rs.getString("nombre"); 
	            System.out.println(nombre);
	            return nombre;
	        } else {
	            // Handle the case where no result is found
	            return null;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error de SQL: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
	            e.printStackTrace();
	        }
	        // Cerramos la conexión
	        this.closeConnection();
	    }
	    return null;
	}

}