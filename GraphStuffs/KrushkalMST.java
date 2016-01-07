/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

/**
 *
 * @author Sourav Kumar Paul
 */
import static graphstuffs.Heap.swap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Edge
{
    private int either;
    private int other;
    private double weight;
    public Edge(int v, int w, double weight)
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
    public double weight()
    {
        return weight;
    }
}
class WeightedGraph
{
    private int v, nofedge;
    private ArrayList<Edge> adj[];
    public WeightedGraph(int n)
    {
        this.v = n;
        nofedge = 0;
        adj = new ArrayList[n];
        for(int i =0; i<v; i++)
            adj[i] = new ArrayList<Edge>();
        
        
    }
    public void insert(int v, int w, double weigh)
    {
        Edge edge = new Edge(v,w,weigh);
        adj[v].add(edge);
        adj[w].add(edge);
        nofedge++;
    }
    public int vertices()
    {
        return v;
    }
    public ArrayList adj(int v)
    {
        return adj[v];
    }
    public int noEdges()
    {
       System.out.println("edgeds" +nofedge);
        return nofedge;
    }
    public ArrayList edges()
    {
        ArrayList list = new ArrayList();
        for(int i=0; i< v; i++)
        {
            for(Object e : adj(i))
            {
                Edge edge = (Edge)e;
                if(edge.other(i) > i)
                   list.add(edge); 
            }
        }
        return list;
    }
            
}
class MinQueue{
    private Edge array[];
    private int ptr;
    private int size;
    public MinQueue(int n)
    {
        array = new Edge[n];
        ptr =0;
        size = 0;
    }
    public void insert(Edge e)
    {
        array[ptr] = e;
        int i = ptr,j;
        ptr++;
        while(i>0)
        {
            j = (i-1)/2;
            if(array[i].weight() > array[j].weight())
                break;
            swap(array, i,j);
            i=j;
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
class UnionFind
{
    int id[];
    public UnionFind(int n)
    {
        id  = new int[n];
        for(int i=0; i<n; i++)
            id[i] = i;
    }
    private int root(int i)
    {
        while(id[i] != i)
            i = id[i];
        return i;
    }
    public boolean connected(int v, int w)
    {
        return root(v) == root(w);
    }
    public void union(int v, int w)
    {
        int i = root(v);
        int j = root(w);
        id[i] =j;
    }
}
public class KrushkalMST {
    private MinQueue queue;
    private Queue<Edge> mst=new LinkedList<Edge>();
    public KrushkalMST(WeightedGraph graph)
    {
      
        queue = new MinQueue(graph.noEdges());
        for(Object e : graph.edges())
        {
            Edge edge = (Edge)e;
            System.out.println(edge.either() + " "+ edge.other(edge.either()));
            queue.insert(edge);
        }
        UnionFind uf = new UnionFind(graph.vertices());
        while(!queue.isEmpty() && mst.size()<graph.vertices()-1)
        {
            Edge e = queue.delMin();
            int v = e.either();
            int w = e.other(v);
            if(!uf.connected(v,w))
            {
                uf.union(v,w);
                mst.add(e);
            }
        }
        for(Edge e : mst)
        {
            System.out.println(e.either() +" -> " + e.other(e.either()));
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        WeightedGraph graph = new WeightedGraph(n);
        while (true) {

            String line[] = in.nextLine().split(" ");
            if(line[0].equals("-1"))
                break;
            graph.insert(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Double.parseDouble(line[2]));
            
        }
        
        System.out.println("Directed Graph is : ");
        for(int i=0; i<graph.vertices(); i++)
        {
            System.out.print("\n"+i+" -> ");
            for(Object j:graph.adj(i))
            {
                Edge edge = (Edge)j;
                System.out.print(edge.other(i)+" ");
            }
        }
        
       KrushkalMST mst = new KrushkalMST(graph);
       
    }
}
