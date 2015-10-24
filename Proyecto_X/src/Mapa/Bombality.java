package Mapa;

import Personajes.Bomberman;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Bombality extends PowerUp {

    public Bombality(){
    	super();
    }
 
    
    public void afectarPersonaje(Bomberman B){
        B.setMaxBombas(1);
    }

}