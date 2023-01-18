package examen.clases;

public interface Juego {
	void jugar();
	void procesarEstado();
	EstadoJuego obtenerEstado();
	boolean hayGanador();
}
