package examen.clases;

public class Tragamonedas implements Juego, Mostrable {

	private static final int CANT_RODILLOS = 5;
	private static final int LADOS = 6;
	// TODO descomentar y completar
	private RodilloDeNumeros[] rodillos;
	private EstadoJuego estado;

	public Tragamonedas() {
		// TODO implementar
		crearRodillos();
		procesarEstado();
	}

	private void crearRodillos() {
		// TODO implementar
		this.rodillos = new RodilloDeNumeros[CANT_RODILLOS];
		for (int i = 0; i < rodillos.length-1; i++) {
			rodillos[i] = new RodilloDeNumeros(LADOS);
		}
	}

	@Override
	public void jugar() {
		for (int i = 0; i < rodillos.length; i++) {
			rodillos[i].rodar();
		}
		procesarEstado();
	}

	@Override
	public void mostrar() {
		for (int i = 0; i < rodillos.length; i++) {
			rodillos[i].mostrar();
		}
		System.out.println(" - " + obtenerResultado());
	}

	@Override
	public boolean hayGanador() {
		return estado.ordinal() > EstadoJuego.SIN_SUERTE.ordinal();
	}

	private boolean generala() {
		// TODO implementar	
		return rodillos[1] == rodillos[2] && rodillos[2] == rodillos[3] && rodillos[3] == rodillos[4] && rodillos[4] == rodillos[5];
	}

	private boolean capicua() {
		// TODO implementar
		return rodillos[1] == rodillos[5] && rodillos[2] == rodillos[4];
	}

	protected String obtenerResultado() {
		return obtenerEstado().toString();
	}

	@Override
	public void procesarEstado() {
		estado = EstadoJuego.SIN_SUERTE;
		if (generala()) {
			estado = EstadoJuego.GENERALA;
		} else if (capicua()) {
			estado = EstadoJuego.CAPICUA;
		}
	}

	@Override
	public EstadoJuego obtenerEstado() {
		return estado;
		
	}

}