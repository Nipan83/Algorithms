/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
class DirectedEdge{
    private int from;
    private int to;
    private double weight;
    DirectedEdge(int from, int to, double weight)
    {
        this.from=from;
        this.to= to;
         this.weight=weight;
    }
    public int to()
    {
        return to;
        
    }
    public int from()
    {
        return from;
    }
    public double weight()
    {
        return weight;
    }
}
class DirectedWeightedGraph{
    private ArrayList adj[];
    private int V;
    private double distTo[];
    public DirectedWeightedGraph(int V)
    {
        this.V =V;
        adj = new ArrayList[V];
        for(int i=0; i<V; i++)
            adj[i] = new ArrayList<DirectedEdge>();
        distTo = new double[V];
    }
    
    public int vertices()
    {
        return V;
        
    }
    public ArrayList adj(int v)
    {
        return adj[v];
    }
    public void addEdge(int v, int w,double weight)
    {
        DirectedEdge edge = new DirectedEdge(v,w,weight);
        adj(v).add(edge);
    }
}
class MinPriorityQueue{
    private int loc[], array[],ptr,size;
    MinPriorityQueue(int n)
    {
        loc = new int[n];
        size = n;
        ptr =0;
        array = new int[n];
    }
    public void insert(int x, double distTo[])
    {
        array[ptr] = x;
        loc[array[ptr]] = ptr;
        int i=ptr,j;
        ptr++;
        
        while(i>0)
        {
            if(i%2==0)
                j = i/2-1;
            else j = i/2;
            if(distTo[array[j]] < distTo[array[i]])
                break;
            loc[array[i]] = j;
            loc[array[j]] = i;
            swap(array, j, i);
            
            i = j;
                    
        }
    }
     public int currentSize()
    {
        return ptr;
    }
    public int peek()
    {
        return array[0];
    }
    public boolean isEmpty()
    {
        return ptr==0;
    }
    public int minHeap(double distTo[])
    {
        int x = array[0];
        loc[array[ptr-1]] = 0;
        swap(array, 0, ptr-1);
        
        ptr--;
        int i=0,j;
        
        while((2*i+2 ) < ptr)
        {
            if(distTo[array[2*i+1]]< distTo[array[2*i+2]])
                j = 2*i+1;
            else 
                j = 2*i+2;
            if(distTo[array[i]] > distTo[array[j]])
            {
                loc[array[i]] = j;
                loc[array[j]] = i;
                
                swap(array,i,j);
                i=j;
                
            }
            else 
                break;
        }
        if((2*i+1) < ptr)
        {
            if(distTo[array[i]] > distTo[array[2*i+1]])
            {
                loc[array[i]] = 2*i+1;
                loc[array[2*i+1]] = i;
                swap(array,i,2*i+1);
                
            }
        }
        return x;
            
    }
    public static void swap(int array[] , int i, int j)
    {
        int x = array[i];
        array[i] =array[j];
        array[j] =x;
    }

    void decreaseKey(int start, double distTo[]) {
    
        int i = loc[start],j;
        
        while(i>0)
        {
             if(i%2==0)
                j = i/2-1;
            else j = i/2;
            if(distTo[array[j]] < distTo[array[i]])
                break;
            loc[array[i]] = j;
            loc[array[j]] = i;
            swap(array, j, i);
            
            i = j;
        }
    }
}
public class Djikstra {
    private double distTo[];
    private DirectedEdge edgeTo[];
    MinPriorityQueue priority;
    public Djikstra(DirectedWeightedGraph graph, int start)
    {
        distTo = new double[graph.vertices()];
        edgeTo = new DirectedEdge[graph.vertices()];
        priority = new MinPriorityQueue(graph.vertices());
        
        for(int i=0; i<graph.vertices(); i++)
        {
            distTo[i] = Double.POSITIVE_INFINITY;
            priority.insert(i,distTo);
        }
        distTo[start] = 0.0;
        priority.decreaseKey(start, distTo);
       
        //relax(start, 0.0);
        int u;
        while(!priority.isEmpty())
        {
            u = priority.minHeap(distTo);
            for(Object i : graph.adj(u))
            {
                 DirectedEdge edge = (DirectedEdge)i;
                 relax(edge);
            }
        }
        System.out.println();
        for(int i=0; i< graph.vertices(); i++)
            System.out.print(-1*distTo[i] + " ");
        
    }
     private void relax(DirectedEdge edge) {
         int v = edge.from(), w = edge.to();
         double weight = edge.weight();
         
         if(distTo[w] > distTo[v] + weight)
         {
             distTo[w] = distTo[v] + weight;
             edgeTo[w] = edge;
             priority.decreaseKey(w, distTo);
         }
         //System.out.println("Relaxed"+w+" new"+ distTo[w]);
         
     }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        DirectedWeightedGraph graph = new DirectedWeightedGraph(n);
        while (true) {

            String line[] = in.nextLine().split(" ");
            if(line[0].equals("-1"))
                break;
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), -1*Double.parseDouble(line[2]));
            
        }
        
        System.out.println("Directed Graph is : ");
        for(int i=0; i<graph.vertices(); i++)
        {
            System.out.print("\n"+i+" -> ");
            for(Object j:graph.adj(i))
            {
                DirectedEdge edge = (DirectedEdge)j;
                System.out.print(edge.to()+" ");
            }
        }
        
        Djikstra dj = new Djikstra(graph, 0);
        
    }

   
}
