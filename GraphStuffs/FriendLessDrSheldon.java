package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class FriendLessDrSheldon {
    
    
    public static int union[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
           union = new int[n];
           for(int i=0; i<n; i++)
               union[i] = i;
            for(int i=0; i<m; i++)
            {
                int u = in.nextInt()-1;
                int v = in.nextInt()-1;
            }
            out.println(n-1);
        }
        out.flush();
        out.close();
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
