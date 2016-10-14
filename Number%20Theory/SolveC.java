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
public class SolveC {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        for (int t = 0; t < test; t++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String lp1 = lps(line1.toCharArray());
        }
    }

    public static String lps(char str[])
{
    char result[] = new char[str.length];
   int n = str.length;
        int i, j, cl;
        int L[][] = new int[n][n];  
   int Way[][] = new int[n][n];

  
   for (i = 0; i < n; i++) {
            L[i][i] = 1;
            Way[i][i] = 0;
        }

   
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (str[i] == str[j] && cl == 2) {
                    L[i][j] = 2;
                    Way[i][j] = 0;
                } else if (str[i] == str[j]) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                    Way[i][j] = 0;
                } else {
                    if (L[i][j - 1] > L[i + 1][j]) {
                        L[i][j] = L[i][j - 1];
                        Way[i][j] = 1;
                    } else {
                        L[i][j] = L[i + 1][j];
                        Way[i][j] = 2;
                    }

                }

            }
        }

        int index = 0;
        int s = 0, e = n - 1;

        while (s <= e) {
            if (Way[s][e] == 0) {
                result[index++]= str[s];
                s += 1;
                e -= 1;

            } else if (Way[s][e] == 1) {
                e -= 1;
            } else if (Way[s][e] == 2) {
                s += 1;
            }
        }

        int endIndex = (L[0][n - 1] % 2 ==1) ? index - 1 : index;

        for (int k = 0; k < endIndex; ++k) {
            result[L[0][n - 1] - 1 - k] = result[k];
        }

        
        String ans = "";
        for(int k=0; k<index+endIndex; k++)
            ans+= result[i];
System.out.println(ans);
        return ans;
    }
}
