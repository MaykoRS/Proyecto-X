package El_Juego;

import GUI.GUI;
import Personajes.Bomberman;

/**
 *  Clase correpondiente a la implementación del módulo Tiempo. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *
 */
public class Tiempo extends Thread{
	
    protected int minutos;
    protected int segundos;
    protected GUI gui;
    protected boolean detener;
    
    /**
     * Crea un constructor de un único parámetro
     * @param g GUI
     */
    public Tiempo(GUI g) 
    {
    	this.gui = g;
        this.minutos = 0;
        this.segundos = 0;
        this.detener = false;
       
    }
    
    /**
     * Metodo encargado del funcionamiento del hilo.
     */
    public void run(){
    	while(!detener){
    		try {
    			
    			Thread.sleep(1000);
    			calcularTiempo();


    			//System.out.print(minutos+ ":" + segundos );
    		} catch (InterruptedException e) {
    		}
    	}
    }
    
    /**
     * Método encargado de calcular el valor del tiempo al cual se debe actualizar
     */
    public void calcularTiempo(){
    	segundos++;
    	if(segundos==60){
    		segundos=0;
    		minutos++;
    	}
    	gui.setTiempo(minutos, segundos);
    }

    
    /**
     * Detiene el hilo del Tiempo.
     */
    public void detener() {
    	this.detener = true;
    }
    
    
    /**Consulta que retorna el valor del atributo minutos
     * @return minutos.
     */
    public int getMinutos() {
        return this.minutos;
    }

    /** Consulta que retorna el valor del atributo segundos.
     * @return segundos
     */
    public int getSegundos() {
        return this.segundos;
    }

    /** Comando para setear el valor del atributo Minutos.
     * @param m Minutos.
     */
    public void setMinutos(int m) {
       minutos= m;
    }

   
    /** Comando encargado de setear el atributo segundos.
     * @param s
     */
    public void setSegundos(int s) {
       segundos= s;
    }

}