package ar.edu.ort.tp1.tp3.ej3;

import java.util.ArrayList;

public class Ticket implements Imprimible{
	private ArrayList<Producto> carrito;
	private static final String TICKET_DE_VENTA = "Ticket de venta \nArticulos:";
	
	public Ticket(ArrayList<Producto> listaConfirmados) {
		this.carrito = listaConfirmados;
	}

	@Override
	public void imprimir() {
		double total;
		total = 0;
		
		System.out.println(TICKET_DE_VENTA);
		for (Producto p : carrito) {
			total += p.getPrecio();
			p.imprimir();
		}
		
		System.out.println("Total: $"+total);
		
	}

}
