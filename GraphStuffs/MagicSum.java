package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class MagicSum {
    public static long cost[];
    public static ArrayList<Integer> adj[];
    public static long ans;
    public static void main(String[] args) throws IOException{
      BufferedReader reader = new BufferedReader(new FileReader("F:\\ProblemSet\\src\\graphs\\test.txt"));
              PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
      
        int test = Integer.parseInt(reader.readLine());
        while(test-->0)
        {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            cost = new long[n+1];
            for(int i=1; i<=n; i++)
                cost[i] = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n+1];
            for(int i=1; i<=n; i++)
                adj[i] = new ArrayList<>();
          
           
            ans = Long.MIN_VALUE;
            for(int i=1; i<(n+1)/2; i++)
            {
                adj[i].add(2*i);
               
                adj[i].add(2*i+1);
               
            }
            dfs(1,-1);
            out.println(ans);
        }
        out.flush();
        out.close();
    }

    private static long dfs(int start, int prev) {
    
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        for(int v: adj[start])
        {
            if(v!= prev)
            {
                long x = dfs(v,start);
                if(x+cost[start] > first)
                {
                    second = first;
                    first = x+cost[start];
                }
                else if(x+cost[start] > second)
                {
                    second = x+cost[start];
                }
            }
        }
        if(first == Long.MIN_VALUE)
        {
            first = cost[start];
            second = cost[start];
        }
        else if (second == Long.MIN_VALUE)
            second = cost[start];
        ans = Math.max(ans, first+second-cost[start]);
       
        return first;
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
