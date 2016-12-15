package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class JungleRun {

    private static boolean valid(int i, int j, int n) {
    
        if(i<0 || i>=n || j<0 || j>=n)
            return false;
       if(marked[i][j])
           return false;
       if(mat[i][j] == 'T')
           return false;
        return true;
       
        
    }
    public static class Pair{
        int i,j;
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    public static char mat[][];
    public static int dist[][];
    public static boolean marked[][];
    public static  Pair start, end;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        mat = new char[n][n];
        dist = new int[n][n];
       marked = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            
            for(int j=0; j<n; j++)
            {
                mat[i][j] = in.next().charAt(0);
                if(mat[i][j] == 'S')
                    start = new Pair(i,j);
                else if(mat[i][j] == 'E')
                    end = new Pair(i,j);
               // out.print(mat[i][j]+" ");
            }
           // out.println();
        }
       // out.println(start.i+" "+start.j+" "+end.i+" "+end.j);
        Queue<Pair> qu = new LinkedList<>();
        qu.add(start);
        marked[start.i][start.j] = true;
        while(!qu.isEmpty())
        {
            Pair pp = qu.remove();
            int i = pp.i;
            int j = pp.j;
             if(valid(i+1,j,n))
             {
                 marked[i+1][j] = true;
                 dist[i+1][j] =  dist[i][j] + 1;
                 qu.add(new Pair(i+1,j));
             }
             if(valid(i-1,j,n))
             {
                 marked[i-1][j] = true;
                 dist[i-1][j] =  dist[i][j] + 1;
                 qu.add(new Pair(i-1,j));
             }
             if(valid(i,j+1,n))
             {
                 marked[i][j+1] = true;
                 dist[i][j+1] = dist[i][j] + 1;
                 qu.add(new Pair(i,j+1));
             }
              if(valid(i,j-1,n))
             {
                 marked[i][j-1] = true;
                 dist[i][j-1] = dist[i][j] + 1;
                 qu.add(new Pair(i,j-1));
             }
            
        }
      //  for(int i=0; i<n; i++)
      //  {
       //     out.println(Arrays.toString(dist[i]));
       // }
        out.println(dist[end.i][end.j]);
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
