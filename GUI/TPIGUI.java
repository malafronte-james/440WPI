package GUI;

/**
 * @author chorne
 * @author jmalafronte
 * Creates TPI setup GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TPIGUI extends JFrame implements ActionListener
{

	public int numberOfCells = 24;
	
	public CustomButton checkRefreshButton,
	                    checkBackButton,
	                    checkNextButton,
	                    conBackButton,
	                    conNextButton,
	                    conRefreshButton,
	                    homeNextButton,
	                    sysBackButton,
	                    sysNextButton,
	                    updateThresholdButton;
	
	public	JTabbedPane tabbedPane;
    private	JPanel homePanel,
                   systemSetupPanel,
                   checkSettingsPanel,
                   confirmPanel;
    
    private String title;
    
    public TextArea generalInfoText,
                     voltArea,
                     genInfoArea;
    
    public JTextField cellField, 
    		          abortVoltageField,
                       cellAlarmField,
                       targetTimeHourField,
                       targetTimeMinField,
                       printMinuteField,
                       printSecondField,
                       lowThresholdField,
                       hiThresholdField,
                       loThreshField,
                       hiThreshField,
                       numCellField,
                       batteryVoltageField;
    
    private JLabel minTotalStatus,
                   minCellStatus,
                   hourStatus,
                   minStatus,
                   prMinStatus,
                   prSecStatus,
                   conLoThreshStatus,
                   conHiThreshStatus,
                   conNumCell,
                   refStatus,
                   overallStatus,
                   versionLabel,
                   dateLabel;
    
    private JRadioButton num12RadioButton,
                         num24RadioButton,
                         num60RadioButton,
                         num240RadioButton,
                         otherNumRadioButton,
                         refYesRadioButton,
                         refNoRadioButton,
                         overallYesRadioButton,
                         overallNoRadioButton;
    
    private int cells;
    
    
	public TPIGUI()
	{
		
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
        createHomePage();
		createSystemSetupPage();
		createCheckSettingsPage();
		createConfirmPage();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
                tabbedPane.addTab( "Home", homePanel );
		tabbedPane.addTab( "System Setup", systemSetupPanel );
		tabbedPane.addTab( "Check Connections", checkSettingsPanel );
		tabbedPane.addTab( "Confirm Settings", confirmPanel );
                tabbedPane.setBackground(Color.WHITE);

                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, false);
                tabbedPane.setEnabledAt(3, false);

		topPanel.add( tabbedPane, BorderLayout.CENTER );
		
		addActionListeners();

	} // end 

	/**
	 * Creates the home tab
	 */
    public void createHomePage()
    {
        		// title
                title = "TPI Voltage Monitor";
                
                // instantiate homePanel
                homePanel = new JPanel();
                
                // set homePanel layout
                homePanel.setLayout(null);
                
                // set homePanel background color
                homePanel.setBackground(Color.WHITE);
                
                // add version and last update date to homePanel
                homePanel.add(versionLabel = new JLabel("Version 1.5"));
                homePanel.add(dateLabel = new JLabel("Updated 4/20/16"));
                
                // set the location of the version and last update date
                versionLabel.setBounds(50, 0, 100, 25);
                dateLabel.setBounds(650, 0, 100, 25);
                
                // logo
                ImageIcon icon = new ImageIcon(this.getClass().getResource("TPI_logo_edited-1.jpg"));
                JLabel iconLabel = new JLabel();
                iconLabel.setIcon(icon);
                homePanel.add(iconLabel);
                iconLabel.setBounds(25, 30, 800, 150);
                
                // info TextArea
                JLabel infoLabel = new JLabel( "General Test Information:" );
		        generalInfoText = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);         
                homePanel.add(infoLabel);
                homePanel.add(generalInfoText);           
                infoLabel.setBounds(50, 175, 150, 30);
                generalInfoText.setBounds(50, 205, 700, 150);
 
                // start Button
                homeNextButton = new CustomButton("Start","Move to the next tab");
                homePanel.add(homeNextButton);
                homeNextButton.setBounds(350, 375, 100, 40);
                
	} // end createHomePage
        
    /**
     * Create System Setup Tab
     */
    public void createSystemSetupPage()
    {
                
                title = "System Setup";
            
                // SystemSetupPanel
                systemSetupPanel = new JPanel();
                systemSetupPanel.setLayout(null);
                systemSetupPanel.setBackground(Color.WHITE);

                // numLabel
                JLabel numLabel= new JLabel ("Number of Cells:");
                systemSetupPanel.add(numLabel);
                numLabel.setBounds( 150, 25, 150, 30 );
                
                num12RadioButton = new JRadioButton("12");
                num24RadioButton = new JRadioButton("24");
                num60RadioButton = new JRadioButton("60");
                num240RadioButton = new JRadioButton("240");
                otherNumRadioButton = new JRadioButton();
                
                num12RadioButton.setOpaque(false);
                num24RadioButton.setOpaque(false);
                num60RadioButton.setOpaque(false);
                num240RadioButton.setOpaque(false);
                otherNumRadioButton.setOpaque(false);
                
                num24RadioButton.setSelected(true);
                
                ButtonGroup numGroup = new ButtonGroup();
                numGroup.add(num12RadioButton);
                numGroup.add(num24RadioButton);
                numGroup.add(num60RadioButton);
                numGroup.add(num240RadioButton);
                numGroup.add(otherNumRadioButton);
                
                systemSetupPanel.add(num12RadioButton);
                systemSetupPanel.add(num24RadioButton);  
                systemSetupPanel.add(num60RadioButton);
                systemSetupPanel.add(num240RadioButton);
                systemSetupPanel.add(otherNumRadioButton);
                
                
                num12RadioButton.setBounds( 325, 25, 50, 30 );
                num24RadioButton.setBounds( 385, 25, 50, 30 );
                num60RadioButton.setBounds( 445, 25, 50, 30 );
                num240RadioButton.setBounds( 505, 25, 50, 30 );
                otherNumRadioButton.setBounds( 565, 25, 20, 30 );
                

		cellField = new JTextField();
                systemSetupPanel.add( cellField );
		cellField.setBounds( 595, 25, 50, 30 );
                
                JLabel refLabel= new JLabel ("Cell Reference:");
                refYesRadioButton = new JRadioButton("+");
                refNoRadioButton = new JRadioButton("-");
                
                refYesRadioButton.setOpaque(false);
                refNoRadioButton.setOpaque(false);
                
                refYesRadioButton.setSelected(true);
                
                systemSetupPanel.add(refLabel);
                refLabel.setBounds( 150, 65, 150, 30 );
                
                ButtonGroup refGroup = new ButtonGroup();
                refGroup.add(refYesRadioButton);
                refGroup.add(refNoRadioButton);

                systemSetupPanel.add(refYesRadioButton);
                systemSetupPanel.add(refNoRadioButton); 
                
                refYesRadioButton.setBounds( 325, 65, 50, 30 );
                refNoRadioButton.setBounds( 385, 65, 50, 30 );
                
                JLabel overallLabel= new JLabel ("Overall Voltage Box:");
                overallYesRadioButton = new JRadioButton("Yes");
                overallNoRadioButton = new JRadioButton("No");
                
                overallYesRadioButton.setOpaque(false);
                overallNoRadioButton.setOpaque(false);
                
                overallYesRadioButton.setSelected(true);
                
                systemSetupPanel.add(overallLabel);
                overallLabel.setBounds( 150, 105, 150, 30 );
                
                ButtonGroup overallGroup = new ButtonGroup();
                overallGroup.add(overallYesRadioButton);
                overallGroup.add(overallNoRadioButton);
                
                systemSetupPanel.add(overallYesRadioButton);
                systemSetupPanel.add(overallNoRadioButton);  
                overallYesRadioButton.setBounds( 325, 105, 50, 30 );
                overallNoRadioButton.setBounds( 385, 105, 50, 30 );


                JLabel minTotalLabel = new JLabel( "Abort Voltage:" );
		
		systemSetupPanel.add( minTotalLabel );
                minTotalLabel.setBounds( 150, 145, 150, 30 );

		abortVoltageField = new JTextField();
	
		systemSetupPanel.add( abortVoltageField );
		abortVoltageField.setBounds( 325, 145, 150, 30 );
                
                JLabel cellAlarmLabel = new JLabel( "Cell Alarm Threshold:" );
                
		systemSetupPanel.add( cellAlarmLabel );
                cellAlarmLabel.setBounds( 150, 185, 150, 30 );

		cellAlarmField = new JTextField();
		
		systemSetupPanel.add( cellAlarmField );
                cellAlarmField.setBounds( 325, 185, 150, 30 );
                
                JLabel targetTimeLabel = new JLabel ("Target Time:");
                
                systemSetupPanel.add(targetTimeLabel);
                targetTimeLabel.setBounds( 150, 225, 150, 30 );
                
                targetTimeHourField = new JTextField();
                JLabel hourLabel = new JLabel("hrs");
                targetTimeMinField = new JTextField();
                JLabel minLabel = new JLabel("min");
                
                systemSetupPanel.add(minLabel);
                systemSetupPanel.add(targetTimeMinField);
                systemSetupPanel.add(hourLabel);
                systemSetupPanel.add(targetTimeHourField);
                
                minLabel.setBounds( 430, 225, 30, 30 );
                targetTimeMinField.setBounds( 395, 225, 30, 30 );
                hourLabel.setBounds( 360, 225, 30, 30 );
                targetTimeHourField.setBounds( 325, 225, 30, 30 );
                
                
                JLabel printLabel = new JLabel ("Print Rate:");
                
                systemSetupPanel.add(printLabel);
                printLabel.setBounds( 150, 265, 150, 30 );
                
                printMinuteField = new JTextField();
                JLabel printMinuteLabel = new JLabel("min");
                printSecondField = new JTextField();
                JLabel printSecondLabel = new JLabel("sec");
                
                systemSetupPanel.add(printMinuteField);
                systemSetupPanel.add(printMinuteLabel);
                systemSetupPanel.add(printSecondField);
                systemSetupPanel.add(printSecondLabel);
                
                printSecondLabel.setBounds( 430, 265, 30, 30 );
                printSecondField.setBounds( 395, 265, 30, 30 );
                printMinuteLabel.setBounds( 360, 265, 30, 30 );
                printMinuteField.setBounds( 325, 265, 30, 30 );
                
                JLabel lowThresholdLabel = new JLabel("Low Threshold:");
                
                systemSetupPanel.add(lowThresholdLabel);
                
                lowThresholdLabel.setBounds(150, 305, 150, 30);
                
                lowThresholdField = new JTextField();
                
                systemSetupPanel.add(lowThresholdField);
                
                lowThresholdField.setBounds(325, 305, 150, 30);
                
                
                JLabel hiThresholdLabel = new JLabel("High Threshold:");
                
                systemSetupPanel.add(hiThresholdLabel);
                
                hiThresholdLabel.setBounds(150, 345, 150, 30);
                
                hiThresholdField = new JTextField();
                
                systemSetupPanel.add(hiThresholdField);
                
                hiThresholdField.setBounds(325, 345, 150, 30);

                sysNextButton = new CustomButton("Next",
                		                           "Move to the next tab");
                sysBackButton = new CustomButton("Back",
						                           "Move to the previous tab");
                
                systemSetupPanel.add(sysNextButton);
                systemSetupPanel.add(sysBackButton);
                
                sysNextButton.setBounds(700, 375, 75, 40);
                sysBackButton.setBounds(600, 375, 75, 40);

        
	} // end create system setup tab

    /**
     * Creates check settings tab
     */
	public void createCheckSettingsPage()
	{
		//panelIndex = 2;
                title = "Check Settings";
                checkSettingsPanel = new JPanel();
                
                checkSettingsPanel.setLayout(null);
                checkSettingsPanel.setBackground(Color.WHITE);
                
                JLabel batteryVoltageLabel = new JLabel("Battery Voltage:");
                batteryVoltageField = new JTextField();
                JLabel  voltsLabel = new JLabel("volts");
                
                checkSettingsPanel.add(batteryVoltageLabel);
                checkSettingsPanel.add(batteryVoltageField);
                checkSettingsPanel.add(voltsLabel);
                
                batteryVoltageLabel.setBounds(50, 50, 100, 30);
                batteryVoltageField.setBounds(200, 50, 50, 30);
                voltsLabel.setBounds(275, 50, 50, 30);
                
                JLabel loThreshLabel = new JLabel("Low Threshold:");
                loThreshField = new JTextField();
                
                
                checkSettingsPanel.add(loThreshLabel);
                checkSettingsPanel.add(loThreshField );
                
                loThreshLabel.setBounds(350, 50, 100, 30);
                loThreshField .setBounds(460, 50, 50, 30);
                
                JLabel numCellLabel = new JLabel("Number of cells:");
                numCellField = new JTextField();
                
                
                JLabel  cellsLabel = new JLabel("cells");
                
                checkSettingsPanel.add(numCellLabel);
                checkSettingsPanel.add(numCellField);
                checkSettingsPanel.add(cellsLabel);
                
                numCellLabel.setBounds(50, 100, 100, 30);
                numCellField.setBounds(200, 100, 50, 30);
                cellsLabel.setBounds(275, 100, 50, 30);
                
                JLabel hiThreshLabel = new JLabel("High Threshold:");
                hiThreshField = new JTextField(hiThresholdField.getText());
                
                checkSettingsPanel.add(hiThreshLabel);
                checkSettingsPanel.add(hiThreshField);
                
                hiThreshLabel.setBounds(350, 100, 100, 30);
                hiThreshField.setBounds(460, 100, 50, 30);
                
                JLabel logLabel = new JLabel("Activity Log");
                TextArea activityLog = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
                activityLog.setBackground(Color.WHITE);
                activityLog.setEditable(false);
                
                checkSettingsPanel.add(logLabel);
                checkSettingsPanel.add(activityLog);
                
                logLabel.setBounds(600, 50, 100, 30);
                activityLog.setBounds(600, 90, 150, 150);
                
                
                JLabel cellVoltLabel = new JLabel("Cell Voltage:");
                JLabel sortLabel = new JLabel("(Cell # - Cell Voltage)");
                
                checkSettingsPanel.add(cellVoltLabel);
                checkSettingsPanel.add(sortLabel);
                
                cellVoltLabel.setBounds(50, 230, 80, 30);
                sortLabel.setBounds(140, 230, 150, 30);
                
                JLabel sortRadioLabel= new JLabel ("Sort by");
                JRadioButton sortCell = new JRadioButton("Cell #");
                JRadioButton sortLow = new JRadioButton("Low");
                JRadioButton sortHigh = new JRadioButton("High");

                
                ButtonGroup sortGroup = new ButtonGroup();
                sortGroup.add(sortCell);
                sortGroup.add(sortLow);
                sortGroup.add(sortHigh);
                
                sortCell.setSelected(true);
                
                checkSettingsPanel.add(sortRadioLabel);
                checkSettingsPanel.add(sortCell);
                checkSettingsPanel.add(sortLow);
                checkSettingsPanel.add(sortHigh);
                
                sortCell.setOpaque(false);
                sortLow.setOpaque(false);
                sortHigh.setOpaque(false);
                
                sortRadioLabel.setBounds( 300, 230, 50, 30 );
                sortCell.setBounds( 360, 230, 60, 30 );
                sortLow.setBounds( 430, 230, 50, 30 );
                sortHigh.setBounds( 500, 230, 50, 30 );
                
                voltArea = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
                voltArea.setBackground(Color.WHITE);
                voltArea.setEditable(false);

                checkSettingsPanel.add(voltArea);
                
                voltArea.setBounds( 50, 270, 500, 150 );
                
                updateThresholdButton = new CustomButton("Update Threshold","Update threshold values");
                
                checkSettingsPanel.add(updateThresholdButton);
                
                updateThresholdButton.setBounds(350, 155, 165, 50);
                
                checkRefreshButton = new CustomButton("Refresh","Refresh the Activity Log");
                
                checkSettingsPanel.add(checkRefreshButton);
                
                checkRefreshButton.setBounds(700, 50, 85, 30);
                
                checkNextButton = new CustomButton("Next","Move to the next tab");
                checkBackButton = new CustomButton("Back","Move to the previous tab");
                
                checkSettingsPanel.add(checkBackButton);
                checkSettingsPanel.add(checkNextButton);
                
                checkNextButton.setBounds(700, 375, 75, 40);
                checkBackButton.setBounds(600, 375, 75, 40);
		
	} // end createCheckSettingsPage
        
	/**
	 * Creates confirm page
	 */
	public void createConfirmPage()
	{
		//panelIndex = 3;
                title = "Confirm";
                confirmPanel = new JPanel();
                
                confirmPanel.setLayout(null);
                confirmPanel.setBackground(Color.WHITE);
                
                JLabel conLabel1 = new JLabel( "Number of Cells:" );
		confirmPanel.add( conLabel1 );
                conLabel1.setBounds( 50, 25, 150, 30 );

		conNumCell= new JLabel ();
                confirmPanel.add( conNumCell );
		conNumCell.setBounds( 225, 25, 150, 30 );
                
                JLabel conRefLabel= new JLabel ("Cell Reference:");
                refStatus = new JLabel();
                
                confirmPanel.add(conRefLabel);
                conRefLabel.setBounds( 50, 65, 150, 30 );

                confirmPanel.add(refStatus); 
                
                refStatus.setBounds( 225, 65, 50, 30 );
                
                JLabel conOverallLabel= new JLabel ("Overall Voltage Box:");
                overallStatus = new JLabel ();
              
                
                confirmPanel.add(conOverallLabel);
                conOverallLabel.setBounds( 50, 105, 150, 30 );
               
                confirmPanel.add(overallStatus);

                overallStatus.setBounds( 225, 105, 50, 30 );


                JLabel conMinTotalLabel = new JLabel( "Abort Voltage:" );
		
		confirmPanel.add( conMinTotalLabel );
                conMinTotalLabel.setBounds( 50, 145, 150, 30 );

		minTotalStatus = new JLabel();
	
		confirmPanel.add( minTotalStatus );
                minTotalStatus.setBounds( 225, 145, 150, 30 );
                
                JLabel conMinCellLabel = new JLabel( "Cell Alarm Threshold:" );
                
		confirmPanel.add( conMinCellLabel );
                conMinCellLabel.setBounds( 50, 185, 150, 30 );

		minCellStatus = new JLabel();
		
		confirmPanel.add( minCellStatus );
                minCellStatus.setBounds( 225, 185, 150, 30 );
                
                JLabel conTestLabel = new JLabel ("Target Time:");
                
                confirmPanel.add(conTestLabel);
                conTestLabel.setBounds( 50, 225, 150, 30 );
                
                hourStatus = new JLabel();
                JLabel conHourLabel = new JLabel("hrs");
                minStatus = new JLabel();
                JLabel conMinLabel = new JLabel("min");
                
                confirmPanel.add(conMinLabel);
                confirmPanel.add(minStatus);
                confirmPanel.add(conHourLabel);
                confirmPanel.add(hourStatus);
                
                conMinLabel.setBounds( 330, 225, 30, 30 );
                minStatus.setBounds( 295, 225, 30, 30 );
                conHourLabel.setBounds( 260, 225, 30, 30 );
                hourStatus.setBounds( 225, 225, 30, 30 );
                
                
                JLabel conPrintLabel = new JLabel ("Print Rate:");
                
                confirmPanel.add(conPrintLabel);
                conPrintLabel.setBounds( 50, 265, 150, 30 );
                
                prMinStatus= new JLabel();
                JLabel conPrMinLabel = new JLabel("min");
                prSecStatus = new JLabel();
                JLabel conPrSecLabel = new JLabel("sec");
                
                confirmPanel.add(prMinStatus);
                confirmPanel.add(conPrMinLabel);
                confirmPanel.add(prSecStatus);
                confirmPanel.add(conPrSecLabel);
                
                conPrSecLabel.setBounds( 330, 265, 30, 30 );
                prSecStatus.setBounds( 295, 265, 30, 30 );
                conPrMinLabel.setBounds( 260, 265, 30, 30 );
                prMinStatus.setBounds( 225, 265, 30, 30 );
                
                JLabel conLoThreshLabel= new JLabel ("Low Threshold:");
                confirmPanel.add(conLoThreshLabel);
                conLoThreshLabel.setBounds( 50, 305, 150, 30 );
                
                conLoThreshStatus = new JLabel ();
                
                confirmPanel.add(conLoThreshStatus);    
                
                
                conLoThreshStatus.setBounds( 225, 305, 50, 30 );
                
                JLabel conHiThreshLabel = new JLabel ("High Threshold:");
                
                confirmPanel.add(conHiThreshLabel);
                conHiThreshLabel.setBounds( 50, 345, 150, 30 );
                
                conHiThreshStatus = new JLabel();
                
                confirmPanel.add(conHiThreshStatus);
                
                conHiThreshStatus.setBounds( 225, 345, 50, 30 );
                
                JLabel conLogLabel = new JLabel("Activity Log");
                TextArea conActivityLog = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
                conActivityLog.setBackground(Color.WHITE);
                conActivityLog.setEditable(false);
                
                confirmPanel.add(conLogLabel);
                confirmPanel.add(conActivityLog);
                
                conLogLabel.setBounds(450, 10, 100, 30);
                conActivityLog.setBounds(450, 50, 300, 125);
                
                JLabel genInfoLabel = new JLabel("General Test Info:");
                genInfoArea = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);

                confirmPanel.add(genInfoLabel);
                confirmPanel.add(genInfoArea);
                
                genInfoLabel.setBounds( 450, 190, 100, 30 );
                genInfoArea.setBounds( 450, 225, 300, 125 );
                
                conRefreshButton = new CustomButton("Refresh","Refresh the Activity Log");
                
                confirmPanel.add(conRefreshButton);
                
                conRefreshButton.setBounds(600, 10, 85, 30);
                
                conNextButton = new CustomButton("Next","Move to the previous tab");
                conBackButton = new CustomButton("Back","Move to the previous tab");
                
                confirmPanel.add(conBackButton);
                confirmPanel.add(conNextButton);
		
                conNextButton.setBounds(700, 375, 75, 40);
                conBackButton.setBounds(600, 375, 75, 40);
                
	} // end createConfirmPage
        
   /**
    * numCell sets the String value for the number of cells from the radio group
    * @return The number of cells
    */
   public String numCell()
   {
        
                String numberOfCells = "";
            
                if (num12RadioButton.isSelected()){
                numberOfCells="12";
                }
            
                else if (num24RadioButton.isSelected() ){
                    numberOfCells="24";
                }

                else if (num60RadioButton.isSelected() ){
                    numberOfCells="60";
                }

                else if (num240RadioButton.isSelected() ){
                    numberOfCells="240";
                }

                else{
                    numberOfCells=cellField.getText();
                }
                return numberOfCells;
                
   } // end numCell 
   
       
    
    /**
     * Sets the String value of the cell reference from the radio group
     * @return
     */
   public String cellRef()
   {
        
                String cellReference = "";
                
                if (refYesRadioButton.isSelected()){
                    
                    cellReference = "Positive";
                }
                
                else{
                    
                    cellReference = "Negative";
                }
                
                return cellReference;
        
    }
        
    /**
     * Sets the String value of the Overall Box from the radio group
     * @return
     */
    public String overallBox()
      {
        
                String overAll = "";
                
                if (overallYesRadioButton.isSelected()){
                    
                    overAll = "Yes";
                }
                
                else{
                    
                    overAll = "No";
                }
                
                return overAll;
        
    } // end overallBox
        
      /**
       * isInt checks that the supplied text value is an integer
       * @param intComp integer to be checked
       * @return true if it's an int, false otherwise
       */
    public boolean isInt(String intComp)
    {
          
          boolean valid; 
          try {
              Integer.parseInt(intComp);
              valid = true;
          }
          
          catch (NumberFormatException e){
              valid = false;
          }
          
          return valid;
          
    } // end isInt
        
    /**
     * isDouble checks that the supplied text value is an Double
     * @param dblComp double to be checked
     * @return true if it's an double, false otherwise
     */
    public boolean isDouble(String dblComp)
    {
          
          boolean valid; 
          try {
              Double.parseDouble(dblComp);
              valid = true;
          }
          
          catch (NumberFormatException e){
              valid = false;
          }
          
          return valid;
          
    } // end is Double
        
    /**
     * 
     * @param spiOutputArray
     */
    public void printVoltage(float[] spiOutputArray)
    {
            
            int cell = 1;
        
            for (int i= 0; 1 < spiOutputArray.length; i++){
                
               voltArea.append("Cell : " + cell + spiOutputArray[i] + "  ");
               cell++;
                
            }
        
    } // end printVoltage
    
    /**
     * reset all gui components for another test
     */
    public void resetGUI()
    {
    	
    }
    
    public void addActionListeners()
    {
    	homeNextButton.addActionListener(this);
    	checkRefreshButton.addActionListener(this);
        checkBackButton.addActionListener(this);
        checkNextButton.addActionListener(this);
        conBackButton.addActionListener(this);
        conRefreshButton.addActionListener(this);
        homeNextButton.addActionListener(this);
        sysBackButton.addActionListener(this);
        sysNextButton.addActionListener(this);
        updateThresholdButton.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource() == sysNextButton)
		{
            if (abortVoltageField.getText().isEmpty() || 
                    cellAlarmField.getText().isEmpty()  ||
                    targetTimeHourField.getText().isEmpty() ||
                    targetTimeMinField.getText().isEmpty() ||
                    printMinuteField.getText().isEmpty() ||
                    printSecondField.getText().isEmpty() ||
                    lowThresholdField.getText().isEmpty() ||
                    hiThresholdField.getText().isEmpty() ||
                    (otherNumRadioButton.isSelected() && cellField.getText().isEmpty()))
            {
                    
                JOptionPane.showMessageDialog( tabbedPane,
                        "Please fill in all parameters");
                }
                
                
                else if ((otherNumRadioButton.isSelected() && (isInt(cellField.getText()) == false)) || 
                          ((cellField.getText().startsWith("-"))) ||
                        ((otherNumRadioButton.isSelected()) && (Integer.parseInt(cellField.getText())) < 1))
                {
                  
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid cell number");
                }
                
                else if ((isInt(abortVoltageField.getText()) == false) && 
                         (isDouble(abortVoltageField.getText())  == false)
                        || (abortVoltageField.getText().startsWith("-")))
                {
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Abort Voltage Value");
                }
                
                else if ((isInt(cellAlarmField.getText()) == false) && 
                         (isDouble(cellAlarmField.getText())  == false)
                        || (cellAlarmField.getText().startsWith("-")))
                {
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Cell Alarm Value");
                }
                
                else if ((isInt(targetTimeHourField.getText()) == false) || 
                         (isInt(targetTimeMinField.getText())  == false)  ||
                         (targetTimeHourField.getText().startsWith("-"))  ||
                         (targetTimeMinField.getText().startsWith("-"))  ||
                         (Integer.parseInt(targetTimeMinField.getText()) > 59 ))
                {
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Target Time Value");
                }
                
                else if ((isInt(printMinuteField.getText()) == false) || 
                         (isInt(printSecondField.getText())  == false) ||
                         (printMinuteField.getText().startsWith("-"))  ||
                         (printSecondField.getText().startsWith("-"))  ||
                         (Integer.parseInt(printSecondField.getText()) > 59 ))
                {
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Print Rate Value");
                }
               
                else if (((isInt(lowThresholdField.getText()) == false) && 
                         (isDouble(lowThresholdField.getText())  == false)) ||
                          ((isInt(hiThresholdField.getText()) == false) && 
                         (isDouble(hiThresholdField.getText())  == false))  ||
                         (lowThresholdField.getText().startsWith("-"))  ||
                         (hiThresholdField.getText().startsWith("-")))
                {
                    
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please enter a valid Threshold Value");
                }
                
                else if (Double.parseDouble(lowThresholdField.getText()) >= 
                        Double.parseDouble(hiThresholdField.getText()))
                {
                
                    JOptionPane.showMessageDialog( tabbedPane,
                        "Please make sure Low Threshold is less the High Threshold");
                    
                }
                
                else
                {
                
                	tabbedPane.setSelectedIndex(2);
                	tabbedPane.setEnabledAt(2, true);
                	loThreshField.setText(lowThresholdField.getText());
                	hiThreshField.setText(hiThresholdField.getText());
                	numCellField.setText(numCell());
                	cells = Integer.parseInt(numCell());
                
                	//float [] spiArray = SPIreadVoltages.getSpiData(cells);
                	//printVoltage(spiArray);
                
                }
		} // end sysNextButton
		
		
		if(e.getSource() == sysBackButton || e.getSource() == conBackButton || e.getSource() == checkBackButton)
		{
			
            tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()-1);
            
		} // end backButton
		
		if(e.getSource() == checkNextButton)
		{
            if (loThreshField.getText().isEmpty() ||
                    hiThreshField.getText().isEmpty() )
            {
                    
                	JOptionPane.showMessageDialog( tabbedPane,
                			"Please fill in all parameters");

            }
                
            else
            {
                
                	tabbedPane.setSelectedIndex(3);
                	tabbedPane.setEnabledAt(3, true);
                	minTotalStatus.setText(abortVoltageField.getText());
                	minCellStatus.setText(cellAlarmField.getText());
                	hourStatus.setText(targetTimeHourField.getText());
                	minStatus.setText(targetTimeMinField.getText());
                	prMinStatus.setText(printMinuteField.getText());
                	prSecStatus.setText(printSecondField.getText());
                	conLoThreshStatus.setText(lowThresholdField.getText());
                	conHiThreshStatus.setText(hiThresholdField.getText());
                	genInfoArea.setText(generalInfoText.getText());
                	conNumCell.setText(numCell());
                	refStatus.setText(cellRef());
                	overallStatus.setText(overallBox());
            }
		
		} // end checkNextButton
		
		if (e.getSource() == updateThresholdButton)
		{
			 if (((isInt(loThreshField.getText()) == false) && 
                     (isDouble(loThreshField.getText())  == false)) ||
                      ((isInt(hiThreshField.getText()) == false) && 
                     (isDouble(hiThreshField.getText())  == false))  ||
                     (loThreshField.getText().startsWith("-"))  ||
                     (hiThreshField.getText().startsWith("-")))
			 {
                
                JOptionPane.showMessageDialog( tabbedPane,
                    "Please enter a valid Threshold Value");
            }
            
            else if (Double.parseDouble(loThreshField.getText()) >= 
                    Double.parseDouble(hiThreshField.getText()))
            {
            
                JOptionPane.showMessageDialog( tabbedPane,
                    "Please make sure Low Threshold is less the High Threshold");
                
            }
            else 
            {
            	lowThresholdField.setText(loThreshField.getText());
            	hiThresholdField.setText(hiThreshField.getText());
            	JOptionPane.showMessageDialog( tabbedPane,
            			"Threshold Values are updated");
            }
			 
		} // end updateThresholdButton
		
		
//======================Number Of Cells==================================================================================
		if(e.getSource() == num12RadioButton)
		{
			numberOfCells = 12;
		}
		
		if(e.getSource() == num24RadioButton)
		{
			numberOfCells = 24;
		}
		
		if(e.getSource() == num60RadioButton)
		{
			numberOfCells = 60;
		}
		
		if(e.getSource() == num240RadioButton)
		{
			numberOfCells = 12;
		}
		
		if(e.getSource() == otherNumRadioButton)
		{
			numberOfCells = Integer.parseInt(cellField.getText());
		}
	}

}
