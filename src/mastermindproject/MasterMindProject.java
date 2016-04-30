/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindproject;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bhargav
 */
public class MasterMindProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int i,j, wPlaces=0, rPlaces=0, n=0, chance=0, hintCounter=0, hintPlaces=-999;
        int[] genNum = new int[4];
        int[] guessNum = new int[4];
        i  = rand.nextInt(9000)+999;
        while(verify(i))
        {
            i = rand.nextInt(9000)+999;
        }
        genNum = intoArray(i,genNum);
        //System.out.println(i);
        System.out.print("Enter a 4 digit number as a guess\n");
        while(rPlaces != 4)
        {
            wPlaces = 0;
            rPlaces = 0;
            n=0;
            
            j = input.nextInt();
            if(j == -738325)
            {
                System.out.println(i);
                rPlaces = 4;
            }
            else if(j == -4468)
            {
                if(hintCounter != 1 && hintPlaces != -999)
                {
                    hintCounter++;
                    System.out.println(hintPlaces+" is in correct place.");
                }
                else if(hintPlaces == -999)
                {
                    System.out.println("There is nothing in right place to give you an hint, try again later");
                }
                else
                {
                    System.out.println("All your hints are used up");
                }
            }
            else
            {
                chance++;
            guessNum = intoArray(j,guessNum);
        
            for(int l:guessNum)
            {
                n++;
                for(int m = 0; m<4;m++)
                {
                    if(l == genNum[m] && n == m+1)
                    {
                        rPlaces++;
                        hintPlaces = l;
                    }
                    else if(l == genNum[m])
                    {
                        wPlaces++;
                    }
                }
            }
        
            System.out.print(j+"   "+wPlaces+":"+rPlaces);
            System.out.println("   "+chance+" chance(s) elapsed");
            }
        }
    }
    
    private static int[] intoArray(int num, int[] arr)
    {
        arr = new int[4];
        int j=4,k;
        while(j!=0) {
            k = num%10;
            num = num/10;
            arr[4-j] = k;
            j--;
        }
        return arr;
    }
    
    private static boolean verify(int num)
    {
        int[] a = new int[4];
        int k=0;
        a = intoArray(num,a);
        for(int i : a)
        {
            for(int j : a)
            {
                if(i == j)
                {
                    k++;
                }
            }
        }   
        if(k == 4)
            return false;
        else
            return true;
    }
}