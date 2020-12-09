/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author yuri
 */
public class CenaryGame extends JPanel implements ActionListener, KeyListener  {

    
    
    private int space;
    private int speed;
    private int WIDTH = 500;
    private int HEIGHT = 700;
    private Rectangle car;
    private ArrayList <Rectangle> otherCars;
    private ArrayList <Rectangle> line;
    private Random random;
    private int width = 80;
    private int height = 70;
    private int move = 20;
    private  Timer t;
    private int count = 1;
    BufferedImage bg;
    BufferedImage road;
    BufferedImage CarStructers;
    BufferedImage user1;
    BufferedImage user2;

    private boolean linearF = true;
    
    
    
    
    
    //-Fazer o método construtor

    public CenaryGame() 
    {
        
        try {
            
            user1 = ImageIO.read(  new  File("/home/yuri/NetBeansProjects/CarGame/src/cargame/Untitled-3.jpg"));
            bg    = ImageIO.read(  new  File("/home/yuri/NetBeansProjects/CarGame/src/cargame/526efa7f16ab4_thumbCard.jpg"));
            road  = ImageIO.read(new File("/home/yuri/NetBeansProjects/CarGame/src/cargame/oth.jpg"));
            CarStructers = ImageIO.read(new File("/home/yuri/NetBeansProjects/CarGame/src/cargame/lo.jpg"));
        } catch (IOException ex) {
            
        }
        t = new Timer(20,this);
        random = new Random();
        otherCars = new ArrayList<Rectangle>();
        line = new ArrayList<Rectangle>();
        car = new Rectangle(WIDTH/2-90,HEIGHT-100,width,height);
        space = 300;
        speed = 2;
        
        addCars(true);
        addCars(true);
        addCars(true);
        
        
        addKeyListener(this);
        setFocusable(true);
        

        addLines(line,WIDTH,true);
        addLines(line,WIDTH,true);
        addLines(line,WIDTH,true);
        addLines(line,WIDTH,true);
        t.start();
    }
    
    
    
    public void addLines(ArrayList<Rectangle> objecto,int WIDTH,boolean lenear)
    {
        int x = WIDTH/2-2;
        int y = 0;
        int sp = 130; // espcao de uma linha com a outra
        int width = 4;
        int heigth = 300;
       int space = 20;
        
        if (lenear)
        {
            
            objecto.add(new Rectangle(x,y-(objecto.size()*space),width,height));
            
        }
        else 
        {
          objecto.add(new Rectangle(x,objecto.get(objecto.size()-1).y-sp,width,height));
            
        }
    }
    
    
  
    public void addCars(boolean first)
    {
        
        int positionX = random.nextInt()%2;
        int x = 0;
        int y = 0;
        int Width = width;
        int Height = height;
        
        if ( positionX == 0)
        {
            x = (WIDTH/2-90);
            
        }else {
            x = (WIDTH/2+10);
            
        }
        
        
        
        if (first)
        {
            otherCars.add(new Rectangle(x,y-100-(otherCars.size()*space), Width,Height));
        }else
        {
          //  otherCars.add(new Rectangle(x,otherCars.get(otherCars.size()-1).y-300,width,height));
        }
    }
    
    
   //  
        public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D) g;
        
      // g.drawImage(bg, 0,0, 750,750, null);
        
         g.drawImage(road, WIDTH/2-100, 0,210,800, null);
         
         g.setColor(Color.white);
         
        
          draw_atomatic_lines(graphics2D,line);
      /* g.setColor(Color.RED);*/
        
       
      
        
        //g.fillRect(car.x, car.y, car.width, car.height);
         g.drawImage(CarStructers, car.x,car.y, car.width, car.height,null);
      /* graphics2D.setStroke(new BasicStroke(10));
        g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);*/
        /*g.setColor(Color.magenta);  */
        
       
        draw_object_cars(graphics2D,random,user1,otherCars);
        
        
        
        
    }
    
    
    
    
    @Override
    
    public void actionPerformed(ActionEvent ae) {
        
        Rectangle rect = null;
        count++;
        
           
       bring_up_automatic_Object(rect,0,count, move,  speed,  otherCars);
        
        // -- Other way to build work 
        
       colision_of_double_car(otherCars,car);
        
       bring_up_again_object(otherCars, rect,0);
      
       
       
       //- to bring a line       
           bring_up_automatic_Object(rect,0,count, move,  speed,  line);
        
        
          for (int i = 0; i < line.size(); i++)
          {
            
            rect = line.get(i);
            
            if (rect.y + rect.height > HEIGHT)
            {
                line.remove(rect);
                //linearF = false;
                addLines(line,WIDTH,false);
            }
         }
        
        repaint();
        
      
    }
    
    public void movedown()
    {
        if ( car.y + move + car.height > HEIGHT-1)
        {
            System.out.println("\b");
            
        }else{
            car.y+=move;
        }
            
            
    }

    
      public void moveup()
     {
        if ( car.y < move)
        {
            System.out.println("\b");
            
        }else{
            car.y-=move;
        }
            
            
     }
      
    public void moveLeft()
    {
        if ( car.x - move < WIDTH/2-90)
        {
             System.out.println("\b");
        }else{
            car.x-=move+4;
        }
            
            
    }
    
 
    
        
    public void moveRight()
    {
        if ( car.x + move > WIDTH/2+10)
        {
            
        }else{
            car.x+=move+4;
        }
            
            
    }
    
    
    
    public void bring_up_automatic_Object(Rectangle rect, int i, int counter, int move, int speed, ArrayList<Rectangle> objecto)
    {
        
        
            if ( i < objecto.size() )
            {
                 rect = objecto.get(i);
            
                 if (count%1000 == 0)
                 {
                     speed++;
                
                     if (move < 50)
                     {
                        move +=10;
                     }
                  }
                 
                   rect.y += speed; 
                   bring_up_automatic_Object(rect,i+1,counter,move,speed,objecto);
             }
           
        }
    
    
    
    public void bring_up_again_object(ArrayList<Rectangle> objecto, Rectangle rect,int i)
    {
         if( i < objecto.size())
         {
            
            rect = objecto.get(i);
            
            if (rect.y + rect.height > HEIGHT)
            {
                objecto.remove(rect);
                addCars(false);
            }
               
            bring_up_again_object( objecto,rect,i+1);
            
          }
    }
    
    public void colision_of_double_car(ArrayList<Rectangle> objecto1, Rectangle objecto2 )
    {
          
        for( Rectangle r : objecto1)
        {
            if (r.intersects(objecto2))
            {
                   JOptionPane.showMessageDialog(null,"Game over");
                     System.exit(0);
                       objecto2.y = r.y+height;
            }
                
            
         
        }
        
        
    }
    
    
    public void draw_object_cars(Graphics2D graphics2D, Random random,Image image,ArrayList<Rectangle> objecto)
    {
         for ( Rectangle rect : objecto)
         {
            
            if (random.nextInt()%2 == 0)
            {         
                graphics2D.drawImage(image, rect.x, rect.y, null);
                
            }else
            {
                
            }
         
            graphics2D.fill(new Rectangle2D.Double(rect.x,rect.y,rect.width,rect.height));
        }
    }
    
    
    
    public void draw_atomatic_lines(Graphics2D graphics2D, ArrayList<Rectangle> objecto)
    {
        
          for ( Rectangle rect : objecto)
          {
           graphics2D.fill( new Rectangle2D.Double (rect.x, rect.y, rect.width, rect.height));
          }
    }
    
    
    
        
        
        
    
    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
     
    }

    
    @Override
    public void keyReleased(KeyEvent ke) {
        
        int key = ke.getKeyCode();
        
        switch(key)
        {
            
            case KeyEvent.VK_UP :
                
                moveup();
                
              break ;
              
            case KeyEvent.VK_DOWN :
                
                movedown();
                break;
                
            case KeyEvent.VK_LEFT :
                
                moveLeft();
                
                break;
                
            case KeyEvent.VK_RIGHT :
                
                moveRight();
                
                break;
                
            default :
                
                break;
                
                
        }
    }
    
    
    
    

    
}
