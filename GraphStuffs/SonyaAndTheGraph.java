package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class SonyaAndTheGraph {
    public static class Edge{
        int v,w;
        Edge(int v, int w)
        {
            this.v = Math.min(v,w);
            this.w = Math.max(v,w);
        }
        public boolean equals(Object o)
        {
            Edge ed = (Edge)o;
            if(v==ed.v && w == ed.w)
                return true;
            else return false;
                
        }
    }
    public static ArrayList<Integer> adj[];
    public static void main(String[] args) throws IOException{
       BufferedReader in = new BufferedReader(new FileReader("F:\\ProblemSet\\src\\graphs\\test.txt"));
       PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        Edge edge[]= new Edge[m+1];
        
        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken())-1;
            adj[v].add(w);
            adj[w].add(v);
            edge[i] = new Edge(v,w);
            
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++)
        {
            st = new StringTokenizer(in.readLine());
            int time = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            map.put(edge[x].v+" "+edge[x].w,time);
        }
        Queue<Integer> qu = new LinkedList<>();
        int distTo[] = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[0] = 0;
        qu.add(0);
        boolean marked[] = new boolean[n];
        marked[0] = true;
        while(!qu.isEmpty())
        {
            int x= qu.remove();
            for(int v: adj[x])
            {
                if(distTo[v] < distTo[x] + 1)
                    continue;
                if(!map.containsKey(Math.min(v,x)+" "+Math.max(v,x)))
                {
                    qu.add(v);
                    distTo[v] = distTo[x]+1;
                    marked[v] = true;
                }
                else if(map.get(Math.min(v,x)+" "+Math.max(v,x)) <distTo[x])
                {
                   // out.println("hek"+map.get(new Edge(x,v)));
                     qu.add(v);
                    distTo[v] = distTo[x]+1;
                    marked[v] = true;
                }
            }
        }
        if(distTo[n-1] == Integer.MAX_VALUE)
            out.println("-1");
        else
        out.println(distTo[n-1]);
        
        out.flush();
        out.close();
    }
    public static class Reader {
        public BufferedReader reader;
        public StringTokenizer st;

        public Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public String nextLine() throws IOException{
            return reader.readLine();
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }

    }
}
