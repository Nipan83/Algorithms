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
public class SolveA {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
    
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        long arr[] = new long[n];
        st = new StringTokenizer(reader.readLine());
        int count = 0;
        boolean flag = false;
        for(int i=0; i<n; i++)
        {
            long x = Long.parseLong(st.nextToken());
            if(t >= x)
                count ++;
            else if(!flag)
            {
                
                flag = true;
            }
            else if(flag)
            {
                break;
            }
        }
        System.out.println(count);
        
        
    }
}
