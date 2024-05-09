package Modelo;


public class Cliente extends Usuario{
	private String n_cuenta;

	
	
	public Cliente(String username, String password, int n_telefono, String direccion, String email, String n_cuenta) {
		super(username, password, n_telefono, direccion, email);
		this.n_cuenta = n_cuenta;
	}

	public Cliente() {
		super();
		this.n_cuenta = "";
		
	}

	public String getN_cuenta() {
		return n_cuenta;
	}

	public void setN_cuenta(String n_cuenta) {
		this.n_cuenta = n_cuenta;
	}
	


}
