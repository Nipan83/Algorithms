/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Sourav Kumar Paul
 */
public class PowerSet {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();
 
        int[] set = new int[10000];
        int n = set.length;
        int m =100
// iterate over all the subsets
        for (int i = 0; i < (1<<n); i=Integer.bitCount(i) < m ? i+1 : (i|(i-1))+1) {
            // generate the i-th subset
            Vector subset = new Vector();
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) > 0) {
                   
                    subset.add(set[k]);
                }
            }

            // perform an action over the subset, here just print it
            System.out.print("Subset " + i + ":");
            for (int k = 0; k < subset.size(); k++) {
                System.out.print(" " + subset.get(k));
            }
            System.out.println();
            
        }

        System.out.println("\n\ntime: " + (System.currentTimeMillis() - start) / 100F + "s");
    }
}
