package Mapa;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import Grafica.PDestruibleGrafica;
import Personajes.*;

/**
 * @author El Vaquero
 *
 */
/**
 * @author El Vaquero
 *
 */
public class Celda {
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int SPACE = KeyEvent.VK_SPACE;
	
	protected ArrayList<Enemigo> MisEnemigos;
	protected Bomberman MiBomberman;
	protected Mapa MiMapa;
	protected Pared MiPared;
	protected PowerUp MiPowerUp;
	protected Bomba MiBomba;
	
	protected int x;
	protected int y;
	
	public Celda(Mapa map, int x, int y){
		this.x = x;
		this.y = y;
		this.MiMapa = map;
		MiBomberman = null;
		MisEnemigos = new ArrayList<Enemigo>();
	}
	
	public void agregarBomba(Bomba b){
		this.MiBomba = b;
	}
	/**
	 * Devuelve true y sòlo si hay pared.
	 * @return True y sòlo si hay pared.
	 */
	public boolean hayPared(){
		return this.MiPared != null;
	}
	
	/**
	 * Devuelve true si y sòlo si hay PowerUp.
	 * @return True si y sòlo si hay PowerUp.
	 */
	public boolean hayPowerUp(){
		return this.MiPowerUp != null;
	}
	
	/**
	 * Devuelve el atributo PowerUp.
	 * @return El atributo PowerUp.
	 */
	public PowerUp getPowerUp(){
		return this.MiPowerUp;
	}
	
	/**
	 * Devuelve true si y sòlo si hay por lo menos un enemigo.
	 * @return True si y sòlo si hay por lo menos un enemigo.
	 */
	public boolean hayEnemigo(){
		return this.MisEnemigos.size() > 0;
	}
	
	/**
	 * Devuelve true si y sòlo la celda es igual a la celda actual.
	 * @param c Celda a examinar.
	 * @return True si y sòlo la celda es igual a la celda actual.
	 */
	public boolean equals(Celda c){
		return (this.x == c.getX() && this.y == c.getY());
	}
	
	/**
	 * Agrega a un enemigo pasado por paràmetro.
	 * @param e Enemigo a agragar.
	 */
	public void agregarEnemigo(Enemigo e){
		this.MisEnemigos.add(e);
	}
	
	/**
	 * Elimina a un enemigo pasado por paràmetro.
	 * @param e Enemigo a eliminar.
	 */
	public void removeEnemigo(Enemigo e){
		this.MisEnemigos.remove(e);
	}
	
//	public Enemigo buscarEnemigo(int pos){
//		return this.MisEnemigos.get(pos);
//	}
	
	/**
	 * Devuelve el atributo MiBomberman.
	 * @return Atributo MiBomberman.
	 */
	public Bomberman getBomberman(){
		return this.MiBomberman;
	}
	
	/**
	 * Establace el atributo MiBomberman por el Bomberman pasado por paràmetro.
	 * @param b Atributo a retornar.
	 */
	public void setBomberman(Bomberman b){
		this.MiBomberman = b;
	}
	
	/**
	 * Agrega Pared.
	 * @param p Pared a agregar.
	 */
	public void agregarPared(Pared p){
		this.MiPared = p;
	}
	
	/**
	 * Elimina Pared.
	 * @param p Pared a eliminar.
	 */
	public void removePared(){
		this.MiPared = null;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean contactoConBomberman(Enemigo e){
		return this.MiBomberman != null;
	}
	
	public boolean contactoConEnemigo(Bomberman b){
		return this.hayEnemigo();
	}
	
	public void dejarPasar(Bomberman b, int dir){
		if(this.hayPared()){
			this.MiPared.recibirBomberman(b,dir);
		}
		else{
			b.moverAhora(dir);
		}
	}
	
	public void dejarPasar(Enemigo e, int dir){
		if(this.hayPared()){
			this.MiPared.recibirEnemigo(e,dir);
		}
		else{
			e.moverAhora(dir);
		}
	}
	
	public Celda getVecina(int dir){
		switch (dir){
			case UP :
				return this.MiMapa.getCelda(x, y - 1);
			case DOWN :
				return this.MiMapa.getCelda(x, y + 1);
			case LEFT :
				return this.MiMapa.getCelda(x - 1, y);
			case RIGHT :
				return this.MiMapa.getCelda(x + 1, y);
		}
		return null;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return MisEnemigos;
	}

	public Pared getPared() {
		return this.MiPared;
	}

	public Bomba getBomba() {
		return this.MiBomba;
	}
	
}
