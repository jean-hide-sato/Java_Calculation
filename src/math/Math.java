package math;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Math extends JFrame implements ActionListener {
	JTextField text;
	JLabel result = new JLabel("");
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel dividers = new JLabel("");
	ArrayList<Integer> divs = new ArrayList<>();
	
	public Math(String title) {
		//frame setting
		setTitle(title);
	    setSize(400, 150);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //icon setting
	    ImageIcon icon = new ImageIcon("./src/math/image/math.png");
	    setIconImage(icon.getImage());
	    
	    //panel1 setting
	    panel1 = new JPanel(new FlowLayout());
	    panel1.setPreferredSize(new Dimension(350, 60));
	    panel1.setBackground(Color.CYAN);
	    panel2 = new JPanel(new FlowLayout());
	    panel2.setPreferredSize(new Dimension(350, 40));
	    panel2.setBackground(Color.CYAN);
	    panel3 = new JPanel(new FlowLayout());
	    panel3.setPreferredSize(new Dimension(350, 30));
	    panel3.setBackground(Color.WHITE);

	    //label setting
	    JLabel label = new JLabel("Enter a number to check if it is a prime number: ");
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.TOP);
	    
	    text = new JTextField(10);

	    JButton btn = new JButton("Check");
	    btn.addActionListener(this);
	    
	    panel1.add(label, BorderLayout.PAGE_START);
	    panel1.add(text, BorderLayout.CENTER);
	    panel1.add(btn, BorderLayout.CENTER);

	    panel2.add(result,BorderLayout.PAGE_END);
	    panel3.add(dividers,BorderLayout.PAGE_END);
	    
	    Container contentPane = getContentPane();
	    contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    contentPane.setBackground(Color.WHITE);
	    contentPane.add(panel1, BorderLayout.CENTER);
	    contentPane.add(panel2, BorderLayout.CENTER);
	    contentPane.add(panel3, BorderLayout.CENTER);
	    
		//btn.addActionListener(this);
		//getContentPane().add(btn);

	    
	}
	public Math() {
		this("Math Samples");
	}
	
	public void actionPerformed(ActionEvent e){
		String textnumber = text.getText();
		try {
			Integer number = Integer.parseInt(textnumber);
			if (number>0) {
				boolean check = PrimeNumber.primecheck(number);
				if(check) {
					panel1.setPreferredSize(new Dimension(350, 60));
					textnumber += " is a prime number";
					panel2.setPreferredSize(new Dimension(350, 40));
				    panel3.setBackground(Color.WHITE);
					dividers.setText("");
				}
				else {
					panel1.setPreferredSize(new Dimension(350, 50));
					textnumber += " is not a prime number";
					panel2.setPreferredSize(new Dimension(350, 20));
				    panel3.setBackground(Color.CYAN);
					PrimeNumber.divisibles(number, divs);
					dividers.setText("Divisible by: " + divs.get(0));
				}
			} else {
				panel1.setPreferredSize(new Dimension(350, 60));
				textnumber = "Please enter a number greather than 0!";
				panel2.setPreferredSize(new Dimension(350, 40));
			    panel3.setBackground(Color.WHITE);
				dividers.setText("");
			}
		} catch (NumberFormatException ex) {
			panel1.setPreferredSize(new Dimension(350, 60));
			textnumber = "Please enter a valid number!";
			panel2.setPreferredSize(new Dimension(350, 40));
		    panel3.setBackground(Color.WHITE);
			dividers.setText("");
		}
		result.setText(textnumber);
	}

	public static void main(String[] args) {
		Math mathframe = new Math();
		mathframe.setVisible(true);
	}
}
