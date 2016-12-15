package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class VisitingIslands {
    public static int arr[],total[];
    public static void main(String[] args) throws IOException{
         BufferedReader in = new BufferedReader(new FileReader("F:\\ProblemSet\\src\\graphs\\test.txt"));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int test = Integer.parseInt(in.readLine());
        StringTokenizer st;
        while(test-->0)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr= new int[n];
            st = new StringTokenizer(in.readLine());
            for(int i=0; i<n; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            total = new int[n];
            Arrays.fill(total,-1);
            
            for(int i=0; i<n; i++)
            {
                if(total[i] == -1)
                {
                    dfs(i,-1);
                }
            }
            int max = 0,index =-1;
            for(int i=0; i<n; i++)
            {
                if(total[i]>max)
                {
                    max = total[i];
                    index = i;
                }
            }
           // out.println(Arrays.toString(total));
            out.println(total[79584] + " "+total[index]);
            out.println(index);
        }
        out.flush();
        out.close();
    }

    private static int dfs(int start, int prev) {
      
        total[start] = 1;
        if(arr[start] == start)
            return total[start];
        else if(arr[start] == prev)
        {
            total[start] +=1;
            return total[start]-1;
        }
        else
        {
            if(total[arr[start]] == -1)
                total[start]+=dfs(arr[start], start);
            else
                total[start] += total[arr[start]];
            
        }
        return total[start];
        
            
        
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
