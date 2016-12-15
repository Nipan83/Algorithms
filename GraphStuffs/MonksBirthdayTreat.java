package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class MonksBirthdayTreat {
    public static ArrayList<Integer> adj[];
    public static boolean marked[];
    public static int count;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        int m = in.nextInt();
        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        marked = new boolean[n];
        for(int i=0; i<m; i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            adj[x].add(y);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            marked = new boolean[n];
            count =0;
            dfs(i);
            min = Math.min(count,min);
        }
        out.println(min);
        out.flush();
        out.close();
    }

    private static void dfs(int start) {
       
        count++;
        marked[start] = true;
        for(int v: adj[start])
            if(!marked[v])
                dfs(v);
        
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
