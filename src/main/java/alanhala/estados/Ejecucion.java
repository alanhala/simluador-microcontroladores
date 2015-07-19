package alanhala.estados;

import java.util.List;

import alanhala.Microcontrolador;
import alanhala.instrucciones.Instruccion;

public class Ejecucion implements Estado {

	public void load(List<Instruccion> instrucciones) {
		throw new RuntimeException("No se puede cargar un programa mientras esta en ejecucion");

	}

	public void start(Microcontrolador micro) {
		throw new RuntimeException("El Microcontrolador ya se encuentra en ejecucion");
	}

	public void execute(){
	}

	public void stop(Microcontrolador micro) {
		micro.setEstado(new Detenido());
	}

}
