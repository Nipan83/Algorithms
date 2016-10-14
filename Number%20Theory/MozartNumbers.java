package NumberTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class MozartNumbers {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int test = in.nextInt();
        while(test-->0)
        {
            int ans =0;
            int a = in.nextInt();
            int b = in.nextInt();
            if(a<=7 && b>=7)
                ans+=8;
            if(a<=13 && b>=13)
                ans+=144;
            out.println(ans);
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
