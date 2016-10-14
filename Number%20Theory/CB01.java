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
public class CB01 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        
        for(int t=0; t<test; t++)
        {
            String line[] = reader.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            long k = Long.parseLong(line[1]);
            System.out.println(findBinCoeff(n,k));
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }

    private static long findBinCoeff(long n, long k) {
        long ans = 1;
        int mod =1009;
        if(k > n-k)
            k = n-k;
        for(long i= 0; i<k; i++)
        {
            ans = (ans * (n - i)) % mod;
            ans = (ans /(i + 1)) % mod;
        }
        return ans;
    }
}
