package alanhala.instrucciones;

import alanhala.Microcontrolador;

public class DIV implements Instruccion {

	public void ejecutar(Microcontrolador micro) {
		if (micro.getB() == 0) {
			throw new RuntimeException("No se puede dividir un numero por 0");
		}
		int resultado = micro.getA() / micro.getB();
		micro.distribuirResultado(resultado);
	}

}
