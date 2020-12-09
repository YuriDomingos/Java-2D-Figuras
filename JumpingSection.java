/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingsection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Yuri Domingos 
 * Objectivo : Construir o kiston 
 */
public class JumpingSection extends JPanel implements KeyListener,ActionListener {
    

    
    private boolean jumping = false;
    private boolean falling = false;
    private double  gravity = 0.0;
    private int velX = 0, velY = 0;
    private int posX = 0; 
    private int posY = 0;
    private Timer timer;
    private int DELAY = 20;
    
    public JumpingSection() {
        
        
        
     
        
        
        addKeyListener(this);
        setFocusable(true);
        
        
        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D) g.create();
        
        
        
        graphics2D.setPaint(Color.BLUE);
        graphics2D.fill(new Rectangle2D.Double(getPosX()+100, getPosY()+100, 50,50));
        
    }

    
    
    public void actionPerformed(ActionEvent ev)
    {
        
        setPosY(getPosY()+getVelY());
        setPosX(getPosX()+getVelX());
        
        moviment();
        conditional();
       //
        
        repaint();
    }
    public int getVelX() {
        return velX;
    }
    
    
    public void conditional()
    {
        if ( getPosY() > this.getHeight()/2)
        {
             setVelX(0);
             condicional_falling();
             setPosY(this.getHeight()/2);
            
        }    
            
    }
    
    
    public void condicional_falling()
    {
        if ( falling)
            
            falling = false;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    

    @Override
    public void keyTyped(KeyEvent ke) {
      
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        
        int choose = ke.getKeyCode();
        
        
        switch(choose)
        {
            
            case KeyEvent.VK_V :
                
                if (!jumping)
                {
                     jumping = true;
                     gravity = 5.0;
                }
               
                
             break;
             
            case KeyEvent.VK_LEFT :
                
                setVelX(-5);
                
            break;
            
            case KeyEvent.VK_RIGHT :
                
                setVelX(5);
                
            break;
            
            case KeyEvent.VK_UP :
                
                setVelY(-5);
                break;
            
            default :
                
                JOptionPane.showMessageDialog(null, "Error Invalid çOption ");
             
        }
        
     
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
        velX = 0;
        velY = 0;
    
    }
    
    
    public void moviment()
    {
        
        if ( jumping)
        {
            gravity -= 0.1;
            
            setVelY((int)-gravity);
            
            if ( gravity <= 0.0)
            {
                jumping = false;
                falling = true;
                
            }
            
            
        }
        
        if ( falling)
        {
            gravity +=0.1;
            setVelY((int)gravity);
        }
    }

    
    
}
