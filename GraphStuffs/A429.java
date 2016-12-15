/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class A429 {
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static int given[], wants[];
    public static class Graph{
        int V;
        ArrayList<Integer> adj[];
        public Graph(int V){
            this.V = V;
            adj = new ArrayList[V];
            for(int i=0; i<V; i++)
                adj[i] = new ArrayList<>();
            
        }
        public void addEdge(int x, int y)
        {
            adj[x].add(y);
            adj[y].add(x);
        }
        public void findSol()
        {
            dfs(0, -1, 0, 0, 0);
            System.out.println(ans.size());
            for(int i=0; i<ans.size(); i++)
                System.out.println(ans.get(i));
        }

        private void dfs(int start, int prev, int level, int odd, int even) 
        {
           if(level%2==0)
           {
               given[start] = given[start] ^ (even%2);
               if(given[start] != wants[start])
               {
                   ans.add(start+1);
                   given[start]= given[start] ^ 1;
                   even++;
               }
           }
           else
           {
               given[start] = given[start] ^ (odd%2);
               if(given[start] != wants[start])
               {
                   ans.add(start+1);
                   given[start]= given[start] ^ 1;
                   odd++;
               }
           }
           
           for(int v : adj[start])
           {
               if(v!= prev)
               {
                   dfs(v, start, level+1, odd,even);
               }
           }
           
               
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
    
        Graph graph = new Graph(n);
        for(int i=0; i<n-1; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) - 1;
           // System.out.println("Hello"+x+" "+y);
            graph.addEdge(x,y);
        }
        given = new int[n];
        wants = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n; i++)
            given[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n; i++)
            wants[i] = Integer.parseInt(st.nextToken());
        graph.findSol();
    }
}
