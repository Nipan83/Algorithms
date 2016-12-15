package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class D472 {
    public static class Edge
{
    private int either;
    private int other;
    private int weight;
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
    public static class MinPQ
{
    private Edge array[];
    private int ptr , size;
    public MinPQ(int n)
    {
        array = new Edge[n];
        ptr = 0;
        size = 0;
        
    }
    public void insert(Edge edge)
    {
        array[ptr] = edge;
        int i =ptr;
        int j;
        ptr ++;
        while(i>0)
        {
            j = (i-1)/2;
            if(array[i].weight() > array[j].weight())
                break;
            swap(array,i,j);
            i = j;
        }
    }
     public Edge delMin()
    {
        Edge temp = array[0];
        array[0] = array[ptr-1];
        ptr--;
        int i=0,j;
        while(2*i+2<ptr)
        {
            if(array[2*i+1].weight() < array[2*i+2].weight())
                j = 2*i+1;
            else
                j = 2*i+2;
            if(array[i].weight() < array[j].weight())
                break;
            swap(array,i,j);
            i = j;
        }
        if((2*i+1)<ptr)
        {
             if(array[2*i+1].weight() < array[i].weight())
            {
                swap(array,i,2*i+1);
               
            }
        }
        return temp;
    }
     public int currentSize()
    {
        return ptr;
    }
    public Edge peek()
    {
        return array[0];
    }
    public boolean isEmpty()
    {
        return ptr==0;
    }

    private void swap(Edge[] array, int i, int j) {
        Edge temp = array[i];
        array[i] = array[j];
        array[j]= temp;
        
    }
}

    public static class PrimMST {
    private boolean marked[];
    private MinPQ priority;
    private Queue<Edge> mst;
    public PrimMST(UndirectedWeighGraph graph, int arr[][])
    {
        marked = new boolean[graph.vertices()];
        priority = new MinPQ(graph.noEdges());
        mst = new LinkedList<Edge>();
        
        visit(graph,0);
        
        while(!priority.isEmpty() && mst.size() < graph.vertices() -1)
        {
            Edge edge = priority.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if(marked[v] && marked[w])
                continue;
            mst.add(edge);
            if(!marked[v])
                visit(graph,v);
            if(!marked[w])
                visit(graph,w);
            
            
        }
        UndirectedWeighGraph gr = new UndirectedWeighGraph(graph.vertices());
        
        for(Edge e : mst)
        {
            gr.add(e.either(), e.other(e.either()), e.weight());
            // System.out.println(e.either() +" -> " + e.other(e.either()));
        }
        for(int i=0; i<gr.vertices(); i++)
        {
            int start = i;
            Queue<Integer> queue = new LinkedList<Integer>();
           boolean visited[] = new boolean[gr.vertices()];
            int distance[] = new int[gr.vertices()];
            visited[start] = true;
            queue.add(start);
            distance[start] = 0;
        
            while(!queue.isEmpty())
            {
                int vertex = queue.remove();
                for(Edge v : gr.adj(vertex))
                {
                    int yyy = v.other(vertex);
                    if(!visited[yyy] )
                    {
                        queue.add(yyy);
                        visited[yyy] = true;
                        distance[yyy] = distance[vertex] + v.weight();
                    }
                }
                
            }
            //System.out.println("Hello"+start+" "+Arrays.toString(distance));
            for(int j=0; j<gr.vertices(); j++)
            {
                //System.out.println(i+" "+j+" je"+" "+arr[i][j]);
                if(j!= start)
                    if(arr[start][j] ==0)
                    {
                        System.out.println("NO");
                    return;
                    }
                if(arr[start][j] != distance[j])
                {
                   // System.out.println("WHY");
                    System.out.println("NO");
                    return;
                }
            }
        
        
        }
        System.out.println("YES");
    }
    private void visit(UndirectedWeighGraph graph, int v)
    {
        marked[v] = true;
        for(Edge e : graph.adj[v])
        {
            Edge edge = (Edge) e;
            if(!marked[edge.other(v)])
                priority.insert(edge);
        }
    }
    }
    public static class UndirectedWeighGraph 
{
    private ArrayList<Edge> adj[];
    private int v, edgeNo;
    public UndirectedWeighGraph(int n)
    {
        this.v = n;
        edgeNo = 0;
        adj = new ArrayList[n];
        for(int i = 0; i<n; i++)
        {
            adj[i] = new ArrayList<Edge>();
        }
    }
    public void add(int u, int w, int weigh)
    {
        Edge edge = new Edge(u,w,weigh);
        adj[u].add(edge);
        adj[w].add(edge);
        edgeNo++;
    }
    public int vertices()
    {
        return v;
    }
    public ArrayList<Edge> adj(int v)
    {
        return adj[v];
    }
    public int noEdges()
    {
       return edgeNo;
    }
       
    public ArrayList<Edge> edges()
    {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i=0; i<v; i++)
        {
            for(Object e : adj(i))
            {
                Edge edge = (Edge)e;
                if(edge.other(i) > i)
                    edges.add(edge);
            }
        }
        return edges;
    }
    }
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                arr[i][j] = in.nextInt();
        }
        
        for(int i=0; i<n; i++)
        {
            for(int j= i; j<n; j++)
            {
                if(arr[i][j] != arr[j][i])
                {
                    out.println("NO");
                    out.flush();
                    out.close();
                    return;
                }
            }
        }
        
        UndirectedWeighGraph graph = new UndirectedWeighGraph(n);
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
                graph.add(i,j,arr[i][j]);
        }
        PrimMST mst = new PrimMST(graph, arr);
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
