package GraphTheory;

import java.io.*;
import java.util.*;

/**
 *
 * @author Sourav Kumar Paul (spaul100) NIT Silchar
 */
public class IOI2050 {

    public static ArrayList<Pax> adj[];
    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int test = in.nextInt();
        int t = 1;
        while (test-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            Pair edges[] = new Pair[m];
            for (int i = 0; i < m; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                long z = in.nextLong();
                edges[i] = new Pair(z, x, y);
            }
            Arrays.sort(edges);
            long floyd[][] = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(floyd[i], inf);
                floyd[i][i] = 0;
            }
  adj = new ArrayList[n];
            for(int i=0; i<n; i++)
                adj[i] = new ArrayList<>();
            union = new int[n];
            init();
            for (int i = 0; i < m; i++) {
                int x = edges[i].y;
                int y = edges[i].z;
                if (!connected(find(x), find(y))) {
                    unionSet(x, y);
                    //out.println(x+" aaaa "+y);
                    adj[x].add(new Pax(y,edges[i].x));
                    adj[y].add(new Pax(x,edges[i].x));

                }
            }
            djik(adj, n);
            out.println("Case: " + (t++));
            for (int i = 0; i < p; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                out.println(dd[x][y]);

            }
        }

        out.flush();
        out.close();
    }
    public static long dd[][];

    public static void djik(ArrayList<Pax> adj[], int V) {
        dd = new long[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dd[i], inf);
        }

        for (int i = 0; i < V; i++) {
            dj(i, adj, dd[i], V);
        }
    }

    private static void dj(int start, ArrayList<Pax> adj[], long[] dist, int n) {
        PriorityQueue<Pax> pq = new PriorityQueue<>();
        boolean marked[] = new boolean[n];
        //  marked[start] = true;
        dist[start] = 0;
        pq.add(new Pax(start, 0));
        int from[] = new int[n];
        from[start] = -1;
        while (!pq.isEmpty()) {
            Pax xx = pq.remove();
            if (marked[xx.x] == true) {
                continue;
            }
            marked[xx.x] = true;
            for (Pax node : adj[xx.x]) {
                int v = node.x;
               // if(!marked[v])
                // {
                visity(n, xx.x, node, pq, dist, from, adj);
                //    marked[v] = true;
                // }
            }

        }

      // System.out.println("ss s "+start+" "+Arrays.toString(dist));
    }

    private static void visity(int n, int u, Pax node, PriorityQueue<Pax> pq, long[] dist, int from[], ArrayList<Pax> adj[]) {

       // long xx = findSome(node.v, u, adj, new long[n],n);
        if (dist[u] + node.z < dist[node.x]) {
            dist[node.x] = dist[u] + node.z;
            pq.add(new Pax(node.x, dist[node.x]));
            from[node.x] = u;
        }
    }
    /**
     * ############################### Template ################################
     */
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[], inv[];
    public static int union[];

    public static class Pair implements Comparable {

        long x;
        int z, y;

        Pair(long x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Object o) {
            Pair pp = (Pair) o;
            if (pp.x == x) {
                return 0;
            } else if (x > pp.x) {
                return 1;
            } else {
                return -1;
            }
        }
    }
 public static class Pax implements Comparable {

        int x;
        long z;

        Pax(int x, long z) {
            this.x = x;
            
            this.z = z;
        }

        @Override
        public int compareTo(Object o) {
            Pax pp = (Pax) o;
            if (pp.z == z) {
                return 0;
            } else if (z > pp.z) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public static void init() {
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
    }

    public static int find(int n) {
        return (union[n] == n) ? n : (union[n] = find(union[n]));
    }

    public static void unionSet(int i, int j) {
        union[find(i)] = find(j);
    }

    public static boolean connected(int i, int j) {
        return union[i] == union[j];
    }

    public static long gcd(long a, long b) {
        long x = Math.min(a, b);
        long y = Math.max(a, b);
        while (x != 0) {
            long temp = x;
            x = y % x;
            y = temp;
        }
        return y;
    }

    public static long modPow(long base, long exp, long mod) {
        base = base % mod;
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
                exp--;
            } else {
                base = (base * base) % mod;
                exp = exp >> 1;
            }

        }
        return result;
    }

    public static void cal() {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
            inv[i] = (inv[i - 1] * modPow(i, mod - 2, mod)) % mod;
        }
    }

    public static long ncr(int n, int r) {
        return (((fac[n] * inv[r]) % mod) * inv[n - r]) % mod;
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

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
