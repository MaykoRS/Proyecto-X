package Mapa;

import Grafica.PIndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class ParedIndestructible extends Pared {

	public ParedIndestructible(Celda pos) {
		super(pos);
		this.Puntaje = 0;
		this.grafico = new PIndestructibleGrafica(this.posicion.getX(),this.posicion.getY());
	}

	@Override
	public boolean destruir() {
		return false;
		
	}


	@Override
	public void recibirBomberman(Bomberman b, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirEnemigo(Enemigo e, int dir) {
		// TODO Auto-generated method stub
		
	}

}
