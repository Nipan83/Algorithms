/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sourav Kumar Paul
 */

public class Graph {
    private int V;
    private ArrayList adj[];
    
    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int v = 0; v<V; v++)
        {
            adj[v] = new ArrayList();
        }
        
    }
    public int vertices()
    {
        return V;
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    public ArrayList adj(int v)
    {
        return  adj[v];
    }
    
     public void show()
    {
        for(int i=0; i<V; i++)
        {
            for(Object v : adj(i))
                System.out.println(i+" -> "+(int)v);
        }
    }
    
    
}
