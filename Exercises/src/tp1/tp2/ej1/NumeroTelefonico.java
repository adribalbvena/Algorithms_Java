package ar.edu.ort.tp1.tp2.ej1;

public class NumeroTelefonico {
	private String caracteristica;
	private String numeroDeAbonado;
	private String codigoDePais;
	private TipoDeLinea tipo;
	
	
	public NumeroTelefonico() {
		
	}
	
	public NumeroTelefonico(String caracteristica, String numeroDeAbonado, String codigoDePais, TipoDeLinea tipo) {
		setCaracteristica(caracteristica);
		setNumeroDeAbonado(numeroDeAbonado);
		setCodigoDePais(codigoDePais);
		setTipo(tipo);
	}

	private void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	private void setNumeroDeAbonado(String numeroDeAbonado) {
		this.numeroDeAbonado = numeroDeAbonado;
	}

	private void setCodigoDePais(String codigoDePais) {
		this.codigoDePais = codigoDePais;
	}

	private void setTipo(TipoDeLinea tipo) {
		this.tipo = tipo;
	}
	
	public String getValor() {
		return "(+"+this.codigoDePais+") "+this.caracteristica+" "+this.numeroDeAbonado;
	}

	public TipoDeLinea getTipo() {
		return tipo;
	}

	public String getNumeroDeAbonado() {
		return numeroDeAbonado;
	}
	
}

