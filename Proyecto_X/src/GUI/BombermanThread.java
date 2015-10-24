package GUI;

import Personajes.Bomberman;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class BombermanThread extends Thread {

	private Bomberman bomberman;
	private GUI gui;
	private boolean detener = false;
	
//	private static int velocidadEstandar = 1500;
//	private int velocidad;

	public BombermanThread(Bomberman b, GUI gui) {
		this.bomberman = b;
		this.gui = gui;
		this.detener = false;
	}

	public void run() {
		while(!detener){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			if(gui.getLock()){
				this.bomberman.mover(gui.getDirection());
				gui.toggleLock();
			} 
			if(this.bomberman.getPosicion().contactoConEnemigo(bomberman)){
				this.destruir();
				System.out.println("Bomberman ha sido afectado - Game Over");
			}
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
	
	
	/**
	 * Detengo la ejecución del hilo.
	 */
	public void destruir() {
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		this.bomberman.morir();
	}
}