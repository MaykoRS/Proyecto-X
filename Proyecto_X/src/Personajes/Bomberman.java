package Personajes;

import java.awt.event.KeyEvent;

import El_Juego.Juego;
import Grafica.BombermanGrafica;
import Mapa.Bomba;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Bomberman extends Personaje{

	private int MaxBomba;
	private int alcanceBomba = 1;
	private Juego Mijuego;
	private Bomba MiBomba;
	
	/**
	 * Crea constructor con 2 parámetros.
	 * @param velocidad Velocidad inicializada del Bomberman.
	 * @param pos Posicion del Bomberman.
	 */
	public Bomberman(int velocidad, Celda pos) {
		super(velocidad,pos);
		this.grafico = new BombermanGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
		this.modoDios = true;// PUSE ESTO PARA HACER LA PRUEBA DE MODO DIOS, EN EL JUEGO NO DEBE ESTAR ESTA SENTENCIA
	}						// PORQUE YA ESTA SETEADO EN LA  CLASE PERSONAJE COMO "FALSE" Y POR ENDE LO HEREDA.
	
	/**
	 * Crea consctructor con un parámetro.
	 * @param pos Posición del Bomberman.
	 */
	public Bomberman(Celda pos){
		super(pos);
		
		this.grafico = new BombermanGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}

	@Override
	public void mover(int dir){
		Celda destino =  this.posicion.getVecina(dir);
		if(destino != null)
			destino.dejarPasar(this, dir);

	}
	
	/**
	 * Mueve a Bomberman a la dirección indicada por parámetro, respetando si es o no modoDios.
	 * @param dir Dirección a mover.
	 */
	public void moverAhora(int dir){
		this.posicion.setBomberman(null);
		
		switch(dir){
			case KeyEvent.VK_UP : //Arriba
				super.mover(KeyEvent.VK_UP);
				break;
			case KeyEvent.VK_DOWN : //Abajo
				super.mover(KeyEvent.VK_DOWN);
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				super.mover(KeyEvent.VK_LEFT);
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				super.mover(KeyEvent.VK_RIGHT);
				break;
		}
		this.posicion.setBomberman(this);
	}
	
	@Override
	public boolean soyDios() {
		return this.modoDios;
	}
	
	/**
	 * Establece modoDios de Bomberman.
	 * @param b Booleano a establecer.
	 */
	public void setModoDios(boolean b){
		this.modoDios = b;
	}
	
	
	@Override
	public void morir() {
		this.grafico.morir();	
	}
	
	/* (non-Javadoc)
	 * @see Personajes.Personaje#getVelocidad()
	 */
	public int getVelocidad(){
		return this.velocidad;
	}
	

	/**
	 * Establece la nueva velocidad.
	 * @param v Velocidad a establecer.
	 */
	public void setVelocidad(int v){
		this.velocidad = v;
	}

	
	/**
	 * Crea y devuelve una bomba. 
	 * @return Bomba a soltar.
	 */
	public Bomba soltarBomba(int dir) {
		if(dir == KeyEvent.VK_SPACE){
			MiBomba = new Bomba(alcanceBomba,this.posicion,this.Mijuego.getTiempoActual());
			getPosicion().agregarBomba(MiBomba);
			//this.Mijuego.getGUI().add(MiBomba.getGrafico());
			System.out.println("SOLTAR BOMBA");
			MiBomba.esperarParaExplotar();
		}
		return MiBomba;
   	}
	
	/**
	 * Devuelve la cantidad màxima de bombas.
	 * @return Cantidad màxima de bombas.
	 */
	public int getMaxBombas(){
        return this.MaxBomba;  
    }
	

	/**
	 * Aumenta cantidad màxima de bombas.
	 * @param m Cantidad a aumentar.
	 */
	public void setMaxBombas(int m){
    	this.MaxBomba += m;
    }
	
	/**
	 * Devuelve true si y solo si logra matar al menos a uno.
	 * @return True si y solo si logra matar al menos a uno.
	 */
	public boolean mateAalguien(){
		boolean mate = false;
    	if(posicion.hayEnemigo()){
    		 for(int i=0;i<posicion.getEnemigos().size();i++){
    			Mijuego.incrementarPuntaje(posicion.getEnemigos().get(i).getPuntosPorMuerte());
    			posicion.removeEnemigo(posicion.getEnemigos().get(i));
    		  }
    		mate = true;		
       }
       	return mate;
  	 }
	
	/**
	 * 
	 * @return
	 */
	public boolean puedoTirarOtraBomba(){
		return true;// modificar
	}
	 
	/**
	 * Devuelve el alcance de la bomba.
	 * @return Alcance de la bomba.
	 */
	public int getAlcanceBomba(){
		return this.alcanceBomba;
	}
	
	/**
	 * Establece el nuevo alcance de la bomba.
	 * @param a Nuevo alcance a establecer.
	 */
	public void setAlcanceBomba(int a){
		 alcanceBomba = a;
	}
	
}
