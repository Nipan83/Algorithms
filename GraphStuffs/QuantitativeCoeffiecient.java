package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class QuantitativeCoeffiecient {

    private static boolean connected(int u, int v) {
    
        return union[find(u)] == union[find(v)];
    }

    private static int find(int u) {
    
        return (union[u]==u)? u: (union[u] = find(union[u]));
    }
    public static class Edge implements Comparable{
        int u,v;
        long w;
        Edge(int u, int v, long w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Object o)
        {
            Edge e = (Edge)o;
            if(e.w == w)
                return 0;
            else if(w> e.w)
                return 1;
            else
                return -1;
        }
    }
    public static int union[];
    public static long mod = 1000000007;

    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            Edge edge[] = new Edge[m];
            for(int i=0; i<m; i++)
            {
                int u = in.nextInt()-1;
                int v= in.nextInt()-1;
                long w = in.nextLong();
                edge[i] = new Edge(u,v,w);
            }
            Arrays.sort(edge);
            union = new int[n];
            for(int i=0; i<n; i++)
                union[i] = i;
            long ans = 1;
            for(int i=0; i<m; i++)
            {
                int u = edge[i].u;
                int v = edge[i].v;
                long w = edge[i].w;
                if(!connected(u,v))
                {
                    union[find(u)] = find(v);
                    ans = (ans * w)%mod;
                }
            }
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
