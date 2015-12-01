package Mapa;

import Grafica.MasacralityGrafica;
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
	   modificarMaxBombas(B);
	   B.setModoDios(true);
	   MasacralityThread hilo = new MasacralityThread(B);
       hilo.start();
   }

     
    

    /**
     * 
     */
    private void modificarMaxBombas(Bomberman B){
        B.setMaxBombas(999);
    }

    
    

}
