
package main;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.*;
import window.*;

public class Visualiser implements ActionListener{
	
	public static final int ARRAY_LENGTH = 1000;
	
	private Frame frame;
	private Panel panel;
	private int[] array;
	private boolean ready;
	
	public Visualiser() {
		
		initialiseArray();
		
		this.ready = true;
		
		this.panel = new Panel(array);
		this.frame = new Frame(panel);
		
		this.setActionListeners();
		
	}
	
	private void initialiseArray() {
		
		this.array = new int[ARRAY_LENGTH];
		
		for (int i = 0; i < ARRAY_LENGTH; i++) {
			
			this.array[i] = i + 1;
			
		}
		
		shuffle();
		
	}
	
	private void shuffle() {
		
		List<Integer> temp = new ArrayList<>();
		
		for (int i : array) { temp.add(i); }
		
		Collections.shuffle(temp);
		
		for (int i = 0; i < ARRAY_LENGTH; i++) {
			
			array[i] = temp.get(i);
			
		}
		
	}
	
	private void setActionListeners() {
		
		for (Button b : panel.getButtons()) {
			
			b.addActionListener(this);
			b.setActionCommand(panel.BUTTON_VALUES[panel.getButtons().indexOf(b)]);
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!ready) return;
		
		ready = false;
		
		shuffle();
		
		switch (panel.getButtons().indexOf(e.getSource())) {
			
			case ButtonValues.SELECTION_SORT:
				this.invokeSelectionSort();
				break;
					
			case ButtonValues.BUBBLE_SORT:
				this.invokeBubbleSort();
				break;
					
			case ButtonValues.INSERTION_SORT:
				this.invokeInsertionSort();
				break;
					
			case ButtonValues.MERGE_SORT:
				this.invokeMergeSort();
				break;
				
			case ButtonValues.QUICK_SORT:
				this.invokeQuickSort();
				break;
					
			case ButtonValues.HEAP_SORT:
				this.invokeHeapSort();
				break;
					
			case ButtonValues.CYCLE_SORT:
				this.invokeCycleSort();
				break;
					
			case ButtonValues.THREE_WAY_MERGE_SORT:
				this.invokeThreeWayMergeSort();
				break;
					
			case ButtonValues.COUNTING_SORT:
				this.invokeCountingSort();
				break;
					
			case ButtonValues.RADIX_SORT:
				this.invokeRadixSort();
				break;
					
			case ButtonValues.BUCKET_SORT:
				this.invokeBucketSort();
				break;
					
			case ButtonValues.TIM_SORT:
				this.invokeTimSort();
				break;
					
			case ButtonValues.COMB_SORT:
				this.invokeCombSort();
				break;
				
			case ButtonValues.PIGEONHOLE_SORT:
				this.invokePigeonholeSort();
				break;
			
		}
		
	}
	
	private void invokeSelectionSort() {
		
		SortingFunction selectionSort = (array, step) -> {
			
			int i, j, min, temp;
			int length = array.length;
			
			for (i = 0; i < length; i++) {
	            
				min = i;
	            
				for (j = i + 1; j < length; j++) {
					
					if (array[j] < array[min]) {
						min = j;
						
						panel.setCursor(j);
						step.run();
						try { Thread.sleep(1); } catch (Exception e) { e.printStackTrace(); }
					}
					
	            }
				
				temp = array[min];
				array[min] = array[i];
				array[i] = temp;
				
	        }
			
			ready = true;
			
	    };
	    
	    SortingAnimator animator = new SortingAnimator(array, panel, selectionSort);
	    animator.start();
	}


	private void invokeBubbleSort() {
		
		SortingFunction bubbleSort = (array, step) -> {
			
			int i, j, temp;
			boolean swapped;
			int length = array.length;
			
			for (i = 0; i < length - 1; i++) {
				
				swapped = false;
				
				for (j = 0; j < length - 1 - i; j++) {
					
					if (array[j] > array[j + 1]) {
						
						temp = array[j];
						array[j] = j + 1;
						array[j + 1] = temp;
						swapped = true;
						
						panel.setCursor(j);
						step.run();
						try { Thread.sleep(1); } catch (Exception e) { e.printStackTrace(); }
						
					}
					
				}
				
			}
			
			ready = true;
			
		};
		
		SortingAnimator animator = new SortingAnimator(array, panel, bubbleSort);
	    animator.start();
		
	}
	
	private void invokeInsertionSort() {
		
		SortingFunction insertionSort = (array, step) -> {
			
			int i, j, key;
			int length = array.length;
			
			for (i = 1; i < length; i++) {
				
				key = array[i];
				j = i - 1;
				
				while (j >= 0 && array[j] > key) {
					
					array[j + 1] = j;
					j -= 1;
					
					panel.setCursor(j);
					step.run();
					
				}
				
				array[j + 1] = key;
				
				try { Thread.sleep(1); } catch (Exception e) { e.printStackTrace(); }
			}
			
			ready = true;
			
		};
		
		SortingAnimator animator = new SortingAnimator(array, panel, insertionSort);
	    animator.start();
		
	}
	
	private void invokeMergeSort() {
		
		
		
	}
	
	private void invokeQuickSort() {
		
		
		
	}
	
	private void invokeHeapSort() {
		
		
		
	}
	
	private void invokeCycleSort() {
		
		
		
	}
	
	private void invokeThreeWayMergeSort() {
		
		
		
	}
	
	private void invokeCountingSort() {
		
		
		
	}
	
	private void invokeRadixSort() {
		
		
		
	}
	
	private void invokeBucketSort() {
		
		
		
	}
	
	private void invokeTimSort() {
		
		
		
	}
	
	private void invokeCombSort() {
		
		
		
	}
	
	private void invokePigeonholeSort() {
		
		
		
	}
	
}
