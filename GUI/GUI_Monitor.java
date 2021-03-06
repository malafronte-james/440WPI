package GUI;

/**
 *
 * @author chorne, jmalafronte
 * Creates monitor Jframe
 */

import java.awt.*; 
import javax.swing.*;


public class GUI_Monitor extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JLabel AV_Cell;
    public JButton Abort;
    public JLabel Activity_Log;
    public JLabel Battery_Amperage;
    public JLabel Battery_Voltage;
    public JTextArea C_V;
    public JLabel Cell_Voltage;
    public JLabel Duration;
    public JLabel High_Cell;
    public JLabel Low_Cell;
    public JButton Pause_Button;
    public JLabel Power_kW;
    public JLabel Test_Completed;
    public JLabel aVPCell;
    public JLabel bAmp;
    public JLabel bVol;
    public JLabel duration;
    public JLabel hCell;
    public JScrollPane jScrollPane1;
    public JScrollPane jScrollPane3;
    public JTextArea jTextArea1;
    public JLabel kWHours;
    public JLabel kW_Hours;
    public JLabel lCell;
    public JLabel pKW;
    public JLabel tCompleted;
    public int pauseCount;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Creates new form Monitor
     */
    public GUI_Monitor() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        C_V = new JTextArea();
        Battery_Voltage = new JLabel();
        Power_kW = new JLabel();
        AV_Cell = new JLabel();
        High_Cell = new JLabel();
        kW_Hours = new JLabel();
        Low_Cell = new JLabel();
        Battery_Amperage = new JLabel();
        Activity_Log = new JLabel();
        Duration = new JLabel();
        Test_Completed = new JLabel();
        Pause_Button = new JButton();
        Cell_Voltage = new JLabel();
        Abort = new JButton();
        bVol = new JLabel();
        pKW = new JLabel();
        kWHours = new JLabel();
        bAmp = new JLabel();
        aVPCell = new JLabel();
        lCell = new JLabel();
        hCell = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTextArea1 = new JTextArea();
        tCompleted = new JLabel();
        duration = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        C_V.setColumns(20);
        C_V.setRows(5);
        jScrollPane1.setViewportView(C_V);

        Battery_Voltage.setText("Battery Voltage:");

        Power_kW.setText("Power (kW):");

        AV_Cell.setText("Average Volts per Cell:");

        High_Cell.setText("High Cell:");

        kW_Hours.setText("kW Hours:");

        Low_Cell.setText("Low Cell:");

        Battery_Amperage.setText("Battery Amperage:");

        Activity_Log.setText("Activity Log:");

        Duration.setText("Duration:");

        Test_Completed.setText("Test Completed:");

        Pause_Button.setText("Pause");
        Pause_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pause_ButtonMouseClicked(evt);
            }
        });

        Cell_Voltage.setText("Cell Voltages:");

        Abort.setText("Abort");
        Abort.setVisible(false);
        Abort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbortActionPerformed(evt);
            }
        });

        bVol.setText("bVol");

        pKW.setText("pKW");

        kWHours.setText("kWHours");

        bAmp.setText("bAmp");

        aVPCell.setText("aVPCell");

        lCell.setText("lCell");

        hCell.setText("hCell");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        tCompleted.setText("Running");

        duration.setText("duration");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.WHITE);
        
        getContentPane().setPreferredSize( new Dimension(800,480) );
        getContentPane().setMaximumSize( new Dimension(800,480) );
        getContentPane().setMinimumSize( new Dimension(800,480) );
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cell_Voltage)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Test_Completed)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tCompleted)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Duration)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duration)
                        .addGap(193, 193, 193))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Power_kW)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pKW))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(kW_Hours)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(kWHours))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Battery_Voltage)
                                                .addGap(18, 18, 18)
                                                .addComponent(bVol)))
                                        .addGap(83, 83, 83)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(AV_Cell)
                                                    .addComponent(Low_Cell))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(aVPCell)
                                                    .addComponent(lCell)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(High_Cell)
                                                .addGap(18, 18, 18)
                                                .addComponent(hCell))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Battery_Amperage)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bAmp))))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(Activity_Log)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Pause_Button)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Abort))
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Duration)
                    .addComponent(Test_Completed)
                    .addComponent(tCompleted)
                    .addComponent(duration))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Battery_Voltage)
                    .addComponent(AV_Cell)
                    .addComponent(bVol)
                    .addComponent(aVPCell))
                .addGap(4, 4, 4)
                .addComponent(Activity_Log)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Low_Cell)
                            .addComponent(Power_kW)
                            .addComponent(pKW)
                            .addComponent(lCell))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(kW_Hours)
                            .addComponent(kWHours)
                            .addComponent(High_Cell)
                            .addComponent(hCell))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Battery_Amperage)
                            .addComponent(bAmp)))
                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(Cell_Voltage)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Pause_Button)
                            .addComponent(Abort))))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void Pause_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pause_ButtonMouseClicked
        // TODO add your handling code here:
        if ((pauseCount % 2) == 0){
        Pause_Button.setText("Resume");    
        getContentPane().setBackground(Color.RED);
        Abort.setVisible(true);
        
        pauseCount ++; 
       
        }
        
        else {
        Pause_Button.setText("Pause ");    
        getContentPane().setBackground(Color.WHITE);
        Abort.setVisible(false);
        
        pauseCount ++;
            
        }
        
        //System.out.println(pauseCount);
    }

    //GEN-LAST:event_Pause_ButtonMouseClicked

    private void AbortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbortActionPerformed
        // TODO add your handling code here:
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = (JOptionPane.showConfirmDialog(null,
        "Do you really want to Abort the Test?", "Abort", dialogButton));
        
        
        
        if (dialogResult == JOptionPane.YES_OPTION){
          
            GUIEndScreen end = new GUIEndScreen();
                
                end.setResizable(false);
		end.setVisible( true );
            
        }
    }//GEN-LAST:event_AbortActionPerformed
    
    /**
     * reset gui components for new test
     */
    public void resetGUI()
    {
    	
    }



}


    


