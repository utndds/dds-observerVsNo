package noObserver.model;

import noObserver.model.Observado;

public class Observador extends Thread{

	Observado observado;
	public int id;
	public float valorActual = 0;
	public long tiempo = 0;
	
	public Observador(Observado _observado, int _id, float _valorInicial) {
		observado = _observado;
		id = _id;
		valorActual = _valorInicial;
	}
	
	@Override
	public void run() {
	
		long startTime = System.nanoTime();
		boolean x = true;
		while(x) {
			
			float valor = observado.getValor();
			if(valor != valorActual){
				x = false;
				valorActual = valor;
			}
			
		}
		
		long endTime = System.nanoTime();
		tiempo = endTime - startTime;
		
	}

}
