package GraphTheory;


import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class OliverAndTheBattle {
    public static class Pair{
        int v,w;
        Pair(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }
    public static int mat[][],n,m,count,temp;
    public static boolean marked[][];
    public static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int test = in.nextInt();
        while(test -- >0)
        {
            n = in.nextInt();
            m = in.nextInt();
        
            mat = new int[n][m];
            count = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                mat[i][j]  = in.nextInt();
              
            }
        }
         marked = new boolean[n][m];
         Queue<Pair> qu ;
         int temp =0;
         int max = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
               
                if(!marked[i][j] && mat[i][j] == 1)
                {
                    qu = new LinkedList<>();
                    count++;
                    temp = 1;
                    marked[i][j] = true;
                    qu.add(new Pair(i,j));
                    while(!qu.isEmpty())
                    {
                        Pair pp = qu.remove();
                        int x = pp.v;
                        int y = pp.w;
                        if(valid(x+1,y))
                        {
                            temp++;
                            qu.add(new Pair(x+1,y));
                        }
                        if(valid(x,y+1))
                        {
                            temp++;
                            qu.add(new Pair(x,y+1));
                        }
                        if(valid(x-1,y))
                        {
                            temp++;
                            qu.add(new Pair(x-1,y));
                        }
                        if(valid(x,y-1))
                        {
                            temp++;
                            qu.add(new Pair(x,y-1));
                        }
                        if(valid(x-1,y-1))
                        {
                            temp++;
                            qu.add(new Pair(x-1,y-1));
                        }
                        if(valid(x+1,y+1))
                        {
                            temp++;
                            qu.add(new Pair(x+1,y+1));
                        }
                        if(valid(x-1,y+1))
                        {
                            temp++;
                            qu.add(new Pair(x-1,y+1));
                        }
                        if(valid(x+1,y-1))
                        {
                            temp++;
                            qu.add(new Pair(x+1,y-1));
                        }
                    }
                    max = Math.max(max,temp);
                }
            }
           
        }
        out.println(count+" "+max);
        }
        out.flush();
        out.close();
    }
     private static boolean  valid(int x, int y) {
      
        if(x<0 || x>=n || y<0 || y>=m)
            return false;
        if(marked[x][y])
            return false;
        if(mat[x][y] == 0)
            return false;
       
        
        marked[x][y] = true;
        
       return true;
        
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
