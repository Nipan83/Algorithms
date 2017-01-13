import java.io.*;
import java.util.*;
 
 
class koko {
	private static InputReader in;
    public static void main(String args[]) throws Exception {
        in = new InputReader(System.in);
        int test = in.nextInt();
        for (int t = 0; t < test; t++) {
            int n = in.nextInt();
            Graph graph = new Graph(n);
            for (int i = 0; i < n - 1; i++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                int w = in.nextInt();
                graph.add(from, to, w);

            }
            int[] dis = new int[n];
            int maxIndexS = maxIndex(graph, 0, dis);
            dis = new int[n];
            int maxIndexE = maxIndex(graph, maxIndexS, dis);
            System.out.println(val(dis[maxIndexE]) + " " + dis[maxIndexE]);
        }
    }
 
 
    static class Graph{
        int v;
        ArrayList<ArrayList<Edge>> ar;
        public Graph(int v){
            this.v = v;
            ar = new ArrayList<>();
            for (int i = 0; i < v; i++){
                ar.add(new ArrayList<>());
            }
            System.out.println(ar);
        }
 
        public ArrayList<Edge> get(int v){
            return ar.get(v);
        }
 
        public void add(int from, int to, int w){
            Edge e = new Edge(from, to, w);
            //Edge r = new Edge(to, from, w);
            ar.get(from).add(e);
           // ar.get(to).add(r);
            System.out.println(ar);
        }
    }
 
    static class Edge{
        int from;
        int to;
        int w;
        public Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
 
    private static int val(int val) {
        if (val < 100)
            return 0;
        else if (val >= 100 && val <= 1000)
            return 100;
        else if (val >= 1000 && val <= 10000)
            return 1000;
 
        return 10000;
 
    }
 
    private static int maxIndex(Graph graph, int start, int[] dis) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.v];
        queue.add(start);
        isVisited[start] = true;
        int tap=queue.peek();
       // System.out.println(graph.get(tap).size());
     //   System.out.println(graph.get(tap).get(0).to+"aya");
        while (!queue.isEmpty()) {
            int first = queue.poll();
            for (int i = 0; i < graph.get(first).size(); i++) {
                if (graph.get(first).get(i).to != Integer.MAX_VALUE && !isVisited[graph.get(first).get(i).to]) {
                    isVisited[graph.get(first).get(i).to] = true;
                    queue.add(graph.get(first).get(i).to);
                    dis[graph.get(first).get(i).to] = dis[first] + graph.get(first).get(i).w;
                }
            }
        }
 
        int maxIndex = 0;
        int maxDistance = 0;
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] > maxDistance) {
                maxDistance = dis[i];
                maxIndex = i;
            }
        }
 
        return maxIndex;
    }
    
    
    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
 
        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLng() {
            return Long.parseLong(next());
        }
    }
}