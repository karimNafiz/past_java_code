/* Developed By: Kevin Wong
 * Revised Date: Oct 24, 2021
 * Version     : 1.1 */

/* Manages the game and all of its attributes */
package com.company;

import java.util.Random;
import java.util.Scanner;

public class GameSystem {
    public final static int DEFAULT_GRID_HEIGHT =    4;
    public final static int DEFAULT_GRID_WIDTH  =    4;
    public final static int DEFAULT_WINNING_VAL = 2048;
    public final static int DEFAULT_WINNING_BLK = 2048;
    private int gridWidth;
    private int gridHeight;
    private Block[][] grid;                              // The grid of the game
    private Player[] allPlayer;                          // To keep track of the two players
    private Random random = new Random();
    private int winningBlk;                              // Block that must be reached to win the game.
    private int winningVal;                              // Value that must be reached to win the game.
    private Player currPlayer;                          // Keeps track of the current player


//    private boolean gameWon = false;
    private static Scanner user = new Scanner(System.in);

    //=================== CONSTRUCTOR =====================//
    /* The constructor to initialize the grid. */
    public GameSystem() {
        this(DEFAULT_WINNING_BLK , DEFAULT_WINNING_VAL , DEFAULT_GRID_HEIGHT , DEFAULT_GRID_WIDTH );
    }

    /* The constructor to customize the winning value.
     * @param winningBlk - The block that the player must reach
     *                     to win the game.
     * @param winningVal - The value that the player must reach
     *                     to win the game. */
    public GameSystem(int winningBlk, int winningVal, int height, int width) {
            this.winningVal = winningVal;
            this.winningBlk = winningBlk;
            this.gridHeight = height;
            this.gridWidth = width;
            this.grid = new Block[height][width];
            this.allPlayer = new Player[2];
            this.initializePlayer();
    }

    //================== PRIVATE METHODS ====================//
    /* Place your private methods here, so that I can
     * find them more easily! */

    // need to convert 4 method into only 2 cuz they have the same algorithm
    private void initializePlayer()
    {
        int pCode = 0;
        for(int i = this.allPlayer.length -1;i >=0 ;i--)
        {
            System.out.println("enter player code for player "+(i+1));
            pCode = (int)user.next().charAt(0);
            this.allPlayer[i] = new Player(pCode);

        }
        this.SetCurrPlayer(pCode);

    }
    // this should return the amount of points
    private int moveLeft(int rIndex , int sVal , int eVal)
    {
        int points = 0;
        for(int no = 0;no < this.gridWidth;no++)
        {
            for(int index = sVal;index < eVal;index++)
            {
                if(index - 1 < 0)
                {
                    continue;
                }
                Block bCur = this.grid[rIndex][index - 1];
                Block Cur = this.grid[rIndex][index];
                if(Cur == null && bCur == null)
                {
                    continue;
                }
                else if(bCur == null && Cur != null )
                {
                    this.grid[rIndex][index - 1] = Cur;
                    this.grid[rIndex][index] = null;
                }else if(bCur != null && Cur != null)
                {
                    if(bCur.GetVal() == Cur.GetVal())
                    {
                        points += bCur.GetVal();
                        bCur.SetVal(bCur.GetVal() * 2);
                        this.grid[rIndex][index] = null;
                    }
                }

            }
        }
        return points;
    }
    private int moveRight(int rIndex , int sVal, int eVal)
    {
        int points = 0;
        for(int no = 0;no < this.gridWidth;no++)
        {
            for(int index = sVal-1;index >= eVal;index--)
            {
                if(index + 1 >= this.gridWidth)
                {
                    continue;
                }
                Block bCur = this.grid[rIndex][index + 1];
                Block Cur = this.grid[rIndex][index];
                if(Cur == null && bCur == null)
                {
                    continue;
                }
                else if(bCur == null && Cur != null )
                {
                    this.grid[rIndex][index + 1] = Cur;
                    this.grid[rIndex][index] = null;
                }else if(bCur != null && Cur != null)
                {
                    if(bCur.GetVal() == Cur.GetVal())
                    {
                        points += bCur.GetVal();
                        bCur.SetVal(bCur.GetVal() * 2);
                        this.grid[rIndex][index] = null;
                    }
                }

            }
        }
        return points;
    }
    private int moveUp(int rIndex , int sVal , int eVal)
    {
        int points = 0;
        for(int no = 0;no < this.gridWidth;no++)
        {
            for(int index = sVal;index < eVal;index++)
            {
                if(index - 1 < 0)
                {
                    continue;
                }
                Block bCur = this.grid[index - 1][rIndex];
                Block Cur = this.grid[index][rIndex];
                if(Cur == null && bCur == null)
                {
                    continue;
                }
                else if(bCur == null && Cur != null )
                {
                    this.grid[index - 1][rIndex] = Cur;
                    this.grid[index][rIndex] = null;
                }else if(bCur != null && Cur != null)
                {
                    if(bCur.GetVal() == Cur.GetVal())
                    {
                        points += bCur.GetVal();
                        bCur.SetVal(bCur.GetVal() * 2);
                        this.grid[index][rIndex] = null;
                    }
                }

            }
        }
        return points;

    }
    private int moveDown(int rIndex , int sVal, int eVal)
    {
        int points = 0;
        for(int no = 0;no < this.gridWidth;no++)
        {
            for(int index = sVal-1;index >= eVal;index--)
            {
                if(index + 1 >= this.gridWidth)
                {
                    continue;
                }
                Block bCur = this.grid[index + 1][rIndex];
                Block Cur = this.grid[index][rIndex];
                if(Cur == null && bCur == null)
                {
                    continue;
                }
                else if(bCur == null && Cur != null )
                {
                    this.grid[index + 1][rIndex] = Cur;
                    this.grid[index][rIndex] = null;
                }else if(bCur != null && Cur != null)
                {
                    if(bCur.GetVal() == Cur.GetVal())
                    {
                        points += bCur.GetVal();
                        bCur.SetVal(bCur.GetVal() * 2);
                        this.grid[index][rIndex] = null;
                    }
                }

            }
        }
        return points;
    }

    //================== PUBLIC METHODS ====================//
    /* Get the whole grid of the game
     * @return - The Block object 2D array */
    public Block[][] GetGrid() {
        return this.grid;
    }

    /* Randomize a block and its value (between 2 or 4) and place it
     * in the grid. Note: Must not randomize a position that already
     * has a block. */
    public void RandBlock() {
        int row = random.nextInt(this.gridHeight);
        int column = random.nextInt(this.gridWidth);


        while(this.grid[row][column] != null)
        {
            row = random.nextInt(this.gridHeight);
            column = random.nextInt(this.gridWidth);
        }

        int random = (int)Math.random()*4 + 1;

        if(random <=2)
        {
            this.grid[row][column] = new Block(2);
        }else
        {
            this.grid[row][column] = new Block(4);
        }

    }

    /* Move all the blocks to the specified direction. If the direction is
     * invalid, it will not move any blocks.
     * @param dir - The direction that the user wants to move to.
     *              Refer to GameSystem global variables for direction
     *              value.
     * @return    - Returns points earned from this round of move.
     *              Returns -1 if the direction is invalid, and blocks
     *              will not be moved. */
    public int Move(int dir) {
        int points = 0;
        int retVal = 1;
        if(dir == (int)'a')
        {
            for(int i = 0 ;i < this.gridHeight;i++)
            {
                points += this.moveLeft(i , 0 , this.gridWidth);
            }
        }else if(dir == (int)'d')
        {
            System.out.println("inside move right pls");
            for(int i = 0 ;i < this.gridHeight;i++)
            {
                points += this.moveRight(i , this.gridWidth , 0);
            }

        }else if(dir == (int)'w')
        {
            for(int i = 0 ;i < this.gridWidth;i++)
            {
                points += this.moveUp(i , 0 , this.gridHeight);
            }
        }else if(dir == (int)'s')
        {
            for(int i = 0 ;i < this.gridWidth;i++)
            {
                points += this.moveDown(i , this.gridHeight , 0);
            }
        }else
        {
            retVal = -1;
        }

        this.GetCurrPlayer().SetScore(this.GetCurrPlayer().GetScore() + points);
        if(this.CheckWinner())
        {
            System.out.println("winner is "+(char)this.GetCurrPlayer().GetId());
            System.exit(0);
        }
        this.SwitchPlayer();

//        System.out.println("end of move function");
        return retVal; // Dummy value. Needs to be changed
    }

    /* Set who will be the player turn
     * @param playerId - The ID of the player */
    public void SetCurrPlayer(int playerId ) {
        for(Player player:this.allPlayer)
        {
            if(player.GetId() == playerId)
            {
                this.currPlayer = player;
                return;
            }
        }
    }

    /* Get the Player who is currently his/her turn
     * @return - The Player object of the player who is currently
     *           his/her turn */
    public Player GetCurrPlayer() {
        return this.currPlayer;  // Dummy value. Needs to be changed
    }

    /* Get the Player with the indicated player ID
     * @param playerId - The ID of the player
     * @return         - The Player object of the player */
    public Player GetPlayer(int playerId ) {
        for(Player player:this.allPlayer)
        {
            if(player.GetId() == playerId)
            {
                return player;
            }
        }
        return null;
    }

    /* Switch player's turn. If it is player 0 turn, then it will
     * switch to player 1, and vice versa */
    public void SwitchPlayer() {
        for(Player player:this.allPlayer)
        {
            if(player != this.GetCurrPlayer())
            {
                this.currPlayer = player;
                return;
            }
        }
    }

    /* Check if the player wins or not by reaching the
     * specified winning value.
     * @return - True if:
     *             - blocks is greater than or equals to winning block OR
     *             - points is greater than or equals to winning value
     *           False otherwise. */
    public boolean CheckWinner() {
        if(this.GetCurrPlayer().GetScore() >= this.winningVal)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /* Check if the grid is full or not
     * @return - True if the grid has no more empty blocks
     *           False otherwise. */
    public boolean IsGridFull() {
        return true;  // Dummy value. Needs to be changed
    }
}