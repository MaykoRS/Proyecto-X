   package Threads;

import javax.swing.JOptionPane;
import GUI.GUI;
import Mapa.Bomba;
import Personajes.Bomberman;

/**
 * Clase correspondiente a la implementación del hilo del Personaje Bomberman.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *  
 */
public class BombermanThread extends Thread {

	private Bomberman bomberman;
	private GUI gui;
	private boolean detener = false;
	
	private static int velocidadEstandar = 800;
	private int velocidad;

	public BombermanThread(Bomberman b, GUI gui) {
		this.bomberman = b;
		this.gui = gui;
		this.detener = false;
		this.velocidad = b.getVelocidad();
	}

	public void run() {
		while(!detener){
			try {
				Thread.sleep(velocidadEstandar / velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			if(!bomberman.getVive())
				detener();
			
			if(gui.getLock()){
				if(direccionValida()){
					this.bomberman.mover(gui.getDirection());
					if(bomberman.getPosicion().hayPowerUp())
					{
						bomberman.getPosicion().getPowerUp().afectarPersonaje(bomberman);
						bomberman.getJuego().incrementarPuntaje(bomberman.getPosicion().getPowerUp().getPuntaje());
						bomberman.getPosicion().setPowerUp();
						
						
						
					}
					gui.toggleLock();
				}else{
					Bomba actual = this.bomberman.soltarBomba(gui.getDirection());
					
					if(actual!=null){
						this.bomberman.getPosicion().agregarBomba(actual);
						actual.esperarParaExplotar();
						
						
					}
					gui.toggleLock();
				}
				
			} 
			if(this.bomberman.getPosicion().contactoConEnemigo(bomberman) && !bomberman.soyDios()){
				JOptionPane.showMessageDialog(null,"Bomberman ha sido afectado - GAME OVER");
				this.bomberman.morir();
				this.destruir();
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
	
	private boolean direccionValida(){
		return gui.getDirection() >= 37 && gui.getDirection() <= 40;
	}
}