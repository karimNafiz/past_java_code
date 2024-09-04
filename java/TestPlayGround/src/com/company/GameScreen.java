package com.company;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;


//    private boolean up,down,right,left;
    int xScroll,yScroll,x1Scroll , y1Scroll = 0;





    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public GameScreen(BufferedImage img) {
        this.img = img;

        loadSprites();

        random = new Random();

    }

    private void loadSprites() {


//        for (int y = 0; y < 10; y++) {
//            for (int x = 0; x < 10; x++) {
//                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
//            }
//        }

        for(int i = 0; i < (40*40); i++)
        {

            if(i >= 20 * 20 )
            {
                sprites.add(img.getSubimage(7 * 32 , 32 , 32 , 32));
                continue;
            }
            sprites.add(img.getSubimage(8 * 32 , 32 , 32 , 32));
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);



//        for (int y = 0; y < 20; y++) {
//            for (int x = 0; x < 20; x++) {
//                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
//            }
//        }

        for(int y =  (this.yScroll/32); y < (this.y1Scroll /32); y++)
        {
            for(int x = (this.xScroll/32) ; x < (this.x1Scroll+640/32);x++)
            {

                g.drawImage(sprites.get(x + y * 40) , (x * 32) - this.xScroll , (y * 32) - this.yScroll , null );
            }
        }



    }



    private int getRndInt() {
        return random.nextInt(100);
    }

    public void setDirection(int xScroll , int yScroll)
    {
//        System.out.println("value of up "+up);
//        if(up)this.yScroll++;
//        else if(down)this.yScroll--;
//
//        if(right)this.xScroll++;
//        else if(left)this.xScroll--;

        this.xScroll = xScroll;
        this.yScroll = yScroll;
        this.x1Scroll = (xScroll + 640);
        this.y1Scroll = (yScroll + 640);


//        System.out.println("values of xScroll "+(this.xScroll/16)+" and x1Scroll "+(this.x1Scroll/16));


//        this.x1Scroll = (this.xScroll + 640) / 32;
//        this.y1Scroll = (this.yScroll + 640) / 32;
//        this.xScroll /= 32;
//        this.yScroll /= 32;

//        System.out.println("value of xScroll "+xScroll+" value of yScroll "+yScroll);


    }

    private Color getRndColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);

    }

	/*
	 * 1000/60 = x; if(Sys.currTime - lastFrame >= x) update else nothing
	 *
	 *
	 * if (System.nanoTime() - lastFrame >= timePerFrame) { lastFrame =
	 * System.nanoTime(); repaint(); } else { // nothing, we wait. }
	 * 		boolean test = SwingUtilities.isEventDispatchThread();
		System.out.println("test: " + test + " : " + Thread.currentThread().getName());
	 *
	 */

}
