/* A class that handles all the printing of
 * the game. */
package com.company;
public class Displayer {
    public Displayer() {
    }

    /* Prints the grid and its content on the screen
     * @param grid - The Block object 2D array. */
    public void PrintGrid( Block[][] grid ) {

        for(int rows = 0;rows < grid.length;rows++)
        {
            for(int columns = 0; columns < grid[rows].length;columns++)
            {
                Block temp = grid[rows][columns];
                this.drawBlocks(temp);


            }// end of inner for loop
            System.out.println();
        }// end of outer for loop
    }

    /* Prints the scores of the two players
     * @param p1 - First player's Player object
     * @param p2 - Second player's Player object */
    public void PrintScores( Player p1, Player p2 ) {
        this.helpPrintScores(true , 40);
        System.out.print(" player "+(char)p1.GetId()+" score = "+p1.GetScore() + "  ||  ");
        System.out.print(" player "+(char)p2.GetId()+" score = "+p2.GetScore());
        this.helpPrintScores(false , 40 + "SCORES".length());

    }

    // helper private methods
    private void drawBlocks(Block tempBlock)
    {
        System.out.print("|");
        if(tempBlock != null) {
            if (tempBlock.GetIsNew()) {
                System.out.print(" {" + tempBlock.GetVal() + "} ");
                tempBlock.SetIsNew(false);
            } else {
                System.out.print("  "+tempBlock.GetVal()+"  ");
            }
        }else {
            System.out.print("     ");
        }
        System.out.print("|");


    }
    private void helpPrintScores(boolean flag, int limit)
    {
        System.out.println();
        String temp = "";
        for(int i = 0; i < limit/2;i++)
        {
            temp += "=";
        }
        if(flag)
        {
            temp += "SCORES";
        }
        for(int i = 0; i < limit/2;i++)
        {
            temp += "=";
        }
        System.out.println(temp);

    }
}
