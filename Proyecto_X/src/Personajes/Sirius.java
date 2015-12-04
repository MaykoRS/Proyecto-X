package Personajes;

import java.util.Random; 

import El_Juego.Juego;
import Grafica.SiriusGrafica;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Sirius extends Enemigo {
    
	protected Juego Mijuego;
	
	/**
	 * crea un enemigo con un puntaje establecido.
	 * @param pos celda a anadir.
	 * @param j juego a anadir.
	 */
	public Sirius(Celda pos, Juego j)
	{
		super(pos);
		Mijuego=j;
		puntosPorMuerte+=35;
		
		
		this.grafico = new SiriusGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	public Sirius(int velocidad, Celda pos, Juego j) {
		super(velocidad, pos);
		Mijuego=j;
		this.grafico = new SiriusGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}

	
	@Override
	public boolean soyDios() {
		return this.modoDios;
	}

	@Override
	public void morir() {
		vive = false;
		getGrafico().setIcon(null);
		
	}
	public void mover()
	{
		
		Celda posMatar=Mijuego.getBomberman().getPosicion();
		Random r = new Random();
		
		int dir = r.nextInt(1);
		
		if(posMatar.getY()==this.posicion.getY())
		{
			if (posMatar.getX()<this.posicion.getX())
			{
				Celda destino =  this.posicion.getVecina(Celda.LEFT);
				
				destino.dejarPasar(this, Celda.LEFT);
				//System.out.print("y==/bomx<a this (IZQUIERDA)");
			}
			else
			{
				Celda destino =  this.posicion.getVecina(Celda.RIGHT);
				
				destino.dejarPasar(this, Celda.RIGHT);
				//System.out.print("y==/bomx>a this(DERECHA)");
			}
		}
		else
		{
			if(posMatar.getX()==this.posicion.getX())
			{
				if(posMatar.getY()>this.posicion.getY())
				{
					Celda destino =  this.posicion.getVecina(Celda.DOWN);
					
					destino.dejarPasar(this, Celda.DOWN);
					//System.out.print("x==/bomby> a this(aBAJP) ");
				}
				else
				{
					
						Celda destino =  this.posicion.getVecina(Celda.UP);
						
						destino.dejarPasar(this, Celda.UP);
						//System.out.print("x==/bomby< a this(arriba)");
					
				}
		}
		if (posMatar.getX()<this.posicion.getX() && posMatar.getY()<this.posicion.getY())
		 {
			if (dir==0)
			{	
				Celda destino =  this.posicion.getVecina(Celda.UP);
				
				destino.dejarPasar(this, Celda.UP);
				 //System.out.print("bomb x <a this los dos (ARRIBA)");
			}
			else
			{

				Celda destino =  this.posicion.getVecina(Celda.LEFT);
				
				destino.dejarPasar(this, Celda.LEFT);
				//System.out.print("bomb x <a this los dos (IZQUIERDA)");
			
			}
					
		}
		else
		{
			if (posMatar.getX()>this.posicion.getX() && posMatar.getY()>this.posicion.getY())
			{
				if (dir==0)
				{	

					Celda destino =  this.posicion.getVecina(Celda.DOWN);
					
					destino.dejarPasar(this, Celda.DOWN);
					//System.out.print("bomb x >a this los dos(ABAJP)");
				}
				else
				{
					Celda destino =  this.posicion.getVecina(Celda.RIGHT);
					
					destino.dejarPasar(this, Celda.RIGHT);
					//System.out.print("bomb x >a this los dos(Derecha)");
				
				}
			}
			else
			{
				if (posMatar.getX()>this.posicion.getX())
				{
					Celda destino =  this.posicion.getVecina(Celda.RIGHT);
					
					destino.dejarPasar(this, Celda.RIGHT);
					//System.out.print("bomb x > a this (derecha)");
				}
				else
				{
					if(posMatar.getY()>this.posicion.getY())
					{
						Celda destino =  this.posicion.getVecina(Celda.DOWN);
						
						destino.dejarPasar(this, Celda.DOWN);
						//System.out.print("bomb y >a this(abajo)");
					}
					else
					{
						if (posMatar.getX()<this.posicion.getX())
						{
							Celda destino =  this.posicion.getVecina(Celda.LEFT);
							
							destino.dejarPasar(this, Celda.LEFT);
							//System.out.print("bomb x < a this (izquierda)");
						}
						else
						{
							if(posMatar.getY()<this.posicion.getY())
							{
								Celda destino =  this.posicion.getVecina(Celda.UP);
								
								destino.dejarPasar(this, Celda.UP);
								//System.out.print("bomb y < a this (arriba)");
							}
							
							
			         }
		         }
				}}}}}
	}
		
			
	


