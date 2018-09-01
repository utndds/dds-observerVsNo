package observer.model;

import java.util.ArrayList;

public class Observado {

	ArrayList<Observador> observadores = new ArrayList<Observador>();
	float valor;
	
	public Observado(float _valor){
		valor = _valor;
	}
	
	public void setValor(float _valor) {
		valor = _valor;
		this.avisarATodos(_valor);
	}
	
	public float getValor() {
		return valor;
	}
	
	public void avisarATodos(float valor) {
		for (Observador observador : observadores) {
			observador.cambioValor(valor);
		}
	}
	
	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}
	
}
