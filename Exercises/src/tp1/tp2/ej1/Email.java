package ar.edu.ort.tp1.tp2.ej1;

public class Email {
	private String cuenta;
	private String dominio;
	
	public Email(String mail) {
		setCuenta(mail);
		setDominio(mail);
	}

	private void setCuenta(String mail) {
		String[] parts = mail.split("@");
		this.cuenta = parts[0];
	}

	private void setDominio(String mail) {
		String[] parts = mail.split("@");
		this.dominio = parts[1];
	}
	
	public String getValor() {
		return this.cuenta+"@"+this.dominio;
	}

}
