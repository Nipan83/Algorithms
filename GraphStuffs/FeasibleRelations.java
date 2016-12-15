package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class FeasibleRelations {
    public static int union[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int test = in.nextInt();
        while(test-->0)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            union = new int[n];
            for(int i=0; i<n; i++)
                union[i] = i;
            boolean marked[] = new boolean[n];
            boolean flag = false;
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;  i<k; i++)
            {
                int x = in.nextInt()-1;
                String r = in.next();
                int y = in.nextInt()-1;
               if(r.equals("!="))
               {
                   list.add(x+" "+r+" "+y);
                   continue;
               }
                
               if(union[x] != union[y])
                   union[find(x)] = find(y);
            }
            StringTokenizer st;
            for(int i=0; i<list.size(); i++)
            {
                st = new StringTokenizer(list.get(i));
                int x = Integer.parseInt(st.nextToken());
                String r = st.nextToken();
                int y = Integer.parseInt(st.nextToken());
                if(union[find(x)] == union[find(y)])
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                out.println("YES");
            else
                out.println("NO");
        }
        out.flush();
        out.close();
    }

    private static int find(int x) {
      
        return (union[x] == x)? x : (union[x] = find(union[x]));
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
