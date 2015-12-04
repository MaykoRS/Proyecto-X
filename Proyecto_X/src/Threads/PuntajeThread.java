package Threads;

import El_Juego.Juego;
import GUI.GUI;

public class PuntajeThread  extends Thread
{
	private GUI gui;
	private String cadenaPuntaje="";
	private boolean detener = false;
	private Juego MiJuego;
	
	public PuntajeThread(GUI g,Juego j)
	{
		this.gui = g;
		this.MiJuego = j;
	}
	
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.detener){
			try {
				Thread.sleep(1000);
				this.cadenaPuntaje = Integer.toString(MiJuego.getPuntaje());
				this.gui.setPuntaje(cadenaPuntaje);
				
			} catch (InterruptedException e) { }
		}
	}


   public void detener() {
	this.interrupt();
	
	
	  this.detener = true;
   }
}