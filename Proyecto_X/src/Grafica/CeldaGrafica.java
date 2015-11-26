package Grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CeldaGrafica 
{
	protected final int width = 32;
	protected final int height = 32;
	protected JLabel grafico;
	protected Icon image;
	protected Point pos;
	
	public CeldaGrafica(int x, int y)
	{
		pos = new Point(x * width, y * height);
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png"));
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}

	public Icon getIcon(){
		return image;
	}
	
	

}
