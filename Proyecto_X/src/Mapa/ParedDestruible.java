package Mapa;

import Grafica.PDestruibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

	/**Clase correspondiente a la implementación del módulo Pared Destruible. 
	 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
	 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
	 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
	 */
public  class ParedDestruible extends Pared {

	/**
	 * Crea un constructor de un parámetro.
	 * @param pos Celda en la que se ubica.
	 */
	public ParedDestruible(Celda pos) {
		super(pos);

		this.grafico = new PDestruibleGrafica(this.posicion.getX(), this.posicion.getY());
	}

	
	@Override
	public void destruir() 
	{	
		grafico.getGrafico().setIcon(null);	
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
	
	@Override
	public void  setGrafico1()
	{
		 grafico.getGrafico1();
	}
	
		
	

}
