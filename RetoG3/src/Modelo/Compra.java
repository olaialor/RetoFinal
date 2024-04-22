package Modelo;

import java.time.LocalDateTime;

public class Compra {
	private String username;
	private String cod_producto;
	private  LocalDateTime hora;
	
	public Compra(String username, String cod_producto, LocalDateTime hora) {
		this.username = username;
		this.cod_producto = cod_producto;
		this.hora = hora;
	}

	public Compra() {
		this.username = "";
		this.cod_producto ="";
		this.hora = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Compra [username=" + username + ", cod_producto=" + cod_producto + ", hora=" + hora + "]";
	}
	
}
