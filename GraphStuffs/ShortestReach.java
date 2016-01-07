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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class ShortestReach {
    public static class Graph {
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

        private void bfs(int s) {
            int nodes[] = new int[V];
            boolean marked[ ] = new boolean[V];
            marked[s] = true;
            Arrays.fill(nodes, -1);
            nodes[s] = 0;
            Queue<Integer> queue = new LinkedList();
            queue.add(s);
            while(!queue.isEmpty())
            {
                int x = queue.remove();
                for(Object o : adj(x))
                {
                    if(!marked[(int)o])
                    {
                        nodes[(int)o] = nodes[x] +1;
                        queue.add((int)o);
                        marked[(int)o] = true;
                    }
                }
            }
            for(int i=0; i<V; i++)
            {
                if(i != s)
                {
                    if(nodes[i] == -1)
                        System.out.print(nodes[i]+" ");
                    else
                        System.out.print(nodes[i]*6+" ");
                           
                }
            }
            System.out.println();
        }
        
    
    
}

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        long start = System.currentTimeMillis();        
        for(int t=0; t<test; t++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Graph graph = new Graph(n);
            for(int i=0; i<m; i++)
            {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken()) -1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                graph.addEdge(x, y);
            }
            int s = Integer.parseInt(reader.readLine())-1;
            graph.bfs(s);
        }

        System.out.println("\n\ntime: "+(System.currentTimeMillis() - start)/100F + "s");
    }
}
