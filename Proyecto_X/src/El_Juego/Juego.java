package El_Juego;

import java.util.Random;
import GUI.GUI;
import Mapa.Celda;
import Mapa.Mapa;
import Mapa.*;
import Personajes.*;
import GUI.EnemigoThread;



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
	protected Bomberman MiBomberman;
	protected Tiempo MarcadorTiempo;
	protected GUI MiGui;
	protected Mapa MiMapa;
	
	public Juego(GUI gui){
		this.MiGui = gui;
		this.MiMapa = new Mapa(HEIGHT,WIDTH);
		
		Celda c = this.MiMapa.getCelda(1,1);
		MiBomberman = new Bomberman(1,c);
		this.MiGui.add(MiBomberman.getGrafico());
	
		insertarParedes(MiGui);
		insertarEnemigos(MiGui);
		
		MarcadorTiempo = new Tiempo();
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
		
		while(contador < 124){ // 124 ES EL 50% DE LAS CELDAS NO OCUPADAS POR PARED INDESTRUCTIBLE
			try {
				ancho = (int)(rnd.nextDouble()*29 +1);
				altura = (int)(rnd.nextDouble()*11 +1);
				cel = this.MiMapa.getCelda(ancho,altura);
				if(!cel.hayPared() && !lugarReservado(ancho,altura) ){
					p = new ParedDestruible(cel);
					cel.agregarPared(p);
					g.add(p.getGrafico());
					contador++;
				}
			} catch (Exception e) {
				e.printStackTrace();
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
						g.add(e.getGrafico());
					}
					else{ 
						e = new Altair(1,cel);
						cel.agregarEnemigo(e);
						g.add(e.getGrafico());
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
		e = new Sirius(5,cel);
		MisEnemigos[5] = e;
		EnemigoHilo[5] = new EnemigoThread(e,g);
		g.add(e.getGrafico());
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
	
//	public GUI getGUI(){
//		return this.MiGui;
//	}
	
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
	
}
