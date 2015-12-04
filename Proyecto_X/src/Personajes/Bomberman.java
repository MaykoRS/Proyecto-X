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

	private int cantMaxBombas;
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
		Mijuego = j;
		this.grafico = new BombermanGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
		this.modoDios = false;
		tirarBomba = true;
		cantMaxBombas = 1;
	}					
	
	/**
	 * Crea consctructor con un parámetro.
	 * @param pos Posición del Bomberman.
	 */
	public Bomberman(Celda pos){
		super(pos);
		
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
		Bomba nueva = null ;
		if(dir == KeyEvent.VK_SPACE) {
			if (!soyDios()) {
				
				if (puedoTirarOtraBomba()) {
					nueva = new Bomba(alcanceBomba,this.posicion,this);
				    posicion.agregarBomba(nueva);
				    cantMaxBombas--;
				    
			   	}
			}
			else {	
				nueva = new Bomba(alcanceBomba,this.posicion,this);
		        posicion.agregarBomba(nueva);
		        cantMaxBombas--;
		    }
			
	    }
		 return nueva;
   	}
	
	/**
	 * Devuelve la cantidad màxima de bombas.
	 * @return Cantidad màxima de bombas.
	 */
	public int getMaxBombas(){
        return this.cantMaxBombas;  
    }
	

	/**
	 * Aumenta cantidad màxima de bombas.
	 * @param m Cantidad a aumentar.
	 */
	public void setMaxBombas(){
    	this.cantMaxBombas ++;
    }
	
	/**
	 * Devuelve el valor de verdad de si es posible o no tirar otra bomba
	 * @return True si en caso puedo tirar otra bomba.
	 */
	public boolean puedoTirarOtraBomba()
	{
		return this.cantMaxBombas > 0;
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

	/**
	 * @param b boolean a anadir.
	 */
	public void setTirarBomba(boolean b) 
	{
		this.tirarBomba = b;
	}
	
	/**
	 * @return Mijuego a retornar.
	 */
	public Juego getJuego()
	{
		return Mijuego;
	}

	/**
	 * Setea el modoDios del bomberman.
	 */
	public void cambiarSoyDios()
	{
		modoDios=!modoDios;	
	}
	
	/**
	 * aumenta la bomba en uno ,usada para recuperar la bomba al tirarla.
	 */
	public void establecerBomba()
	{
		
		cantMaxBombas++;
	}
}
