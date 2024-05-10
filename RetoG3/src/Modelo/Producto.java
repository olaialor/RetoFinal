package Modelo;

public class Producto {
	private String personaje;
	private int cod_producto;
	private double precio;
	private String descripcion;
	private int stock;	
	private String ruta_img;


	public Producto(String personaje, int cod_producto, double precio, String descripcion, int stock, String ruta_img) {
		super();
		this.personaje = personaje;
		this.cod_producto = cod_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
		this.ruta_img = ruta_img;
	}

	public Producto() {
		this.cod_producto = 0;
		this.precio = 0.0;
		this.descripcion = "";
		this.stock = 0;
		this.ruta_img ="";
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	public String getRuta_img() {
		return ruta_img;
	}

	public void setRuta_img(String ruta_img) {
		this.ruta_img = ruta_img;
	}

	@Override
	public String toString() {
		return "Producto [cod_producto=" + cod_producto + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", stock=" + stock + "]";
	}
	
	
	
}