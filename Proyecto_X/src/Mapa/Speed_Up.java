package Mapa;

import Grafica.SpeedUpGrafica;
import Personajes.Bomberman;

public class Speed_Up extends PowerUp {

	public Speed_Up(Celda c){
        super(c);
        this.MiGrafica = new SpeedUpGrafica(this.pos.getX(), this.pos.getY());
    }

    
    public void afectarPersonaje(Bomberman B){
      B.setVelocidad(B.getVelocidad()*2);
    }

}