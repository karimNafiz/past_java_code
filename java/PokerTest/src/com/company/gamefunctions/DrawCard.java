package com.company.gamefunctions;

public class DrawCard {
    public static void drawLines(int lBound , int uBound , int max , boolean flag , int gRound)
    {
        for(int j = 0; j < gRound ; j++) {
            for (int i = 1; i <= max; i++) {
                if (i == lBound || i == uBound) {
                    System.out.print("|");
                } else if (i == 1 || i == max) {
                    System.out.print("|");
                } else if (i < lBound || i > uBound) {
                    System.out.print(" ");
                } else if (flag) {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }// end of for loop
        }
        System.out.println();
    }// end of function

    public static  void drawLines(int lBound , int uBound , int max , boolean flag , String[] suitOrRank , int gRound)
    {
        int middle = (max + 1)/2;


        for(int j = 0; j < gRound ; j++) {
            for (int i = 1; i <= max; i++) {

                if (i == lBound || i == uBound) {
                    System.out.print("|");
                } else if (i == middle - 1) {
                    if (suitOrRank[j].charAt(0) == '0') {
                        System.out.print(" ");
                    } else {
                        System.out.print(suitOrRank[j].charAt(0));
                    }
                } else if (i == middle) {
                    if (suitOrRank[j].charAt(1) == '0') {
                        System.out.print(" ");
                    } else {
                        System.out.print(suitOrRank[j].charAt(1));
                    }
                } else if (i == middle + 1) {
                    if (suitOrRank[j].charAt(2) == '0') {
                        System.out.print(" ");
                    } else {
                        System.out.print(suitOrRank[j].charAt(2));
                    }
                } else if (i == 1 || i == max) {
                    System.out.print("|");
                } else if (i < lBound || i > uBound) {
                    System.out.print(" ");
                } else if (flag) {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }// end of for loop
        }
        System.out.println();

    }
}
