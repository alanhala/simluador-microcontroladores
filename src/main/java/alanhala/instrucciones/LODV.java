package alanhala.instrucciones;

import alanhala.Microcontrolador;

public class LODV implements Instruccion {

	private int value;

	public LODV(int value) {
		this.value = value;
	}

	public void ejecutar(Microcontrolador micro) {
		if (value > 255){
			throw new RuntimeException("El valor no puede ser mayor a 255");
		}
		micro.setA(value);
	}

}
