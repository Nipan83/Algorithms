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
/**
 *
 * @author Sourav Kumar Paul
 */
class AMR14E1 {
    public static boolean primes[] = new boolean[100000];
    public static ArrayList<Integer> myPrime = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
      //  long start = System.currentTimeMillis(); 
        Arrays.fill(primes, true);
        generatePrime();
        
        for(int t=0; t<test; t++)
        {
            String line[] = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            findSegPrime(a,b);
           // System.out.println();
        }
 
       // System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }
 
    private static void generatePrime() {
        
        
        int range = (int)Math.sqrt(1000000000);
        for(int i=2; i<= (int)Math.sqrt(range); i++)
        {
            if(primes[i])
            {
                for(int j = i*i; j<=range; j= j+i)
                {
                    primes[j] = false;
                }
            }
        }
        for(int i=2; i<=range; i++)
            if(primes[i])
                myPrime.add(i);
    }
 
    private static void findSegPrime(int a, int b) {
        
        int segPrime[] = new int[b-a+1];
        int segCompValue[] = new int[b-a+1];
       int count = 0;
        for(int i=0; i<myPrime.size(); i++)
        {
            if(myPrime.get(i) > (int)Math.sqrt((double)b))
                break;
            int p = myPrime.get(i);
            int x = (int)Math.ceil((double)a/(double)p);
            //System.out.println("x"+x);
            for(int j = x* p; j<=b; j=j+p)
            {
               // System.out.println(j);
                if(j!= p)
                {
                    segPrime[j-a] ++;
                    segCompValue[j-a] = p;
                }
            }
        }
        for(int i=0; i<segPrime.length; i++)
        {
            if(segPrime[i]==0 && (i + a) != 1)
                count++;
            else if(segPrime[i] == 1)
            {
                if(Math.ceil(Math.sqrt((double)(i+a))) == Math.floor(Math.sqrt((double)(i+a))))
                {
                   int cc = (int)(Math.log10(i+a)/ Math.log10(segCompValue[i]));
                    if(primes[cc+1])
                        count++;
                }
                
               // int cc = (int)(Math.log10(i+a)/ Math.log10(segCompValue[i]));
               // if(primes[cc+1])
                //    count++;
            }
                
        }
        System.out.println(count);
    }
}