/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi.gui;

/**
 *  This class creates a GUI that allows the user to input parameters 
 *  and start a test.  A tabbed pane is used for the different steps of
 *  data entry.
 * 
 * 4/9/16
 * @author Mickey Horne
 * IST440W
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class TabbedPaneExample
		extends 	JFrame
{
	private		JTabbedPane tabbedPane;
        private		JPanel		panel;
	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;
        private         String          title;
        private         TextArea        infoText;
        private         JTextField      minTotalField;
        private         JTextField      minCellField;
        private         JTextField      hourField;
        private         JTextField      minField;
        private         JTextField      prMinField;
        private         JTextField      prSecField;
        private         JTextField      lowThresholdField;
        private         JTextField      hiThresholdField;
        private         JTextField      loThreshField;
        private         JTextField      hiThreshField;
        private         JLabel          minTotalStatus;
        private         JLabel          minCellStatus;
        private         JLabel          hourStatus;
        private         JLabel          minStatus;
        private         JLabel          prMinStatus;
        private         JLabel          prSecStatus;
        private         JLabel          conLoThreshStatus;
        private         JLabel          conHiThreshStatus;
        private         TextArea        genInfoArea;
        private         JTextField      cellField;
        private         JRadioButton    num12;
        private         JRadioButton    num24;
        private         JRadioButton    num60;
        private         JRadioButton    num240;
        private         JRadioButton    otherNum;
        private         JRadioButton    refYes;
        private         JRadioButton    refNo;
        private         JTextField      numCellField;   
        private         JLabel          conNumCell;
        private         JLabel          refStatus;
        private         JRadioButton    overallYes;
        private         JRadioButton    overallNo;
        private         JLabel          overallStatus;
        
	public TabbedPaneExample()
	{
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout.  This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.
		//String title = new String();
                title = "TPI Voltage Monitor";
		setTitle( title );
		setSize( 800, 480 );
		setBackground( Color.white );
                setResizable(false);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                //setExtendedState(JFrame.MAXIMIZED_BOTH);
                

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
                topPanel.setBackground(Color.WHITE);
		getContentPane().add( topPanel );

		// Create the tab pages
                createPage();
		createPage1();
		createPage2();
		createPage3();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
                tabbedPane.addTab( "Home", panel );
		tabbedPane.addTab( "System Set up", panel1 );
		tabbedPane.addTab( "Check Connections", panel2 );
		tabbedPane.addTab( "Confirm Settings", panel3 );
                tabbedPane.setBackground(Color.WHITE);

                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, false);
                tabbedPane.setEnabledAt(3, false);

		topPanel.add( tabbedPane, BorderLayout.CENTER );

	}
        
        //  Creates the Home Page
        public void createPage()
	{
                title = "TPI Voltage Monitor";
                panel = new JPanel();
                panel.setLayout(null);
                panel.setBackground(Color.WHITE);
                
                JLabel versionLabel = new JLabel("Version 1.4");
                JLabel dateLabel = new JLabel("Updated 4/9/16");
                
                panel.add(versionLabel);
                panel.add(dateLabel);
                
                versionLabel.setBounds(50, 0, 100, 25);
                dateLabel.setBounds(650, 0, 100, 25);
                
                
                ImageIcon icon = new ImageIcon(this.getClass().getResource("TPI_logo_edited-1.jpg"));
                
                JLabel iconLabel = new JLabel();
                iconLabel.setIcon(icon);
                
                panel.add(iconLabel);
                iconLabel.setBounds(25, 30, 800, 150);
                
                JLabel infoLabel = new JLabel( "General Test Information:" );
		//TextArea infoText = new TextArea();
                infoText = new TextArea();
                
                panel.add(infoLabel);
		panel.add(infoText);
             
                infoLabel.setBounds(50, 175, 150, 30);
                infoText.setBounds(50, 205, 700, 150);
                
                JButton homeNext = new HomeNextButton();
               
                panel.add(homeNext);
                homeNext.setBounds(350, 375, 100, 40);
                
                
	}
        
        //  Creates the System Set-up Page
        public void createPage1()
	{
                
                title = "System set up";
            
                panel1 = new JPanel();
                
		panel1.setLayout(null);
                panel1.setBackground(Color.WHITE);


                JLabel numLabel= new JLabel ("Number of Cells:");
                panel1.add(numLabel);
                numLabel.setBounds( 150, 25, 150, 30 );
                
                num12 = new JRadioButton("12");
                num24 = new JRadioButton("24");
                num60 = new JRadioButton("60");
                num240 = new JRadioButton("240");
                otherNum = new JRadioButton();
                
                num12.setOpaque(false);
                num24.setOpaque(false);
                num60.setOpaque(false);
                num240.setOpaque(false);
                otherNum.setOpaque(false);
                
                num24.setSelected(true);
                
                ButtonGroup numGroup = new ButtonGroup();
                numGroup.add(num12);
                numGroup.add(num24);
                numGroup.add(num60);
                numGroup.add(num240);
                numGroup.add(otherNum);
                
                panel1.add(num12);
                panel1.add(num24);  
                panel1.add(num60);
                panel1.add(num240);
                panel1.add(otherNum);
                
                
                num12.setBounds( 325, 25, 50, 30 );
                num24.setBounds( 385, 25, 50, 30 );
                num60.setBounds( 445, 25, 50, 30 );
                num240.setBounds( 505, 25, 50, 30 );
                otherNum.setBounds( 565, 25, 20, 30 );
                
                //JLabel label1 = new JLabel( "Number of Cells:" );
		//panel1.add( label1 );
                //label1.setBounds( 250, 65, 150, 30 );

		cellField = new JTextField();
                panel1.add( cellField );
		cellField.setBounds( 595, 25, 50, 30 );
                
                JLabel refLabel= new JLabel ("Cell Reference:");
                refYes = new JRadioButton("+");
                refNo = new JRadioButton("-");
                
                refYes.setOpaque(false);
                refNo.setOpaque(false);
                
                refYes.setSelected(true);
                
                panel1.add(refLabel);
                refLabel.setBounds( 150, 65, 150, 30 );
                
                ButtonGroup refGroup = new ButtonGroup();
                refGroup.add(refYes);
                refGroup.add(refNo);

                panel1.add(refYes);
                panel1.add(refNo); 
                
                refYes.setBounds( 325, 65, 50, 30 );
                refNo.setBounds( 385, 65, 50, 30 );
                
                JLabel overallLabel= new JLabel ("Overall Voltage Box:");
                overallYes = new JRadioButton("Yes");
                overallNo = new JRadioButton("No");
                
                overallYes.setOpaque(false);
                overallNo.setOpaque(false);
                
                overallYes.setSelected(true);
                
                panel1.add(overallLabel);
                overallLabel.setBounds( 150, 105, 150, 30 );
                
                ButtonGroup overallGroup = new ButtonGroup();
                overallGroup.add(overallYes);
                overallGroup.add(overallNo);
                
                panel1.add(overallYes);
                panel1.add(overallNo);  
                overallYes.setBounds( 325, 105, 50, 30 );
                overallNo.setBounds( 385, 105, 50, 30 );


                JLabel minTotalLabel = new JLabel( "Abort Voltage:" );
		
		panel1.add( minTotalLabel );
                minTotalLabel.setBounds( 150, 145, 150, 30 );

		minTotalField = new JTextField();
	
		panel1.add( minTotalField );
                minTotalField.setBounds( 325, 145, 150, 30 );
                
                JLabel minCellLabel = new JLabel( "Cell Alarm Threshold:" );
                
		panel1.add( minCellLabel );
                minCellLabel.setBounds( 150, 185, 150, 30 );

		minCellField = new JTextField();
		
		panel1.add( minCellField );
                minCellField.setBounds( 325, 185, 150, 30 );
                
                JLabel testLabel = new JLabel ("Target Time:");
                
                panel1.add(testLabel);
                testLabel.setBounds( 150, 225, 150, 30 );
                
                hourField = new JTextField();
                JLabel hourLabel = new JLabel("hrs");
                minField = new JTextField();
                JLabel minLabel = new JLabel("min");
                
                panel1.add(minLabel);
                panel1.add(minField);
                panel1.add(hourLabel);
                panel1.add(hourField);
                
                minLabel.setBounds( 430, 225, 30, 30 );
                minField.setBounds( 395, 225, 30, 30 );
                hourLabel.setBounds( 360, 225, 30, 30 );
                hourField.setBounds( 325, 225, 30, 30 );
                
                
                JLabel printLabel = new JLabel ("Print Rate:");
                
                panel1.add(printLabel);
                printLabel.setBounds( 150, 265, 150, 30 );
                
                prMinField = new JTextField();
                JLabel prMinLabel = new JLabel("min");
                prSecField = new JTextField();
                JLabel prSecLabel = new JLabel("sec");
                
                panel1.add(prMinField);
                panel1.add(prMinLabel);
                panel1.add(prSecField);
                panel1.add(prSecLabel);
                
                prSecLabel.setBounds( 430, 265, 30, 30 );
                prSecField.setBounds( 395, 265, 30, 30 );
                prMinLabel.setBounds( 360, 265, 30, 30 );
                prMinField.setBounds( 325, 265, 30, 30 );
                
                JLabel lowThresholdLabel = new JLabel("Low Threshold:");
                
                panel1.add(lowThresholdLabel);
                
                lowThresholdLabel.setBounds(150, 305, 150, 30);
                
                lowThresholdField = new JTextField();
                
                panel1.add(lowThresholdField);
                
                lowThresholdField.setBounds(325, 305, 150, 30);
                
                
                JLabel hiThresholdLabel = new JLabel("High Threshold:");
                
                panel1.add(hiThresholdLabel);
                
                hiThresholdLabel.setBounds(150, 345, 150, 30);
                
                hiThresholdField = new JTextField();
                
                panel1.add(hiThresholdField);
                
                hiThresholdField.setBounds(325, 345, 150, 30);

                JButton sysNext = new SysNextButton();
                JButton sysBack = new SysBackButton();
                
                panel1.add(sysNext);
                panel1.add(sysBack);
                
                sysNext.setBounds(700, 375, 75, 40);
                sysBack.setBounds(600, 375, 75, 40);

        
	}

        //  Creates the Check Settings page
	public void createPage2()
	{
		//panelIndex = 2;
                title = "Check Settings";
                panel2 = new JPanel();
                
                panel2.setLayout(null);
                panel2.setBackground(Color.WHITE);
                
                JLabel battVoltLabel = new JLabel("Battery Voltage:");
                JTextField  battVoltField = new JTextField();
                JLabel  voltsLabel = new JLabel("volts");
                
                panel2.add(battVoltLabel);
                panel2.add(battVoltField);
                panel2.add(voltsLabel);
                
                battVoltLabel.setBounds(50, 50, 100, 30);
                battVoltField.setBounds(200, 50, 50, 30);
                voltsLabel.setBounds(275, 50, 50, 30);
                
                JLabel loThreshLabel = new JLabel("Low Threshold:");
                loThreshField = new JTextField();
                
                
                panel2.add(loThreshLabel);
                panel2.add(loThreshField );
                
                loThreshLabel.setBounds(350, 50, 100, 30);
                loThreshField .setBounds(460, 50, 50, 30);
                
                JLabel numCellLabel = new JLabel("Number of cells:");
                numCellField = new JTextField();
                
                
                JLabel  cellsLabel = new JLabel("cells");
                
                panel2.add(numCellLabel);
                panel2.add(numCellField);
                panel2.add(cellsLabel);
                
                numCellLabel.setBounds(50, 100, 100, 30);
                numCellField.setBounds(200, 100, 50, 30);
                cellsLabel.setBounds(275, 100, 50, 30);
                
                JLabel hiThreshLabel = new JLabel("High Threshold:");
                hiThreshField = new JTextField(hiThresholdField.getText());
                
                panel2.add(hiThreshLabel);
                panel2.add(hiThreshField);
                
                hiThreshLabel.setBounds(350, 100, 100, 30);
                hiThreshField.setBounds(460, 100, 50, 30);
                
                JLabel logLabel = new JLabel("Activity Log");
                TextArea activityLog = new TextArea();
                
                panel2.add(logLabel);
                panel2.add(activityLog);
                
                logLabel.setBounds(600, 50, 100, 30);
                activityLog.setBounds(600, 90, 150, 150);
                
                
                JLabel cellVoltLabel = new JLabel("Cell Voltage:");
                JLabel sortLabel = new JLabel("(Cell # - Cell Voltage)");
                
                panel2.add(cellVoltLabel);
                panel2.add(sortLabel);
                
                cellVoltLabel.setBounds(50, 230, 80, 30);
                sortLabel.setBounds(140, 230, 150, 30);
                
                JLabel sortRadioLabel= new JLabel ("Sort by");
                JRadioButton sortCell = new JRadioButton("cell#");
                JRadioButton sortLow = new JRadioButton("Low");
                JRadioButton sortHigh = new JRadioButton("High");

                
                ButtonGroup sortGroup = new ButtonGroup();
                sortGroup.add(sortCell);
                sortGroup.add(sortLow);
                sortGroup.add(sortHigh);
                
                panel2.add(sortRadioLabel);
                panel2.add(sortCell);
                panel2.add(sortLow);
                panel2.add(sortHigh);
                
                sortCell.setOpaque(false);
                sortLow.setOpaque(false);
                sortHigh.setOpaque(false);
                
                sortRadioLabel.setBounds( 300, 230, 50, 30 );
                sortCell.setBounds( 360, 230, 60, 30 );
                sortLow.setBounds( 430, 230, 50, 30 );
                sortHigh.setBounds( 500, 230, 50, 30 );
                
                TextArea voltArea = new TextArea();

                panel2.add(voltArea);
                
                voltArea.setBounds( 50, 270, 500, 150 );
                
                JButton threshButton = new ThresholdButton();
                
                panel2.add(threshButton);
                
                threshButton.setBounds(350, 155, 165, 50);
                
                JButton checkRefrButton = new CheckRefreshButton();
                
                panel2.add(checkRefrButton);
                
                checkRefrButton.setBounds(700, 50, 85, 30);
                
                JButton chkNext = new ChkNextButton();
                JButton chkBack = new ChkBackButton();
                
                panel2.add(chkBack);
                panel2.add(chkNext);
                
                chkNext.setBounds(700, 375, 75, 40);
                chkBack.setBounds(600, 375, 75, 40);
		
	}
        
        //  Creates the Confirm page
	public void createPage3()
	{
		//panelIndex = 3;
                title = "Confirm";
                panel3 = new JPanel();
                
                panel3.setLayout(null);
                panel3.setBackground(Color.WHITE);
                
                JLabel conLabel1 = new JLabel( "Number of Cells:" );
		panel3.add( conLabel1 );
                conLabel1.setBounds( 50, 25, 150, 30 );

		conNumCell= new JLabel ();
                panel3.add( conNumCell );
		conNumCell.setBounds( 225, 25, 150, 30 );
                
                JLabel conRefLabel= new JLabel ("Cell Reference:");
                refStatus = new JLabel();
                
                panel3.add(conRefLabel);
                conRefLabel.setBounds( 50, 65, 150, 30 );

                panel3.add(refStatus); 
                
                refStatus.setBounds( 225, 65, 50, 30 );
                
                JLabel conOverallLabel= new JLabel ("Overall Voltage Box:");
                overallStatus = new JLabel ();
              
                
                panel3.add(conOverallLabel);
                conOverallLabel.setBounds( 50, 105, 150, 30 );
               
                panel3.add(overallStatus);

                overallStatus.setBounds( 225, 105, 50, 30 );


                JLabel conMinTotalLabel = new JLabel( "Abort Voltage:" );
		
		panel3.add( conMinTotalLabel );
                conMinTotalLabel.setBounds( 50, 145, 150, 30 );

		minTotalStatus = new JLabel();
	
		panel3.add( minTotalStatus );
                minTotalStatus.setBounds( 225, 145, 150, 30 );
                
                JLabel conMinCellLabel = new JLabel( "Cell Alarm Threshold:" );
                
		panel3.add( conMinCellLabel );
                conMinCellLabel.setBounds( 50, 185, 150, 30 );

		minCellStatus = new JLabel();
		
		panel3.add( minCellStatus );
                minCellStatus.setBounds( 225, 185, 150, 30 );
                
                JLabel conTestLabel = new JLabel ("Target Time:");
                
                panel3.add(conTestLabel);
                conTestLabel.setBounds( 50, 225, 150, 30 );
                
                hourStatus = new JLabel();
                JLabel conHourLabel = new JLabel("hrs");
                minStatus = new JLabel();
                JLabel conMinLabel = new JLabel("min");
                
                panel3.add(conMinLabel);
                panel3.add(minStatus);
                panel3.add(conHourLabel);
                panel3.add(hourStatus);
                
                conMinLabel.setBounds( 330, 225, 30, 30 );
                minStatus.setBounds( 295, 225, 30, 30 );
                conHourLabel.setBounds( 260, 225, 30, 30 );
                hourStatus.setBounds( 225, 225, 30, 30 );
                
                
                JLabel conPrintLabel = new JLabel ("Print Rate:");
                
                panel3.add(conPrintLabel);
                conPrintLabel.setBounds( 50, 265, 150, 30 );
                
                prMinStatus= new JLabel();
                JLabel conPrMinLabel = new JLabel("min");
                prSecStatus = new JLabel();
                JLabel conPrSecLabel = new JLabel("sec");
                
                panel3.add(prMinStatus);
                panel3.add(conPrMinLabel);
                panel3.add(prSecStatus);
                panel3.add(conPrSecLabel);
                
                conPrSecLabel.setBounds( 330, 265, 30, 30 );
                prSecStatus.setBounds( 295, 265, 30, 30 );
                conPrMinLabel.setBounds( 260, 265, 30, 30 );
                prMinStatus.setBounds( 225, 265, 30, 30 );
                
                JLabel conLoThreshLabel= new JLabel ("Low Threshold:");
                panel3.add(conLoThreshLabel);
                conLoThreshLabel.setBounds( 50, 305, 150, 30 );
                
                conLoThreshStatus = new JLabel ();
                
                panel3.add(conLoThreshStatus);    
                
                
                conLoThreshStatus.setBounds( 225, 305, 50, 30 );
                
                JLabel conHiThreshLabel = new JLabel ("High Threshold:");
                
                panel3.add(conHiThreshLabel);
                conHiThreshLabel.setBounds( 50, 345, 150, 30 );
                
                conHiThreshStatus = new JLabel();
                
                panel3.add(conHiThreshStatus);
                
                conHiThreshStatus.setBounds( 225, 345, 50, 30 );
                
                JLabel conLogLabel = new JLabel("Activity Log");
                TextArea conActivityLog = new TextArea();
                
                panel3.add(conLogLabel);
                panel3.add(conActivityLog);
                
                conLogLabel.setBounds(450, 10, 100, 30);
                conActivityLog.setBounds(450, 50, 300, 125);
                
                JLabel genInfoLabel = new JLabel("General Test Info:");
                genInfoArea = new TextArea();

                panel3.add(genInfoLabel);
                panel3.add(genInfoArea);
                
                genInfoLabel.setBounds( 450, 190, 100, 30 );
                genInfoArea.setBounds( 450, 225, 300, 125 );
                
                JButton conRefrButton = new ConRefreshButton();
                
                panel3.add(conRefrButton);
                
                conRefrButton.setBounds(600, 10, 85, 30);
                
                JButton conNext = new ConNextButton();
                JButton conBack = new ConBackButton();
                
                panel3.add(conBack);
                panel3.add(conNext);
		
                conNext.setBounds(700, 375, 75, 40);
                conBack.setBounds(600, 375, 75, 40);
	}
        
        //  numCell sets the String value for the number of cells from the radio group
        public  String numCell(){
        
                String numberOfCells = "";
            
                if (num12.isSelected()){
                numberOfCells="12";
                }
            
                else if (num24.isSelected() ){
                    numberOfCells="24";
                }

                else if (num60.isSelected() ){
                    numberOfCells="60";
                }

                else if (num240.isSelected() ){
                    numberOfCells="240";
                }

                else{
                    numberOfCells=cellField.getText();
                }
                return numberOfCells;
            } 
       
        //     Sets the String value of the cell reference from the radio group
        public String cellRef(){
        
                String cellReference = "";
                
                if (refYes.isSelected()){
                    
                    cellReference = "Pos";
                }
                
                else{
                    
                    cellReference = "Neg";
                }
                
                return cellReference;
        
        }
        
        //     Sets the String value of the Overall Box from the radio group
        public String overallBox(){
        
                String overAll = "";
                
                if (overallYes.isSelected()){
                    
                    overAll = "Yes";
                }
                
                else{
                    
                    overAll = "No";
                }
                
                return overAll;
        
        }
        
        //  isInt checks that the supplied text value is an integer
        public boolean isInt(String intComp){
          
          boolean valid; 
          try {
              Integer.parseInt(intComp);
              valid = true;
          }
          
          catch (NumberFormatException e){
              valid = false;
          }
          
          return valid;
        }
        
        //  isDouble checks that the supplied text value is an Double
        public boolean isDouble(String intComp){
          
          boolean valid; 
          try {
              Double.parseDouble(intComp);
              valid = true;
          }
          
          catch (NumberFormatException e){
              valid = false;
          }
          
          return valid;
        }
        
        private class HomeNextButton extends JButton implements ActionListener{
            
            //int nextIndex;
            
            public HomeNextButton() {
                setText("Start");
                setToolTipText ("Move to the next tab");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                if (infoText.getText().isEmpty()){
                JOptionPane.showMessageDialog( tabbedPane,
                        "Please Enter Test Info");
                //setTitle("Sytem Setup");
                }
                
                else{
                
                tabbedPane.setSelectedIndex(1);
                tabbedPane.setEnabledAt(1, true);
                }
            }
        }
        
        private class SysNextButton extends JButton implements ActionListener{
            
            //int nextIndex;
            
            public SysNextButton() {
                setText("Next");
                setToolTipText ("Move to the next tab");
                //setEnabled(false);
                addActionListener(this);
                
            }
            
            public void actionPerformed(ActionEvent e){
                
                if (minTotalField.getText().isEmpty() || 
                    minCellField.getText().isEmpty()  ||
                    hourField.getText().isEmpty() ||
                    minField.getText().isEmpty() ||
                    prMinField.getText().isEmpty() ||
                    prSecField.getText().isEmpty() ||
                    lowThresholdField.getText().isEmpty() ||
                    hiThresholdField.getText().isEmpty() ||
                    (otherNum.isSelected() && cellField.getText().isEmpty())){
                    
                JOptionPane.showMessageDialog( tabbedPane,
                        "Please fill in all parameters");
                //setTitle("Sytem Setup");
                }
                
                
                else if (otherNum.isSelected() && (isInt(cellField.getText()) == false)){
                  
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid cell number");
                }
                
                else if ((isInt(minTotalField.getText()) == false) && 
                         (isDouble(minTotalField.getText())  == false)){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Abort Voltage Value");
                }
                
                else if ((isInt(minCellField.getText()) == false) && 
                         (isDouble(minCellField.getText())  == false)){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Cell Alarm Value");
                }
                
                else if ((isInt(hourField.getText()) == false) || 
                         (isInt(minField.getText())  == false)){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Target Time Value");
                }
                
                else if ((isInt(prMinField.getText()) == false) || 
                         (isInt(prSecField.getText())  == false)){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Print Rate Value");
                }
               
                else if (((isInt(lowThresholdField.getText()) == false) && 
                         (isDouble(lowThresholdField.getText())  == false)) ||
                          ((isInt(hiThresholdField.getText()) == false) && 
                         (isDouble(hiThresholdField.getText())  == false))){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Threshold Value");
                }
                
                else if (Double.parseDouble(lowThresholdField.getText()) >= 
                        Double.parseDouble(hiThresholdField.getText())){
                
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please make sure Low Threshold is less the High Threshold");
                    
                }
                
                else{
                
                tabbedPane.setSelectedIndex(2);
                tabbedPane.setEnabledAt(2, true);
                loThreshField.setText(lowThresholdField.getText());
                hiThreshField.setText(hiThresholdField.getText());
                numCellField.setText(numCell());
                
                }
            }
        }

        private class SysBackButton extends JButton implements ActionListener{
            //int backIndex;
            
            public SysBackButton() {
                setText("Back");
                setToolTipText ("Move to the previous tab");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                tabbedPane.setSelectedIndex(0);
                
            }
        }
        
        private class ChkNextButton extends JButton implements ActionListener{
            
            //int nextIndex;
            
            public ChkNextButton() {
                setText("Next");
                setToolTipText ("Move to the next tab");
                addActionListener(this);
                
            }
            
            public void actionPerformed(ActionEvent e){
                
                    if (loThreshField.getText().isEmpty() ||
                    hiThreshField.getText().isEmpty() ){
                    
                JOptionPane.showMessageDialog( tabbedPane,
                        "Please fill in all parameters");
                //setTitle("Sytem Setup");
                }
                
                else{
                
                tabbedPane.setSelectedIndex(3);
                tabbedPane.setEnabledAt(3, true);
                minTotalStatus.setText(minTotalField.getText());
                minCellStatus.setText(minCellField.getText());
                hourStatus.setText(hourField.getText());
                minStatus.setText(minField.getText());
                prMinStatus.setText(prMinField.getText());
                prSecStatus.setText(prSecField.getText());
                conLoThreshStatus.setText(lowThresholdField.getText());
                conHiThreshStatus.setText(hiThresholdField.getText());
                genInfoArea.setText(infoText.getText());
                conNumCell.setText(numCell());
                refStatus.setText(cellRef());
                overallStatus.setText(overallBox());
                }
                
                    
            }
        }

        private class ChkBackButton extends JButton implements ActionListener{
            //int backIndex;
            
            public ChkBackButton() {
                setText("Back");
                setToolTipText ("Move to the previous tab");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                tabbedPane.setSelectedIndex(1);
                
            }
        }
        
        private class ThresholdButton extends JButton implements ActionListener{
            //int backIndex;
            
            public ThresholdButton() {
                setText("Update Threshold");
                setToolTipText ("Update threshold values");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                if (((isInt(loThreshField.getText()) == false) && 
                         (isDouble(loThreshField.getText())  == false)) ||
                          ((isInt(hiThreshField.getText()) == false) && 
                         (isDouble(hiThreshField.getText())  == false))){
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Threshold Value");
                }
                
                else if (Double.parseDouble(loThreshField.getText()) >= 
                        Double.parseDouble(hiThreshField.getText())){
                
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please make sure Low Threshold is less the High Threshold");
                    
                }
                else {
                lowThresholdField.setText(loThreshField.getText());
                hiThresholdField.setText(hiThreshField.getText());
                JOptionPane.showMessageDialog( tabbedPane,
                        "Threshold Values are updated");
                }
            }
        }
        
        private class CheckRefreshButton extends JButton implements ActionListener{
            //int backIndex;
            
            public CheckRefreshButton() {
                setText("Refresh");
                setToolTipText ("Reset the Activity Log");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){

                JOptionPane.showMessageDialog( tabbedPane,
                        "Activity Log is reset");
                
            }
        }
        
        private class ConNextButton extends JButton implements ActionListener{
            
            //int nextIndex;
            
            public ConNextButton() {
                setText("Run");
                setToolTipText ("Start the test");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                Monitor monitor = new Monitor();
         
		monitor.setVisible( true );
                
                /*JOptionPane.showMessageDialog( tabbedPane,
                        "Monitor goes here");*/
                //setSize(800, 480);
            }
        }

        private class ConBackButton extends JButton implements ActionListener{
            //int backIndex;
            
            public ConBackButton() {
                setText("Back");
                setToolTipText ("Move to the previous tab");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){
                
                tabbedPane.setSelectedIndex(2);
                
            }
        }
        
         private class ConRefreshButton extends JButton implements ActionListener{
            //int backIndex;
            
            public ConRefreshButton() {
                setText("Refresh");
                setToolTipText ("Reset the Activity Log");
                addActionListener(this);
            }
            
            public void actionPerformed(ActionEvent e){

                JOptionPane.showMessageDialog( tabbedPane,
                        "Activity Log is reset");
                
            }
        }
         
             
            

         
    // Main method to get things started
	public static void main( String args[] )
	{
		// Create an instance of the test application
		TabbedPaneExample mainFrame	= new TabbedPaneExample();
         
		mainFrame.setVisible( true );
                mainFrame.setBackground(Color.WHITE);
	}
}

