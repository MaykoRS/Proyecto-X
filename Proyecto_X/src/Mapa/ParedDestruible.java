package Mapa;

import javax.swing.ImageIcon;

import Grafica.PDestruibleGrafica;
import Grafica.PIndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class ParedDestruible extends Pared {

	public ParedDestruible(Celda pos) {
		super(pos);

		this.grafico = new PDestruibleGrafica(this.posicion.getX(), this.posicion.getY());
	}

	
	//Deberia retornar un entero que representa la cantidad de putnso
	public void destruir() 
	{
		
		grafico.destruir();
		
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
