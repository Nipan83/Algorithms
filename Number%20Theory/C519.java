/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Sourav Kumar Paul
 */
public class C519 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // long start = System.currentTimeMillis();        
        String line[] = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        System.out.println(solution(n,m));
        

        //System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static int solution(int n, int m) {
        int ans = 0;
        
        while(n>0 && m>0)
        {
            while(n>0 && m>0 && n<m)
            {
                n-=1;
                m-=2;
                if(m>=0)
                ans++;
            }
            if(n<=0 || m<=0)
                break;
            while(n>0 && m>0 && n>=m)
            {
                n-= 2;
                m-= 1;
                if(n>=0)
                ans++;
            }
        }
        return ans;
        
    }
}
