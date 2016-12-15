package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class KingdomOfMonkeys {
    public static ArrayList<Integer> adj[];
    public static boolean marked[];
    public static long count, cost[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            
            adj = new ArrayList[n];
            for(int i=0; i<n; i++)
                adj[i] = new ArrayList<>();
            for(int i=0; i<m; i++)
            {
                int x= in.nextInt()-1;
                int y = in.nextInt()-1;
                adj[x].add(y);
                adj[y].add(x);
            }
            cost = new long[n];
            for(int i=0; i<n; i++)
                cost[i] = in.nextLong();
            marked = new boolean[n];
            long ans = 0;
            Queue<Integer> qu = new LinkedList<>();
            
            for(int i=0; i<n; i++)
            {
                count =0;
                if(!marked[i])
                {
                    
                    qu.add(i);
                    marked[i] = true;
                    while(!qu.isEmpty())
                    {
                        int x = qu.remove();
                        count+=cost[x];
                        for(int v: adj[x])
                        {
                            if(!marked[v])
                            {
                                marked[v] = true;
                                qu.add(v);
                            }
                        }
                    }
                    ans = Math.max(ans, count);
                }
            }
            out.println(ans);
        }
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
