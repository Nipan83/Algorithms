package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class PrimeNumbers {
    public static Queue<Long> qu;
    public static HashMap<Long,Long> can, dist,par;
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        long a = in.nextLong();
        long b = in.nextLong();
        qu = new LinkedList<>() ;
        can = new HashMap<>();
        dist = new HashMap<>();
        par = new HashMap<>();
        dist.put(a,0l);//.TRUE)
        can.put(a, 1l);
        prime = new HashMap<>();
        qu.add(a);
        while(qu.size() >0)
        {
            long v = qu.poll();
            test(v,v-2);
            test(v,v+2);
            test(v,2);
            test(v,b-2);
            test(v,b);
            test(v,b+2);
        }
        if(!can.containsKey(b))
            out.println("Unlucky Benny");
        else
        {
            ArrayList<Long> ans = new ArrayList<>();
            long v = b;
            while(v!=a)
            {
                ans.add(v);
                v = par.get(v);
                
            }
            ans.add(v);
            for(int i=ans.size()-1; i>=0; i--)
            {
                if(i==ans.size()-1)
                    out.print(ans.get(i));
                else
                    out.print("->"+ans.get(i));
            }
            out.println();
        }
      
        out.flush();
        out.close();
    }
      private static void test(long from, long key) {
       
          if(can.containsKey(key))
              return;
          if(!valid(from,key))
              return;
          can.put(key,1l);
          dist.put(key, dist.get(from)+1);
          par.put(key, from);
          qu.add(key);
      }
       private static boolean valid(long from, long key) {
        
           return (check(from) && check(key) && check(Math.abs(from-key)));
       }
       public static HashMap<Long,Boolean> prime;
        private static boolean check(long no) {
       
            if(prime.containsKey(no))
                return prime.get(no);
            
            if(no <2)
            {
                prime.put(no,false);//, Boolean.TRUE)
                return false;
            }
            for(long i=2; i*i<=no; i++)
            {
                if(no%i==0)
                {
                    prime.put(no,false);
                    return false;
                }
            }
            prime.put(no,true);
            return true;
            
        }


/**
 *  ############################### Template ################################
 */
    
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[],inv[];
    public static int union[];

   
   

  
    public static class Pair implements Comparable{
        int x,y;
       
        Pair(int x, int y)
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

