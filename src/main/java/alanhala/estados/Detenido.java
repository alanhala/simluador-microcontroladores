package alanhala.estados;

import java.util.List;

import alanhala.Microcontrolador;
import alanhala.instrucciones.Instruccion;

public class Detenido implements Estado {

	public void load(List<Instruccion> instrucciones) {
	}

	public void start(Microcontrolador micro) {
		if (micro.getPrograma().isEmpty())
			throw new RuntimeException("No hay programa cargado");
		else
			micro.setEstado(new Ejecucion());
	}

	public void execute() {
		throw new RuntimeException("El microcontrolador esta detenido");
	}

	public void stop(Microcontrolador micro) {
		throw new RuntimeException("El microcontrolador esta detenido");

	}

}
