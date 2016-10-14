/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Sourav Kumar Paul
 */
 class NDIV {
    public static boolean primes[] = new boolean[100000];
    static ArrayList<Integer> pp = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        precompute();
        String line[] = reader.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int n = Integer.parseInt(line[2]);
        int count = 0;
        for(int i=a; i<=b; i++)
        {
            int temp = i;
            int prDiv = 1;
            for(int j=0; pp.get(j)*pp.get(j) <=temp; j++)
            {
                int cc = 0;
                while(temp%pp.get(j) == 0)
                {
                    cc++;
                    temp = temp/pp.get(j);
                }
                prDiv = prDiv * (cc+1);
                
            }
            if(temp >1)
                prDiv*=2;
            if(prDiv == n)
                count++;
        }
        System.out.println(count);
      //  long start = System.currentTimeMillis();        


       // System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static void precompute() {
    
        int range = 100000;
        Arrays.fill(primes,true);
        for(int i=2; i*i<range; i++)
        {
            if(primes[i])
            {
                
                for(int j=i*i; j<range; j+=i)
                    primes[j] = false;
            }
        }
        for(int i=2; i<range; i++)
            if(primes[i])
                pp.add(i);
        
    }
}
