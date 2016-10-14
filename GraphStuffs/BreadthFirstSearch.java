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
public class BreadthFirstSearch {
    
    private boolean visited[];
    LiinkedQueue queue;
    public BreadthFirstSearch(Graph graph)
    {
        visited = new boolean[graph.vertices()];
        queue = new LiinkedQueue();
    }
    public void connectedComponents(Graph graph)
    {
        int explored[] = new int[graph.vertices()];
        for(int i =0;i<graph.vertices(); i++)
            explored[i] = -1;
        for(int i =0; i<graph.vertices(); i++)
        {
            if(explored[i] == -1)
                bfs(graph,i, explored);
                
        }
        for(int i=0; i< graph.vertices(); i++)
            System.out.println(i + " -> " + explored[i]);
    }
    
    public void bfs(Graph graph, int i, int explored[])
    {
         visited[i] = true;
        queue.enqueue(i);
        explored[i] = i;
        
        while(!queue.isEmpty())
        {
            int vertex = queue.dequeue();
            for(Object v : graph.adj(vertex))
                if(visited[(int)v] == false)
                {
                    queue.enqueue((int)v);
                    visited[(int)v] = true;
                    explored[(int)v] = i;
                }
            
                
        }
    }
    public int shortestPath(Graph graph, int start, int dest)
    {
        int distance[] = new int[graph.vertices()];
        visited[start] = true;
        queue.enqueue(start);
        distance[start] = 0;
        
        while(!queue.isEmpty())
        {
            int vertex = queue.dequeue();
            for(Object v : graph.adj(vertex))
                if(!visited[(int)v] )
                {
                    queue.enqueue((int)v);
                    visited[(int)v] = true;
                    distance[(int)v] = distance[vertex] + 1;
                }
            
                
        }
        
        return distance[dest];
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        for(int t=0; t< test; t++)
        {
            String line[ ] = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            Graph graph = new Graph(n);
            for(int i=0; i<m; i++)
            {
                line = reader.readLine().split(" ");
                graph.addEdge(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1);
            }
            
            BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
            System.out.println(bfs.shortestPath(graph, 0, n-1));
        }
       
    }
}
