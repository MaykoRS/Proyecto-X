package Mapa;

import Personajes.Bomberman;

public class Fatality extends PowerUp {

    public Fatality(){
    	super();
    }

    
    public void afectarPersonaje(Bomberman B){
        B.setAlcanceBomba(B.getAlcanceBomba()*2);
    }

}