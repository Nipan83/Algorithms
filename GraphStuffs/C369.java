package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class C369 {
    
    public static ArrayList<Integer> ans  = new ArrayList<>();
    public static class Edge{
        public int either;
        public int other;
        public int weight;
        public Edge(int v, int w, int weight)
        {
            this.either = v;
            this.other = w;
            this.weight = weight;
        }
        public int either()
        {
            return either;
        }
        public int other(int v)
        {
            if(v==either)
                return other;
            else
                return either;
        }
        public int weight()
        {
            return weight;
        }
    }
    public static class Graph{
        int V;
        ArrayList<Edge> adj[];
        public Graph(int n)
        {
            this.V = n;
            adj = new ArrayList[V];
            for(int i= 0; i<V; i++)
                adj[i] = new ArrayList<>();
        }
        public void addEdge(int x, int y, int w)
        {
            if(w == 1)
                w = -1;
            Edge edge = new Edge(x,y,w);
            adj[x].add(edge);
            adj[y].add(edge);
        }
        public void findSol()
        {
           // System.out.println("Ok");
            dfs(0, -1, -1);
        }

        private int dfs(int start, int prev, int val) {
           
            int ff = -1;
            //System.out.println(start+" "+val);
            for(Edge v : adj[start])
            {
                if(v.other(start)!= prev)
                {
                    int xx =  dfs(v.other(start), start, v.weight());
                    if(xx != -1)
                        ff = xx;
                }
            }
            if(ff == -1 && val != -1)
            {
                ans.add(start+1);
            }
            if(ff == -1)
                return val;
            else 
                return ff;
            
        }
    }
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n = in.nextInt();
        Graph graph = new Graph(n);
        for(int i=0; i<n-1; i++)
        {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int t = in.nextInt() ;
            
            graph.addEdge(x,y,t);
        }
        graph.findSol();
        out.println(ans.size());
        for(int i=0; i<ans.size(); i++)
            out.print(ans.get(i)+" ");
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
