package alanhala;

public class STR implements Instruccion {
	
	private int address;
	
	public STR(int address){
		this.address = address;
	}

	public void ejecutar(Microcontrolador micro) {
		if (address >= 1023){
			throw new RuntimeException("La direccion de memoria esta fuera del rango. Debe ser menor a 1024");
		}
		micro.setMemoria(address, micro.getA());
	}

}
