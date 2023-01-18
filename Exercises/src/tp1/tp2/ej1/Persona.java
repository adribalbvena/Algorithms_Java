package ar.edu.ort.tp1.tp2.ej1;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private String apellido;
	private ArrayList<NumeroTelefonico> telefonos;
	private ArrayList<Email> emails;
	private ArrayList<Mascota> mascotas;
	private ArrayList<Hito> hitos;

	
	public Persona (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos = new ArrayList();
		this.emails = new ArrayList();
		this.mascotas = new ArrayList();
		this.hitos = new ArrayList();
	}
	
	public void agregarNumero(String caracteristica, String numeroDeAbonado, String codigoDePais, TipoDeLinea tipo) {
		telefonos.add(new NumeroTelefonico(caracteristica, numeroDeAbonado, codigoDePais, tipo));
	}
	
	public void agregarEmail(String mail) {
		emails.add(new Email(mail));
	}
	
	public void agregarMasctora(String nombre, String tipo) {
		mascotas.add(new Mascota(nombre, tipo));
	}
	
	private NumeroTelefonico buscarNumero(String numeroDeAbonado) {
		int i;
		NumeroTelefonico numeroEncontrado;
		
		i = 0;
		numeroEncontrado = null;
		
		while (i < telefonos.size() && numeroEncontrado == null) {
			NumeroTelefonico miNumero = telefonos.get(i);
			if (miNumero.getNumeroDeAbonado().equals(numeroDeAbonado)) {
				numeroEncontrado = miNumero;
			}
			i++;
		}
		return numeroEncontrado;
		
	}
	
	public void eliminarNumero(String numeroDeAbonado) {
		NumeroTelefonico miNumero;
		
		miNumero = buscarNumero(numeroDeAbonado);
		
		if (miNumero != null) {
			telefonos.remove(miNumero);
		}
	}
	
	public String getValor() {
		return this.apellido+", "+this.nombre;
	}
	
	public void agregarHito(Hito hito) {
		hitos.add(hito);
	}
	
	public void mostrarTodo() {
		System.out.println(getValor());
		System.out.println("Telefonos:");
		for (NumeroTelefonico tel : telefonos) {
			System.out.println(tel.getTipo()+":"+tel.getValor());
		}
		
		System.out.println("email:");
		for (Email mail : emails) {
			System.out.println(mail.getValor());
		}
		
		System.out.println("Mascotas:");
		for (Mascota mascota : mascotas) {
			System.out.println(mascota.getTipo()+", "+mascota.getNombre());
		}
		
		System.out.println("Hitos:");
		for (Hito hito : hitos) {
			System.out.println(hito.getValor());
		}
	}
}
