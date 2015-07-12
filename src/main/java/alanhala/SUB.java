package alanhala;

public class SUB implements Instruccion {

	public void ejecutar(Microcontrolador micro) {
		int resultado = micro.getB() - micro.getA();
		micro.distribuirResultado(resultado);
	}

}
