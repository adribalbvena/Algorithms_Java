package ar.edu.ort.tp1.tp3.ej3;

public class Lavarropas extends Producto {
	private float cargaMax;
	private Tipo tipo;
	
	
	public Lavarropas(String marca, String modelo, String nroSerie, int voltaje, boolean estado, float precio, float cargaMax, Tipo tipo) {
		super(marca, modelo, nroSerie, voltaje, estado, precio);
		setCargaMax(cargaMax);
		setTipo(tipo);
	}


	private void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public Tipo getTipo() {
		return tipo;
	}


	private void setCargaMax(float cargaMax) {
		this.cargaMax = cargaMax;
	}
	
	public float getCargaMax() {
		return cargaMax;
	}


	@Override
	public String toString() {
		return "Lavarropas " +super.toString()+ ", cargaMax=" + cargaMax + ", tipo=" + tipo + "]";
	}


	@Override
	public void imprimir() {
		System.out.println("Lavarropas "+super.getMarca()+" "+ tipo + ", carga maxima "+ cargaMax + "kg "+ ",modelo "+ super.getModelo() + ": $"+ super.getPrecio());
			
	}

	
	
}
