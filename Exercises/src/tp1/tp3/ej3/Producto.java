package ar.edu.ort.tp1.tp3.ej3;

public abstract class Producto implements Imprimible {
	private String marca;
	private String modelo;
	private String nroSerie;
	private int voltaje;
	private boolean estado;
	private float precio;
	
	
	public Producto(String marca, String modelo, String nroSerie, int voltaje, boolean estado, float precio) {
		super();
		setMarca(marca);
		setModelo(modelo);
		setNroSerie(nroSerie);
		setVoltaje(voltaje);
		setEstado(estado);
		setPrecio(precio);
	}


	private void setMarca(String marca) {
		this.marca = marca;
	}


	private void setModelo(String modelo) {
		this.modelo = modelo;
	}


	private void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}


	private void setVoltaje(int voltaje) {
		this.voltaje = voltaje;
	}


	private void setEstado(boolean estado) {
		this.estado = estado;
	}


	private void setPrecio(float precio) {
		this.precio = precio;
	}
	

	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}
	
	public float getPrecio() {
		return precio;
	}


	@Override
	public String toString() {
		return " [marca=" + marca + ", modelo=" + modelo + ", nroSerie=" + nroSerie + ", voltaje=" + voltaje
				+ ", estado=" + estado + ", precio=" + precio;
	}
		
}
