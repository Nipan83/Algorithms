package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class Dhoom4 {
    public static int mod = 100000;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int start = in.nextInt();
        int result = in.nextInt();
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();
        Queue<Integer> qu = new LinkedList<>();
        long map[] = new long[100000];
        Arrays.fill(map,-1);
        map[start] = 0;
        qu.add(start);
        if(map[result]!=-1)
        {
            out.println(map[result]);
             out.flush();
            out.close();
            return;
        }
        boolean flag = true;
        while(flag)
        {
            flag = false;
            int temp = qu.remove();
            if(temp == result)
            {
                flag  = true;
                out.println(map[temp]);
                break;
            }
            for(int i=0; i<n; i++)
            {
                int x = (temp * arr[i])%mod;
              // out.println(x) ;
                if( x>=0 && map[x] == -1) 
                {
                    flag = true;
                    map[x]=map[temp]+1;
                    qu.add(x);
                }
            }
            if(!qu.isEmpty())
               flag= true;
        }
        if(!flag)
        {
            out.println("-1");
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
