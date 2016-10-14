/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class BinomialCoeffLucas {
    public static int MOD = 1009;
    public static long ncr[][];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
         ncr = new long[MOD +1][MOD+1];
        generateNCR();
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t= 0; t<test; t++)
        {
            StringTokenizer st=new StringTokenizer(reader.readLine());
		
		long n=Long.parseLong(st.nextToken());
		long k=Long.parseLong(st.nextToken());
           
            out.println(findSol(n,k));
        }
        
        out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
        out.flush();
        out.close();
    }

    private static void generateNCR() {
        
      ncr[0][0] = 1;
      for(int i=1; i<=MOD; i++)
      {
          ncr[i][0] = 1;
          ncr[0][i] = 0;
      }
        for(int i=1; i<=MOD; i++)
        {
            for(int j=1; j<=MOD; j++)
            {
                ncr[i][j] = (ncr[i-1][j] + ncr[i-1][j-1]) % MOD;
                //System.out.println(i+" "+ j);
            }
        }
    }

    

    private static long findSol(long n, long k) {
    
        long ans = 1;
        
        while(n>0)
        {
            int N = (int)(n%MOD);
            int K = (int)(k%MOD);
            if(K>N)
                return 0;
            ans *= (ncr[N][K] );
            n /= MOD;
            k /= MOD;
        }
        return ans % MOD;
    }
}
