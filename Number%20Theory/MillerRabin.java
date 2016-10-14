/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class MillerRabin {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long start = System.currentTimeMillis();        
        System.out.println(checkPrimality(n));

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static boolean checkPrimality(long p) {
       int iteration = 20;
       if(p<2)
           return false;
       if(p != 2 && p%2==0)
           return false;
       long s = p-1;
       while(s%2==0)
           s/=2;
       for(int i=0; i<iteration; i++)
       {
           long a = ((long)(Math.random()*10000000000000000L))%(p-1) +1 , temp = s;
           long mod = modPow(a, temp, p);
           
         while(temp!=p-1 && mod!=1 && mod!=p-1){
            mod=(mod * mod)%p;
            temp *= 2;
        }
        if(mod!=p-1 && temp%2==0){
            return false;
        }
       }
       return true;
    }
    private static long modPow(long base, long exp, long mod) {

       
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }
            
        }
        return result;
        
    }
}
