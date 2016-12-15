package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class XennyAndTravel {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        int rail[][] = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                rail[i][j] = in.nextInt();
        }
        
        int bus[][] = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                bus[i][j] = in.nextInt();
            
        }
        rd = new long[n];
        Arrays.fill(rd,inf);
        bd = new long[n];
        Arrays.fill(bd, inf);
        
        int u = in.nextInt()-1;
        int v = in.nextInt()-1;
        dj(rd,rail,u);
        int temp[][] = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                temp[i][j] = bus[j][i];
            }
        }
        dj(bd,temp,v);
      //  out.println(Arrays.toString(rd));
       // out.println(Arrays.toString(bd));
        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            if(u==i || v==i)
                continue;
            ans = Math.min(ans, rd[i]+ bd[i]);
        }
      
        Arrays.fill(rd,inf);
        Arrays.fill(bd,inf);
        dj(rd,bus,u);
        temp = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                temp[i][j] = rail[j][i];
            }
        }
        dj(bd,temp,v);
        for(int i=0; i<n; i++)
        {
            if(u==i || v==i)
                continue;
            ans = Math.min(ans, rd[i]+ bd[i]);
        }
        out.println(ans);
        out.flush();
        out.close();
    }
    private static void dj(long[] rd, int[][] rail, int start) {
     
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,start));
        rd[start] = 0;
        int n = rail.length;
        boolean marked [] = new boolean[n];
        while(!pq.isEmpty())
        {
            int v= pq.poll().y;
             marked[v] = true;
       
            for(int i=0; i<rail[v].length; i++)
            {
                if(!marked[i])
                    visit(v,i,pq,rail[v][i],rd);
            }
        }
    }
 private static void visit(int v, int i, PriorityQueue<Pair> pq, long dd, long[] rd) {
      
     if(dd + rd[v] < rd[i])
     {
         rd[i] = dd + rd[v];
         pq.add(new Pair(rd[i],i));
     }
 }
    public static long rd[], bd[];
/**
 *  ############################### Template ################################
 */
    
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[],inv[];
    public static int union[];

   

    
    public static class Pair implements Comparable{
        long x;
        int y;
       
        Pair(long x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Object o)
        {
            Pair pp = (Pair)o;
            if(pp.x == x)
                return 0;
            else if (x>pp.x)
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

