package PowerUps;

import Grafica.FatalityGrafica;
import Mapa.Celda;
import Personajes.Bomberman;

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