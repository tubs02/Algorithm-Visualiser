
package window;

import java.awt.Button;

import javax.swing.JFrame;

public class Frame {
	
	public static final int DEFAULT_WIDTH = 1200, DEFAULT_HEIGHT = 1100;
	
	private JFrame frame;
	
	private Button button1;
	private Button button2;
	private Button button3;
	
	public Frame(Panel panel) {
		
		initialise(panel, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}
	
	private void initialise(Panel panel, int width, int height) {
		
		this.frame = new JFrame();
		this.frame.setTitle("Algorithm Visualiser");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(width, height);
		this.frame.setLocationRelativeTo(null);
		this.frame.setResizable(true);
		this.frame.add(panel);
		this.frame.pack();
		this.frame.setVisible(true);
		
	}
	
}
