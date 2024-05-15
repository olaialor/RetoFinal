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
import Modelo.Cliente;
import Modelo.Personaje;
import Modelo.Producto;
import Modelo.Trabajador;

/**
 * Controlador para gestionar la conexión y operaciones con la base de datos.
 */
public class Controlador implements Icontrolador {
    private Connection conexion;
    private PreparedStatement sentencia;

    final String OBTENERusuario = "SELECT * FROM Usuario WHERE username=? AND password=?";
    final String INNSERTuser = "CALL InsertarUsuario(?, ?, ?, ?,?);";
    final String INNSERTcliente = "INSERT INTO cliente VALUES (?, ?)";
    final String OBTENERusername = "SELECT COUNT(*) FROM usuario WHERE username = ?";
    final String EXISTEusuario = "SELECT COUNT(*) AS existe FROM Usuario WHERE username = ?";
    final String OBTENERpersonaje = "SELECT COUNT(*) FROM Personaje WHERE nombre = ?";
    final String OBTENERPersonajes = "SELECT * FROM personaje";
    final String INNSERTpersonaje = "INSERT INTO personaje VALUES (?,?,?,?,?,?)";
    final String OBTENERnom_personajes = "SELECT nombre from Personaje";
    final String OBTENERNombrePersonaje = "Select nombre from personaje where codigo = ?";
    final String OBTENERProductos = "SELECT * FROM producto";
    final String INNSERTproducto = "INSERT INTO producto VALUES (?,?,?,?,?,?)";
    final String NUEVOCod_prod = "SELECT MAX(cod_producto) AS max_codigo FROM Producto";
    final String NUEVOCod_per = "SELECT MAX(codigo) AS max_codigo FROM Personaje";
    final String MODIFICARperfil = "UPDATE Usuario AS u JOIN Cliente AS c ON u.username = c.username SET u.password = ?, u.telefono = ?, u.email = ?, u.direccion = ?, c.num_cuenta = ? WHERE u.username = ?";
    final String USERSdata = "CALL UsersData(?,?)";
    final String EScliente = "SELECT COUNT(*) AS count FROM Usuario u JOIN Cliente c ON u.username = c.username WHERE u.username = (?);";
    final String MODIFICARperfiles = "UPDATE  Usuario u, Cliente c SET u.password=?, u.telefono=?, u.email=?, u.direccion=?, c.num_cuenta=? WHERE u.username=c.username AND u.username=?";
    final String ELIMINARUsuario = "CALL EliminarCliente(?);";

    /**
     * Abre la conexión con la base de datos de MySQL.
     */
    private void abrirConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/Sanrio?serverTimezone=Europe/Madrid&useSSL=false";
            conexion = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException error) {
            System.out.println("Error al intentar abrir la BD: " + error.getMessage());
            error.printStackTrace();
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     */
    private void cerrarConexion() {
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException error) {
            System.out.println("Error al intentar cerrar la conexión: " + error.getMessage());
            error.printStackTrace();
        }
    }

    /**
     * Inicia sesión en la aplicación.
     *
     * @param us   El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @return Un objeto Usuario si las credenciales son correctas, de lo contrario, null.
     */
    @Override
    public Usuario logIn(String us, String pass) {
        ResultSet resultado = null;
        Usuario usuario = null;
        ResultSet resultado1 = null;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(USERSdata);
            sentencia.setString(1, us);
            sentencia.setString(2, pass);
            resultado = sentencia.executeQuery();
            if (resultado.next() && resultado.getString(1) != null) {
                sentencia = conexion.prepareStatement(EScliente);
                sentencia.setString(1, us);
                resultado1 = sentencia.executeQuery();
                if (resultado1.next() && resultado1.getBoolean(1) == true) {
                    usuario = new Cliente(resultado.getString("username"), resultado.getString("password"),
                            Integer.parseInt(resultado.getString("telefono")), resultado.getString("direccion"),
                            resultado.getString("email"), resultado.getString("num_cuenta"));
                } else {
                    usuario = new Trabajador(resultado.getString("username"), resultado.getString("password"),
                            Integer.parseInt(resultado.getString("telefono")), resultado.getString("direccion"),
                            resultado.getString("email"), Integer.parseInt(resultado.getString("nss")));
                }
            } else {
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            error.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
            } catch (SQLException error) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + error.getMessage());
                error.printStackTrace();
            }
            this.cerrarConexion();
        }
        return usuario;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param user El usuario a registrar.
     * @return true si el usuario fue registrado con éxito, de lo contrario, false.
     */
    @Override
    public boolean SignUp(Usuario user) {
        boolean introducido = false;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(INNSERTuser);
            sentencia.setString(1, user.getUsername());
            sentencia.setString(2, user.getPassword());
            sentencia.setInt(3, user.getN_telefono());
            sentencia.setString(4, user.getEmail());
            sentencia.setString(5, user.getDireccion());
           
        } catch (SQLException error) {
            System.out.println("Error de SQL");
            error.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
        return introducido;
    }

    /**
     * Verifica si un usuario existe en la base de datos.
     *
     * @param username El nombre de usuario a verificar.
     * @return true si el usuario existe, de lo contrario, false.
     */
    @Override
    public boolean existeUsuario(String username) {
        ResultSet resultado = null;
        boolean existe = false;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERusername);
            sentencia.setString(1, username);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                existe = true;
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            this.cerrarConexion();
        }
        return existe;
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param nombreUsuario El nombre de usuario a eliminar.
     */
    @Override
    public void eliminarUsuario(String nombreUsuario) {
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(ELIMINARUsuario);
            sentencia.setString(1, nombreUsuario);
            sentencia.executeUpdate();
        } catch (SQLException error) {
            System.out.println("Error de SQL al eliminar el usuario: " + error.getMessage());
            error.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
    }

    /**
     * Modifica los datos de un usuario en la base de datos.
     *
     * @param username   El nombre de usuario.
     * @param contraseña La nueva contraseña.
     * @param telf       El nuevo número de teléfono.
     * @param email      El nuevo correo electrónico.
     * @param direc      La nueva dirección.
     * @param cuenta     El nuevo número de cuenta.
     * @return true si los datos fueron modificados con éxito, de lo contrario, false.
     */
    @Override
    public boolean modificarUsuario(String username, String contraseña, int telf, String email, String direc,
            String cuenta) {
        boolean cambios = false;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(MODIFICARperfiles);
            sentencia.setString(1, contraseña);
            sentencia.setInt(2, telf);
            sentencia.setString(3, email);
            sentencia.setString(4, direc);
            sentencia.setString(5, cuenta);
            sentencia.setString(6, username);
            if (sentencia.executeUpdate() == 1) {
                cambios = true;
            }
        } catch (SQLException error) {
            System.out.println("Error de SQL");
            error.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
        return cambios;
    }

    /**
     * Obtiene una lista de personajes desde la base de datos.
     *
     * @return Una lista de objetos Personaje.
     */
    @Override
    public List<Personaje> getPersonajes() {
        List<Personaje> listaPersonajes = new ArrayList<>();
        ResultSet resultado = null;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERPersonajes);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("Codigo");
                String nombre = resultado.getString("Nombre");
                String descripcion = resultado.getString("Descripcion");
                Date cumpleaños = resultado.getDate("Cumpleaños");
                String ruta_foto = resultado.getString("ruta_foto");
                String curiosidad = resultado.getString("Curiosidad");
                Personaje personaje = new Personaje(nombre, descripcion, cumpleaños, curiosidad, ruta_foto, codigo);
                listaPersonajes.add(personaje);
            }
        } catch (SQLException error) {
            System.out.println("Error de SQL: " + error.getMessage());
            error.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
            } catch (SQLException error) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + error.getMessage());
                error.printStackTrace();
            }
            this.cerrarConexion();
        }
        return listaPersonajes;
    }

    /**
     * Añade un nuevo personaje a la base de datos.
     *
     * @param character El personaje a añadir.
     * @return true si el personaje fue añadido con éxito, de lo contrario, false.
     */
    @Override
    public boolean añadirPersonaje(Personaje character) {
        boolean introducido = false;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(INNSERTpersonaje);
            sentencia.setInt(1, character.getCodigo());
            sentencia.setString(2, character.getNombre());
            sentencia.setString(3, character.getDescripcion());
            sentencia.setDate(4, new java.sql.Date(character.getCumpleaños().getTime()));
            sentencia.setString(5, character.getCuriosidad());
            sentencia.setString(6, character.getRuta());
            if (sentencia.executeUpdate() > 0) {
                introducido = true;
            } else {
                System.out.println("Falló la inserción del personaje");
            }
        } catch (SQLException error) {
            System.out.println("Error de SQL");
            error.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
        return introducido;
    }

    /**
     * Verifica si un personaje existe en la base de datos.
     *
     * @param nombre El nombre del personaje a verificar.
     * @return true si el personaje existe, de lo contrario, false.
     */
    @Override
    public boolean existePersonaje(String nombre) {
        ResultSet resultado = null;
        boolean existe = false;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERpersonaje);
            sentencia.setString(1, nombre);
            resultado = sentencia.executeQuery();
            if (resultado.next())
                existe = resultado.getInt(1) > 0;
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            this.cerrarConexion();
        }
        return existe;
    }

    /**
     * Obtiene el nuevo código para un personaje.
     *
     * @return El nuevo código de personaje.
     */
    @Override
    public int nuevoCodigoPer() {
        int codigo = 0;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(NUEVOCod_per);
            ResultSet resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                codigo = resultSet.getInt("max_codigo") + 1;
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        this.cerrarConexion();
        return codigo;
    }

    /**
     * Obtiene una lista con los nombres de todos los personajes.
     *
     * @return Una lista de nombres de personajes.
     */
    @Override
    public ArrayList<String> completarNombrePer() {
        ArrayList<String> lista = new ArrayList<>();
        ResultSet resultado = null;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERnom_personajes);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombrePersonaje = resultado.getString(1);
                lista.add(nombrePersonaje);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
            this.cerrarConexion();
        }
        return lista;
    }

    /**
     * Obtiene una lista de productos desde la base de datos.
     *
     * @return Una lista de objetos Producto.
     */
    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProducto = new ArrayList<>();
        ResultSet resultado = null;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERProductos);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("Cod_producto");
                Double precio = resultado.getDouble("Precio");
                String descripcion = resultado.getString("Descrip_prod");
                int stock = resultado.getInt("Stock");
                String ruta_foto = resultado.getString("ruta_foto_prod");
                String nombre = resultado.getString("Nombre");
                Producto producto = new Producto(nombre, codigo, precio, descripcion, stock, ruta_foto);
                listaProducto.add(producto);
            }
        } catch (SQLException error) {
            System.out.println("Error de SQL: " + error.getMessage());
            error.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
            } catch (SQLException error) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + error.getMessage());
                error.printStackTrace();
            }
            this.cerrarConexion();
        }
        return listaProducto;
    }

    /**
     * Obtiene el nombre de un personaje dado su código.
     *
     * @param command El código del personaje.
     * @return El nombre del personaje, o null si no se encuentra.
     */
    @Override
    public String getNombre(int command) {
        ResultSet resultado = null;
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(OBTENERNombrePersonaje);
            sentencia.setInt(1, command);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                return nombre;
            } else {
                return null;
            }
        } catch (SQLException error) {
            System.out.println("Error de SQL: " + error.getMessage());
            error.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
            } catch (SQLException error) {
                System.out.println("Error de SQL al cerrar el ResultSet: " + error.getMessage());
                error.printStackTrace();
            }
            this.cerrarConexion();
        }
        return null;
    }

    /**
     * Añade un nuevo producto a la base de datos.
     *
     * @param producto El producto a añadir.
     */
    @Override
    public void añadirProducto(Producto producto) {
        this.abrirConexion();
        try {
            sentencia = conexion.prepareStatement(INNSERTproducto);
            sentencia.setInt(1, producto.getCod_producto());
            sentencia.setInt(2, (int) producto.getPrecio());
            sentencia.setString(3, producto.getDescripcion());
            sentencia.setInt(4, producto.getStock());
            sentencia.setString(5, producto.getRuta_img());
            sentencia.setString(6, producto.getPersonaje());
        } catch (SQLException error) {
            System.out.println("Error de SQL");
            error.printStackTrace();
        } finally {
            this.cerrarConexion();
        }
    }

    /**
     * Obtiene el nuevo código para un producto.
     *
     * @return El nuevo código de producto.
     */
    @Override
    public int nuevoCodigoProd() {
        int codigo = 0;
        this.abrirConexion();
        ResultSet resultado = null;
        try {
            sentencia = conexion.prepareStatement(NUEVOCod_prod);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("max_codigo") + 1;
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        this.cerrarConexion();
        return codigo;
    }
    
    
}
