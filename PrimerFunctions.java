/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballrelativity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Yuri Domingos
 * Dt  : 03 - 11 -2020
 */
public class PrimerFunctions extends JPanel implements Runnable {
    
    private int cx = 250;
    private int cy = 7;
   
    
    private Image img;
    private int velY = 2;
    private boolean flag = false;
    

    //-- aditional object 
    
    private double vx = 5.0;
    private double gravity = 5.0;
    private double vy = 7;
    private double bounce = 0.7;
    private double xFricction = 0.1;
    
    
    
    public PrimerFunctions() 
    {
  
                

         img = new ImageIcon(this.getClass().getResource("BLL.jpg")).getImage();
        new  Thread(this).start();
       
    }
    
  
    
    public void paintComponent(Graphics g)
    {
        Graphics2D graphics2D = (Graphics2D) g;
        
          graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          graphics2D.setBackground(Color.WHITE);

          graphics2D.clearRect(0, 0, this.getWidth(),this.getHeight());
          graphics2D.setColor(Color.red);
          //graphics2D.fill(new Ellipse2D.Double(cx,cy, 60+dr,60+dr ));
          
     
        
       graphics2D.drawImage(img,cx,cy,100, 100, this);
    }
    
   
    
    
    
    public void counted()
    {
        int altura = 387;
      
        cx +=vx ;
      cy +=vy;
        cy +=gravity;
        
        //--- condicao de retorno da nossa bola
        
        if (cy <  -25|| cy  >  altura )
        {
            
             cx *=(-1);
             
          
             
        }
       
        if ( cy + 100 > this.getWidth() )
        {
            cy = altura - 50;
            cy  *= -bounce;
            
            
          
            if ( cy < 0 && cy > -2.1 )
               cy = 0;
            
            
           if ( Math.abs(cx) < 1.1 )
               
               cx = 0;
        }
        
        
        xF();                 
    }
    
    
      
  public void xF()
  {
  
     if ( vx > 0)
     
         vx = vx-xFricction;
            
            if ( vx < 0 ) 
            
            vx = vx + xFricction;
  }

    @Override
    public void run() {
        
        while(true)
        {
             //cy +=  velY; 
            System.out.println(cy);

            try {
               
                
                  Thread.sleep(114);
              
                  counted();
              
                  repaint();
                  
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
     
    }
    
}
