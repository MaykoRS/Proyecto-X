package Personajes;

import Grafica.AltairGrafica;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Altair extends Enemigo {

	public Altair(Celda pos) {
		super(pos);
		this.modoDios = true;
		this.grafico = new AltairGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	public Altair(int velocidad, Celda pos){
		super(velocidad,pos);
		this.modoDios = true;
		this.grafico = new AltairGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	@Override
	public boolean soyDios() {
		return this.modoDios;
	}

	@Override
	public void morir() {
		vive = false;
		getGrafico().setIcon(null);
	}

}
