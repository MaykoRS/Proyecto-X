package PowerUps;

import Grafica.FatalityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Fatality extends PowerUp {

    public Fatality(Celda c){
    	super(c);
    	this.MiGrafica = new FatalityGrafica(this.pos.getX(), this.pos.getY());
    	Puntaje+=5;
    }

    
    public void afectarPersonaje(Bomberman B){

        B.setAlcanceBomba(B.getAlcanceBomba()*2);
    }

}