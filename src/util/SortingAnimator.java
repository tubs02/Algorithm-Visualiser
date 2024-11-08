
package util;

import java.util.List;

import window.Panel;

public class SortingAnimator implements Runnable {
	
	private int[] array;
	private Panel panel;
	private SortingFunction function;
	
	public SortingAnimator(int[] array, Panel panel, SortingFunction function) {
		
		this.array = array;
		this.panel = panel;
		this.function = function;
		
	}
	
	public void start() {
		
		new Thread(this).start();
		
	}
	
	public void draw() {
		
		this.panel.setArray(array);
		this.panel.repaint();
		
	}
	
	@Override
	public void run() {
		
		function.begin(array, this::draw);
		
	}

}
