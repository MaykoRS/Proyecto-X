package PowerUps;

import Grafica.SpeedUpGrafica;
import Mapa.Celda;
import Personajes.Bomberman;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Speed_Up extends PowerUp {

	public Speed_Up(Celda c){
        super(c);
        this.MiGrafica = new SpeedUpGrafica(this.pos.getX(), this.pos.getY());
    }

    
    public void afectarPersonaje(Bomberman B){
      B.setVelocidad(B.getVelocidad()*2);
    }

}