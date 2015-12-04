package PowerUps;

import Grafica.BombalityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Bombality extends PowerUp {

    public Bombality(Celda c){
    	super(c);
    	this.MiGrafica = new BombalityGrafica(this.pos.getX(), this.pos.getY());
    	Puntaje+=5;
    }
 
    
    
    public void afectarPersonaje(Bomberman B){
        B.setMaxBombas();
    }

}