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
public class DepthFirstSearch {
    private boolean marked[];
    public DepthFirstSearch(Graph graph, int start)
    {
        marked = new boolean[graph.vertices()];
        
        dfs(graph, start);
    }
    
    
    
    public void dfs(Graph graph, int s)
    {
        marked[s] = true;
        System.out.println(s);
        for(Object v : graph.adj(s))
            if(!marked[(int)v])
                dfs(graph, (int)v);
        
    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of vertices: ");
        int v = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(v);
        
        System.out.println("Enter edges: ");
        String line[];
        while(true)
        {
            line = reader.readLine().split(" ");
            if(Integer.parseInt(line[0]) == -1)
                break;
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        
    }
}
