public static void main(String args[])
{

   MainClass main = new MainClass();
   
   // add actionlistener to main.startbutton object
   main.startButton.addActionListener(this);
   

   public void actionPerformed(ActionEvent e) { 
      if (e.getSource() == main.startButton)
         {
            // dispose setup gui
           // main.dispose();
           
            
            //instantiate and create run gui
            nextGUI runGUI = new nextGUI(tempData);
            
            //start loop
            Loop start = new Loop(runGUI);
            
            public void actionPerformed(ActionEvent e) { 
              if (e.getSource() == runGUI.pauseButton)
            {
               // pause loop
               start.pause();
               
               int confirm = JOptionPane.showConfirmDialog(null, "Abort?", "Paused", JOptionPane.YES_NO_OPTION); 
               
               if (confirm == JOptionPane.YES_OPTION)
               {
                  //create summary gui                  

               }
               
               else {
                  // resume loop
                  start.resume();
               }
               
           
            
         }
   }
  

}