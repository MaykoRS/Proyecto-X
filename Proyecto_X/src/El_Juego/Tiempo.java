package El_Juego;

import GUI.GUI;

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

    public Tiempo(GUI g) 
    {
    	this.gui = g;
        this.minutos = 0;
        this.segundos = 0;
        this.detener = false;
       
    }
    
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
    
    
    /**
     * @param T 
     * @return
     */
    public boolean equals(Tiempo T) {
        // TODO implement here
        return false;
    }
    
    
    /**
     * @param T 
     * @return
     */
    public boolean greater(Tiempo T) {
        // TODO implement here
        return false;
    }

    /**
     * @param T 
     * @return
     */
    public Tiempo obtenerDiferencia(Tiempo T) {
        // TODO implement here
        return null;
    }


    /**
     * @return
     */
    public int getMinutos() {
        return this.minutos;
    }

    /**
     * @return
     */
    public int getSegundos() {
        return this.segundos;
    }

    /**
     * @param m
     */
    public void setMinutos(int m) {
        // TODO implement here
    }

    /**
     * @param h
     */
    public void setHoras(int h) {
        // TODO implement here
    }

    /**
     * @param s
     */
    public void setSegundos(int s) {
        // TODO implement here
    }

}