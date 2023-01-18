package ar.edu.ort.tp1.tp3.ej3;

public class Cliente {
	private String cuil;
	private String nomApe;
	
	public Cliente(String cuil, String nomApe) {
		setCuil(cuil);
		setNomApe(nomApe);
		
	}

	public String getCuil() {
		return cuil;
	}

	private void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNomApe() {
		return nomApe;
	}

	private void setNomApe(String nomApe) {
		this.nomApe = nomApe;
	}
	
	

}
