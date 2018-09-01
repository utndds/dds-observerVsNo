package observer;

import observer.model.*;

public class ConPatron {
	
	public static void ejecutar(int numObservadores,float valorInicial, float valorCambiado) {
		
		// Construccion del modelo
		Observado observado = new Observado(valorInicial);
		
		for(int i=0; i<numObservadores;i++) {
			Observador observador = new Observador();
			observado.agregarObservador(observador);
		}
				
		observado.setValor(valorCambiado);
	
	}


}
