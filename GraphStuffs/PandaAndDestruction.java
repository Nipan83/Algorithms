package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class PandaAndDestruction {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
      
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        int edges[] = new int[n];
        for(int i=0; i<m; i++)
        {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
            edges[a]++;
            edges[b]++;
        }
        TreeSet<Pair> set = new TreeSet<>(new comp());
        for(int i=0; i<n; i++)
        {
            if(edges[i]>0)
            {
               // out.println("Hello");
                set.add(new Pair(edges[i],i));
              //  out.println("sfs"+set.size());
            }
        }
        int ctr = 0;
      //  out.println(set.size());
        while(!set.isEmpty())
        {
            Pair x = set.first();
            set.remove(x);
           // out.println(x.y);
            ctr++;
            for(int v: adj[x.y])
            {
                if(edges[v]>0)
                {
                    set.remove(new Pair(edges[v],v));
                    edges[v]--;
                    edges[x.y]--;
                    if(edges[v]>0)
                        set.add(new Pair(edges[v],v));
                   // set.remove(v)
                }
            }
        }
        out.println(ctr);
        out.flush();
        out.close();
    }

/**
 *  ############################### Template ################################
 */
    
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[],inv[];
    public static int union[];
    public static class Pair {
        int x,y;
       
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int getFirst()
        {
            return x;
        }
        public int getSecond()
        {
            return y;
        }
    }
        public static class comp implements Comparator{
        @Override
        public int compare(Object p1, Object  p2) {
            Pair o1 = (Pair)p1;
            Pair o2 = (Pair)p2;
            
            if(o1.x == o2.x)
            {
                if(o1.y == o2.y)
                    return 0;
                else if(o1.y>o2.y)
                return 1;
            else 
                return -1;
            }
            else if(o1.x<o2.x)
                return 1;
            else 
                return -1;
              
            }
    }

   
    public static void init()
    {
        for(int i=0; i<union.length; i++)
            union[i] = i;
    }
    public static int find(int n)
    {
        return (union[n]==n)?n:(union[n]=find(union[n]));
    }
    public static void unionSet(int i ,int j)
    {
        union[find(i)]=find(j);
    }
    public static boolean connected(int i,int j)
    {   
        return union[i]==union[j];
    }

    public static long gcd(long a, long b) {
        long x = Math.min(a,b);
        long y = Math.max(a,b);
        while(x!=0)
        {
            long temp = x;
            x = y%x;
            y = temp;
        }
        return y;       
    }

    public static long modPow(long base, long exp, long mod) {
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }
            
        }
        return result;
    }
    
    public static void cal()
    {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0]=1;
        inv[0]=1;
        for(int i=1; i<=1000000; i++)
        {
            fac[i]=(fac[i-1]*i)%mod;
            inv[i]=(inv[i-1]*modPow(i,mod-2,mod))%mod;
        }
    }
    public static long ncr(int n, int r)
    {
        return (((fac[n]*inv[r])%mod)*inv[n-r])%mod;
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

