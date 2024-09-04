package com.company;

public class Main {

    private int[] hashTable;

    public Main()
    {
        hashTable = new int[25];

    }
    public static void main(String[] args) {
	// write your code here
        new Main();
    }

    public void insertIntoHashtable(int studentID)
    {
        int lastTwoDigits = studentID % 100;
        int divisor = (lastTwoDigits/10) + (lastTwoDigits%10)+7;

        int hashedIndex = 0;
        if(studentID % divisor < 10)
        {
            hashedIndex = (studentID % divisor)+8;
        }else
        {
            hashedIndex = (studentID % divisor) - 4;
        }


        insertIntoIndexAt(hashedIndex , studentID);

    }
    private void insertIntoIndexAt(int index , int studentID)
    {
        if(this.hashTable[index] == 0)
        {
            this.hashTable[index] = studentID;
        }else
        {
            index++;
            while(this.hashTable[index] != 0)
            {
                index++;
            }
            this.hashTable[index] = studentID;
        }
    }





}
