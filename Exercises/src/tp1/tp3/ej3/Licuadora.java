package ar.edu.ort.tp1.tp3.ej3;

public class Licuadora extends Producto {
	private float potencia;
	private int cantVelocidades;

	
	public Licuadora(String marca, String modelo, String nroSerie, int voltaje, boolean estado, float precio, float potencia, int cantVelocidades) {
		super(marca, modelo, nroSerie, voltaje, estado, precio);
		setPotencia(potencia);
		setCantVelocidades(cantVelocidades);
		}


	private void setPotencia(float potencia) {
		this.potencia = potencia;
	}


	private void setCantVelocidades(int cantVelocidades) {
		this.cantVelocidades = cantVelocidades;
	}


	@Override
	public void imprimir() {
		System.out.println("Licuadora "+super.getMarca()+ " ,modelo "+ super.getModelo()+ " ,potencia" + potencia + " ,cantidad de velocidades"+ cantVelocidades+ ": $"+ super.getPrecio());
		
	}
			
}
