package NumberTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class RMATRIX {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       int test = in.nextInt();
       while(test-->0)
       {
           long n= in.nextLong();
           long m = in.nextLong();
           if(n==1 || m==1)
               out.println(Math.max(n,m));
           else
           {
               out.println(gcd(n-1,m-1) + 1);
           }
       }
        out.flush();
        out.close();
    }

    private static long gcd(long n, long m) {
    
        long x = Math.min(n,m);
        long y = Math.max(n,m);
        while(x!=0)
        {
            long temp = y%x;
            
            y = x;
            x = temp;
        }
        return y;
    }
    public static class Reader {
        public BufferedReader reader;
        public StringTokenizer st;

        public Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public String nextLine() throws IOException{
            return reader.readLine();
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }

    }
}
