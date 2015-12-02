package Mapa;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Grafica.CeldaGrafica;
import Personajes.*;
import PowerUps.PowerUp;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
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
	protected CeldaGrafica grafico;
	protected int x,y;
	
	/**
	 * Crea un constructor con tres par�metros.
	 * @param map valor nuevo del atributo MiMapa
	 * @param x coordenada x de su ubicaci�n
	 * @param y coordenada y de su ubicaci�n
	 */
	public Celda(Mapa map, int x, int y) {	
		this.x=x;
		this.y=y;
		this.MiMapa = map;
		MiBomberman = null;
		MisEnemigos = new ArrayList<Enemigo>();
	    grafico= new CeldaGrafica(x,y);
	   
	}
	
	/**
	 * Comando encargado de setear el atributo MiPowerUp
	 * @param p PowerUp
	 */
	public void agregarPowerUp(PowerUp p)
	{
		MiPowerUp=p;
	}
	
	/**
	 * Comando encargado de agregar la bomba a la celda
	 * @param b Bomba
	 */
	public void agregarBomba(Bomba b)
	{
		this.MiBomba = b;
		grafico.agregarBomba(b);
		
		
	}
	/**
	 * Devuelve true y s�lo si hay pared.
	 * @return True y s�lo si hay pared.
	 */
	public boolean hayPared(){
		return MiPared != null;
	}
	
	
	/**
	 * Devuelve true si y s�lo si hay PowerUp.
	 * @return True si y s�lo si hay PowerUp.
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
	 * Devuelve true si y s�lo si hay por lo menos un enemigo.
	 * @return True si y s�lo si hay por lo menos un enemigo.
	 */
	public boolean hayEnemigo(){
		return this.MisEnemigos.size() > 0;
	}
	
	/**
	 * Devuelve true si y s�lo la celda es igual a la celda actual.
	 * @param c Celda a examinar.
	 * @return True si y s�lo la celda es igual a la celda actual.
	 */
	public boolean equals(Celda c){
		return (this.x == c.getX() && this.y == c.getY());
	}
	
	/**
	 * Agrega a un enemigo pasado por par�metro.
	 * @param e Enemigo a agragar.
	 */
	public void agregarEnemigo(Enemigo e){
		this.MisEnemigos.add(e);
	}
	
	/**
	 * Elimina a un enemigo pasado por par�metro.
	 * @param e Enemigo a eliminar.
	 */
	public void removeEnemigo(Enemigo e){
		this.MisEnemigos.remove(e);
		
	}

	
	/**
	 * Devuelve el atributo MiBomberman.
	 * @return Atributo MiBomberman.
	 */
	public Bomberman getBomberman(){
		return this.MiBomberman;
	}
	
	/**
	 * Establace el atributo MiBomberman por el Bomberman pasado por par�metro.
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
	 * Retorna true si y s�lo si logra remover la pared.
	 * @return True si y s�lo si logra remover la pared.
	 */
	public boolean removePared()
	{	
		boolean destrui = this.MiPared.destruir();
		if(destrui)
			this.MiPared = null;
		
		return destrui;
	}
	
	/**
	 * Consulta encargada de retornar el valor de verdad de si el Enemigo recibido por parametro
	 * tuvo contacto con el Bomberman
	 * @param e Enemigo
	 * @return el valor de verdad
	 */
	public boolean contactoConBomberman(Enemigo e){
		return this.MiBomberman != null;
	}
	
	/**
	 * Consulta que retorna el valor de verdad de si el Bomberman tuvo contacto con el Enemigo
	 * @param b Bomberman
	 * @return valor de verdad
	 */
	public boolean contactoConEnemigo(Bomberman b){
		return this.hayEnemigo();
	}
	
	
	/**
	 * Comando encargado de decidir si el Bomberman puede avanzar en la direcci�n
	 * pasada por par�metro
	 * @param b Bomberman
	 * @param dir direcci�n en la que desea avanzar
	 */
	public void dejarPasar(Bomberman b, int dir){
		if(this.hayPared()){
			this.MiPared.recibirBomberman(b,dir);
		}
		else{
			b.moverAhora(dir);
		}
	}
	
	/**
	 * Comando encargado de decidir si el Enemigo puede avanzar en la direcci�n
	 * pasada por par�metro
	 * @param e Enemigo 
	 * @param dir direcci�n en la que desea avanzar
	 */
	
	public void dejarPasar(Enemigo e, int dir){
		if(this.hayPared()){
			this.MiPared.recibirEnemigo(e,dir);
		}
		else{
			e.moverAhora(dir);
		}
	}
	
	/**
	 * Consulta que retorna la Celda vecina en la direcci�n pasada por par�metro
	 * @param dir direcci�n en la cual se desea ubicar la celda
	 * @return Celda 
	 */
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
	
	/**
	 * Consulta que retorna el valor del atributo x
	 * @return x
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * Consulta que retorna el valor del atributo y
	 * @return y
	 */
	
	public int getY(){
		return this.y;
	}

	/**
	 * Consulta que retorna la lista de Enemigo
	 * @return ArrayList<Enemigo>
	 */
	public ArrayList<Enemigo> getEnemigos() {
		return MisEnemigos;
	}

	/**
	 * Consulta que retorna el atributo MiPared
	 * @return MiPared
	 */
	public Pared getPared() {
		return this.MiPared;
	}

	/**
	 * Retorna el valor del atributo MiBomba
	 * @return MiBomba
	 */
	public Bomba getBomba() {
		return this.MiBomba;
	}
	
	/**
	 * Consulta que retorna el atributo grafico
	 * @return  grafico
	 */
	
	public CeldaGrafica getGrafico()
	{
		return grafico;
	}

	/**
	 * Comando encargado de setear el valor del PowerUp a nulo
	 */
	public void setPowerUp()
	{
		MiPowerUp=null;
		grafico.setGrafico();
	}
	
	/**
	 * Comando encargado de setear la explosi�n
	 */
	public void setGraficaExplosion() 
	{
		grafico.setExplosion();
		
	}
	

	
}
