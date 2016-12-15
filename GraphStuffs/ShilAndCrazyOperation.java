package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class ShilAndCrazyOperation {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
        int n = in.nextInt();
        long t =in.nextLong();
       // t=2;
        int arr[] = new int[n+1];
        int pa[] = new int[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = in.nextInt();
        for(int i=1; i<=n; i++)
            pa[i] = in.nextInt();
       // out.println("pa "+Arrays.toString(pa));
        int size[] = new int[n+1];
        
        boolean marked[] = new boolean[n+1];
        ArrayList<Integer> list[] = new ArrayList[n];
        for(int i=0;i <n; i++)
            list[i] = new ArrayList<>();
        
        int ctr=0;
        int box[] = new int[n+1];
        int pos[] = new int[n+1];
        Arrays.fill(pos,-1);
      for(int i=1; i<=n; i++)
      {
          if(!marked[i])
          {
             // out.println("aa cdd "+ctr);
              sz = 0;
              dfs(i,pa,marked,size,list[ctr]);
              for(int j=0; j<list[ctr].size(); j++)
              {
                  
                  int xx = list[ctr].get(j);
                  size[xx] = sz;
                  pos[xx] = j;
                  box[xx] = ctr;
               //   out.println("aaa "+ctr+" "+xx);
              }
              ctr++;
          }
      }
     // out.println(Arrays.toString(pos));
    //  out.println(Arrays.toString(box));
    //  out.println(Arrays.toString(size));
      int ans[] = new int[n+1];
      for(int i=1; i<=n; i++)
      {
           int ss = size[i];
          int rem = (int)(t%(long)ss);
          int ps = (pos[i] + rem)%ss;
          int ac = list[box[i]].get(ps);
          ans[i] = arr[ac];
        //  out.println("sfsf"+ac);
         // ans[ac] = arr[i];
          
      }
      for(int i=1; i<=n; i++)
          out.print(ans[i]+" ");
        out.flush();
        out.close();
    }
    public static int sz;

     private static void dfs(int start, int[] pa, boolean[] marked, int[] size, ArrayList<Integer> list) {
     
         while(true)
         {
              marked[start] = true;
         list.add(start);
         sz++;
         if(!marked[pa[start]])
            start = pa[start];
         else 
             break;
      //   System.out.println(sz);
      //   size[start] = sz;
         }
             
         
         //System.out.println("dfsfs "+start+" "+pa[start]);
        
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

