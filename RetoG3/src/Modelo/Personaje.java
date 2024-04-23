package Modelo;

import java.time.LocalDate;

public class Personaje {
	private String nombre;
	private String descripcion;
	private LocalDate cumple;
	private String curiosidad;
	private String ruta_foto;
	private int codigo;


	public Personaje() {
		this.nombre = "";
		this.descripcion = "";
		this.cumple =null;
		this.curiosidad = "";
		this.ruta_foto="";
		this.codigo=0;
	}

	public Personaje(String nombre, String descripcion, LocalDate cumple, String curiosidad, String ruta_foto, int codigo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cumple = cumple;
		this.curiosidad = curiosidad;
		this.ruta_foto = ruta_foto;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripcion;
	}

	public void setDescripción(String descripción) {
		this.descripcion = descripción;
	}

	public LocalDate getCumple() {
		return cumple;
	}

	public void setCumple(LocalDate cumple) {
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

	public String getRuta() {
		return ruta_foto;
	}

	public void setRuta(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", descripción=" + descripcion + ", cumple=" + cumple + ", curiosidad="
				+ curiosidad + ", ruta=" + ruta_foto + ", codigo=" + codigo + "]";
	}

	
}