package GUI;

import Personajes.Enemigo;

/**
 * Clase correspondiente a la implementación del hilo de la clase Enemigo.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *  
 */
public class EnemigoThread extends Thread{

	private Enemigo enemigo;
	private static int velocidadEstandar = 1500;
	private int velocidad;
	private volatile boolean eDetener;
	private GUI gui;
	
	public EnemigoThread(Enemigo e, GUI gui){
		this.gui = gui;
		this.enemigo = e;
		this.eDetener = false;
		this.velocidad = e.getVelocidad();
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.eDetener){
			try {
				Thread.sleep(this.velocidadEstandar / velocidad);
				
				// Realizo el movimiento
				if(this.enemigo.getVive())
					this.enemigo.mover();
				else{
					//enemigo.getGrafico().setIcon(null);
					eDetener=true;
				}
			} catch (InterruptedException e) { }
		}
	}
	
	
	/**
	 * Interrumpe el hilo para que no continue con su ejecución. 
	 */
	public void detener() {
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		this.eDetener = true;
	}
	
	
	/**
	 * Detengo la ejecucion del hilo.
	 */
	public void destruir() {
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		this.enemigo.morir();
	}
	
}
