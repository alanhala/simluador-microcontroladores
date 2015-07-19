package alanhala.instrucciones;

import alanhala.Microcontrolador;

public class SWAP implements Instruccion {

	public void ejecutar(Microcontrolador micro) {
		int aux = micro.getA();
		micro.setA(micro.getB());
		micro.setB(aux);
	}

}
