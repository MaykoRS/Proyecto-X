package El_Juego;


import GUI.GUI;
import Personajes.Bomberman;

public class ContadorBomba extends Thread {
	
	private Bomberman bomberman;
	private int tiempo;
	private boolean detener = false;
 
	
	public ContadorBomba(Bomberman B, int t){
		this.bomberman = B;
		this.tiempo = t;
	}
	
	public void run(){
		while(!detener){
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			if(gui.getDirection() == 32)
//				System.out.println("EXPLOTE");
		}
	}
	
	
	/**
	 * Detiene el hilo para que no continue con su ejecución.
	 */
	public void detener() {
		this.interrupt();
		
		// Seteamos el flag para detener su ejecución.
		this.detener = true;
	}
	
	
}
