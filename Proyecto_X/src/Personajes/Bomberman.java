package Personajes;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

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
	private boolean tirarBomba;
	
	/**
	 * Crea constructor con 2 parámetros.
	 * @param velocidad Velocidad inicializada del Bomberman.
	 * @param pos Posicion del Bomberman.
	 */
	public Bomberman(int velocidad, Celda pos,Juego j) {
		super(velocidad,pos);
		this.Mijuego = j;
		this.grafico = new BombermanGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
		this.modoDios = false;
		tirarBomba=true;
		MaxBomba=1;
	}					
	
	/**
	 * Crea consctructor con un parámetro.
	 * @param pos Posición del Bomberman.
	 */
	public Bomberman(Celda pos, Juego j){
		super(pos);
		this.Mijuego = j;
		
		this.grafico = new BombermanGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}


    /**
     * Metodo encargado de mover el Bomberman
     */
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
	
	/**
	 * Consulta que retorna el valor de verdad del atributo modoDios
	 * @return modoDios
	 */
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
	
	
	/**
	 * Método encargado de la muerte del Bomberman
	 */
	public void morir() {
		this.grafico.morir();
		vive = false;
		this.getJuego().detenerTiempo();
	}
	
	/**
	 * Consulta que retorna el valor del atributo velocidad
	 * @return velocidad
	 */
	public int getVelocidad()
	{
		return velocidad;
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
		Bomba nueva = null ;
		if(dir == KeyEvent.VK_SPACE) {
			if (!soyDios()) {
				if (puedoTirarOtraBomba()) {
					nueva = new Bomba(alcanceBomba,this.posicion,this);
				    posicion.agregarBomba(nueva);
				    MaxBomba--;
			   	}
			}
			else {	
				nueva = new Bomba(alcanceBomba,this.posicion,this);
		        posicion.agregarBomba(nueva);
		    }
	    }
		 return nueva;
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
	
	/**Devuelve el valor de verdad de si es posible o no tirar otra bomba
	 * 
	 * @return 
	 */
	public boolean puedoTirarOtraBomba()
	{
		return MaxBomba>0;
	}
	 
	/**
	 * Devuelve el alcance de la bomba.
	 * @return Alcance de la bomba.
	 */
	public int getAlcanceBomba()
	{
		return this.alcanceBomba;
	}
	
	/**
	 * Establece el nuevo alcance de la bomba.
	 * @param a Nuevo alcance a establecer.
	 */
	public void setAlcanceBomba(int a){
		 alcanceBomba = a;
	}

	public void setTirarBomba(boolean b) 
	{
		tirarBomba=b;
	}
	
	public Juego getJuego()
	{
		return Mijuego;
	}

	public void cambiarSoyDios()
	{
		modoDios=!modoDios;
		
	}
	public void establecerBomba()
	{
		MaxBomba++;
	}
}
