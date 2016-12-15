package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class OliverAndTheGame {
    public static ArrayList<Integer> adj[];
    public static int into[],outo[];
    public static int k = 0;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n = in.nextInt();
        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            adj[x].add(y);
            adj[y].add(x);
        }
        into = new int[n];
        outo = new int[n];
        dfs(0,-1);
        
        int q = in.nextInt();
        for(int i=0; i<q; i++)
        {
            int type = in.nextInt();
            if(type == 0)
            {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if(into[x]<=into[y] && outo[x] >= outo[y])
                    out.println("YES");
                else
                    out.println("NO");
            }
            else
            {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if(into[x]>=into[y] && outo[x] <= outo[y])
                    out.println("YES");
                else
                    out.println("NO");
            }
        }
        out.flush();
        out.close();
    }

    private static void dfs(int start, int prev) {
       
        into[start] = k++;
        for(int v: adj[start])
        {
            if(v!=prev)
                dfs(v,start);
        }
        outo[start] = k++;
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
