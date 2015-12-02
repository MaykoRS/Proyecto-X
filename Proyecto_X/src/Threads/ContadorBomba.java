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

public class ContadorBomba extends Thread {
	
	private Bomberman bomberman;
	private Bomba bomba;
	private int tiempo;
	private boolean detener = false;
 
	
	public ContadorBomba(Bomberman B, Bomba b, int t){
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
				listCeldas.add(afectaCelda(bomba.getPosicion()));
				
				/* Recorro con doble for, la primera es las direcciones que son 
				 * izquierda, arriba, derecha, abajo y en el segundo for se encarga de
				 * las celdas hasta donde llega el alcance de la bomba */
				for(int dir = 37; dir<=40;dir++){
					Celda celdaActual = bomba.getPosicion();
					boolean sigo = true;
					for(int p = 0; sigo && p<bomberman.getAlcanceBomba(); p++){
						celdaActual=celdaActual.getVecina(dir);
						if(celdaActual != null){
							if(celdaActual.hayPared()){
								sigo = false;
							}
							celdaActual = afectaCelda(celdaActual);
							listCeldas.add(celdaActual);
														
						}else{
							sigo=false;
						}
						
					}
				}
				Thread.sleep(400);
				bomba.getGrafico().setIcon(null);

				for(Celda c : listCeldas){
					if(c != null){	
						if(c.hayEnemigo()){
							c.getGrafico().setGrafico();
						}else
						if(c.getBomba() != null){
							c.getGrafico().setGrafico();
						}else
						if(!c.hayPowerUp()){
							c.getGrafico().setGrafico();
						}
					}
							
				}
				//System.out.println("EXPLOTE");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			detener();
			
	}
	
	/**
	 * Este método te devuelve el JLabel de la ceda afectada pasada por parámetro.
	 * @param celdaActual Celda afectada.
	 * @return JLabel de la celda afectada.
	 */
	private Celda afectaCelda(Celda celdaActual){
		Celda salida = celdaActual;
		celdaActual.setGraficaExplosion();
		
		if(celdaActual.hayPared()){
			bomberman.getJuego().incrementarPuntaje(celdaActual.getPared().GetPuntaje());
			String g = Integer.toString(bomberman.getJuego().getPuntaje());
			bomberman.getJuego().getGui().setPuntaje(g);
			bomberman.getJuego().disminuirPDestruible();
			celdaActual.removePared();
			if(bomberman.getJuego().gane()){
				bomberman.getJuego().detenerTiempo();
				JOptionPane.showMessageDialog(null, "FELICIDADES, GANASTE");
			}
		}
			
		if(celdaActual.hayEnemigo()){
			for(int i=0; i<celdaActual.getEnemigos().size(); i++){
				Enemigo ene = celdaActual.getEnemigos().get(i);
				bomberman.getJuego().incrementarPuntaje(ene.getPuntosPorMuerte());
				String g=Integer.toString(bomberman.getJuego().getPuntaje());
				bomberman.getJuego().getGui().setPuntaje(g);
					 
				ene.morir();
				celdaActual.removeEnemigo(ene);
			}
		}
		
		if(celdaActual.getBomberman()!=null){
			if(!(celdaActual.getBomberman().soyDios()))
			{	bomberman.morir();
			JOptionPane.showMessageDialog(null,"Bomberman ha sido afectado - GAME OVER");
		}}
			
		return salida;
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
	



