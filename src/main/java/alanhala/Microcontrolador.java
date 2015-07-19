package alanhala;

import java.util.ArrayList;
import java.util.List;

import alanhala.estados.Detenido;
import alanhala.estados.Estado;
import alanhala.instrucciones.Instruccion;

public class Microcontrolador {
	private int a;
	private int b;
	private int[] memoria;
	private List<Instruccion> programa;
	private Estado estado;
	private int counter;
	private Microcontrolador estadoAnterior;

	public Microcontrolador() {
		a = 0;
		b = 0;
		memoria = new int[1024];
		programa = new ArrayList<Instruccion>();
		estado = new Detenido();
		counter = 0;
	}

	public int[] getMemoria() {
		return memoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public int getCounter() {
		return counter;
	}

	public Microcontrolador getEstadoAnterior() {
		return estadoAnterior;
	}

	public Microcontrolador(int a, int b, int[] memoria,
			List<Instruccion> programa, Estado estado, int counter) {
		this.a = a;
		this.b = b;
		this.memoria = memoria;
		this.programa = programa;
		this.estado = estado;
		this.counter = counter;
	}

	public void ejecutarInstruccion(Instruccion instruccion) {
		estadoAnterior = this.clonar();
		instruccion.ejecutar(this);
	}

	public Microcontrolador clonar() { // era una chota usar el metodo clone.
										// tenia que agregar una excepcion cada
										// vez que lo usaba. este metodo tambien
										// me parece choto.
		return new Microcontrolador(a, b, memoria, programa, estado, counter);
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

	public int getInfoDeMemoria(int address) {
		return memoria[address];
	}

	public void setMemoria(int address, int a) {
		memoria[address] = a;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Instruccion> getPrograma() {
		return programa;
	}

	public void load(List<Instruccion> programa) {
		estado.load(programa);
		this.programa = programa;
		counter = 0;
	}

	public void start() {
		estado.start(this);
		memoria = new int[1024];
	}

	public void execute() {
		estado.execute();
		this.ejecutarSiguienteInstruccion();
	}

	public void ejecutarSiguienteInstruccion() {
		this.ejecutarInstruccion(programa.get(counter));
		counter++;
		if (this.finDePrograma()) {
			this.stop();
		}
	}

	public boolean finDePrograma() {
		return counter == programa.size();
	}

	public void stop() {
		estado.stop(this);
		counter = 0;
	}

	public void ejecutarPrograma() { // aca no se si verificar que el micro este
										// detenido o en ejecucion
		// En caso de hacerlo podria usar
		// micro.start();
		if (programa.isEmpty())
			throw new RuntimeException("Tiene que haber un programa cargado");
		else
			programa.forEach(instruccion -> this
					.ejecutarInstruccion(instruccion));
	}

	public void deshacer() { // me parece demasiado choto este metodo. Aumentan
								// los atributos y tengo que estar agregandolos
								// todo el tiempo
		a = estadoAnterior.getA();
		b = estadoAnterior.getB();
		memoria = estadoAnterior.getMemoria();
		programa = estadoAnterior.getPrograma();
		estado = estadoAnterior.getEstado();
		counter = estadoAnterior.getCounter();
	}
}