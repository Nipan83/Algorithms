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
/**
 *
 * @author Sourav Kumar Paul
 */
public class ChanduAndInterns {
    public static boolean prime[] = new boolean[10001];

    private static void precompute() {
       int range = 10000000 + 10;
       for(int i=2; i*i<=range; i++)
       {
           if(!prime[i])
           {
               for(int j= i*i; j<10001; j+=i)
                   prime[j]=true;
           }
       }
       for(int i =2; i< 10001; i++)
           if(!prime[i])
               myPrimes.add(i);
       
       
    }
    static ArrayList<Integer> myPrimes  = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        precompute();
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test; t++)
        {
            long ans = 1;
            int n = Integer.parseInt(reader.readLine());
            for(int i=2; i*i<=n; i++)
            {
                if(!prime[i])
                {
                    int c =0;
                
                while(n%i==0 )
                {
                    c++;
                    n = n/i;
                }
                
                ans = ans* (c+1);
                }
                
            }
            if(n>1)
                ans = ans*2;
            //System.out.println(ans);
            if(ans<4)
            System.out.println("NO");
            else 
                System.out.println("YES");
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }
}
