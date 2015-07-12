package alanhala;

public class LODV implements Instruccion {

	private int value;

	public LODV(int value) {
		this.value = value;
	}

	public void ejecutar(Microcontrolador micro) {
		micro.setA(value);
	}

}
