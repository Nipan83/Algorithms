package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class EfficientNetwork {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        int m = in.nextInt();
        
       Pair pairs[] = new Pair[m];
        for(int i=0; i<m; i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            int z = in.nextInt();
            pairs[i]= new Pair(x,y,z);
        }
        Arrays.sort(pairs);
        union = new int[n];
        init();
        ArrayList<Integer> list = new ArrayList<>();
        int q = in.nextInt();
        for(int i=0; i<q; i++)
        {
            list.add(in.nextInt());
        }
        Collections.sort(list);
        int ctr = 0;
        long ans = 0;
       // out.println(Arrays.toString(union));
     
        for(int i=0; i<m; i++)
        {
            int z = pairs[i].z;
            int x = pairs[i].x;
            int y = pairs[i].y;
            if(connected(x, y))
            {
                continue;
            }
            else
            {
                unionSet(x, y);
                list.add(z);
            }
            
          //  out.println(x+" "+y+" "+ans);
          //  out.println(Arrays.toString(union));
        }
        Collections.sort(list);
        for(int i=0; i<n-1; i++)
            ans += list.get(i);
        out.println(ans);
        out.flush();
        out.close();
    }

/**
 *  ############################### Template ################################
 */
    
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[],inv[];
    public static int union[];
    public static class Pair implements Comparable, Comparator{
        int x,y,z;
       
        Pair(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        Pair()
        {
            
        }
        @Override
        public int compareTo(Object o)
        {
            Pair pp = (Pair)o;
            if(pp.z == z)
                return 0;
            else if (z>pp.z)
                return 1;
            else 
                return -1;
        }

        @Override
        public int compare(Object o1, Object o2) {
           Pair p1 = (Pair)o1;
           Pair p2 = (Pair)o2;
           if(p1.x == p2.x)
           {
               if(p1.y == p2.y)
                   return 0;
               else if(p1.y>p2.y)
                   return 1;
               else
                   return -1;
           }
           else if(p1.x> p2.x)
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
        int x = find(i);
        int y = find(j);
        union[x]=y;
      //  union[y] = y;
    }
    public static boolean connected(int i,int j)
    {   int x = find(i);
        int y = find(j);
        return union[x]==union[y];
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

