package Assignment2;

/**
* ASSIGNMENT 2 - ITEC 2610 M
* @author 		Anh P. Trinh	-	215 955 560
* 
* Viewer class: main method
* 		Responsible for creating the frame and displaying	
*/

import javax.swing.JFrame;

public class PizzaOrderFormViewer {

	public static void main(String[] args) {
		
		JFrame f = new PizzaOrderFormFrame();
		f.setTitle("Choices Frame");
		f.setSize(600,260);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}