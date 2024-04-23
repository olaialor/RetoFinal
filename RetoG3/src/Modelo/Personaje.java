package Modelo;

import java.util.Date;

public class Personaje {
	private String nombre;
	private String descripcion;
	private Date cumpleaños;
	private String curiosidad;
	private String ruta_foto;
	private int codigo;

	public Personaje(String nombre, String descripcion, Date cumpleaños, String curiosidad, String ruta_foto, int codigo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cumpleaños = cumpleaños;
		this.curiosidad = curiosidad;
		this.ruta_foto = ruta_foto;
		this.codigo = codigo;
	}

	public Personaje() {
		this.nombre = "";
		this.descripcion = "";
		this.cumpleaños = null;
		this.curiosidad = "";
		this.ruta_foto = "";
		this.codigo = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCumpleaños() {
		return cumpleaños;
	}

	public void setCumpleaños(Date cumpleaños) {
		this.cumpleaños = cumpleaños;
	}

	public String getCuriosidad() {
		return curiosidad;
	}

	public void setCuriosidad(String curiosidad) {
		this.curiosidad = curiosidad;
	}

	public String getRuta_foto() {
		return ruta_foto;
	}

	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", descripcion=" + descripcion + ", cumpleaños=" + cumpleaños
				+ ", curiosidad=" + curiosidad + ", ruta_foto=" + ruta_foto + ", codigo=" + codigo + "]";
	}

	

}