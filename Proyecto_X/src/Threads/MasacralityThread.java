package Threads;

import Personajes.Bomberman;

public class MasacralityThread extends Thread {
	
	private Bomberman bomberman;
	
	public MasacralityThread(Bomberman b) {
		this.bomberman = b;
	}
	
	public void run() {
		try {
			
			
			Thread.sleep(5000);
			this.bomberman.cambiarSoyDios();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
