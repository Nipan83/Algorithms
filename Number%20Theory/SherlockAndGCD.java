/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class SherlockAndGCD {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test; t++)
        {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int gc = 0;
            for(int i=0; i<n; i++)
            {
                int x = Integer.parseInt(st.nextToken());
                 gc = gcd(gc, x);
            }
            if(gc == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static int gcd(int gc, int x) {
       if(x == 0)
           return gc;
       return gcd(x, gc % x);
    }
}
