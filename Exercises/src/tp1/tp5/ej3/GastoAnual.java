package ar.edu.ort.tp1.tp5.ej3;
import java.util.ArrayList;

public class GastoAnual {
	private ArrayList<Rubro> rubros;

	public GastoAnual() {
		this.rubros = new ArrayList<>();
	}
	
	public void agregarGasto(EnumMes mes, String nombreRubro, double importe) {
		Rubro rubroEncontrado;
		rubroEncontrado = obtenerRubro(nombreRubro);
		
		if (importe > 0) {
			rubroEncontrado.agregarGasto(mes, importe);
		}
		
	}
	
	private Rubro obtenerRubro(String nombreRubro) {
		Rubro rubroEncontrado;
		rubroEncontrado = buscarRubro(nombreRubro);
		
		if (rubroEncontrado.equals(null)) {
			rubroEncontrado = new Rubro(nombreRubro);
		}
		
		return rubroEncontrado;
	}
	
	private Rubro buscarRubro(String nombreRubro) {
		Rubro rubroEncontrado;
		rubroEncontrado = null;
		
		int i;
		i = 0;
		
		while (i < rubros.size() && rubroEncontrado == null) {
			if (rubros.get(i).getNombre().equals(nombreRubro)) {
				rubroEncontrado = rubros.get(i);
			}			
			i++;
		}		
		return rubroEncontrado;
	}
	
	private double[][] consolidadoDeGastos() {
		double[][] consolidado;
		Rubro r;
		consolidado = new double[EnumMes.values().length][rubros.size()];
		
		for (int i = 0; i < consolidado.length; i++) {
			for (int j = 0; j < consolidado[i].length; j++) {
				r = rubros.get(j);
				consolidado[i][j] = r.getTotalGastos(EnumMes.values()[i]);				
			}
		}		
		return consolidado;
	}
	
	public double gastoAcumulado(EnumMes mes) {
		double[][] consolidado;
		double gastoAcumulado;
		double[] gastoAcumuladoUnMes;
		
		consolidado = consolidadoDeGastos();
		gastoAcumulado = 0;
		gastoAcumuladoUnMes = consolidado[mes.ordinal()];
		
		for (double d: gastoAcumuladoUnMes) {
			gastoAcumulado += d;
		}
		
		return gastoAcumulado;
	}
	
	public double gastoAcumulado(String nombreRubro) {
		double[][] consolidado;
		double acumuladoRubro;
		int posRubro;
		
		consolidado = consolidadoDeGastos();
		acumuladoRubro = 0;
		posRubro = obtenerPosicionRubro(nombreRubro);
		
		if (posRubro != -1) {
			for (int i = 0; i < consolidado.length; i++) {
				acumuladoRubro += consolidado[i][posRubro];
			}
		} else {
			acumuladoRubro = posRubro;
		}		
		return acumuladoRubro;
	}

	private int obtenerPosicionRubro(String nombreRubro) {		
		return buscarRubro(nombreRubro) != null ? this.rubros.indexOf(nombreRubro) : -1;
	}
	
	public void informarConsumosPorMes() {
		double[][] consolidado;
		Rubro r;
		
		consolidado = consolidadoDeGastos();
		
		for (int i = 0; i < consolidado.length; i++) {
			System.out.println("Mes: " + EnumMes.values()[i]);
			for (int j = 0; j < consolidado[i].length; j++) {
				r = rubros.get(j);
				System.out.println("Rubro: " + r.getNombre());
				System.out.println("Gasto: $" + consolidado[i][j]);
			}
		}
	}
	
	public void informarPromedioMensualPorRubro() {	
		for (Rubro r : rubros) {
			System.out.println("Rubro: "+ r.getNombre());
			System.out.println("Promedio: $"+ r.obtenerPromedioMesesTotales());
		}
	}
	
	public void informarMesMayorConsumo() {
		double mayorConsumo;
		ArrayList<EnumMes> mesesMayorConsumo;
		double acumuladorMes;
		mayorConsumo = 0;
		mesesMayorConsumo = new ArrayList<>();
		
		for (int i = 0; i < EnumMes.values().length; i++) {
			acumuladorMes = gastoAcumulado(EnumMes.values()[i]);
			if (acumuladorMes > mayorConsumo) {
				if(!mesesMayorConsumo.isEmpty()) {
					mesesMayorConsumo.clear();
				}
				mayorConsumo = acumuladorMes;
				mesesMayorConsumo.add(EnumMes.values()[i]);
			} else if (acumuladorMes == mayorConsumo) {
				mesesMayorConsumo.add(EnumMes.values()[i]);
			}
		}
		
		System.out.println("Los meses con mayor consumo son:");
		for (EnumMes mes: mesesMayorConsumo) {
			System.out.println(mes.name());
		}
	}
	
	
}
