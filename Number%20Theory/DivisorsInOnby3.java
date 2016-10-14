/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Sourav Kumar Paul
 */
public class DivisorsInOnby3 {
    public static ArrayList<Long> primeDivisors = new ArrayList<Long>();
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static boolean isPrime[] = new boolean[1000005];
    public static void main(String[] args) throws IOException{
        precompute();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long start = System.currentTimeMillis();        
        System.out.println(findDivisors(n));

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static void precompute() {
    
        Arrays.fill(isPrime, true);
        isPrime[0]= false;
        isPrime[1] = false;
        for(int i=2; i*i <= 1000000; i++)
        {
            if(isPrime[i])
            {
                for(int j= i*i; j<=1000000; j+=i)
                    isPrime[j] = false;
            }
        }
        for(int i=0; i<=1000000; i++)
            if(isPrime[i])
                primes.add(i);
    }

    private static long findDivisors(long n) {
        long ans = 1;
        for(Integer pp : primes)
        {
            if(pp*pp*pp >n)
                break;
            long count =1;
            if(n%pp == 0)
                primeDivisors.add((long)pp);
            while(n%pp == 0)
            {
                n = n/pp;
                count++;
            }
            ans = ans *count;
        }
        if(checkPrimality(n))
        {
            primeDivisors.add(n);
            ans = ans*2;
        }
        else if(checkPrimality((long)Math.sqrt(n)))
        {
            primeDivisors.add((long)Math.sqrt(n));
            ans = ans * 3;
        }
        else if(n != 1)
            ans = ans *4;
        primeDivisors.add(2l);
        primeDivisors.add(3l);
        return ans;
    }
    

     private static boolean checkPrimality(long p) {
       int iteration = 30;
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
