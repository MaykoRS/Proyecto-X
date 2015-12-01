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
import Mapa.PowerUp;
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
	
	/**
	 * Me retorna true si la pared es destruíble o false en caso contrario, sin hacer instanceOf, sino casteando.
	 * @param p Pared a verificar.
	 * @return True si y sólo sí la pared es Destruible.
	 */
	private boolean esDestruible(Pared p){
		boolean es = false;
		es = p!=null;
		try{
			ParedDestruible pa = (ParedDestruible)p;
		}catch(ClassCastException exc){es=false;}
		return es;
	}
	
	/**
	 * Me retorna true si la pared es Indestructíble o false en caso contrario, sin hacer instanceOf, sino casteando.
	 * @param p Pared a verificar.
	 * @return True si y sólo sí la pared es Indestructible.
	 */
	private boolean esIndestructible(Pared p){
		boolean es = false;
		es = p!=null;
		try{
			ParedIndestructible pa = (ParedIndestructible)p;
		}catch(ClassCastException exc){es=false;}
		return es;
		
	}
	
	public void run(){
		//while(!detener){
			try {	
				Thread.sleep(tiempo);
				bomba.explotar();
				bomberman.establecerBomba();
					
				ArrayList<Celda> listCeldas = new ArrayList<Celda>();
				ArrayList<PowerUp> listPowerUp = new ArrayList<PowerUp>();
				
				Celda posB = afectaCelda(bomba.getPosicion(),listPowerUp);
				listCeldas.add(posB);
				

				
				/* Recorro con doble for, la primera es las direcciones que son 
				 * izquierda, arriba, derecha, abajo y en el segundo for se encarga de
				 * las celdas hasta donde llega el alcance de la bomba */
				for(int dir = 37; dir<=40;dir++){
					Celda celdaActual = bomba.getPosicion();
					boolean sigo = true;
					for(int p = 0; p<bomberman.getAlcanceBomba() && sigo; p++){
						celdaActual=celdaActual.getVecina(dir);
						if(celdaActual!= null){
							celdaActual = afectaCelda(celdaActual,listPowerUp);
								//lblCel.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Explosion.png")));
							listCeldas.add(celdaActual);
							if(esIndestructible(celdaActual.getPared()))
								sigo = false;
						}else{
							sigo=false;
						}
						
					}
				}
				Thread.sleep(400);
				bomba.getGrafico().setIcon(null);

//				for(PowerUp pU : listPowerUp){
//					Celda c = pU.getPosicion();
//					//c.getGrafico().getGrafico().setIcon(null);
//					c.getGrafico().agregarPowerUP(pU);
//					
//				}
				
				for(Celda c : listCeldas){	
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
	private Celda afectaCelda(Celda celdaActual, ArrayList<PowerUp> lista){
		Celda salida = celdaActual;
		celdaActual.setGraficaExplosion();
		
		if(esDestruible(celdaActual.getPared())){
			bomberman.getJuego().incrementarPuntaje(celdaActual.getPared().GetPuntaje());
			String g=Integer.toString(bomberman.getJuego().getPuntaje());
			bomberman.getJuego().getGui().setPuntaje(g);
			bomberman.getJuego().disminuirPDestruible();
			if(celdaActual.hayPowerUp()) {
				celdaActual.getPared().destruir();
				lista.add(celdaActual.getPowerUp());
			}
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
	



