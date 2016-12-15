package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class WeAreOnFire {
    public static int mat[][],n,m,count;
    public static boolean marked[][];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
         n = in.nextInt();
         m = in.nextInt();
        int q = in.nextInt();
         mat = new int[n][m];
         count = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                mat[i][j]  = in.nextInt();
                if(mat[i][j] == 1)
                    count++;
            }
        }
         marked = new boolean[n][m];
        for(int i=0; i<q; i++)
        {
            int x= in.nextInt()-1;
            int y = in.nextInt()-1;
            dfs(x,y);
            out.println(count);
        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
      
        if(x<0 || x>=n || y<0 || y>=m)
            return;
        if(marked[x][y])
            return;
        if(mat[x][y] == 0)
            return ;
        else
            count--;
        marked[x][y] = true;
        
        dfs(x-1,y);
        dfs(x+1,y);
        dfs(x,y-1);
        dfs(x,y+1);
        
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
