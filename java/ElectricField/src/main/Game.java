package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Game extends JFrame
{


    public Game()
    {
        this.setSize(800 , 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Paint());
        this.pack();
        this.setVisible(true);

    }










    public static void main(String[] args)
    {
        new Game();
        int[][] t = new int[1][1];
        t = new int[1][1];
        System.out.println("hello");


    }
}

class Paint extends JPanel implements ActionListener
{
    Timer time;
    double lineGradient = (600 - 0)/(800 - 0);

    public ArrayList<Line2D.Double> gridLines = new ArrayList<Line2D.Double>();
    public Rectangle2D middleCharge = new Rectangle2D.Double(400 -25, 300 -25, 50 , 50 );
//    public Rectangle2D testCharge = new Rectangle2D.Double(0 - 10,  0-10 , 20 , 20 );
    double startX = -10;
    double startY = -10;
    double impAngle = Math.atan(400/300);
    double speed = 0.25;

    public Paint()
    {

        this.setPreferredSize(new Dimension(800 , 600));
        this.gridLines.add(new Line2D.Double(0 , 0 , 800 , 600));
        this.gridLines.add(new Line2D.Double(800 , 0 , 0 , 600));
        this.gridLines.add(new Line2D.Double(400 , 0 , 400 , 600));
        this.gridLines.add(new Line2D.Double(0 , 300 , 800 , 300));


    }

    public void paint(Graphics g)
    {
        RenderingHints hints =new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
//        hints.put(RenderingHints.KEY_ANTIALIASING,
//        RenderingHints.VALUE_ANTIALIAS_OFF);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(hints);


//        g2d.drawLine(0 , 0 , 800 , 600);
//        g2d.drawLine(800 , 0 , 0 , 600);
//        g2d.drawLine(400 , 0 , 400 , 600);
//        g2d.drawLine(0 , 300 , 800 , 300);


        for(Line2D.Double line : this.gridLines)
        {
            g2d.draw(line);
        }

        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.red);
        g2d.fillOval(400 -25, 300 -25, 50 , 50 );
        g2d.setColor(Color.blue);

        g2d.draw(new Rectangle2D.Double(this.startX ,  this.startY , 20 , 20 ));
//        if(this.gridLines.get(0).intersects(middleCharge))
//        {
//            System.out.println("intersecting");
//        }

        time = new Timer(500 , this);
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("value of impAngle "+this.impAngle);
//        this.startX += this.speed * (Math.sin(this.impAngle));
//        this.startY += this.speed * (Math.cos(this.impAngle));
        System.out.println("value of startX "+startX);
        System.out.println("value of startY "+startY);
        repaint();

    }
}