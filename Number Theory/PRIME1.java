/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
    Segmented Sieve
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
public class PRIME1 {
    public static boolean primes[] = new boolean[100000];
    public static ArrayList<Integer> myPrime = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis(); 
        Arrays.fill(primes, true);
        generatePrime();
        
        for(int t=0; t<test; t++)
        {
            String line[] = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            findSegPrime(a,b);
            System.out.println();
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
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
        
        boolean segPrime[] = new boolean[b-a+1];
        Arrays.fill(segPrime, true);
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
                    segPrime[j-a] = false;
            }
        }
        for(int i=0; i<segPrime.length; i++)
        {
            if(segPrime[i] && (i + a) != 1)
            System.out.println(i+a);
        }
    }
}
