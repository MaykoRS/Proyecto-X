package El_Juego;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Tiempo {
    protected int horas;
    protected int minutos;
    protected int segundos;

    public Tiempo() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        for(int i= 0; i < 999; i++ ){
        	for(int j= 0; j < 20; j++){
        		for(int k = 0; k < 20; k ++){
        			this.horas = i;
        			this.minutos = j;
        			this.segundos = k;
        			delaySegundo();
        		}
        	}
        }
    }

    /**
     * @param T 
     * @return
     */
    public boolean equals(Tiempo T) {
        // TODO implement here
        return false;
    }
    
    private void delaySegundo(){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
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
    public int getHoras() {
        return this.horas;
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