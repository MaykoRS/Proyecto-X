package Mapa;

import javax.swing.JLabel;
import El_Juego.Tiempo;
import Grafica.BombaGrafica;
import Personajes.Bomberman;
import Threads.BombaTread;

/**
 * Clase correspondiente a la Implementacion del módulo Bomba. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class Bomba {
	
	
	protected int nivelDeImpacto;
    protected boolean estadoActiva;
    protected Celda posicion;
    protected Tiempo tiempoTirada;
    protected Bomberman bomberman;
    protected BombaGrafica grafico;
    
    
    /**
   	 * Crea constructor con 3 parámetros.
   	 * @param ni Nivel de Impacto, el cual se ve reflejado en la longitud de celdas que afectara.
   	 * @param pos Posicion del Bomberman.
   	 * @param t Tiempo en el que fue creada la bomba.
   	 * 
   	 */
	public Bomba(int ni, Celda pos, Tiempo t) {
		this.estadoActiva = true;
		this.tiempoTirada = t;
    	this.posicion = pos;
    	this.nivelDeImpacto = ni;
    	this.grafico = new BombaGrafica(this.posicion.getX(), this.posicion.getY());
	}
	
	/**
	 * Crea un constructor con 3 parámetros.
	 * @param aB representa el nivel de impacto de las bombas.
	 * @param pos Posición donde se ubica inicialmente.
	 * @param b Boomberman
	 */
	public Bomba(int aB, Celda pos, Bomberman b) {
		this.bomberman = b;
		this.estadoActiva = true;
    	this.posicion = pos;
    	this.nivelDeImpacto = aB;
    	this.grafico = new BombaGrafica(this.posicion.getX(), this.posicion.getY());
	}

	/**
	 * Método encargado de la explosión de la Bomba.
	 */
	public void explotar()
	{
        this.grafico.explotar();
        bomberman.setTirarBomba(true);
       
	}

    /**
     * Incrementa el nivel del impacto.
     * @param n La cantidad de nivel a incrementar.
     */
    public void incrementarImpacto(int n){
    	this.nivelDeImpacto += n;
    }

    /**
     * Devuelve true si la bomba está activada, false en caso contrario.
     * @return True si la bomba está acitvada, false en caso contrario.
     */
    public boolean getEstadoActiva(){        
        return this.estadoActiva;
    }

    /**
     *  Espera el tiempo para que la bomba explote.
     */
    public void esperarParaExplotar()
    {   
    	BombaTread cb = new BombaTread(this.bomberman,this,3000);
		cb.start();
		
    	//new ContadorBomba(bomberman,0).start();
    }
    
    /**
     * Devuelve la posición de la bomba.
     * @return Posición de la bomba.
     */
    public Celda getPosicion(){
        return this.posicion;
    }

    /**
     * Devuelva una nueva bomba clonada.
     * @return Bomba clonada a devolver.
     */
    public Bomba clone()
    {
        Bomba B = new Bomba(nivelDeImpacto,posicion,tiempoTirada);
        return B; //modificar 
    }

    /**
     * Establece la posición de la bomba por la q
     * @param p La p
     */
    public void setPosicion(Celda p){
        posicion = p;
    }

    /**
     * @return tiempo en que la bomba se tiro.
     */
    public Tiempo getTiempoTirada(){
        return this.tiempoTirada;
    }
    
    /**
     * @return JLabel de la bomba.
     */
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
  }