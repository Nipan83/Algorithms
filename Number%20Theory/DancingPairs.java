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
public class DancingPairs {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test; t++)
        {
            long n = Long.parseLong(reader.readLine());
            long ans = (long)Math.sqrt(n);
            long result =0;
            for(long i=ans-5; i<=ans+5; i++)
                if(i*i <= n)
                    result = i;
            //System.out.println(ans);
            if((result & 1) == 1)
                System.out.println("odd");
            else
                System.out.println("even");
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }
}
