package com.company;

//package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private BufferedImage img;
    private Thread gameThread;
    private KeyBoard keyBoard = new KeyBoard();
    int testx , testy = 0;


    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    public Game() {

        importImg();

        setSize(640, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.addKeyListener(keyBoard);
        gameScreen = new GameScreen(img);
        add(gameScreen);
        setVisible(true);

    }

    private void importImg() {

//        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            img = ImageIO.read(new File("/Users/MofizulKarim/Developer/java/TestPlayGround/spriteatlas.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    private void updateGame() {

        // System.out.println("Game Updated!");
        keyBoard.update();

        if(keyBoard.right)testx++;
        if(keyBoard.left)testx--;
        if(keyBoard.up)testy--;
        if(keyBoard.down)testy++;

//        System.out.println("value of test "+testx);
        gameScreen.setDirection(testx , testy);

    }

    public static void main(String[] args) {

        Game game = new Game();
        game.start();

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (true) {

            // Render
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }

            // Update
            if (System.nanoTime() - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
//                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }

    }

    /*
     * public void run() {
     *
     * long last = System.nanoTime(); double ns = 1000000000.0 / TARGET_UPS; float
     * delta = 0; int updates = 0; int frames = 0; long timer =
     * System.currentTimeMillis();
     *
     * while (running) { long now = System.nanoTime(); delta += (now - last) / ns;
     * last = now;
     *
     * if (delta >= 1) { if (delta > 1.3) delta = 1.2F; update(delta); updates++;
     * delta--; } render(); frames++; if (System.currentTimeMillis() - timer > 1000)
     * { timer += 1000; // frame.setTitle(TITLE + " | UPS: " + updates + " FPS: " +
     * // frames);
     *
     * // System.out.println("UPS: " + updates + " FPS: " + frames); updates = 0;
     * frames = 0; } }
     *
     * stop(); }
     */

}
