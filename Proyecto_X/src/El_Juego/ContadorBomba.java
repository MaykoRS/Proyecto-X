package El_Juego;

import Personajes.Bomberman;

public class ContadorBomba extends Thread {
	
	private Bomberman b;
	private int tiempo;
	
	public ContadorBomba(Bomberman B, int t){
		this.b = B;
		this.tiempo = t;
	}
	
	public void run(){
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//b.getVelocidad();
		System.out.println("EXPLOTE");
	}
}
