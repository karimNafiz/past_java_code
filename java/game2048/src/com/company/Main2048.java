package com.company;
import java.util.*;
public class Main2048 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);


        // Provided code. Do not modify
        GameSystem gs;
        Displayer disp = new Displayer();

        gs = new GameSystem(/*2048 , 2 , 5 , 7*/);
        gs.RandBlock();
        disp.PrintGrid(gs.GetGrid());
        while (true)
        {
            System.out.println((char)gs.GetCurrPlayer().GetId() +" 's turn");
            System.out.println("pls enter direction");
            int dir = (int)userInput.next().charAt(0);
            if(dir == (int)'q')
            {
                break;
            }
            while(true)
            {
                if(gs.Move(dir) == 1)
                {
                    break;
                }else
                {
                    System.out.println("invalid direction enter direction again");
                    dir = (int)userInput.next().charAt(0);
                }
            }

            gs.RandBlock();
            Player player1 = gs.GetCurrPlayer();
            gs.SwitchPlayer();
            Player player2 = gs.GetCurrPlayer();
            gs.SwitchPlayer();
            disp.PrintScores(player1 , player2);
            disp.PrintGrid(gs.GetGrid());
        }

//        disp.PrintGrid(gs.GetGrid());

    }
}
