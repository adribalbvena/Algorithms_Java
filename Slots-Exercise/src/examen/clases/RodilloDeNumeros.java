package examen.clases;

import tp1.u5.tad.implementaciones.nodo.ColaNodos;

public class RodilloDeNumeros implements Rodillo, Mostrable{
	private static final int CARAS_MINIMAS = 3;
	private static final String MSJ_LADOS_INVALIDOS= "El minimo de caras es 3";
	private ColaNodos<Integer> valores;
	private int lados;
	
	
	public RodilloDeNumeros(int lados) {
		super();
		setCaras(lados);
		inicializar();
	}


	private void setCaras(int lados) {
		if (lados < CARAS_MINIMAS) {
			throw new RuntimeException(MSJ_LADOS_INVALIDOS);
		}
		
		this.lados = lados;
	}


	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(obtenerActual());
	}


	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		this.valores = new ColaNodos<Integer>();
		
		for (int i = 0; i < lados; i++) {
			valores.add(i);
		}
		
	}


	@Override
	public void rodar() {
		// TODO Auto-generated method stub
		int valor;
		int random;
		random = (int) (Math.random() * lados);
		
		valor = valores.remove();
		while (valor !=  random) {
			valores.add(valor);
			valor = valores.remove();
		}
		

		
	}


	@Override
	public Integer obtenerActual() {
		// TODO Auto-generated method stub
		Integer resultado = null;
		int valor = valores.remove();
		int random = (int) (Math.random() * lados);
		
		if (valor == random) {
			resultado = valor;
		}
		
		return resultado;
	}
	
	
	
	

}
