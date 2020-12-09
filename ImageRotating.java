/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagerotating;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author yuri
 */
public class ImageRotating extends JPanel implements Runnable {
    
    private Image image;
    private Thread thread;
    int i = 0, cx = 120;

    public ImageRotating() {
        
        thread = new Thread(this);
        thread.start();
    }
    
    
    
   
    public void paintComponent(Graphics g)
    {
        
        image = Toolkit.getDefaultToolkit().getImage( "/home/yuri/NetBeansProjects/ImageRotating/src/imagerotating/game.jpg");
  
        
        
        AffineTransform at = AffineTransform.getTranslateInstance(150, 200);
        
        at.rotate(Math.toRadians(i),image.getWidth(this)/2, image.getHeight(this)/2);
    
        
        Graphics2D graphics2D = (Graphics2D) g;
        
        graphics2D.drawImage(image, at, this);
     
        
       
        
       
       
    }
    /*
    BufferedImage loadImage(String name)
    {
        
        BufferedImage image = null;
        
        try {
            
            
            image = ImageIO.read(new File(name));
            
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        
        return image;
    }*/

    @Override
    public void run() {
        
        while(true)
        {
            i++; cx+=1;
            repaint();
            
            try {
                Thread.sleep(90);
                
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
                
            
        }

    }

  
}
