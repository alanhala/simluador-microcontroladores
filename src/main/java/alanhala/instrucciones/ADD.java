package alanhala.instrucciones;

import alanhala.Microcontrolador;

public class ADD implements Instruccion {

	public void ejecutar(Microcontrolador micro) {
		int resultado = micro.getA() + micro.getB();
		micro.distribuirResultado(resultado);
	}

}
