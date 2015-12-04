package Threads;

import Personajes.Bomberman;

public class MasacralityThread extends Thread {
	
	private Bomberman bomberman;
	
	public MasacralityThread(Bomberman b) {
		this.bomberman = b;
	}
	
	public void run() {
		try {
			
			bomberman.setModoDios(true);
			Thread.sleep(5000);
			this.bomberman.setModoDios(false);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
