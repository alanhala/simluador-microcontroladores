package alanhala.instrucciones;

import alanhala.Microcontrolador;

public class LOD implements Instruccion {
	private int address;
	
	public LOD(int address){
		this.address = address;
	}

	public void ejecutar(Microcontrolador micro) {
		if (address >= 1023){
			throw new RuntimeException("La direccion de memoria esta fuera del rango. Debe ser menor a 1024");
		}
		micro.setA(micro.getInfoDeMemoria(address));
		
	}
	
	

}
