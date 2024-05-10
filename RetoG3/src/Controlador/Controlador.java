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
	final String EXISTEusuario = "SELECT COUNT(*) AS existe FROM Usuario WHERE username = ?";
	final String OBTENERpersonaje = "SELECT COUNT(*) FROM Personaje WHERE nombre = ?";
	final String INNSERTpersonaje = "INSERT INTO personaje VALUES (?,?,?,?,?,?)";
	final String OBTENERnom_personajes = "SELECT nombre from Personaje";
	final String INNSERTproducto = "INSERT INTO producto VALUES (?,?,?,?,?,?)";
	final String NUEVOCod_prod = "SELECT MAX(cod_producto) AS max_codigo FROM Producto";
	final String NUEVOCod_per = "SELECT MAX(codigo) AS max_codigo FROM Personaje";
	final String MODIFICARperfil = "UPDATE  Usuario u, Cliente c SET u.password=?, u.telefono=?, u.email=?, u.direccion=?, c.num_cuenta=? WHERE u.username=c.username AND u.username=?";

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

	@Override
	public boolean SignUp(Usuario user) {
		boolean introducido = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(INNSERTuser);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getN_telefono());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getDireccion());
			if (stmt.executeUpdate() > 0) {
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
	public boolean existeUsuario(String username) {
		ResultSet rs = null;
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERusername);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
				Personaje personaje = new Personaje(nombre, descripcion, cumpleaños, curiosidad, ruta_foto, codigo);
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

	// Añadir Personaje
	@Override
	public boolean existePersonaje(String nombre) {
		ResultSet rs = null;
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERpersonaje);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			if (rs.next())
				if (rs.getInt(1) == 1)
					existe = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.closeConnection();
		}
		return existe;
	}

	// Añadir Personaje
	@Override
	public boolean añadirPersonaje(Personaje character) {
		// TODO Auto-generated method stub
		boolean introducido = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(INNSERTpersonaje);
			stmt.setInt(1, character.getCodigo());
			stmt.setString(2, character.getNombre());
			stmt.setString(3, character.getDescripcion());
			stmt.setDate(4, new java.sql.Date(character.getCumpleaños().getTime()));
			stmt.setString(5, character.getCuriosidad());
			stmt.setString(6, character.getRuta_foto());

			if (stmt.executeUpdate() > 0) {
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

	// Añadir Personaje
	@Override
	public int nuevoCodigoPer() {
		int codigo = 0;
		this.openConnection();
		try {
			stmt = con.prepareStatement(NUEVOCod_per);
			ResultSet resultSet = stmt.executeQuery();
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

	// Añadir Producto
	@Override
	public ArrayList<String> completarNombrePer() {
		ArrayList<String> lista = new ArrayList<>();
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERnom_personajes);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String nombrePersonaje = rs.getString(1);
				lista.add(nombrePersonaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(NUEVOCod_prod);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				codigo = rs.getInt("max_codigo") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.closeConnection();
		return codigo;
	}

	// Añadir Producto
	@Override
	public void añadirProducto(Producto producto) {
		// TODO Auto-generated method stub
		// cod_producto, precio, descrip_prod, stock, personaje

		this.openConnection();
		try {
			stmt = con.prepareStatement(INNSERTproducto);
			stmt.setInt(1, producto.getCod_producto());
			stmt.setInt(2, (int) producto.getPrecio());
			stmt.setString(3, producto.getDescripcion());
			stmt.setInt(4, producto.getStock());
			stmt.setString(5, producto.getRuta_img());
			stmt.setString(6, producto.getPersonaje());

			if (stmt.executeUpdate() > 0) {
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
		Cliente cl = new Cliente();
		this.openConnection();
		try {
			stmt = con.prepareStatement(MODIFICARperfil);
			stmt.setString(1, contraseña);
			stmt.setInt(2, telf);
			stmt.setString(3, email);
			stmt.setString(4, direc);
			stmt.setString(5, cuenta);
			stmt.setString(6, username);
			if (stmt.executeUpdate() == 1) {
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
}