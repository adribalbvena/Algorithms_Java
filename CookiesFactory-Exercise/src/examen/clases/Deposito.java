package examen.clases;

import java.util.ArrayList;

public class Deposito {
	ArrayList<Envase<?>> contenido;
	
	public Deposito() {
		contenido = new ArrayList<>();
	}
	
	public void estibar(Envase<?> envase) {
		contenido.add(envase);
	}
}
