 package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import El_Juego.ContadorBomba;
import El_Juego.Juego;

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

	private JPanel contentPane;
	
	private Juego j;
	private BombermanThread tiempo;
	private ContadorBomba cb;
	
	private volatile boolean lock = false;
	private int direction = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
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
		super("Bomberman");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 450);
		setSize(1010,450);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		j = new Juego(this);
		
		tiempo = new BombermanThread(j.getBomberman(), this);
		
		tiempo.start();
		//cb = new ContadorBomba(j.getBomberman(), 3000);
		//cb.start();
		j.empezar();
	}
	
	protected void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			this.lock = true;
		}
	}
	
	public boolean getLock(){
		return this.lock;
	}
	
	public void toggleLock(){
		this.lock = !this.lock;
	}
	
	
	public int getDirection(){
		return this.direction;
	}
}
