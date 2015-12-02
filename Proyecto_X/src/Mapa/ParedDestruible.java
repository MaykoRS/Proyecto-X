package Mapa;

import Grafica.PDestruibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class ParedDestruible extends Pared {

	public ParedDestruible(Celda pos) {
		super(pos);
		this.Puntaje = 10;
		this.grafico = new PDestruibleGrafica(this.posicion.getX(), this.posicion.getY());
	}

	
	//Deberia retornar un entero que representa la cantidad de putnso
	public boolean destruir() 
	{
		this.getGrafico().setIcon(null);

		if(this.posicion.getPowerUp() != null){
			this.posicion.getGrafico().agregarPowerUP(this.posicion.getPowerUp());
			
		}
		return true;
		
	}


	@Override
	public void recibirBomberman(Bomberman b, int n) {
		if(b.soyDios()){
			b.moverAhora(n);
		}
		
	}

	@Override
	public void recibirEnemigo(Enemigo e, int dir) {
		if(e.soyDios()){
			e.moverAhora(dir);
		}	
	}

}
