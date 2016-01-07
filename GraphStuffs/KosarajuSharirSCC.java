/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sourav Kumar Paul
 */
public class KosarajuSharirSCC {
    int count;
    private boolean marked[];
    private int id[];
    public KosarajuSharirSCC(DirectedGraph graph)
    {
       count = 0;
       marked = new boolean[graph.vertices()];
       id = new int[graph.vertices()];
       TopologicalSort dfs = new TopologicalSort(graph.reverse());
       for(Object i : dfs.reversePost())
       {
           if(!marked[(int)i])
           {
               depthFirstSearch(graph,(int)i, count);
               count++;
           }
       }
       
       for(int i=0; i< graph.vertices(); i++)
           System.out.println(i + " -> " + id[i]);
        
    }
    
    public void depthFirstSearch(DirectedGraph graph, int i, int count)
    {
        marked[i] = true;
        id[i] = count;
        for(Object j : graph.adj(i))
        {
            if(!marked[(int)j])
                depthFirstSearch(graph, (int)j, count);
        }
    }
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        DirectedGraph graph = new DirectedGraph(n);
        String line[];
        while(true)
        {
            line = reader.readLine().split(" ");
            if(line[0].equals("-1"))
                break;
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            
        }
        
        KosarajuSharirSCC strong = new KosarajuSharirSCC(graph);
    }
}
