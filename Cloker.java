/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejlabel;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author   : Yuri Domingos 
 * Objectivo : Testar o código
 */
public class Cloker extends JPanel{
    
    
    private JLabel label;
    
    

    public Cloker() {
        
        label = new JLabel("0");
        
        label.setFont(new Font("Serief",Font.BOLD,16));
        add(label);
        clock();
        
    }
    
    
    
    
    public void clock()
    {
        
        Thread thread = new Thread(){
          
            public void run()
            {
                while(true)
                {
                    Calendar cal = new GregorianCalendar();
                    
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    
                    int hour = cal.get(Calendar.HOUR);
                    int minutes = cal.get(Calendar.MINUTE);
                    int seconds = cal.get(Calendar.SECOND);
                    
                    
                  label.setText( hour+" : minutes :"+minutes+"seconds :"+seconds +"Dia "+day);
                 repaint();
                }
            }
            
        };
        
        
        thread.start();
        
    }
    
    
    
    
    
public void game_time_data(Calendar cal, int day, int month, int year, JLabel label)
{
    day   = cal.get(Calendar.DAY_OF_MONTH);
    month = cal.get(Calendar.MONTH);
    year  = cal.get(Calendar.YEAR);
    
    label.setText("Dia : "+day + "  Mes  : "+month +"  Ano : " + year);

}



public void game_time_hour(Calendar cal, int hour, int minutes, int seconds, JLabel label )
{
    
    hour     = cal.get(Calendar.HOUR);
    minutes  = cal.get(Calendar.MINUTE);
    seconds  = cal.get(Calendar.SECOND);
    
    label.setText("Hour : "+ hour + "  Minutes  : "+ minutes +"  Seconds : " +seconds);
    
    
}



}


