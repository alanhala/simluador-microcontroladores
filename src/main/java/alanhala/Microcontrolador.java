package alanhala;

import java.util.ArrayList;
import java.util.List;

public class Microcontrolador {
	private int a;
	private int b;
	private int[] memoria;

	public Microcontrolador() {
		a = 0;
		b = 0;
		memoria = new int[1024];
	}

	public void distribuirResultado(int resultado) {
		if (resultado < 255) {
			b = resultado;
			a = 0;
		} else {
			b = 255;
			a = resultado - 255;
		}
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public void setA(int a) {
		this.a = a;

	}

	public void setB(int b) {
		this.b = b;

	}

	public int getMemoria(int address) {
		return memoria[address];
	}

	public void setMemoria(int address, int a) {
		memoria[address] = a;
	}

}