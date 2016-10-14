/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import static NumberTheory.NDIV.pp;
import static NumberTheory.NDIV.primes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class SolveB {
    public static ArrayList<Integer> pp = new ArrayList<>();
    public static boolean primes[] = new boolean[1000005];
    public static long dp[] = new long[1000005];
    public static long fact[] = new long[1000005];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        precompute();
        
        for(int i=2; i<=1000000; i++)
        {
            int temp = i;
            int prDiv = 1;
            for(int j=0; pp.get(j)*pp.get(j) <=temp; j++)
            {
                int cc = 0;
                while(temp%pp.get(j) == 0)
                {
                    cc++;
                    temp = temp/pp.get(j);
                }
                fact[i] += cc;
                
            }
            if(temp >1)
                fact[i]+=1;
            
        }
       // System.out.println(Arrays.toString(fact));
        for(int i=2;i<=1000000; i++)
            fact[i]+=fact[i-1];
        
       //System.out.println(Arrays.toString(fact));
        int n = Integer.parseInt(reader.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n ;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        subs(arr,n);
    }
    public static void subs(int arr[], int n)
    {
        long sum = 0;
        long ans = 0;
        int ml = 1<<n;
      
        for(int i=0;i<ml;i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
         
         for(int j=0;j<n;j++)
         {
             if( (i & (1<<j)) >=1   )
                list.add(arr[j]);
         }
        // System.out.println(sum);
         sum = 0;
       //  System.out.println(list.size());
         for(int k=0; k<list.size(); k++)
         {
             sum+=fact[list.get(k)];
         }
         if(sum %2 ==0)
             ans +=sum;
     }
     
     
   
  
      
        
        
        System.out.println(ans);
    }
     


    private static void precompute() {
    
        int range = 1000000;
        Arrays.fill(primes,true);
        for(int i=2; i*i<range; i++)
        {
            if(primes[i])
            {
                
                for(int j=i*i; j<range; j+=i)
                    primes[j] = false;
            }
        }
        for(int i=2; i<range; i++)
            if(primes[i])
                pp.add(i);
        
    }
}





