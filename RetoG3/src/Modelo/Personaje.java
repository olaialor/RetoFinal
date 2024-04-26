package Modelo;

import java.util.Date;

public class Personaje {
	private String nombre;
	private String descripción;
	private Date cumple;
	private String curiosidad;
	private int codigo;

	public Personaje(String nombre, String descripción, Date cumple, String curiosidad, int codigo) {
		this.nombre = nombre;
		this.descripción = descripción;
		this.cumple = cumple;
		this.curiosidad = curiosidad;
		this.codigo = codigo;
	}

	public Personaje() {
		this.nombre = "";
		this.descripción = "";
		this.cumple = null;
		this.curiosidad = "";
		this.codigo = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public Date getCumple() {
		return cumple;
	}

	public void setCumple(Date cumple) {
		this.cumple = cumple;
	}

	public String getCuriosidad() {
		return curiosidad;
	}

	public void setCuriosidad(String curiosidad) {
		this.curiosidad = curiosidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", descripción=" + descripción + ", cumple=" + cumple + ", curiosidad="
				+ curiosidad + ", codigo=" + codigo + "]";
	}

}