package PowerUps;

import Grafica.MasacralityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;
import Threads.MasacralityThread;

public class Masacrality extends PowerUp {

   
    public Masacrality(Celda c){
    	super(c);
    	this.MiGrafica = new MasacralityGrafica(this.pos.getX(), this.pos.getY());
    	Puntaje+=20;
    }
 
    /**
     * @param B
     */
    public void afectarPersonaje(Bomberman B){
 	   MasacralityThread hilo = new MasacralityThread(B);
        hilo.start();
    }

}
