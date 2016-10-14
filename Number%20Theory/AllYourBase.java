/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 	Google Codejam 2009, Round 1C, Problem A
 */
package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Sourav Kumar Paul
 */
public class AllYourBase {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        

        for(int t=0; t<test; t++)
        {
            String line = reader.readLine();
            int text[] = new int[256];
            char n[] = line.toCharArray();
            int unq=0;
            for(int i=0; i<n.length; i++)
            {
                if(text[n[i]] == 0)
                    text[n[i]] = ++unq;
                
            }
            if(unq<=1)
                unq=2;
            long ans =0;
            for(int i=0; i<n.length; i++)
            {
                int temp = text[n[i]];
                if(temp==2)
                    temp =0;
                else if(temp>2)
                    temp--;
                ans = unq*ans + temp;
            }
            System.out.println("Case #"+(t+1)+": "+(ans));
        }
        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }
}
