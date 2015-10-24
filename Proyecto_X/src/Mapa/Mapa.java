package Mapa;

public class Mapa {
	protected Celda [][] MiGrilla;
	protected int ancho, altura;
	
	public Mapa(int ancho, int altura){
		this.ancho = ancho;
		this.altura = altura;
		MiGrilla = new Celda[ancho][altura];
		
		for(int i=0; i<ancho; i++){
			for(int j=0; j<altura; j++){
				this.MiGrilla[i][j] = new Celda(this,i,j);
			}
		}
	}
	
	public Celda getCelda(int x, int y){
		if((x < this.ancho && x >= 0) && (y < this.altura && y >=0))
			return this.MiGrilla[x][y];
		return null;
	}
	
	public Celda[][] getGrilla(){
		return MiGrilla;
	}
	
	public int getAncho(){
		return this.ancho;
	}
	
	public int getAltura(){
		return this.altura;
	}
	
	
}
