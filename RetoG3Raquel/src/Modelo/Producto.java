package Modelo;

public class Producto {
	private String cod_producto;
	private double precio;
	private String descripcion;
	private int stock;	
	
	public Producto(String cod_producto, double precio, String descripcion, int stock) {
		this.cod_producto = cod_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
	}

	public Producto() {
		this.cod_producto = "";
		this.precio = 0.0;
		this.descripcion = "";
		this.stock = 0;
	}

	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
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

	@Override
	public String toString() {
		return "Producto [cod_producto=" + cod_producto + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", stock=" + stock + "]";
	}
	
	
	
}
