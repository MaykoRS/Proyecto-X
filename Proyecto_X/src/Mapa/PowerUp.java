package Mapa;

import Personajes.Bomberman;

public abstract class PowerUp{
   
	protected boolean activa;

    public PowerUp(){
    	this.activa = false;
    }
    public abstract void afectarPersonaje(Bomberman B);
   
    public void setActiva(boolean a){
       this.activa=a;
    }

    public boolean getActiva(){
        return this.activa;
    }

}