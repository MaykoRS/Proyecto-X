package Mapa;

import Personajes.Bomberman;

public class Speed_Up extends PowerUp {

	public Speed_Up(){
        super();
    }

    
    public void afectarPersonaje(Bomberman B){
      B.setVelocidad(B.getVelocidad()*2);
    }

}