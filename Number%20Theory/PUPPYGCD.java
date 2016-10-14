/*
 * To change this license headerl, choose License Headers in Project Properties.
 * To change this template filel, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Sourav Kumar Paul
 */
public class PUPPYGCD {
    private static int step = 250000;
   // private static long SUM[] = 
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
              // int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
       // long SUM[] = new long[500000000+10];
        for(int i=1; i<100000000; i++)
            System.out.print(fi(i)+", ");
       /* for(int t= 0 ;t<test; t++)
        {
            String line[] = reader.readLine().split(" ");
            int n=Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
            System.out.println(puppyGCD(n, d));
        }
*/
        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static long puppyGCD(int n, int d) {
        n= n/d;
        int x = n/ step;
        
        long result = 0;
       // for(int i=1; i<=x*step; i++)
       //     result += SUM[i];
        for(int i=x*step + 1; i<=n; i++)
        {
            result += fi(i);
            
        }
        return result;
    }
    private static long fi(int n)
    {
        long result = n;
        for(int i =2; i*i <= n; i++)
        {
            if(n%i == 0)     result -= result/i;
            while(n % i ==0)
                n /= i;
            
        }
        if(n >1 )
            result -= result/ n;
        return result;
    }
}
