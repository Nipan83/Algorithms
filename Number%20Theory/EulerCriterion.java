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
public class EulerCriterion {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test; t++)
        {
            String line [] = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            if(a==0   || m==2)
            {
                System.out.println("YES");
                continue;
            }
            
            long ans =1;
            int k = (m-1)/2;
            while(k>0)
            {
                if(k%2==1)
                    ans = (long)ans * a %m;
                a = (int)((long)a*a % m);
                k = k/2;
            }
            if(ans == 1)
                System.out.println("YES");
            else 
                System.out.println("NO");
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

}
