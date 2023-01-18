package ar.edu.ort.tp1.tp5.ej3;

public class Rubro {
	public static final int TOTAL_MESES = 12;
	private String nombre;	
	private double[] gastosPorMes;
	
	
	public Rubro(String nombre) {
		super();
		setNombre(nombre);
		inicializarGastos();
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}
	
	private void inicializarGastos() {
		this.gastosPorMes = new double[TOTAL_MESES];
		
	}
	
	public void agregarGasto(EnumMes mes,double importe) {
		this.gastosPorMes[mes.ordinal()] += importe;
	}
	
	public double getTotalGastos(EnumMes mes) {		
		return this.gastosPorMes[mes.ordinal()];
	}
	
	public double getTotal() {
		double acum;
		acum= 0;
		for (double d : gastosPorMes) {
			acum += d;
		}
		
		return acum;
	}
	
	public double obtenerPromedioMesesTotales() {
		return getTotal() / TOTAL_MESES;
	}
	
	
	
	
	
	

	
}
