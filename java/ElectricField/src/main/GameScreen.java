










































//package main;
//
//
//
//import java.awt.*;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import javax.swing.JPanel;
//
//public class GameScreen extends JPanel {
//
//    private Random random;
//    private BufferedImage img;
//
//
//    //    private boolean up,down,right,left;
//    int xScroll,yScroll,x1Scroll , y1Scroll = 0;
//
//    int barWidht = 300;
//    int barHeight = 20;
//    int chargePar = 1;
//    int chargeMass = 1;
//    int potentialDifference = 1;
//    int potentialDiffCon = 200;
//    int halfDistanceBetweenPlates = 100;
//    int electricFieldStrength = ((potentialDifference * potentialDiffCon) / halfDistanceBetweenPlates * 2) * chargePar;
//
//    int fieldGap = (20/potentialDifference);
//
//    public ArrayList<Rectangle2D.Double> fieldLinePosition = new ArrayList<Rectangle2D.Double>();
//
//    public Rectangle2D.Double charge = new Rectangle2D.Double((this.particleDisplacementCov) , 300-50 , 10 , 10 );
//
//    double particleSpeed = 240;
//
//    double particleDisplacementCov = 0;
//    double getParticleDisplacementCovY = 300-50;
//    double velY = 0;
//    int fieldLineWidth = 1;
//
//    int particleCharge = 1;
//
//    public double lastUpdate;
//
////    int countFieldLines = ((this.barWidht)/this.fieldGap)+1;
//    int coundFieldLines = 0;
//
//
//
//    private ArrayList<BufferedImage> sprites = new ArrayList<>();
//
//    public GameScreen(BufferedImage img) {
//        this.img = img;
//
//        loadSprites();
//
//        random = new Random();
//
//    }
//
//    private void loadSprites() {
//
//
////        for (int y = 0; y < 10; y++) {
////            for (int x = 0; x < 10; x++) {
////                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
////            }
////        }
//
////        for(int i = 0; i < (40*40); i++)
////        {
////
////            if(i >= 20 * 20 )
////            {
////                sprites.add(img.getSubimage(7 * 32 , 32 , 32 , 32));
////                continue;
////            }
////            sprites.add(img.getSubimage(8 * 32 , 32 , 32 , 32));
////        }
//
//    }
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        Graphics2D g2d = (Graphics2D)g;
//        g.setColor(Color.black);
//        g.fillRect(400 - (this.barWidht/2) , 300 - (this.barHeight/2)-this.halfDistanceBetweenPlates , this.barWidht+1 , this.barHeight);
//        g.fillRect(400 - (this.barWidht/2) , 300 - (this.barHeight/2)+this.halfDistanceBetweenPlates, this.barWidht+1 , this.barHeight);
//
//        g.setColor(Color.GRAY);
//        for(int i = 0 ; i < ((this.barWidht)/this.fieldGap)+1 ;i++)
//        {
//            g.fillRect(400 - (this.barWidht/2) + ((i)*this.fieldGap) , 300 - (this.barHeight/2)-100 + 20 , this.fieldLineWidth , 200-20);
//            if(this.fieldLinePosition.isEmpty() || this.fieldLinePosition.size() <= ((this.barWidht)/this.fieldGap)+1)
//            {
////                this.fieldLinePosition.add(new Rectangle2D.Double(400 - (this.barWidht/2) + ((i)*this.fieldGap) , 300 - (this.barHeight/2)-100 + 20 , 1 , 200-20));
//                this.fieldLinePosition.add(new Rectangle2D.Double(400 - (this.barWidht/2) + ((i)*this.fieldGap) , 300 - (this.barHeight/2)-100 + 20 , this.fieldLineWidth , 200-20));
//            }
//
//        }
////        System.out.println(this.lastUpdate);
//        g.setColor(Color.black);
//
//        if(!this.fieldLinePosition.isEmpty())
//        {
////            System.out.println(this.fieldLinePosition.size());
////            System.out.println(charge.x);
//            for(int i = this.coundFieldLines ; i < this.fieldLinePosition.size();i++)
//            {
//
////                System.out.println(this.fieldLinePosition.get(i).getX());
//                if((int)this.fieldLinePosition.get(i).x == (int)(this.charge.x -1))
//                {
////                    this.coundFieldLines++;
//                    System.out.println("ok intersection");
//
////                    this.getParticleDisplacementCovY +=  (((this.lastUpdate/1000000000) * this.velY) + (0.5 * (1) * (this.lastUpdate/1000000000)*(this.lastUpdate/1000000000)));
//                    this.getParticleDisplacementCovY += 10;
//                    System.out.println(this.getParticleDisplacementCovY);
//                    this.charge.y = this.getParticleDisplacementCovY;
////                    System.out.println(this.fieldLinePosition.get(i).x);
//                    break;
//                }
////                if(this.fieldLinePosition.get(i).intersects(new Rectangle((int)(this.particleDisplacementCov) , 300-50 , 10 , 10)))
////                {
////                    this.coundFieldLines++;
////                    System.out.println("ok intersection");
////                    break;
////                }
//            }
//
//
//
////            System.out.println((int)this.particleDisplacementCov);
////            for(Rectangle2D.Double fieldRect:this.fieldLinePosition)
////            {
////                if(fieldRect.intersects(new Rectangle2D.Double((this.particleDisplacementCov) , 300-50 , 10 , 10)))
////                {
////
////                }
////            }
//        }
//        this.particleDisplacementCov += this.particleSpeed * (this.lastUpdate/1000000000) ;
////        System.out.println(TimeUnit.MILLISECONDS.toSeconds(lastUpdate));
////        System.out.println(this.lastUpdate/10000000);
////        g.fillOval((int)(this.particleDisplacementCov) , 300-50 , 10 , 10 );
////        System.out.println(this.particleDisplacementCov);
////        g2d.draw(new Ellipse2D.Double((this.particleDisplacementCov) , 300-50 , 10 , 10 ));
//        charge.x = this.particleDisplacementCov;
//        g2d.draw(charge);
//
////        for (int y = 0; y < 20; y++) {
////            for (int x = 0; x < 20; x++) {
////                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
////            }
////        }
//
////        for(int y =  (this.yScroll/32); y < (this.y1Scroll /32); y++)
////        {
////            for(int x = (this.xScroll/32) ; x < (this.x1Scroll+640/32);x++)
////            {
////
////                g.drawImage(sprites.get(x + y * 40) , (x * 32) - this.xScroll , (y * 32) - this.yScroll , null );
////            }
////        }
//
//
//
//    }
//
//
//
//    private int getRndInt() {
//        return random.nextInt(100);
//    }
//    public void setLastUpdate(long time)
//    {
//        this.lastUpdate = time;
//    }
//
//    public void setDirection(int xScroll , int yScroll)
//    {
////        System.out.println("value of up "+up);
////        if(up)this.yScroll++;
////        else if(down)this.yScroll--;
////
////        if(right)this.xScroll++;
////        else if(left)this.xScroll--;
//
//        this.xScroll = xScroll;
//        this.yScroll = yScroll;
//        this.x1Scroll = (xScroll + 640);
//        this.y1Scroll = (yScroll + 640);
//
//
////        System.out.println("values of xScroll "+(this.xScroll/16)+" and x1Scroll "+(this.x1Scroll/16));
//
//
////        this.x1Scroll = (this.xScroll + 640) / 32;
////        this.y1Scroll = (this.yScroll + 640) / 32;
////        this.xScroll /= 32;
////        this.yScroll /= 32;
//
////        System.out.println("value of xScroll "+xScroll+" value of yScroll "+yScroll);
//
//
//    }
//
//    private Color getRndColor() {
//        int r = random.nextInt(256);
//        int g = random.nextInt(256);
//        int b = random.nextInt(256);
//
//        return new Color(r, g, b);
//
//    }
//
//	/*
//	 * 1000/60 = x; if(Sys.currTime - lastFrame >= x) update else nothing
//	 *
//	 *
//	 * if (System.nanoTime() - lastFrame >= timePerFrame) { lastFrame =
//	 * System.nanoTime(); repaint(); } else { // nothing, we wait. }
//	 * 		boolean test = SwingUtilities.isEventDispatchThread();
//		System.out.println("test: " + test + " : " + Thread.currentThread().getName());
//	 *
//	 */
//
//}
