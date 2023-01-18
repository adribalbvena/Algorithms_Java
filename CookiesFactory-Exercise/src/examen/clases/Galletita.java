package examen.clases;

public class Galletita {
	private static final double GRAMOS_DESEADOS = 10;
	private static final double GRAMOS_ACEPTABLES = GRAMOS_DESEADOS / 2;
	private static final double PORC_COBERTURA_VALIDO = 98;
	private double gramos;
	private boolean entera;
	private double porcentajeCobertura;
	
	public Galletita() {
		entera = obtenerEntereza();
		porcentajeCobertura = calcularCobertura();
		if (entera)
			gramos = GRAMOS_DESEADOS;
		else
			gramos = GRAMOS_DESEADOS - Math.random() * GRAMOS_DESEADOS;
	}

	private double calcularCobertura() {
		return Math.min(100, 60 + Math.random() * 50);
	}

	public boolean estaEntera() {
		return entera;
	}

	public double getGramos() {
		return gramos;
	}

	public Calidad obtenerCalidad() {
		Calidad calidad;
		// TODO
		if (estaEntera() && (calcularCobertura()/100) >= (PORC_COBERTURA_VALIDO / 100)) {
			calidad = Calidad.A;
		} else if (getGramos() >= GRAMOS_ACEPTABLES) {
			calidad = Calidad.B;
		} else {
			calidad = Calidad.C;
		}
		
		return calidad;
	}

	private boolean obtenerEntereza() {
		return Math.random() > .2;
	}

	@Override
	public String toString() {
		return "Galletita [gramos=" + gramos + ", entera=" + entera + ", obtenerCalidad()=" + obtenerCalidad() + "]";
	}

}