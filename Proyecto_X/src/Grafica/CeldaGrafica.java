package Grafica;

import java.awt.Point;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Bomba;
import PowerUps.PowerUp;

public class CeldaGrafica 
{
	protected final int width = 32;
	protected final int height = 32;
	protected JLabel grafico;
	protected PowerUPGrafica graficoP;
	protected Icon image,image2;
	protected Point pos;
	protected Bomba b;
	
	public CeldaGrafica(int x, int y)
	{
		pos = new Point(x * width, y * height);
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png"));
	    b=null;
	}

	public JLabel getGrafico(){
		if (b==null)
		{	if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		else {
			grafico = new JLabel(image2);	
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		}
			
			
		return this.grafico;
	}

	public void agregarBomba(Bomba b) 
	{
	    this.b=b;
	    grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Bomba.png")));
		
		
	}

	public void destruir() 
	{
		System.out.println(grafico);
		System.out.println(graficoP); 
		if(graficoP != null){
			this.grafico = graficoP.getGrafico();
		}
		
		
	}
	
	public void setImagen(JLabel j)
	{
		grafico=j;
	}

	public void agregarPowerUP(PowerUp p)
	{
		grafico.setIcon(p.getIcon());
	}
	public void setGrafico() 
	{
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png")));
		
		
	}

	public void setExplosion() 
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Explosion.gif")));
		
	}

	
	
	

}
