package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class Pilgrims {
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
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            union = new int[n];
            for(int i=0; i<n; i++)
                union[i] = i;
            ArrayList<Edge> list = new ArrayList<>();
            boolean marked[] = new boolean[k];
            long ans = 0;
            for(int i=0; i<m; i++)
            {
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
                long w = in.nextLong();
                if(a<k && b<k)
                {
                    if(!connected(a,b))
                    {
                        union[find(a)] = find(b);
                        ans+=w;
                        marked[a] = true;
                    }
                }
            }
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
