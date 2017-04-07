package assignment3;

import java.awt.EventQueue;


public class EdmundSuA3 {

    public static void main(String[] args) {
        //Database database = new Database();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    GuiBuilder frame = new GuiBuilder();
                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
            }
        });
        
    }
}
