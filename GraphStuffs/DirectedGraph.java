/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.util.ArrayList;

/**
 *
 * @author Sourav Kumar Paul
 */
public class DirectedGraph {
    private int V;
    private ArrayList adj[];
    
    public DirectedGraph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int v = 0; v < V; v++)
            adj[v] = new ArrayList();
    }
    
    public int vertices()
    {
        return V;
        
    }
    
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    
    public ArrayList adj(int v)
    {
        return adj[v];
    }
    
    public DirectedGraph reverse()
    {
        DirectedGraph reverse = new DirectedGraph(V);
        for(int v = 0; v<V; v++)
        {
            for(Object i : adj(v))
                reverse.addEdge((int)i, v);
        }
        return reverse;
    }
}
