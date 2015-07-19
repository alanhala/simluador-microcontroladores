package alanhala;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import alanhala.instrucciones.ADD;
import alanhala.instrucciones.DIV;
import alanhala.instrucciones.LODV;
import alanhala.instrucciones.SWAP;

public class Instrucciones {
	Microcontrolador micro = new Microcontrolador();
	SWAP swap = new SWAP();
	ADD add = new ADD();
	DIV div = new DIV();

	@Test
	public void cargaDe100Y50LaSumaDa150YSeAlmacenaEnB() {
		LODV lodv = new LODV(100);
		LODV lodv1 = new LODV(50);
		
		lodv.ejecutar(micro);
		swap.ejecutar(micro);
		lodv1.ejecutar(micro);
		add.ejecutar(micro);
		
		assertEquals(150, micro.getB());
		assertEquals(0, micro.getA());
	}
	
	@Test
	public void cargaYSuma200Y150YReparteElResultado(){
		LODV lodv = new LODV(200);
		LODV lodv1 = new LODV(150);
		
		lodv.ejecutar(micro);
		swap.ejecutar(micro);
		lodv1.ejecutar(micro);
		add.ejecutar(micro);
		
		assertEquals(255, micro.getB());
		assertEquals(95, micro.getA());
	}
	
	@Test(expected = RuntimeException.class)
	public void tiraExcepcionCuandoDividePor0(){
		LODV lodv = new LODV(0);
		LODV lodv1 = new LODV(2);
		
		lodv.ejecutar(micro);
		swap.ejecutar(micro);
		lodv1.ejecutar(micro);
		div.ejecutar(micro);
		
	}

}
