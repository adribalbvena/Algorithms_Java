package ar.edu.ort.tp1.tp3.ej3;

import java.util.ArrayList;

public class Programa {
	private ArrayList<Producto> listaArticulos;
	private ArrayList<Producto> listaConfirmados;
	
	public Programa() {	
		this.listaArticulos = new ArrayList<>();
		this.listaConfirmados = new ArrayList<>(); 
	}
	
	public void agregarArticulo(Producto p) {
		listaArticulos.add(p);
	}
	
	public void mostrarArticulos() {
		int contador;
		
		contador = 1;
		
		for (Producto p : listaArticulos) {
			System.out.println(contador++ + "-" + p.getClass().getSimpleName() + " Marca: " + p.getMarca() + " Modelo: " + p.getModelo());
		}
	}
	
	public void mostrarDetalle(int numero) {
			
		switch(numero) {
		case 1: 
			System.out.println(listaArticulos.get(0));
			break;
		case 2: 
			System.out.println(listaArticulos.get(1));
			break;
		case 3: 
			System.out.println(listaArticulos.get(2));
		case 4:
			System.out.println(listaArticulos.get(3));
		
		}
	}
	
	
	public void confirmar(String respuesta, int numero) {
		if (respuesta.equals("s")) {
			listaConfirmados.add(listaArticulos.get(numero-1));
		}
	}
	
	public void crearTicket() {
		Ticket tk1 = new Ticket(listaConfirmados);
		tk1.imprimir();
	}
	

	@Override
	public String toString() {
		return "Programa [listaArticulos=" + listaArticulos + "]";
	}
	
	
}
