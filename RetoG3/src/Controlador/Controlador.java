package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;

import Modelo.Usuario;
import Modelo.Personaje;

public class Controlador implements Icontrolador {
	private Connection con;
	private PreparedStatement stmt;

	final String OBTENERusuario = "SELECT * FROM Usuario WHERE username=? AND password=?";
	final String INNSERTuser = "INSERT INTO usuario VALUES (?,?,?,?,?)";
	final String INNSERTpersonaje = "INSERT INTO personaje VALUES (?,?,?,?,?,?)";
	final String INNSERTcliente = "INSERT INTO cliente VALUES (?, ?)";
	final String OBTENERusername = "SELECT COUNT(*) FROM usuario WHERE username = ?";
	final String OBTENERpersonaje = "SELECT COUNT(*) FROM Personaje WHERE nombre = ?";
	final String OBTENERcodigo_max = "SELECT MAX(codigo) FROM Personaje";
	final String OBTENERnom_personajes= "SELECT nombre from Personaje";
	final String OBTENERtrabajador= "SELECT * FROM Trabajador WHERE username=?";

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
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERusername);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) 
				if (rs.getInt(1)==1)
					existe = true;
			
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

	public boolean existePersonaje(String nombre) throws SQLException {
		ResultSet rs = null;
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERpersonaje);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			if (rs.next()) 
				if (rs.getInt(1)==1)
					existe = true;
				
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
	public Personaje getPersonaje(int Codigo, String nombre, String descripcion, Date cumple, String curiosidad) {
		// TODO Auto-generated method stub
		return null;
	}

	public int nuevoCodigo() throws SQLException {
	    int codigo = 0;
	    this.openConnection();
	    String query = "SELECT MAX(codigo) AS max_codigo FROM Personaje";
	    stmt = con.prepareStatement(query);
	    ResultSet resultSet = stmt.executeQuery();
	    if (resultSet.next()) {
	        codigo = resultSet.getInt("max_codigo") + 1;
	    }
	    
	    this.closeConnection();
	    return codigo;
	}

	public boolean añadirPersonaje(Personaje character) {
		// TODO Auto-generated method stub
		boolean introducido = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(INNSERTpersonaje);
			stmt.setInt(1, character.getCodigo());
			stmt.setString(2, character.getNombre());
			stmt.setString(3, character.getDescripción());
			stmt.setDate(4, java.sql.Date.valueOf(character.getCumple()));
			stmt.setString(5, character.getCuriosidad());
			stmt.setString(6, character.getRuta());
			
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

	public boolean buscarusuario(String usuario) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OBTENERtrabajador);
			stmt.setString(1, usuario);
			rs = stmt.executeQuery();
			if (rs.next()) 
				//if (rs.getInt(1)==1)
					existe = true;
			
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
	}

//	public ArrayList<String> completarNombrePer() throws SQLException {
//		ArrayList<String> lista = new ArrayList<>();
//				
//	    ResultSet rs = null;
//	    boolean existe = false;
//	    this.openConnection();
//	    try {
//	        stmt = con.prepareStatement(OBTENERnom_personajes);
//	        rs = stmt.executeQuery();
//	        while (rs.next()) {
//	            rs.getString(1);
//	            lista.add(userName)	 ;       }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        if (rs != null) {
//	            rs.close();
//	        }
//	        this.closeConnection();
//	    }
//	    return lista;
//	}
	
	
//	public void completarNombrePer(JComboBox comboBoxNombrePer) throws SQLException {
//	    ResultSet rs = null;
//	    boolean existe = false;
//	    this.openConnection();
//	    try {
//	        stmt = con.prepareStatement(OBTENERpersonaje);
//	        rs = stmt.executeQuery();
//	        while (rs.next()) {
//	            comboBoxNombrePer.addItem(rs.getString(1));
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        if (rs != null) {
//	            rs.close();
//	        }
//	        this.closeConnection();
//	    }
//	}



