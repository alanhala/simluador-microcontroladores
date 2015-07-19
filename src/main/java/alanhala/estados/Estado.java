package alanhala.estados;

import java.util.List;

import alanhala.Microcontrolador;
import alanhala.instrucciones.Instruccion;

public interface Estado {
	public void load(List<Instruccion> instrucciones);
	public void start(Microcontrolador micro);
	public void execute();
	public void stop(Microcontrolador micro);
	
}
