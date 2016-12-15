package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class BigPAndPary {
    public static ArrayList<Integer> adj[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        int m = in.nextInt();
        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        for(int i=0; i<m; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        Queue<Integer> qu = new LinkedList<>();
        int distTo[] = new int[n];
        qu.add(0);
        Arrays.fill(distTo,-1);
        distTo[0] = 0;
        boolean marked[] = new boolean[n];
        marked[0] = true;
        while(!qu.isEmpty())
        {
            int x = qu.remove();
            for(int v: adj[x])
            {
                if(!marked[v])
                {
                    qu.add(v);
                    distTo[v] = distTo[x]+1;
                    marked[v] = true;
                }
            }
        }
        for(int i=1; i<n; i++)
        {
            out.println(distTo[i]);
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
