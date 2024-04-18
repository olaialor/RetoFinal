package Modelo;

public class Trabajador extends Usuario {
	private int nss;

	
	
	public Trabajador(String username, String password, int n_telefono, String direccion, String email, int nss) {
		super(username, password, n_telefono, direccion, email);
		this.nss = nss;
	}

	public Trabajador() {
		super();
		this.nss = 0;
	}

	public int getNss() {
		return nss;
	}

	public void setNss(int nss) {
		this.nss = nss;
	}
			
}
