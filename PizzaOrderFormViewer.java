/**
*
* @author Anh Trinh
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
