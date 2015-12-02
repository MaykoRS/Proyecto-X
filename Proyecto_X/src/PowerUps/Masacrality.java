package PowerUps;

import Grafica.MasacralityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;
import Threads.MasacralityThread;

/** Clase correspondiente a la implementación del módulo del PowerUp Masacrality.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Masacrality extends PowerUp {

   /**
    * Crea un constructor con un único parámetro.
    * @param c Celda en la que se ubica el Masacrality.
    */
    public Masacrality(Celda c){
    	super(c);
    	this.MiGrafica = new MasacralityGrafica(this.pos.getX(), this.pos.getY());
    	Puntaje+=20;
    }
 
    /** Comando encargado de crear el Hilo del Masacrality
     * @param B Bomberman
     */
    public void afectarPersonaje(Bomberman B){
     
	   MasacralityThread hilo = new MasacralityThread(B);
       hilo.start();
   }

   

}
