import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class JFrame2 extends JFrame implements ActionListener
{
	JButton pauseButton, testButton;
	JLabel label, label2;
	int counter = 1;
	
	public JFrame2()
	{
		super("Frame 2 - Monitor/Run");
		JPanel panel = new JPanel();
		
		panel.add(pauseButton = new JButton("Stop"));
		panel.add(testButton = new JButton("Test"));
		panel.add(label = new JLabel("Panel1"));
		panel.add(label2 = new JLabel(""));
		
		testButton.addActionListener(this);
		
		add(panel);
		
	     // sizes frame width, height
	     setSize(350, 150);
	     
	     //disable resize
	     setResizable(false);
	  
	     setVisible(false);
	     
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void loadData()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == testButton)
		{
			label2.setText("Pressed " + counter + " time(s).");
			counter++;
		}
	}

}
