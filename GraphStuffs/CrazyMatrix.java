package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class CrazyMatrix {
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
      
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr[i][j] = in.nextInt();
            }
        }
        boolean top[][] = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            if(arr[0][i] == 1)
                top[0][i] = true;
        }
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(arr[i][j] != 1)
                    continue;
                top[i][j] |= top[i-1][j];
                if(j-1>=0)
                    top[i][j] |= top[i-1][j-1];
                if(j+1<n)
                    top[i][j] |= top[i-1][j+1];
            }
            for(int j=0; j<n; j++)
            {
                if(top[i][j] != true)
                    continue;
                checkTop(top,arr,i,j,n);
            }
        }
        int ll = 0;
        for(int i=0; i<n; i++)
            if(top[n-1][i])
            {
                ll = 1;
                break;
            }
       boolean bot[][] = new boolean[n][n];
       for(int i=0; i<n; i++)
        {
            if(arr[i][0] == 2)
                bot[i][0] = true;
        }
        for(int j=1; j<n; j++)
        {
            for(int i=0; i<n; i++)
            {
                if(arr[i][j] != 2)
                    continue;
                bot[i][j] |= bot[i][j-1];
                if(i-1>=0)
                    bot[i][j] |= bot[i-1][j-1];
                if(i+1<n)
                    bot[i][j] |= bot[i+1][j-1];
            }
            for(int i=0; i<n; i++)
            {
                if(bot[i][j] != true)
                    continue;
                checkBot(bot,arr,i,j,n);
            }
        }
        int rr = 0;
        for(int i=0; i<n; i++)
            if(bot[i][n-1])
            {
                rr = 1;
                break;
            }
        if(ll==1 && rr==1)
        {
            out.println("AMBIGUOUS");
        }
        else if(ll==1)
            out.println(1);
        else if(rr==1)
            out.println(2);
        else
            out.println(0);
        out.flush();
        out.close();
    }
    private static void checkTop(boolean[][] top, int[][] arr, int x, int y, int n) {
      
        for(int i=y; i>=0; i--)
        {
            if(i-1>=0 && arr[x][i-1]==1)
                top[x][i-1] |= top[x][i];
            if(i+1<n && arr[x][i+1] == 1)
                top[x][i+1] |= top[x][i];
        }
        for(int i=y; i<n; i++)
        {
            if(i-1>=0 && arr[x][i-1]==1)
                top[x][i-1] |= top[x][i];
            if(i+1<n && arr[x][i+1] == 1)
                top[x][i+1] |= top[x][i];
        }
    }
     private static void checkBot(boolean[][] bot, int[][] arr, int x, int y, int n) {
      for(int i=x; i>=0; i--)
        {
            if(i-1>=0 && arr[i-1][y]==2)
                bot[i-1][y] |= bot[i][y];
            if(i+1<n && arr[i+1][y] == 2)
                bot[i+1][y] |= bot[i][y];
        }
      for(int i=x; i<n; i++)
      {
          if(i-1>=0 && arr[i-1][y]==2)
                bot[i-1][y] |= bot[i][y];
            if(i+1<n && arr[i+1][y] == 2)
                bot[i+1][y] |= bot[i][y];
      }
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

