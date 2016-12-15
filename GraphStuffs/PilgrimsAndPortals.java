package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class PilgrimsAndPortals {
   
    public static class Pair implements Comparable{
        Edge edge;
        double dist;
        public Pair(Edge edge, double dist)
        {
            this.edge = edge;
            this.dist = dist;
        }
        public int compareTo(Object o)
        {
            Pair pp = (Pair)o;
            if(dist == pp.dist)
                return 0;
            else if(dist > pp.dist)
                return 1;
            else
                return -1;
        }
    }
    public static class Graph{
     
        int V;
        boolean marked[];
        double distanceTo[];
        Edge edgeTo[];
        ArrayList<Edge> adj[];
        PriorityQueue<Pair> pq;
        public Graph(int n)
        {
           adj = new ArrayList[n];
           V = n;
           for(int i=0; i<V; i++)
           {
               adj[i] = new ArrayList<>();
           }
           
        }
        public void addEdge(int v, int w, double weight)
        {
            Edge edge = new Edge(v,w,weight);
            adj[v].add(edge);
            adj[w].add(edge);
        }
        public void djikstra(int start)
        {
            marked = new boolean[V];
            distanceTo = new double[V];
            edgeTo = new Edge[V];
            for(int i=0; i<V; i++)
                distanceTo[i] = Double.POSITIVE_INFINITY;
            
            pq = new PriorityQueue<>();
            
            distanceTo[start] = 0;
            marked[start] = true;
            visit(start);
            int count = 1;
           // System.out.println(pq.size());
            while(!pq.isEmpty())
            {
                Pair pair = pq.remove();
                int v = pair.edge.either();
                int w = pair.edge.other(v);
                if(marked[v] && marked[w])
                    continue;
               // System.out.println(Arrays.toString(marked));
                if(!marked[v])
                {
                    marked[v] = true;
                    visit(v);
                }
                if(!marked[w])
                {
                    marked[w] = true;
                    visit(w);
                }
            }
            ArrayList<Edge> list = new ArrayList<>();
            for(int i=1; i<k; i++)
            {
                list.add(edgeTo[i]);
                int u = edgeTo[i].other(i);
                while(u!=start)
                {
                    list.add(edgeTo[u]);
                    u = edgeTo[i].other(u);
                }
            }
            long ans = 0;
            union= new int[V];
            for(int i=0; i<V; i++)
                union[i] = i;
            for(int i=0; i<list.size(); i++)
            {
                int u = list.get(i).either;
                int v = list.get(i).other(u);
                if(!connected(u,v))
                {
                    ans+=list.get(i).weight;
                    System.out.println(u+" "+v+" "+list.get(i).weight);
                    union[find(u)] = find(v);
                }
            }
            System.out.println(ans);
        }
        public static int union[];
         private static boolean connected(int u, int v) {
    
        return union[find(u)] == union[find(v)];
    }

    private static int find(int u) {
    
        return (union[u]==u)? u: (union[u] = find(union[u]));
    }
        private void visit(int start) {
          
            for(Edge e : adj[start])
            {
                int w = e.other(start);
                if(distanceTo[w] > distanceTo[start] + e.weight)
                {
                   // marked[w] = true;
                    distanceTo[w] = distanceTo[start] + e.weight;
                    edgeTo[w] = e;
                   // System.out.println("Check"+distanceTo[w]);
                    pq.add(new Pair(e, distanceTo[w]));
                }
            }
        }
    }
    public static class Edge{
        public int either,other;
        public double weight;
        public Edge(int either, int other, double weight)
        {
            this.either = either;
            this.other = other;
            this.weight = weight;
            
        }
        public int either()
        {
            return either;
        }
        public int other(int v)
        {
            if(either != v)
                return either;
            else
                return other;
        }
    }
    public static int k;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       int test = in.nextInt();
       for(int t=0; t<test; t++)
       {
        int n = in.nextInt();
        
        Graph graph = new Graph(n);
        int edges = in.nextInt();
         k = in.nextInt();
        for(int i=0; i<edges; i++)
        {
            int v = in.nextInt()-1;
            int w = in.nextInt()-1;
            double weight = in.nextInt();
            graph.addEdge(v,w,weight);
        }
        int start = 0;
        graph.djikstra(start);
       
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
