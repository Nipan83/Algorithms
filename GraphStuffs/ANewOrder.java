package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class ANewOrder {
    public static ArrayList<Integer> list;
    public static ArrayList<Integer> adj[];
    public static boolean marked[];
    public static int rank[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        String words[] = new String[n];
        int hash[] = new int[26];
        for(int i=0; i<n; i++)
        {
            words[i] = in.nextLine();
            for(int j=0; j<words[i].length(); j++)
                hash[words[i].charAt(j)-'a']++;
        }
        adj = new ArrayList[26];
        for(int i=0; i<26; i++)
        {
            adj[i] = new ArrayList<>();
        }
        marked = new boolean[26];
        for(int i=1; i<n; i++)
        {
            char first[] = words[i-1].toCharArray();
            char second[] = words[i].toCharArray();
            for(int j=0; j<Math.min(first.length, second.length); j++)
            {
                if(first[j] == second[j])
                    continue;
                else
                {
                    adj[first[j]-'a'].add(second[j]-'a');
                    marked[second[j]-'a'] = true;
                    break;
                }
            }
        }
        list = new ArrayList<>();
        rank = new int[26];
       for(int i=0; i<26; i++)
       {
           if(!marked[i])
               list.add(i);
       }
        marked = new boolean[26];
        for(int i=0; i<list.size(); i++)
        {
            int x = list.get(i);
            
                dfs(x,0,-1);
        }
        for(int i=0; i<1000000; i++)
        {
            boolean flag = false;
            for(int j=0;j<26; j++)
            {
                if(hash[j]==0)
                    continue;
                if(rank[j] == i)
                {
                    flag = true;
                    out.print((char)(j+'a'));
                }
            }
            if(flag)
            out.println();
        }
      
        out.flush();
        out.close();
    }

    private static void dfs(int start, int ran, int prev) {
        
        marked[start] = true;
        rank[start] = Math.max(ran,rank[start]);
        for(int v: adj[start])
            if(prev != v)
                dfs(v,ran+1, start);
        
       
    }

    private static void topo(int start) {
      marked[start] = true;
      for(int v: adj[start])
          if(!marked[v])
              topo(v);
      list.add(start);
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
