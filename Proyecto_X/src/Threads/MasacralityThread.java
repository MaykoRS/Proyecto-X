package Threads;

import Personajes.Bomberman;
/** Clase correspondiente a la implementación del hilo del Masacrality.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class MasacralityThread extends Thread {
	
	private Bomberman bomberman;
	
	/**
	 * Crea un constructor con un único parámetro
	 * @param b Bomberman
	 */
	public MasacralityThread(Bomberman b) {
		this.bomberman = b;
	}
	/**
	 * Metodo encargado del funcionamiento del hilo. 
	 */
	
	public void run() {
		try {
			
			this.bomberman.cambiarSoyDios();
			Thread.sleep(5000);
			this.bomberman.cambiarSoyDios();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
