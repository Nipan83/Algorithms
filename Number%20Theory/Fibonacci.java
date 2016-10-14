/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Sourav Kumar Paul
 */
public class Fibonacci {

    static long mod =   1000000000 + 7;;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        for (int t = 0; t < test; t++) {
            long a, b, n;

            String line[] = reader.readLine().split(" ");
            a = Long.parseLong(line[0]);
            b = Long.parseLong(line[1]);
            n = Long.parseLong(line[2]) + 1;
            long f1[][] = new long[2][1];
            f1[0][0] = a;
            f1[1][0] = b;
            long T[][] = new long[2][2];
            T[0][1] = 1;
            T[1][0] = 1;
            T[1][1] = 1;
            if (n == 2) {
                System.out.println(b);
                continue;
            }
            long ans[][] = new long[T.length][1];
          
            T = pow(T, n - 1);
            for (int i = 0; i < T.length; i++) {
                for (int j = 0; j < f1[0].length; j++) {
                    ans[i][j] = 0;
                    for (int k = 0; k < f1.length; k++) {
                        ans[i][j] = ans[i][j] + (T[i][k] * f1[k][j]) % mod;

                    }
                }
            }
            System.out.println(ans[0][0] % mod);

        }
    }

    private static long[][] pow(long[][] T, long n) {
        if (n == 1) {
            return T;
        }
        if (n % 2 != 0) {
            return mul(T, pow(T, n - 1));
        }
        long X[][] = pow(T, n / 2);
        return mul(X, X);

    }

    private static long[][] mul(long[][] T, long[][] f1) {
        long ans[][] = new long[T.length][f1[0].length];
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < f1[0].length; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < f1.length; k++) {
                    ans[i][j] = ans[i][j] + (T[i][k] * f1[k][j]) % mod;

                }
            }
        }
        return ans;
    }
}
