package El_Juego;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.GUI;
import Grafica.CeldaGrafica;
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
	
	private boolean esDestruible(Pared p){
		boolean es = false;
		es = p!=null;
		try{
			ParedDestruible pa = (ParedDestruible)p;
		}catch(ClassCastException exc){es=false;}
		return es;
	}
	
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
				
				ArrayList<JLabel> listCeldas = new ArrayList<JLabel>();
				listCeldas.add(afectaCelda(bomba.getPosicion()));
				
				for(int dir = 37; dir<=40;dir++){
					Celda celdaActual = bomba.getPosicion();
					boolean sigo = true;
					for(int p = 0; p<bomberman.getAlcanceBomba() && sigo; p++){
						celdaActual = celdaActual.getVecina(dir);
						if(celdaActual!= null){
							JLabel lblCel = afectaCelda(celdaActual);
							if(lblCel!=null){
								lblCel.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Explosion.png")));
								listCeldas.add(lblCel);
							}else 
								if(esIndestructible(celdaActual.getPared()))
									sigo = false;
						}else{
							sigo=false;
						}
						
					}
				}
				Thread.sleep(1000);
				bomba.getGrafico().setIcon(null);
				for(JLabel l: listCeldas){//mostrar powerups!!
					if(l!=null)
						l.setIcon(bomba.getPosicion().getGrafico().getIcon());

				}
				//System.out.println("EXPLOTE");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			detener();
//			if(gui.getDirection() == 32)
				//System.out.println("EXPLOTE");
		//}
	}
	
	private JLabel afectaCelda(Celda celdaActual){
		JLabel salida = null;
		
			if(!celdaActual.hayPared()){
				salida = celdaActual.getGrafico().getGrafico();
			}
			
			if(esDestruible(celdaActual.getPared())){
				salida=celdaActual.getPared().getGrafico();
				celdaActual.removePared();
			}
			
			if(celdaActual.hayEnemigo()){
//				int index=0;
//				while(!celdaActual.getEnemigos().isEmpty() && index <= 6){
//					Enemigo ene = celdaActual.getEnemigos().get(index);
//					salida = ene.getGrafico();
//					ene.morir();
//					celdaActual.removeEnemigo(ene);
//					index++;
//				}
				for(int i=0; i<celdaActual.getEnemigos().size(); i++){
					Enemigo ene = celdaActual.getEnemigos().get(i);
					salida = ene.getGrafico();
					ene.morir();
					celdaActual.removeEnemigo(ene);
				}
			}
			if(celdaActual.getBomberman()!=null){
				celdaActual.getBomberman().morir();
				salida = celdaActual.getBomberman().getGrafico();
				JOptionPane.showMessageDialog(null, "GAME OVER");
			}
			
			
			//celdaActual.remove
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
