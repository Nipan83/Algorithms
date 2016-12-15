package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class AgitatedChandan {
    public static class Pair{
        int to,w;
        Pair(int to, int w)
        {
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            ArrayList<Pair> adj[] = new ArrayList[n];
            for(int i=0; i<n; i++)
            {
                adj[i] = new ArrayList<>();
            }
            for(int i=0; i<n-1; i++)
            {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                int w = in.nextInt();
                adj[x].add(new Pair(y,w));
                adj[y].add(new Pair(x,w));
            }
            int distTo[] = new int[n];
            Arrays.fill(distTo,-1);
            distTo[0] = 0;
            Queue<Integer> qu = new LinkedList<>();
            qu.add(0);
            int index=-1;
            boolean marked[] = new boolean[n];
            marked[0] = true;
            while(!qu.isEmpty())
            {
                int x = qu.remove();
                for(Pair pp : adj[x])
                {
                    int v= pp.to;
                    int w= pp.w;
                    if(!marked[v])
                    {
                        distTo[v] = distTo[x] + w;
                        marked[v] = true;
                        qu.add(v);
                    }
                }
            }
            int max = 0;
            index = 0;
            for(int i=0; i<n; i++)
            {
                if(distTo[i] > max)
                {
                    max = distTo[i];
                    index = i;
                }
            }
            distTo = new int[n];
            Arrays.fill(distTo,-1);
            distTo[index] = 0;
            marked = new boolean[n];
            qu = new LinkedList<>();
            qu.add(index);
            marked[index] = true;
            
            
             while(!qu.isEmpty())
            {
                int x = qu.remove();
                for(Pair pp : adj[x])
                {
                    int v= pp.to;
                    int w= pp.w;
                    if(!marked[v])
                    {
                        distTo[v] = distTo[x] + w;
                        marked[v] = true;
                        qu.add(v);
                    }
                }
            }
             max = 0;
            index = index;
            for(int i=0; i<n; i++)
            {
                if(distTo[i] > max)
                {
                    max = distTo[i];
                    index = i;
                }
            }
            if(max > 10000)
                out.println(10000+" "+max);
            else if(max >1000)
                out.println(1000+" "+max);
            else if(max > 100)
                out.println(100+" "+max);
            else 
                out.println(0+" "+max);
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
