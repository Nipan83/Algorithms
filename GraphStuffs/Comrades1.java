package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class Comrades1 {
   public static ArrayList<Integer> adj[];
    public static int into[],outo[];
    public static int k ;
    public static int levels[];
    public static void main(String[] args) throws IOException{
         BufferedReader reader = new BufferedReader(new FileReader("F:\\ProblemSet\\src\\graphs\\test.txt"));
       PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(reader.readLine());
        while(test-->0){
        int n = Integer.parseInt(reader.readLine());
        adj = new ArrayList[n+5];
        levels = new int[n+5];
        k=0;
        for(int i=0; i<n; i++)
        {
            adj[i] = new ArrayList<>();
        }
       int start = -1;
       StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n; i++)
        {
            int x =Integer.parseInt(st.nextToken());
            if(x==0)
            {
                start = i;
                continue;
            }
            x--;
            adj[x].add(i);
            
        }
        into = new int[n];
        outo = new int[n];
        
        
        
        dfs(start,-1,0);
        //out.println(Arrays.toString(into));
       // out.println(Arrays.toString(outo));
        int q = Integer.parseInt(reader.readLine());
        for(int i=0; i<q; i++)
        {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            if(into[y]<=into[x] && outo[y]>= outo[x])
            {
                out.println(levels[x] - levels[y]-1);
            }
            else
                out.println(-1);
        }
        }
        out.flush();
        out.close();
    }

    private static void dfs(int start, int prev, int lev) {
       
        into[start] = k++;
        levels[start] = lev;
        for(int v: adj[start])
        {
            if(v!=prev)
                dfs(v,start,lev+1);
        }
        outo[start] = k++;
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
