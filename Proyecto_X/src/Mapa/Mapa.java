package Mapa;

import El_Juego.Juego;

/** Clase correspondiente a la implementación del módulo Mapa.
	 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
	 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
	 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
	 */

public class Mapa {
	protected Celda [][] MiGrilla;
	protected int ancho, altura;
	protected Juego juego;
	
	/**
	 * Crea un constructor de dos parámetros.
	 * @param ancho
	 * @param altura
	 */
	public Mapa(int ancho, int altura, Juego juego){
		this.juego = juego;
		this.ancho = ancho;
		this.altura = altura;
		MiGrilla = new Celda[ancho][altura];
		
		for(int i=0; i<ancho; i++){
			for(int j=0; j<altura; j++){
				this.MiGrilla[i][j] = new Celda(this,i,j,this.juego);
			}
		}
	}
	
	/**
	 * Retorna la Celda que se ubica en la posición x e y pasadas por parámetros.
	 * @param x
	 * @param y
	 * @return Celda
	 * 
	 */
	public Celda getCelda(int x, int y){
		if((x < this.ancho && x >= 0) && (y < this.altura && y >=0))
			return this.MiGrilla[x][y];
		return null;
	}
	
	/**
	 * Retorna el atributo MiGrilla
	 * @return MiGrilla una matriz de Celda
	 */
	public Celda[][] getGrilla(){
		return MiGrilla;
	}
	
	/**
	 * Retorna el valor del atributo ancho
	 * @return ancho
	 */
	public int getAncho(){
		return this.ancho;
	}
	
	/**
	 * Retorna el valor del atributo altura.
	 * @return altura
	 */
	
	public int getAltura(){
		return this.altura;
	}
	
	
}
