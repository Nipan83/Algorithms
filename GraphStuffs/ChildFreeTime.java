package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class ChildFreeTime {

    private static long dfs(int start) {
       
        marked[start] = true;
        
        for(Pair pp : reverse[start])
        {
            int v = pp.v;
            if(!marked[v])
            {
                long x = pp.w + dfs(v);
               dist[start] =  Math.max(dist[start], x);
            }
            else
                dist[start] = Math.max(dist[start], dist[v] + pp.w);
        }
        return dist[start] = 2+ dist[start];
    }
    public static class Pair{
        int v;
        long w;
        Pair(int v, long w)
        {
          
            this.v = v;
            this.w = w;
        }
    }
    public static ArrayList<Pair> adj[],reverse[];
    public static boolean marked[];
    public static long dist[];
    public static void main(String[] args) throws IOException{
       // Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       BufferedReader reader = new BufferedReader(new FileReader("F:\\ProblemSet\\src\\graphs\\test.txt"));
       StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        reverse = new ArrayList[n];
        for(int i=0; i<n; i++)
        {
            adj[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            long w = Long.parseLong(st.nextToken());
            adj[x].add(new Pair(y,w));
            reverse[y].add(new Pair(x,w));
        }
        marked = new boolean[n];
        dist = new long[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(adj[i].size()==0)
                list.add(i);
        }
        long max = 0;
        for(int i=0; i<list.size(); i++)
        {
            int x = list.get(i);
            if(!marked[x])
            {
                dfs(x);
                dist[x]-=2;
                max = Math.max(max, dist[x]);
               // out.println("Holla");
            }
        }
       // out.println(Arrays.toString(dist));
        out.println(max);
        
        
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
