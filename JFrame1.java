import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class JFrame1 extends JFrame implements ActionListener
{
	JButton startButton;
	JLabel label;
	
	public JFrame1()
	{
		super("Frame 1 - Setup");
		JPanel panel = new JPanel(new GridLayout(2,1));
		JPanel panel2 = new JPanel();
		
		panel2.add(startButton = new JButton("start"));
		panel.add(panel2);
		panel.add(label = new JLabel(""));

		
		add(panel);
		
	     // sizes frame width, height
	     setSize(350, 150);
	     
	     //disable resize
	     setResizable(false);
	  
	     setVisible(true);
	     
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void loadData()
	{
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
