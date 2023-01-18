package ar.edu.ort.tp1.tp3.ej3;
import java.util.Scanner;


public class Test3 {
	public static Scanner input = new Scanner(System.in);
	public static Programa prog;
	
	public static void elegirArticulos() {
		prog.mostrarArticulos();
		
		String mensaje;
		String mensaje2;
		String respuesta;
		int numero;
		
		mensaje = "Ingrese el numero del articulo elegido: ";
		mensaje2 = "Desea Confirmar item? (s/n)";
		
		System.out.println(mensaje);
		numero = input.nextInt();
		input.nextLine();
		
		while (numero != 0) {
			prog.mostrarDetalle(numero);
			System.out.println(mensaje2);
			respuesta = input.nextLine();
			prog.confirmar(respuesta, numero);
			prog.mostrarArticulos();
			System.out.println(mensaje);
			numero = input.nextInt();
			input.nextLine();
			
		}				
	}		
	

	public static void main(String[] args) {
		prog = new Programa();

		
		prog.agregarArticulo(new Heladera("Whirlpool", "H2745", "12345", 220, false, 14999, 250 , Tipo.Nofrost));
		prog.agregarArticulo(new Televisor("Philips", "49PGFS", "6789", 220, false, 14370, "49 pulgadas", Tipo.Smart));
		prog.agregarArticulo(new Licuadora("Oster", "P90", "101112", 220, false, 10300, 60, 3));
		prog.agregarArticulo(new Lavarropas("Drean", "CONCEPT 5.05", "43679", 220, false, 6799, 6, Tipo.SemiAutomatico));

		elegirArticulos();
		prog.crearTicket();

	}

}
