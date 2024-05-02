package Modelo;

public class Producto extends Personaje{
	private String cod_producto;
	private String precio;
	private String descripcion;
	private int stock;
	private String ruta_foto;

	public Producto(String nombre, String cod_producto, String precio, String descripcion2, int stock, String ruta_foto2) {
		super(nombre);
		this.cod_producto = cod_producto;
		this.precio = precio;
		descripcion = descripcion2;
		this.stock = stock;
		ruta_foto = ruta_foto2;
	}


	public Producto() {
		this.cod_producto = "";
		this.precio = "";
		this.descripcion = "";
		this.stock = 0;
		this.ruta_foto="";
	}


	public String getCod_producto() {
		return cod_producto;
	}


	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
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


	public String getRuta_foto() {
		return ruta_foto;
	}


	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}


	@Override
	public String toString() {
		return "Producto [cod_producto=" + cod_producto + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", stock=" + stock + ", ruta_foto=" + ruta_foto + "]";
	}
	
}
