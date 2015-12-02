package El_Juego;

import java.util.Random;
import GUI.GUI;
import Mapa.*;
import Personajes.*;
import PowerUps.*;
import Threads.EnemigoThread;



/**
 * Clase correspondiente a la Implementacion del módulo Juego
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Juego {

	protected int puntaje;
	protected static final int WIDTH = 13;
	protected static final int HEIGHT = 31;
	
	protected EnemigoThread [] EnemigoHilo;
	protected Enemigo [] MisEnemigos;
	protected PowerUp[] MisPowerUps;
	protected Bomberman MiBomberman;
	protected Tiempo MarcadorTiempo;
	protected GUI MiGui;
	protected Mapa MiMapa;
	
	private int cantSpeedUp = 4;
	private int cantFatality = 3;
	private int cantBombality = 3;
	private int cantMasacrality = 1;
	
	protected boolean detener;
	protected boolean gane;
	protected int cantPDestruibles;
	
	
	/**
	 * Crea un constructor con un único parámetro
	 * @param gui GUI
	 */
	public Juego(GUI gui){
		this.MiGui = gui;
		this.MiMapa = new Mapa(HEIGHT,WIDTH);
		this.puntaje = 0;
		this.detener = false;
		this.gane = false;
		this.cantPDestruibles = 124;
		this.MarcadorTiempo = new Tiempo(MiGui);
		this.MarcadorTiempo.start();
		
		/* Inserto a Bomberman en su respectiva celda */
		Celda c = this.MiMapa.getCelda(1,1);
		MiBomberman = new Bomberman(1,c,this);
		this.MiGui.add(MiBomberman.getGrafico(),0);
        
		
		insertarParedes(MiGui);
		insertarEnemigos(MiGui);
		insertarCeldasTransitables(MiGui);
	
	}
	
	/**
	 * Crea e inserta todas las paredes y los agrega a la GUI pasada por paràmetro.
	 * @param g GUI a añadir.
	 */
	private void insertarParedes(GUI g){
		/* Inserto las paredes Indestructibles */
		Celda cel;
		Pared p;
		for(int f=0; f<HEIGHT; f++){
			for(int c=0; c <WIDTH; c++){
				if(f==0 || f==HEIGHT-1 || c==0 || c==WIDTH-1 || (f%2==0 && c%2==0)){
					cel = this.MiMapa.getCelda(f,c);
					p = new ParedIndestructible(cel);
					cel.agregarPared(p);
					g.add(p.getGrafico());
				}	
				
					
			}
		}
		
		/* Inserto las paredes Destruibles aleatoriamente */
		Random rnd = new Random();
		int ancho; 	int altura;
		int contador = 0;
		
		while(contador < cantPDestruibles){ // 124 ES EL 50% DE LAS CELDAS NO OCUPADAS POR PARED INDESTRUCTIBLE
			try {
				ancho = (int)(rnd.nextDouble()*29 +1);
				altura = (int)(rnd.nextDouble()*11 +1);
				cel = this.MiMapa.getCelda(ancho,altura);
				if(!cel.hayPared() && !lugarReservado(ancho,altura) ){
					p = new ParedDestruible(cel);
					cel.agregarPared(p);
					g.add(p.getGrafico(),1 );
					agregarPowerUp(cel);
					contador++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Crea e inserta a todos los powerUp 'detrás' de las paredes destruíbles y los añade en la GUI pasada por paràmetro. 
	 * @param g GUI a añadir.
	 */
	private void agregarPowerUp(Celda c)
	{
		if(cantFatality>0)
		{	Fatality f = new Fatality(c);
			c.agregarPowerUp(f);
			//MiGui.add(f.getGrafico(),2);
			cantFatality--;
		}
		else
		{
			if(cantMasacrality>0)
			{	Masacrality m = new Masacrality(c);
				c.agregarPowerUp(m);
				//MiGui.add(m.getGrafico(),2);
				cantMasacrality--;
			}
			else
			{
				if(cantSpeedUp>0)
				{	Speed_Up s = new Speed_Up(c);
					c.agregarPowerUp(s);
					//MiGui.add(s.getGrafico(),2);
					cantSpeedUp--;
				}
				else
				{
					if(cantBombality>0) {
						Bombality b = new Bombality(c);
						c.agregarPowerUp(b);
						//MiGui.add(b.getGrafico(),2);
						cantBombality--;
					}
				}
						
			}
		}
		
	}
	
	
	/**
	 * Crea e inserta a todos los enemigos y los añade en la GUI pasada por paràmetro. 
	 * @param g GUI a añadir.
	 */
	private void insertarEnemigos(GUI g){
		this.MisEnemigos = new Enemigo[6];
		this.EnemigoHilo = new EnemigoThread[6];
		
		Random rnd = new Random();
		Enemigo e;	Celda cel;
		int i=0;	int ancho, altura;
		while(i < 5){
			try {
				ancho = (int)(rnd.nextDouble()*29 +1);
				altura = (int)(rnd.nextDouble()*11 +1);
				cel = this.MiMapa.getCelda(ancho,altura);
				if(!cel.hayPared() && !lugarReservado(ancho,altura)){
					if(i < 3){
						e = new Rugulo(1,cel);
						cel.agregarEnemigo(e); 
						g.add(e.getGrafico(),0);
					}
					else{ 
						e = new Altair(1,cel);
						cel.agregarEnemigo(e);
						g.add(e.getGrafico(),0);
					}
					MisEnemigos[i] = e;
					EnemigoHilo[i] = new EnemigoThread(e,g); 
					i++;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		cel = this.MiMapa.getCelda(29,11);
		e = new Sirius (5,cel,this);
		MisEnemigos[5] = e;
		EnemigoHilo[5] = new EnemigoThread(e,g);
		g.add(e.getGrafico(),0);
	}
	
	
	/**
	 * Agrega a cada celda una celda transitable ( fondo del mapa ).
	 * @param g GUI a añadir.
	 */
	private void insertarCeldasTransitables(GUI g) {
		Celda cel;
		
		for(int f=0; f<HEIGHT; f++){
			for(int c=0; c <WIDTH; c++)	{
				cel= MiMapa.getCelda(f,c);		
				g.add(cel.getGrafico().getGrafico());
			}
		}
	}
	
	/**
	 * Devuelve true si y solo si, son celdas reservadas.
	 * @param x	Coordenada X a examinar.
	 * @param y Coordenada Y a examinar.
	 * @return
	 */
	private boolean lugarReservado(int x, int y){
		return (x==1 && y==1) || (x==1 && y==2) || (x==2 && y==1) || // Celdas Reservadas Bomberman
			(x==29 && y==11) || (x==29 && y==10) || (x==28 && y==11); // Celdas Reservads Sirius
	}
	
	
	/**
	 * Devuelve el atributo Bomberman.
	 * @return Bomberman a retornar.
	 */
	public Bomberman getBomberman(){
		return this.MiBomberman;
	}
	
	
	/**
	 * Inicia los hilos para cada uno de lo enemigos.
	 */
	public void empezar(){
		for(EnemigoThread hilo : this.EnemigoHilo){
			hilo.start();
		}
	}
	
	/**
	 * Detiene los hilos para cada uno de los enemigos.
	 */
	public void pausar() {
		for(EnemigoThread hilo : this.EnemigoHilo){
			hilo.detener();
		}
	}

	/**
	 * Devuele el Tiempo actual.
	 * @return Tiempo a retornar.
	 */
	public Tiempo getTiempoActual() {
		return this.MarcadorTiempo;
	}

	/**
	 * Incrementa el puntaje.
	 * @param puntosPorMuerte Puntaje a incrementar.
	 */
	public void incrementarPuntaje(int puntosPorMuerte) {
		this.puntaje += puntosPorMuerte;
		
	}

	/**
	 * Retorna el valor del atributo MiGui
	 * @return MiGui
	 */
	public GUI getGui() {
		return MiGui;
	}
	
	/**
	 * Retorna el valor del atributo puntaje
	 * @return puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Metodo encargado de disminuir la cantidad de 
	 * paredes destruibles
	 */
	public void disminuirPDestruible() {
		this.cantPDestruibles-- ;
		if(cantPDestruibles == 0){
			gane = true;
			this.detenerTiempo();
		}
	}
	
	/**
	 * Comando  encargado de detener el tiempo
	 * y cortar el hilo de los enemigos.
	 */
	public void detenerTiempo() {
		this.detener = true;
		this.MarcadorTiempo.detener();
		
		// Corto el hilo de los enemigos activos.
		for(EnemigoThread eh : EnemigoHilo){
			eh.detener();
		}
	}
	
	/**
	 * Retorna el valor de verdad del atributo detener
	 * @return detener
	 */
	public boolean detener(){
		return this.detener;
	}
	/**
	 * Retorna el valor de verdad del atributo gane
	 * @return gane
	 */
	
	public boolean gane(){
		return this.gane;
	}
	
}
