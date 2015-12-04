package Threads;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.GUI;
import Mapa.Bomba;
import Mapa.Celda;
import Mapa.Pared;
import Mapa.ParedIndestructible;
import Mapa.ParedDestruible;
import Personajes.Bomberman;
import Personajes.Enemigo;




import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.GUI;
import Mapa.Bomba;
import Mapa.Celda;
import Mapa.Pared;
import Mapa.ParedIndestructible;
import Mapa.ParedDestruible;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class BombaTread extends Thread {
	
	private Bomberman bomberman;
	private Bomba bomba;
	private int tiempo;
	private boolean detener = false;
    private String cadenaPuntaje="";
	
	public BombaTread(Bomberman B, Bomba b, int t){
		this.bomberman = B;
		this.tiempo = t;
		this.bomba=b;
		
	}
	
	
	public void run(){
			try {	
				Thread.sleep(tiempo);
				bomba.explotar();
				
				bomberman.establecerBomba();
				
					
				ArrayList<Celda> listCeldas = new ArrayList<Celda>();
				
				
				/* Recorro con doble for, la primera es las direcciones que son 
				 * izquierda, arriba, derecha, abajo y en el segundo for se encarga de
				 * las celdas hasta donde llega el alcance de la bomba */
				
				
				Celda celdabomba= bomba.getPosicion();
				bomberman.getJuego().incrementarPuntaje(celdabomba.explotar());
				for(int dir = 37; dir<=40;dir++){
					Celda celdaActual = bomba.getPosicion();
					boolean sigo = true;
					for(int p = 0; sigo && p<bomberman.getAlcanceBomba(); p++){
						celdaActual=celdaActual.getVecina(dir);
						
						if(celdaActual != null){
							 if((celdaActual.hayPared()) )
								 sigo=false;	
							 
							 listCeldas.add(celdaActual);
							 bomberman.getJuego().incrementarPuntaje(celdaActual.explotar());
						}
						else
							sigo=false;
						
						
						
					}
				}
				Thread.sleep(400);
				
				bomba.getPosicion().setGraficos();
				
               
				for(Celda c : listCeldas){
					c.setGraficos();
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			detener();
			
	}
	

	public void detener() {
		this.interrupt();
		
		// Seteamos el flag para detener su ejecución.
		this.detener = true;
	}
	
	
}