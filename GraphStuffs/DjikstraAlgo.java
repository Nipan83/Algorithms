/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
class Directed1Edge {

    private int to;
    private int from;
    private double weight;

    public Directed1Edge(int to, int from, double weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    public int to() {
        return to;
    }

    public int from() {
        return from;
    }

    public double weight() {
        return weight;
    }
}

class DirectedWeighGraph {

    private int v;
    private ArrayList<Directed1Edge> adj[];

    public DirectedWeighGraph(int n) {
        this.v = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Directed1Edge>();
        }
    }

    public void add(int v, int w, double weig) {
        Directed1Edge edge = new Directed1Edge(v, w, weig);
        adj[v].add(edge);
    }

    public int vertices() {
        return v;

    }

    public ArrayList adj(int v) {
        return adj[v];
    }
}

class Min1PQ {

    private int array[];
    private int loc[];
    int ptr;

    public Min1PQ(int n) {
        array = new int[n];
        loc = new int[n];
        ptr = 0;
    }

    public void add(int x, double distTo[]) {
        array[ptr] = x;
        loc[x] = ptr;
        int i = ptr;
        ptr++;
        int j;
        while (i > 0) {
            j = (i - 1) / 2;
            if (distTo[array[i]] > distTo[array[j]]) {
                break;
            }
            int temp = i;
            loc[array[i]] = j;
            loc[array[j]] = temp;
            swap(i, j, array);
            i = j;

        }
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public int delete(double distTo[]) {
        int x = array[0];
        array[0] = array[ptr - 1];
        loc[array[ptr - 1]] = 0;
        ptr--;
        int i = 0;
        int j;
        while (2 * i + 2 < ptr) {
            if (distTo[array[2 * i + 1]] < distTo[array[2 * i + 2]]) {
                j = 2 * i + 1;
            } else {
                j = 2 * i + 2;
            }
            if (distTo[array[i]] < distTo[array[j]]) {
                break;
            }
            int temp = i;
            loc[array[i]] = j;
            loc[array[j]] = temp;
            swap(i, j, array);
            i = j;
        }
        if (2 * i + 1 < ptr) {
            if (distTo[array[i]] > distTo[array[2 * i + 1]]) {
                int temp = i;
                loc[array[i]] = 2 * i + 1;
                loc[array[2 * i + 1]] = temp;
                swap(i, 2 * i + 1, array);
            }
        }
        return x;
    }

    public void decreaseKey(int x, double distTo[]) {
        int i = loc[x];
        int j;
        while (i > 0) {
            j = (i - 1) / 2;
            if (distTo[array[i]] > distTo[array[j]]) {
                break;
            }
            int temp = i;
            loc[array[i]] = j;
            loc[array[j]] = temp;
            swap(i, j, array);
            i = j;
        }
    }

    public static void swap(int i, int j, int array[]) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }
}

public class DjikstraAlgo {

    private Min1PQ prior;
    private double distTo[];
    private Directed1Edge edgeTo[];

    public DjikstraAlgo(DirectedWeighGraph graph) {
        distTo = new double[graph.vertices()];
        edgeTo = new Directed1Edge[graph.vertices()];
        prior = new Min1PQ(graph.vertices());
        for (int i = 0; i < graph.vertices(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            prior.add(i, distTo);
        }
        distTo[0] = 0;
        prior.decreaseKey(0, distTo);

        while (!prior.isEmpty()) {
            int u = prior.delete(distTo);
            for (Object e : graph.adj(u)) {
                Directed1Edge edge = (Directed1Edge) e;
                relax(edge);
            }
        }
        for (int i = 0; i < graph.vertices(); i++) {
            System.out.print(distTo[i] + " ");
        }
    }

    private void relax(Directed1Edge edge) {
        int from = edge.from();
        int to = edge.to();
        double weight = edge.weight();
        if (distTo[to] > distTo[from] + weight) {
            distTo[to] = distTo[from] + weight;
            prior.decreaseKey(to, distTo);
            edgeTo[to] = edge;

        }

    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        DirectedWeighGraph graph = new DirectedWeighGraph(n);
        while (true) {

            String line[] = in.nextLine().split(" ");
            if (line[0].equals("-1")) {
                break;
            }
            graph.add(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Double.parseDouble(line[2]));

        }

        System.out.println("Directed Graph is : ");
        for (int i = 0; i < graph.vertices(); i++) {
            System.out.print("\n" + i + " -> ");
            for (Object j : graph.adj(i)) {
                Directed1Edge edge = (Directed1Edge) j;
                System.out.print(edge.to() + " ");
            }
        }

        DjikstraAlgo dj = new DjikstraAlgo(graph);
    }
}
