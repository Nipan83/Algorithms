package GraphTheory;

import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul (spaul100)
 * NIT Silchar    
 */

public class SomebodyIUsedToKnow {
    public static Pair dist[][];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       
      
        int n = in.nextInt();
        int m = in.nextInt();
        
        dist = new Pair[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                dist[i][j] = new Pair(0,0,inf);
            dist[i][i] = new Pair(0,0,0);
            
        }
        for(int i=0; i<m; i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            long d = in.nextLong();
            char c = in.next().charAt(0);
            if(c=='(')
            {
                dist[x][y] = new Pair(1,0,d);
                dist[y][x] = dist[x][y];
            }
            else
            {
                 dist[x][y] = new Pair(0,1,d);
                dist[y][x] = dist[x][y];
            }
            
        }
        distance(n);
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(dist[i][j].z >=inf)
                        out.print(-1+" ");
                    else if()
                        out.print(dist[i][j].z+" ");
                }
                out.println();
            }
        out.flush();
        out.close();
    }
     private static void distance(int n ) {
      
         for(int k=0; k<n; k++)
         {
             for(int i=0; i<n; i++)
             {
                 for(int j=0; j<n; j++)
                 {
                     if(dist[i][k].x + dist[k][j].x >= dist[i][k].y + dist[k][j].y)
                     {
                        if(dist[i][k].z + dist[k][j].z < dist[i][j].z)
                         {
                            dist[i][j].z = dist[i][k].z + dist[k][j].z;
                      
                             dist[i][j].x = dist[i][k].x + dist[k][j].x;
                             dist[i][j].y = dist[i][k].y + dist[k][j].y;
                         }
                        else if(dist[i][k].z + dist[k][j].z == dist[i][j].z)
                        {
                            if(dist[i][k].x + dist[k][j].x - dist[i][k].y - dist[k][j].y > (dist[i][j].x - dist[i][j].y))
                            {
                                 dist[i][j].z = dist[i][k].z + dist[k][j].z;
                      
                             dist[i][j].x = dist[i][k].x + dist[k][j].x;
                             dist[i][j].y = dist[i][k].y + dist[k][j].y;
                            }
                        }
                         
                     }
                 }
             }
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
        long z;
       
        Pair(int x, int y, long z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
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

