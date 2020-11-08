/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometric_projects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Yuri Francisco Domingos ( UCAN )
 * Data  : 19-03-2020
 * @Goal : Draw a most popular geometric figures
 */
public class Geometric_Projects extends JPanel {
    
    int r = 55; int cx = 50; int cy = 100; int angle = 30;
    //
    
    
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        
        g.setFont(new Font("SansSerif", Font.BOLD,20));
        g.setColor(Color.black);
        g.drawString("Name : Yuri Francisco Domingos (UCAN)", 20, 55);
        g.drawString("Goal: Draw all geometrics figures", 20, 80);
        g.setColor(Color.RED);
       g.drawLine(-10, 100, 850, 100);  // this is a linear line 
     
        
       // here we will design a circle 
       g.setColor(Color.RED);
       g.fillOval(145, 155, 95, 95);
       
       // draw other things 
       
       // just to draw a  romam triangle
       g.setColor(Color.magenta);  
       
       cy = 212; cx = 80;
       Polygon triangle = new Polygon();
       
       for (int i = 0; i< 15; i++)
           
           triangle.addPoint(
                   
                   (int)(cx+r*Math.cos(3*i*Math.PI/4))
                   
                   , (int)(cy+r*Math.sin(3*i*Math.PI/4)));
       
      g.drawPolygon(triangle);

       //------  chine design
       cx = 310; cy = 200;
       g.setColor(Color.BLACK);
       Polygon chine =  new Polygon();
       
       for ( int i = 0; i < 20; i++)
       {
           double k =  i/90.0;
           chine.addPoint(
                   
   (int)(cx+r*Math.cos(60*k/3*i*Math.PI))
                   
                                      , (int)(cy+r*Math.sin(90*k/3*i*Math.PI)));
            
       g.fillPolygon(chine); 
       }
       
       // Here we will design aspaj
       
       g.setColor(Color.RED);
       
       cx =  460;
       
       
       //-- to design a quadra
       
       g.setColor(Color.BLACK);
       g.fillRect(560, 160, 90, 90); // we put 560 just to give a space in geometric order
       
  
       // here we will design a triangle anda aspiral figures
       cy = 370; cx = 90;
       Polygon aspiral_greg = new Polygon();
       
       for (int i =0; i< 360; i++)
       {
           double k = i/360.0;
           
           aspiral_greg.addPoint(
                   
                   (int)(cx+r*k*Math.cos(8*k*Math.PI))
                   
                   ,(int)(cy+r*k*Math.sin(8*k*Math.PI)));
           
          
       }
        g.fillPolygon(aspiral_greg);
        
        /*
         Even we have oportunity to design well with for we have to put all esforce there 
        then let us join with me I mean Yuri ( Labareda) Fathers day 19-03-2020)
        
        */
        
        g.setColor(Color.red);
        cx = 270; cy = 330;
        Polygon p_game =  new Polygon();
        
        for ( int i = 0; i< 120; i++)
        {
            p_game.addPoint(
                    
                    (int)(cx+r*Math.cos(i+Math.PI/180))
                    
                    ,(int)(cy+r*Math.sin(i*Math.PI/180)) );
            g.fillPolygon(p_game);
        }
        
        // here we will put other things 
        g.setColor(Color.red);
           cx = 440; cy = 380;
        Polygon stop = new Polygon();
        
        for (int i = 0; i< 28; i++)
       
            
            // there are rules that we can not forget when we re doing geometrics figures like casting bellow 
            // will show or say in IDE that will have casting on code.
      
           stop.addPoint(
                    
                    (int)(cx+r*Math.cos(9*i*Math.PI/6))  
                    
                    ,(int)(cy+r*Math.sin(5*i*Math.PI/9)));
        
        
       g.fillPolygon(stop);
       
       
       // triangle
        cx = 610; cy = 400;
       
        g.setColor(Color.BLUE);  r = 70;
       Polygon triangle1 = new Polygon();
       
       for(int i = 0; i<15; i++)
           triangle1.addPoint(
                   
                   (int)(cx+r*Math.cos(3*i*Math.PI/6))
                   ,(int)(cy+r*Math.sin(3*i*Math.PI/6)) );
       
         g.fillPolygon(triangle1);
         
         //----
         
           cx = 610; cy = 360;
       
        g.setColor(Color.BLUE);  r = 70;
       Polygon triangle2 = new Polygon();
       
       for(int i = 0; i<19; i++)
           triangle2.addPoint(
                   
                   (int)(cx+r*Math.cos(3*i*Math.PI/6))
                   ,(int)(cy+r*Math.sin(3*i*Math.PI/6)) );
       
         g.fillPolygon(triangle2);
         
         
         //----------------
         
         cx = 310; cy = 560;
         
         g.setColor(Color.black);
   Polygon pent =  new Polygon();
   
   for (int i = 0; i<8; i++)
       pent.addPoint(
               (int)(cx+r*Math.cos(3*i*Math.PI/4)), 
               
               (int)(cy+r*Math.sin(3*i*Math.PI/4))
               
               );
   
   g.fillPolygon(pent);
   
   
   
   // house suport
   
       cx = 10; cy = 460;
    g.fillRoundRect(40,440,90,210,115,10);
    
    
    
    // here is to put crown
    
     cx = 590; cy = 610;
    g.setColor(Color.red);
    
    Polygon last = new Polygon();
    
    for (int i = 0; i<20; i++)
    {
       double k = i/20.0;   
    
        
        last.addPoint((int)(cx+r*Math.cos(260*k/10*i*Math.PI)), 
                
                (int)(cy+r*Math.sin(300*k/10*i*Math.PI))
                
                );
          g.fillPolygon(last);
    }
    
    
    // a figuret to talk with may friend Engenheiro Eufranio about something
    g.setColor(Color.RED);
    g.drawOval(530, 330, 145, 125);
    g.setColor(Color.black);
    g.setFont(new Font("SansSerif",Font.BOLD,15));
    g.drawString("Engenheiro Eufranio a figura \n"+"que esta no circulo falamos ontem na fau! ", 210, 290);
    g.drawString("Quando estavas com a Maria! Sao os dois triangulos invertidos. CHAUK", 208, 315);
}
}
class Geometric_ProjectsFrame extends JFrame {
    
    public  Geometric_ProjectsFrame()
    {
        setTitle("Paint draw design");
        setSize(800,700);
        setVisible(true);
        
        addWindowListener(new WindowAdapter()
        {
            public void WindowClosing(WindowEvent ev)
            {
               System.exit(0);
            }
        });
        
        Container contentPane = getContentPane();
        contentPane.add(new Geometric_Projects());
    }
    
}
