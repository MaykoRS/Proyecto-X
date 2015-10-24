package Mapa;

import Personajes.Bomberman;

public class Masacrality extends PowerUp {

   
    public Masacrality(){
    	super();
    }
 
    /**
     * @param B
     */
    public void afectarPersonaje(Bomberman B){
       B.setModoDios(true);
	   modificarMaxBombas(B);
	   B.setModoDios(true);
       //durante 5s luego se setea en false
    }

    /**
     * 
     */
    private void modificarMaxBombas(Bomberman B){
        B.setMaxBombas(999);
    }

    
    

}
