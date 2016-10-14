/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Sourav Kumar Paul
 */
class MinPQ
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
class UndirectedWeighGraph 
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
    public void add(int u, int w, double weigh)
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
public class PrimMST {
    private boolean marked[];
    private MinPQ priority;
    private Queue<Edge> mst;
    public PrimMST(UndirectedWeighGraph graph)
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
        
        for(Edge e : mst)
        {
             System.out.println(e.either() +" -> " + e.other(e.either()));
        }
    }
    private void visit(UndirectedWeighGraph graph, int v)
    {
        marked[v] = true;
        for(Edge e : graph.adj(v))
        {
            Edge edge = (Edge) e;
            if(!marked[edge.other(v)])
                priority.insert(edge);
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        UndirectedWeighGraph graph = new UndirectedWeighGraph(n);
        while (true) {

            String line[] = in.nextLine().split(" ");
            if(line[0].equals("-1"))
                break;
            graph.add(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Double.parseDouble(line[2]));
            
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
        
       PrimMST mst = new PrimMST(graph);
    }
}
