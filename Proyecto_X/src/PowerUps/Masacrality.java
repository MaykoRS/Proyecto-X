package PowerUps;

import Grafica.MasacralityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;
import Threads.MasacralityThread;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Masacrality extends PowerUp {

   
    public Masacrality(Celda c){
    	super(c);
    	this.MiGrafica = new MasacralityGrafica(this.pos.getX(), this.pos.getY());
    	Puntaje+=20;
    }
 
    
    public void afectarPersonaje(Bomberman B){
       
	   MasacralityThread hilo = new MasacralityThread(B);
       hilo.start();
   
    }
    
    

}
