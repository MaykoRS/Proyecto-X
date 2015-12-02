package Threads;

import Personajes.Bomberman;

public class MasacralityThread extends Thread {
	private int cant;
	private Bomberman bomberman;
	
	public MasacralityThread(Bomberman b) {
		this.bomberman = b;
	}
	
	public void run() {
		try {
			cant= bomberman.getMaxBombas();
			this.bomberman.cambiarSoyDios();
			Thread.sleep(5000);
			this.bomberman.cambiarSoyDios();
			bomberman.setCantBombas(cant);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}