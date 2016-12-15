package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class PinkAndBlue {
    public static int count ;
    public static ArrayList<Integer> adj[];
    public static boolean marked[];
    public static int arr[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
      
        int n = in.nextInt();
        int m = in.nextInt();
        arr = new int[n];
        count = 0;
       for(int i=0; i<n; i++)
       {
           char x = in.next().charAt(0);
           if(x=='B')
               arr[i] = 0;
           else
               arr[i] =1;
       }
       marked = new boolean[n];
       adj = new ArrayList[n];
       for(int i=0; i<n; i++)
           adj[i] = new ArrayList<>();
       for(int i=0; i<m; i++)
       {
           int x = in.nextInt()-1;
           int y = in.nextInt()-1;
           adj[x].add(y);
           adj[y].add(x);
           
       }
       
       dfs(0,0);
       out.println(Math.min(count, n-count));
        out.flush();
        out.close();
    }

    private static void dfs(int start, int col) {
      
        marked[start] = true;
        if(col != arr[start])
            count++;
        for(int v : adj[start])
        {
            if(!marked[v])
                dfs(v, (col+1)%2);
        }
            
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
