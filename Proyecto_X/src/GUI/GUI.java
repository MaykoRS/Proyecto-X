package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import El_Juego.Juego;
import Threads.BombermanThread;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase correspondiente a la Implementacion del módulo GUI.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel inferior;
	
	private Juego j;
	private BombermanThread tiempo;
	private volatile boolean lock = false;
	private int direction = -1;
	
	private JLabel labelPuntaje;
	private JLabel labelTiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Bomberman");
		setResizable(false);
		setBounds(100, 100, 998, 497);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Oyente del bomberman
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
				
		inferior = new JPanel();
		armarPanelInferior();
		inferior.setLocation(0, 416);
		add(inferior);
				
		j = new Juego(this);
		tiempo = new BombermanThread(j.getBomberman(), this);
		tiempo.start();
		j.empezar();
		
	}
	
	protected void mover(KeyEvent key) {
		if(!lock) {
			direction = key.getKeyCode();
			this.lock = true;
		}
	}
	
	public boolean getLock() {
		return this.lock;
	}
	
	public void toggleLock() {
		this.lock = !this.lock;
	}
	
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setPuntaje(String g) {
		labelPuntaje.setText("Puntaje :"+" "+g);
	}
	
	public void setTiempo(int m, int s){
		labelTiempo.setText("Tiempo: 00:" + String.format("%02d", m) + ":" + String.format("%02d", s));
	}
	
	
	public void armarPanelInferior() {
		inferior.setSize(new Dimension(992, 52));
		inferior.setBackground(Color.LIGHT_GRAY);
		inferior.setLayout(new FlowLayout(FlowLayout.CENTER, 115, 18));
		
		labelTiempo = new JLabel("Tiempo: 00:00");
		labelPuntaje = new JLabel("Puntaje: 0");
		
		inferior.add(labelTiempo);
		inferior.add(labelPuntaje);
		
	}
	
}
