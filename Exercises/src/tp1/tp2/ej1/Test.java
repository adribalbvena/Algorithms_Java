package ar.edu.ort.tp1.tp2.ej1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p = new Persona("Lionel","Messi");
		
		p.agregarNumero("011", "72870684", "549", TipoDeLinea.CELULAR);
		p.agregarNumero("032444", "5678", "608", TipoDeLinea.CELULAR);
		p.agregarNumero("4411", "5472", "054", TipoDeLinea.FIJO);
		
		p.agregarEmail("lio@messi.com");
		
		p.agregarMasctora("Pluto", "Perro");
		p.agregarMasctora("Felix", "Gato");
		
		p.eliminarNumero("5678");
		
		Hito h = new Hito("21/8/96", "Nacimiento Adri", "Madre, Padre, Hermana");
		
		p.agregarHito(h);
		
		Persona p2 = new Persona("Adri", "Balbuena");
		
		p2.agregarHito(h);
		
		p.mostrarTodo();
		p2.mostrarTodo();
	

}
}