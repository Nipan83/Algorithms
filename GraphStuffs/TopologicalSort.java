/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Sourav Kumar Paul
 */
public class TopologicalSort {
    
    private boolean marked[];
    Stack stack;
    public TopologicalSort(DirectedGraph graph)
    {
        marked = new boolean[graph.vertices()];
        stack = new Stack();
        for(int v = 0; v<graph.vertices(); v++)
            if(!marked[v])
                dfs(graph,v);
        
    }
    
    private void dfs(DirectedGraph graph, int s)
    {
        marked[s] = true;
        for(Object v : graph.adj(s))
            if(!marked[(int)v])
                dfs(graph, (int)v);
        stack.push(s);
    }
    
    public void display()
    {
        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }
    }
    
    public ArrayList reversePost()
    {   
        
        ArrayList list = new ArrayList(stack.capacity());
        while(!stack.empty())
            list.add(stack.pop());
        return list;
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
        
        TopologicalSort sort = new TopologicalSort(graph);
        sort.display();
    }
}
