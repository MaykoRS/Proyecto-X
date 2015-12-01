package Mapa;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.PowerUPGrafica;
import Personajes.Bomberman;

public abstract class PowerUp{
	
	
	protected boolean activa;
	protected PowerUPGrafica MiGrafica;
	protected Celda pos;
	protected int Puntaje;

    public PowerUp(Celda c){
    	this.pos = c;
    	this.activa = false;
    	MiGrafica = null;
    	Puntaje =30;
    }
    public abstract void afectarPersonaje(Bomberman B);
   
    public void setActiva(boolean a){
       this.activa=a;
    }
    
    public boolean getActiva(){
        return this.activa;
    }
    
   
	public JLabel getGrafico() {
		
		 return MiGrafica.getGrafico();	
		
	}
	
	public Icon getIcon(){
		return MiGrafica.getImage();
	}
	public int getPuntaje() 
	{
		
		return Puntaje;
	}
	public Celda getPosicion() {
		return this.pos;
	}
    
}