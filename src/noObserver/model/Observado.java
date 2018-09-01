package noObserver.model;

import java.util.concurrent.Semaphore;

public class Observado {

	static Semaphore mutex = new Semaphore(1);
	float valor;
	
	public Observado(float _valor){
		valor = _valor;
	}
	
	public void setValor(float _valor) {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valor = _valor;
		mutex.release();
	}
	
	public float getValor(){
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float val = valor;
		mutex.release();
		return val;
	}
	
}
