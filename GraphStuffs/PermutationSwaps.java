package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class PermutationSwaps {
    public static ArrayList<Integer> list,adj[];
    public static boolean marked[];
    
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int test = in.nextInt();
        while(test-->0)
        {
            
            int n = in.nextInt();
            adj = new ArrayList[n];
            for(int i=0; i<n; i++)
                adj[i] = new ArrayList<>();
            int m = in.nextInt();
            int p[] = new int[n];
            int q[] = new int[n];
            for(int i=0; i<n; i++)
                p[i] = in.nextInt();
            for(int i=0; i<n; i++)
                q[i] = in.nextInt();
            marked = new boolean[n];
            while(m-->0)
            {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                adj[x].add(y);
                adj[y].add(x);
                
            }
            boolean flag = false;
            for(int i=0; i<n; i++)
            {
                if(!marked[i])
                {
                    list = new ArrayList<>();
                    dfs(i);
                    Set<Integer> set1 = new HashSet<>();
                    Set<Integer> set2 = new HashSet<>();
                    for(int v:list)
                    {
                        set1.add(p[v]);
                        set2.add(p[v]);
                        set2.add(q[v]);
                        
                    }
                    if(set1.size() != set2.size())
                    {
                        out.println("NO");
                        flag = true;
                    }
                    
                }
                if(flag)
                    break;
            }
            if(!flag)
                out.println("YES");
            
        }
        out.flush();
        out.close();
    }

    private static void dfs(int start) {
       
        marked[start] = true;
        list.add(start);
        for(int v : adj[start])
            if(!marked[v])
                dfs(v);
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
