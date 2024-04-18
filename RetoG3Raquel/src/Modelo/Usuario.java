package Modelo;

import java.util.Date;

public class Usuario {
	private String username;
	private String password;
	private int n_telefono;
	private String direccion;
	private String email;

	public Usuario(String username, String password, int n_telefono, String direccion, String email) {
		this.username = username;
		this.password = password;
		this.n_telefono = n_telefono;
		this.direccion = direccion;
		this.email = email;
		}

	public Usuario() {
		this.username ="";
		this.password ="";
		this.n_telefono =0;
		this.direccion ="";
		this.email = "";

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getN_telefono() {
		return n_telefono;
	}

	public void setN_telefono(int n_telefono) {
		this.n_telefono = n_telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", n_telefono=" + n_telefono
				+ ", direccion=" + direccion + ", email=" + email + "]";
	}
	
}
