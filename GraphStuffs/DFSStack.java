/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sourav Kumar Paul
 */
public class DFSStack {
    private boolean marked[];
    Stack stack;
    public DFSStack(DirectedGraph graph)
    {
        marked = new boolean[graph.vertices()];
                
        stack = new Stack();
        
        int s,node;
        for(int i=0; i<graph.vertices(); i++)
        {
            if(!marked[i])
            {
                stack.push(i);
                marked[i] = true;
                
                        
            }
            while(!stack.isEmpty())
            {
                node = (int)stack.pop();
                System.out.print(node+ " ");
                for(Object v: graph.adj(node))
                    if(!marked[(int)v])
                    {
                        stack.push((int)v);
                        marked[(int)v] = true;
                    }
                
                    
            }
            
            
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of vertices: ");
        int v = Integer.parseInt(reader.readLine());
        DirectedGraph graph = new DirectedGraph(v);
        
        System.out.println("Enter edges: ");
        String line[];
        while(true)
        {
            line = reader.readLine().split(" ");
            if(Integer.parseInt(line[0]) == -1)
                break;
                       
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        
        DFSStack dfs = new DFSStack(graph);
       // DepthFirstSearch df = new DepthFirstSearch(graph,0);
    }
}
