
package window;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.Visualiser;

public class Panel extends JPanel {
	
	public static final Color DEFAULT_BACKGROUND = new Color(42, 39, 39);
	
	private int[] array;
	private List<Button> buttons;
	private Visualiser visualiser;
	private int cursor;
	
	public Panel(int[] array) {
		
		this.array = array;
		
		this.setBackground(DEFAULT_BACKGROUND);
		this.setPreferredSize(new Dimension(this.array.length, this.array.length));
		
		this.setButtons();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int index = 0;
		for (Integer i : array) {
			
			if (index == cursor) { g.setColor(Color.blue); } else { g.setColor(Color.white); }
			
			g.drawLine(index, this.getHeight(), index, this.getHeight() - i);
			
			index++;
		}
		
	}
	
	public static final String[] BUTTON_VALUES = {
			
			"Selection Sort",
			"Bubble Sort",
			"Insertion Sort",
			"Merge Sort",
			"Quick Sort",
			"Heap Sort",
			"Cycle Sort",
			"3-way Merge Sort",
			"Counting Sort",
			"Radix Sort",
			"Bucket Sort",
			"Tim Sort",
			"Comb Sort",
			"Pigeonhole Sort"
			
	};
	
	private void setButtons() {
		
		//Comparison Based : Selection Sort, Bubble Sort, Insertion Sort, Merge Sort, Quick Sort, Heap Sort, Cycle Sort, 3-way Merge Sort
		//Non Comparison Based : Counting Sort, Radix Sort, Bucket Sort, TimSort, Comb Sort, Pigeonhole Sort
		
		buttons = new ArrayList<>();
		
		for (int i = 0; i < BUTTON_VALUES.length; i++) {
			
			buttons.add(new Button(BUTTON_VALUES[i]));
			this.add(buttons.get(i));
			
		}
		
	}
	
	public List<Button> getButtons() {
		
		return this.buttons;
		
	}
	
	public void setArray(int[] array) {
		
		this.array = array;
		
	}
	
	public void setCursor(int cursor) {
		
		this.cursor = cursor;
		
	}
	
}
