package Assignment2;

/**
* ASSIGNMENT 2 - ITEC 2610 M
* @author 		Anh P. Trinh	-	215 955 560
* 
* Frame class:
* 		Subclass of JFrame
* 		Responsible for creating and operating the form
*/

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderFormFrame extends JFrame {
	
	/** INSTANCES */
	private JLabel inputLabel;
	private JLabel resultLabel;
	private JButton button;

	private JTextField inputField;
	private static final int NUMBER_WIDTH = 4;
	private static final int DEFAULT_nPIZZA = 1;

	private JComboBox sizeBox;
	private static final double SMALL_PRICE = 2.50;
	private static final double MEDIUM_PRICE = 4.00;
	private static final double LARGE_PRICE = 12.60;
	private static final String SIZE_SMALL = "Small | $2.50"; 
	private static final String SIZE_MEDIUM = "Medium | $4.00";
	private static final String SIZE_LARGE = "Large | $12.60"; 

	private JCheckBox checkOnion;
	private JCheckBox checkPine;
	private JCheckBox checkOlive;

	private JRadioButton radio5;
	private JRadioButton radio10;
	private JRadioButton radio15;
	private static final double TIP_5 = 0.5;
	private static final double TIP_10 = 0.1;
	private static final double TIP_15 = 0.15;

	private JTextArea resultArea;
	private static final int RESULT_ROWS = 11;
	private static final int RESULT_COLUMNS = 24;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu;
	private JMenuItem menuItem;

	/** CONSTRUCTOR */
	public PizzaOrderFormFrame() {
		createTextFields();
		createComboBoxes();
		createCheckBoxes();
		createRadios();
		createButtons();
		createResultArea();
		createMenuBar();
		createPanel();
	}
	
/* --------------------------------------------------------------- */
	
	/** TEXT FIELD METHOD - user input area */
	private void createTextFields() {
		inputLabel = new JLabel("Numbers of Pizza: ");
		inputField = new  JTextField(NUMBER_WIDTH);
		inputField.setText(""+DEFAULT_nPIZZA);
	}
	
/* --------------------------------------------------------------- */
	
	/** COMBO BOX METHOD - choose size area */
	private void createComboBoxes() {
		sizeBox = new JComboBox();
		sizeBox.addItem(SIZE_SMALL);
		sizeBox.addItem(SIZE_MEDIUM);
		sizeBox.addItem(SIZE_LARGE);
	}
	
/* --------------------------------------------------------------- */
	
	/** CHECKBOX METHOD - choose toppings area*/
	private void createCheckBoxes() {
		checkPine = new JCheckBox("Pineapple");
		checkOnion = new JCheckBox("Onion");
		checkOlive = new JCheckBox("Olive");
	}
	
/* --------------------------------------------------------------- */
	
	/** RADIO BUTTON METHOD - choose tips area */
	private void createRadios() {
		radio5 = new JRadioButton("5%");
		radio10 = new JRadioButton("10%");
		radio15 = new JRadioButton("15%");
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radio5);
		radioGroup.add(radio10);
		radioGroup.add(radio15);
	}
	
/* --------------------------------------------------------------- */
	
	/** ACTION LISENTER FOR DONE BUTTON */
	class DoneListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int nPizza = Integer.parseInt(inputField.getText()); // get user input
			double total = 0;	// to get total price
			
			/** Calculate price of ordered pizza */
			if (sizeBox.getSelectedItem() == SIZE_SMALL)
				total += nPizza * SMALL_PRICE;
			else if (sizeBox.getSelectedItem() == SIZE_MEDIUM)
				total += nPizza * MEDIUM_PRICE;
			else if (sizeBox.getSelectedItem() == SIZE_LARGE)
				total += nPizza * LARGE_PRICE;
			
			/** Calculate the total + tips  */
			String radioSelected;
			if (radio5.isSelected()) {
				radioSelected = radio5.getText();
				total += (total * TIP_5);
			}else if (radio10.isSelected()) {
				radioSelected = radio10.getText();
				total += (total * TIP_10);
			} else if(radio15.isSelected()) {
				radioSelected = radio15.getText();
				total += (total * TIP_15);
			} else radioSelected = "none";
			
			/** Get info of selected checkbox */
			String topping = "";
			if (checkPine.isSelected())
				topping += "+" + checkPine.getText() + " ";
			if (checkOnion.isSelected())
				topping+= "+" + checkOnion.getText() + " ";
			if (checkOlive.isSelected())
				topping+= "+" + checkOlive.getText();

			/** Display output in result area */
			resultArea.append(	"Quantity:\t" 	+ nPizza 								+ "\n" +
								"Size:\t" 		+ (String) sizeBox.getSelectedItem()	+ "\n" +
								"Toppings:\t"	+ topping.toLowerCase()					+ "\n" +
								"Tips:\t" 		+ radioSelected 						+ "\n" +
								"TOTAL:\t$" 	+ total 								+ "\n" +
								"------------------\n"	);
		}
	}
	
/* --------------------------------------------------------------- */
	
	/** DONE BUTTON METHOD */
	private void createButtons() {
		button  = new JButton("Done");
		ActionListener listener = new DoneListener();
		button.addActionListener(listener);
	}
	
/* --------------------------------------------------------------- */
	
	/** RESULT AREA METHOD */
	private void createResultArea() {
		resultLabel = new JLabel("Result:");
		resultArea = new JTextArea("----INVOICE----\n",RESULT_ROWS,RESULT_COLUMNS);
		resultArea.setEditable(false);
	}
	
/* --------------------------------------------------------------- */
	
	/** EXIT ITEM MENU ACTION LISTENER */
	class ExitItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		}
	
/* --------------------------------------------------------------- */
	
	/** MENU BAR METHOD */
	private void createMenuBar() {
		ActionListener listener = new ExitItemListener();
		setJMenuBar(menuBar);
		menu = new JMenu("File");
		menuItem = new JMenuItem("Exit");
		
		menuItem.addActionListener(listener);
		menuBar.add(menu);
		menu.add(menuItem);
	}
	
/* --------------------------------------------------------------- */
	
	/** PANELS METHOD */
	private void createPanel() {

		JPanel textFieldPanel = new JPanel();
		textFieldPanel.add(inputLabel);
		textFieldPanel.add(inputField);
		
		JPanel sizeButtonPanel = new JPanel();
		sizeButtonPanel.setBorder(new TitledBorder("Size"));
		sizeButtonPanel.add(sizeBox);
		
		JPanel toppingButtonPanel = new JPanel();
		toppingButtonPanel.setLayout(new GridLayout(3,1));
		toppingButtonPanel.setBorder(new TitledBorder("Toppings"));
		toppingButtonPanel.add(checkPine);
		toppingButtonPanel.add(checkOnion);
		toppingButtonPanel.add(checkOlive);
		
		JPanel tipButtonPanel = new JPanel();
		tipButtonPanel.setLayout(new GridLayout(1,1));
		tipButtonPanel.setBorder(new TitledBorder("Tips Options"));
		tipButtonPanel.add(radio5);
		tipButtonPanel.add(radio10);
		tipButtonPanel.add(radio15);
		
		JPanel centerPanel = new JPanel();
		centerPanel.add(textFieldPanel);
		centerPanel.add(sizeButtonPanel);
		centerPanel.add(toppingButtonPanel);
		centerPanel.add(tipButtonPanel);
		centerPanel.add(button);

		JPanel resultAreaPanel = new JPanel();
		JScrollPane resultScroll = new JScrollPane(resultArea);
		resultAreaPanel.add(resultLabel);
		resultAreaPanel.add(resultScroll);
		
		JPanel eastPanel = new JPanel();
		eastPanel.add(resultAreaPanel);
		
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
	}
}
