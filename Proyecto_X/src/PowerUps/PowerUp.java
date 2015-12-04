package PowerUps;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.PowerUPGrafica;
import Mapa.Celda;
import Personajes.Bomberman;

public abstract class PowerUp{
	
	protected int cantidad;
	protected boolean activa;
	protected PowerUPGrafica MiGrafica;
	protected Celda pos;
	protected int Puntaje;

	
    /**
     * crea una PowerUp con puntaje en una posicion c.
     * @param c celda a anadir.
     */
    public PowerUp(Celda c){
    	this.pos = c;
    	this.activa = false;
    	MiGrafica = null;
    	Puntaje =30;
    }
    /**
     * @param B bomberman a anadir.
     */
    public abstract void afectarPersonaje(Bomberman B);
   
    /**
     * Setea la variable activa.
     * @param a boolean a anadir.
     */
    public void setActiva(boolean a){
       this.activa=a;
    }
    
    
    /**
     * @return activa a retornar.
     */
    public boolean getActiva(){
        return this.activa;
    }
    
   
	/**
	 * @return JLabel a retornar.
	 */
	public JLabel getGrafico() {
		
		 return MiGrafica.getGrafico();	
		
	}
	
	/**
	 * @return Image a retornar.
	 */
	public Icon getIcon(){
		return MiGrafica.getImage();
	}
	/**
	 * @return puntaje del powerup.
	 */
	public int getPuntaje() 
	{
		
		return Puntaje;
	}
    
}