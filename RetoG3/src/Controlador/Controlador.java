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

public class Controlador implements Icontrolador {
	private Connection conexion;
	private PreparedStatement sentencia;
	private ResultSet resultado;

	final String OBTENERusuario = "SELECT * FROM Usuario WHERE username=? AND password=?";
	final String INNSERTuser = "INSERT INTO usuario VALUES (?,?,?,?,?)";
	final String INNSERTcliente = "INSERT INTO cliente VALUES (?, ?)";
	final String OBTENERusername = "SELECT COUNT(*) FROM usuario WHERE username = ?";
	final String OBTENERPersonajes = "SELECT * FROM personaje";
	final String OBTENERProductos = "SELECT * FROM producto";
	final String OBTENERNombrePersonaje = "Select nombre from personaje where codigo = ?";
	final String EXISTEusuario = "SELECT COUNT(*) AS existe FROM Usuario WHERE username = ?";
	final String OBTENERpersonaje = "SELECT COUNT(*) FROM Personaje WHERE nombre = ?";
	final String INNSERTpersonaje = "INSERT INTO personaje VALUES (?,?,?,?,?,?)";
	final String OBTENERnom_personajes = "SELECT nombre from Personaje";
	final String INNSERTproducto = "INSERT INTO producto VALUES (?,?,?,?,?,?)";
	final String NUEVOCod_prod = "SELECT MAX(cod_producto) AS max_codigo FROM Producto";
	final String NUEVOCod_per = "SELECT MAX(codigo) AS max_codigo FROM Personaje";
	final String MODIFICARperfil = "UPDATE Usuario AS u JOIN Cliente AS c ON u.username = c.username SET u.password = ?, u.telefono = ?, u.email = ?, u.direccion = ?, c.num_cuenta = ? WHERE u.username = ?";
	final String USERSdata = "CALL UsersData(?,?)";
	final String EScliente = "SELECT COUNT(*) AS count FROM Usuario u JOIN Cliente c ON u.username = c.username WHERE u.username = (?);";
	final String MODIFICARperfiles = "UPDATE  Usuario u, Cliente c SET u.password=?, u.telefono=?, u.email=?, u.direccion=?, c.num_cuenta=? WHERE u.username=c.username AND u.username=?";
	final String ELIMINARUsuario = "CALL EliminarCliente(?);";

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/Sanrio?serverTimezone=Europe/Madrid&useSSL=false";
			conexion = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException error) {
			System.out.println("Error al intentar abrir la BD: " + error.getMessage());
			error.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			if (sentencia != null) {
				sentencia.close();
			}
			if (sentencia != null) {
				conexion.close();
			}
		} catch (SQLException error) {
			System.out.println("Error al intentar cerrar la conexión: " + error.getMessage());
			error.printStackTrace();
		}
	}

	@Override
	public Usuario logIn(String us, String pass) {
		resultado = null;
		Usuario usuario = null;
		ResultSet resultado1 = null;
		this.openConnection();
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
				System.out.println(usuario);
			} else {

				System.out.println("Nombre de usuario o contraseña incorrectos.");
			}
		} catch (SQLException e) {
//			System.out.println("Error de SQL: " + e.getMessage());
//			e.printStackTrace();
		} finally {
			try {
				if (resultado != null) {
					resultado.close();
				}
			} catch (SQLException e) {
				System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
				e.printStackTrace();
			}
			this.closeConnection();
		}
		return usuario;

	}

	@Override
	public boolean SignUp(Usuario user) {
		boolean introducido = false;
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(INNSERTuser);
			sentencia.setString(1, user.getUsername());
			sentencia.setString(2, user.getPassword());
			sentencia.setInt(3, user.getN_telefono());
			sentencia.setString(4, user.getEmail());
			sentencia.setString(5, user.getDireccion());
			if (sentencia.executeUpdate() > 0) {
				introducido = true;
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
		resultado = null;

		// Abrimos la conexión
		this.openConnection();

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
		} catch (SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null) {
					resultado.close();
				}
			} catch (SQLException e) {
				System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
				e.printStackTrace();
			}

			this.closeConnection();
		}

		return listaPersonajes;
	}

	@Override
	public List<Producto> getProducto() {
		// TODO Auto-generated method stub
		List<Producto> listaProducto = new ArrayList<>();
		ResultSet rs = null;

		this.openConnection();

		try {
			sentencia = conexion.prepareStatement(OBTENERProductos);
			rs = sentencia.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("Cod_producto");
				Double precio = rs.getDouble("Precio");
				String descripcion = rs.getString("Descrip_prod");
				int stock = rs.getInt("Stock");
				String ruta_foto = rs.getString("ruta_foto_prod");
				String nombre = rs.getString("Nombre");

				Producto producto = new Producto(nombre, codigo, precio, descripcion, stock, ruta_foto);
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

			this.closeConnection();
		}

		return listaProducto;
	}

	@Override
	public String getNombre(int command) {
		resultado = null;

		// Abrimos la conexión
		this.openConnection();

		try {

			sentencia = conexion.prepareStatement(OBTENERNombrePersonaje);
			sentencia.setInt(1, command); // Setting the parameter
			resultado = sentencia.executeQuery();

			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
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
				if (resultado != null) {
					resultado.close();
				}
			} catch (SQLException e) {
				System.out.println("Error de SQL al cerrar el ResultSet: " + e.getMessage());
				e.printStackTrace();
			}

			this.closeConnection();
		}
		return null;
	}

	public int nuevoCodigo() throws SQLException {
		int codigo = 0;
		this.openConnection();
		String query = "SELECT MAX(codigo) AS max_codigo FROM Personaje";
		sentencia = conexion.prepareStatement(query);
		resultado = sentencia.executeQuery();
		if (resultado.next()) {
			codigo = resultado.getInt("max_codigo") + 1;
		}

		this.closeConnection();
		return codigo;
	}

	@Override
	public boolean existePersonaje(String nombre) {
		resultado = null;
		boolean existe = false;
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(OBTENERpersonaje);
			sentencia.setString(1, nombre);
			resultado = sentencia.executeQuery();
			if (resultado.next())
				if (resultado.getInt(1) == 1)
					existe = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultado != null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.closeConnection();
		}
		return existe;
	}

	@Override
	public boolean añadirPersonaje(Personaje character) {
		// TODO Auto-generated method stub
		boolean introducido = false;
		this.openConnection();
		try {
			sentencia= conexion.prepareStatement(INNSERTpersonaje);
			sentencia.setInt(1, character.getCodigo());
			sentencia.setString(2, character.getNombre());
			sentencia.setString(3, character.getDescripcion());
			sentencia.setDate(4, new java.sql.Date(character.getCumpleaños().getTime()));
			sentencia.setString(5, character.getCuriosidad());
			sentencia.setString(6, character.getRuta());

			if (sentencia.executeUpdate() > 0) {
				introducido = true;

				System.out.println("Personaje insertado correctamente");
			} else {
				System.out.println("Falló la inserción del personaje");
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
	public int nuevoCodigoPer() {
		int codigo = 0;
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(NUEVOCod_per);
			ResultSet resultSet = sentencia.executeQuery();
			if (resultSet.next()) {
				codigo = resultSet.getInt("max_codigo") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeConnection();
		return codigo;
	}

	@Override
	public ArrayList<String> completarNombrePer() {
		ArrayList<String> lista = new ArrayList<>();
		resultado = null;
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(OBTENERnom_personajes);
			resultado = sentencia.executeQuery();
			while (resultado.next()) {
				String nombrePersonaje = resultado.getString(1);
				lista.add(nombrePersonaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultado!= null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.closeConnection();
		}
		return lista;
	}

	// Añadir Producto
	@Override
	public int nuevoCodigoProd() {
		// TODO Auto-generated method stub
		int codigo = 0;
		this.openConnection();
		resultado = null;
		try {
			sentencia = conexion.prepareStatement(NUEVOCod_prod);
			resultado = sentencia.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (resultado.next()) {
				codigo = resultado.getInt("max_codigo") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.closeConnection();
		return codigo;
	}

	
	@Override
	public void añadirProducto(Producto producto) {
		// TODO Auto-generated method stub
	
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(INNSERTproducto);
			sentencia.setInt(1, producto.getCod_producto());
			sentencia.setInt(2, (int) producto.getPrecio());
			sentencia.setString(3, producto.getDescripcion());
			sentencia.setInt(4, producto.getStock());
			sentencia.setString(5, producto.getRuta_img());
			sentencia.setString(6, producto.getPersonaje());

			if (sentencia.executeUpdate() > 0) {
				System.out.println("Personaje insertado correctamente");
			} else {
				System.out.println("Falló la inserción del personaje");
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

	}

	@Override
	public boolean modificarUsuario(String username, String contraseña, int telf, String email, String direc,
			String cuenta) {
		// TODO Auto-generated method stub
		boolean cambios = false;
		this.openConnection();
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
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return cambios;
	}

	@Override
	public boolean existeUsuario(String username) {
		resultado = null;
		boolean existe = false;
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(OBTENERusername);
			sentencia.setString(1, username);
			resultado = sentencia.executeQuery();
			if (resultado.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultado != null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.closeConnection();
		}
		return existe;
	}

	@Override
	public void eliminarUsuario(String nombreUsuario) {
		this.openConnection();
		try {
			sentencia = conexion.prepareStatement(ELIMINARUsuario);
			sentencia.setString(1, nombreUsuario);
			sentencia.executeUpdate();

			System.out.println("El usuario ha sido eliminado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error de SQL al eliminar el usuario: " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
	}
	

}