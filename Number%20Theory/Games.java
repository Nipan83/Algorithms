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
public class Games {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test;t++)
        {
            String n = reader.readLine();
            int decDigits = 0;
            boolean flag =false;
            for(int i=n.length()-1; i>=0; i--)
            {
                if(n.charAt(i)== '.')
                {
                    flag = true;
                    break;
                }
                else
                    decDigits++;
            }
            long number = 0;
            for(int i=0; i<n.length(); i++)
            {
                if(n.charAt(i) != '.')
                    number = number *10+ (n.charAt(i)- '0');
            }
            //System.out.println(number+" c");
            long frac = 1;
            if(flag)
                frac = (long)Math.pow(10,decDigits);
            //System.out.println(frac+ " far");
            System.out.println(frac/ gcd(number, frac));
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static long gcd(long a, long b) {
    
        return b==0?a:gcd(b,a%b);
    }
}
