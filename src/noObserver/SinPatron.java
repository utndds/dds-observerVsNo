package noObserver;

import java.util.ArrayList;

import noObserver.model.*;

public class SinPatron {
	
	public static ArrayList<Observador> ejecutar(int numObservadores, float valorInicial, float valorCambiado) throws InterruptedException{
		
		// Construccion del modelo
		Observado observado = new Observado(valorInicial);
		
		ArrayList<Observador> observadores = new ArrayList<Observador>();
		
		for(int i=0;i<numObservadores;i++) {
			Observador observador = new Observador(observado,i,valorInicial);
			observadores.add(observador);
			observador.start();
		}
		
		observado.setValor(valorCambiado);
		
		return observadores;
		
	}

	
}
