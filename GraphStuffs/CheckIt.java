package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class CheckIt {

    private static int find(int u) {
       return (union[u] == u)? u: (union[u] = find(union[u]));
    }

    private static boolean connected(int u, int v) {
    
        return union[find(u)] == union[find(v)];
    }
    public static class Edge{
        int u,v;
        public Edge(int u, int v)
        {
            this.u = u;
            this.v = v;
        }
    }
    public static ArrayList<Integer> adj[];
    public static int union[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int test = in.nextInt();
        while(test-->0){
        int n = in.nextInt();
        int m  = in.nextInt();
        adj = new ArrayList[n];
        Edge edge[] = new Edge[m];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        union = new int[n];
        for(int i=0; i<n; i++)
            union[i] = i;
        for(int i=0; i<m ; i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            adj[x].add(y);
            adj[y].add(x);
            edge[i] = new Edge(x,y);
        }
        boolean flag = true;
        for(int i=0; i<n-1; i++)
        {
            int x = in.nextInt()-1;
            int u = edge[x].u;
            int v = edge[x].v;
            if(connected(u,v))
            {
                flag = false;
                
            }
            union[find(u)] = find(v);
        }
        if(!flag)
            out.println("NO");
        else 
            out.println("YES");
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
