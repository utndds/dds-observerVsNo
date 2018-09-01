import observer.ConPatron;

import java.util.ArrayList;

import noObserver.SinPatron;
import noObserver.model.Observador;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		float valorInicial = 0;
		float valorCambiado = 5;
		int cantObservadores = 100000;
		
		// CON OBSERVER
		long startTime = System.nanoTime();
		ConPatron.ejecutar(cantObservadores,valorInicial,valorCambiado);
		long endTime = System.nanoTime();
		
		long time = (endTime - startTime);

		System.out.println("Resultados con patron Observer");
		System.out.println("Nanosegundos: " + time);
		System.out.println("Milisegundos: " + ((double) time/1000000));
		System.out.println("Segundos: " + ((double) time/1000000000));
		
		// SIN OBSERVER
		System.out.println("------------------------------------");
		System.out.println("Resultados sin patron Observer (Hilos)");
		ArrayList<Observador> observadores = SinPatron.ejecutar(cantObservadores, valorInicial, valorCambiado);
	
		// Sleep para dejar terminar a todos los hilos
		Thread.sleep(1000);
	
		time = 0;
		for(Observador observador : observadores) {
			if (observador.tiempo  == 0 || observador.valorActual != valorCambiado){
				System.out.println("Hilo " + observador.id + " no termino, cambiar sleep hilo");
				break;
			} else {
				time = time + observador.tiempo;
			}
		}
		
		double timeProm = (double) time / observadores.size();
		System.out.println("Nanosegundos: " + timeProm);
		System.out.println("Milisegundos: " + ((double) timeProm/1000000));
		System.out.println("Segundos: " + ((double) timeProm/1000000000));
		
	}

}
