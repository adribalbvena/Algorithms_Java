package examen.clases;

public class Resumen {

	private int bolsas;
	private int paquetes;
	private double kilosDescarte;
	private int tanda;

	public Resumen(int nroTanda, int bolsas, int paquetes, double kilosDescarte) {
		this.tanda = nroTanda;
		this.bolsas = bolsas;
		this.paquetes = paquetes;
		this.kilosDescarte = kilosDescarte;
	}

	public int getBolsas() {
		return bolsas;
	}

	public double getKilosDescarte() {
		return kilosDescarte;
	}

	public int getPaquetes() {
		return paquetes;
	}
	
	

	public int getTanda() {
		return tanda;
	}

	@Override
	public String toString() {
		return "Resumen [tanda=" + tanda + ", bolsas=" + bolsas + ", paquetes=" + paquetes + ", kilosDescarte="
				+ kilosDescarte + "]";
	}

}
