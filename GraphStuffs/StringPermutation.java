/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
public class StringPermutation {
    private static int counter = 0;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        printPermutation(text.toCharArray(),0);
        System.out.println(counter);
    }

    private static void printPermutation(char text[], int ctr) {
    
        if(ctr == text.length)
        {   counter++;
            System.out.println(text);
            return;
        }
        
        for(int i=ctr; i<text.length; i++)
        {
            swap(text,i,ctr);
            printPermutation(text,ctr+1);
            swap(text,i,ctr);
        }
    }
    private static void swap(char text[], int i, int j)
    {
        char k;
        k = text[i];
        text[i] = text[j];
        text[j] = k;
        
    }
}
