// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
     public static InputReader in;
     public int []find=new int[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        int l=0;
        while (queue.size() != 0)
        {
            
            int size=0;
            s = queue.poll();
            if()
           // System.out.print(s+" ");

             find[0]=1; 
            
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()&&adj[])
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;

                    queue.add(n);
                    
                }
            }
            queue.add(101);
             
           // System.out.println(size+ "aya");
           // l++;
        }
    }
 
    // Driver method to
    public static void main(String args[])
    {
      in=new InputReader(); 
      int t=0; 
      int node=in.nextInt();
      Graph g=new Graph(node);

        for(int i=0;i<node-1;i++)
                  {  

                       int x=in.nextInt() ;
                       int y=in.nextInt() ;
                       if(i==0)
                  	   {
                  	   	t=x;
                  	   }

                       g.addEdge(x,y);
                      // adj[y].add(x);

                  }
        g.BFS(t);
        int p=in.nextInt();
        System.out.println(find[p]); 
        
        //System.out.println("Following is Breadth First Traversal "+
                        //   "(starting from vertex 2)");
 
       
    }
    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
 
        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLng() {
            return Long.parseLong(next());
        }
    }
}