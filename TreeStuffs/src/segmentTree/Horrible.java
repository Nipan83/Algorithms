package segmentTree;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sourav Kumar Paul
 */
public class Horrible {

    private long   segTree[], lazy[];
    private int size, sizeArray;

    public Horrible(int n) {
        int x = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        size = 2 * x - 1;
        segTree = new long[2 * x - 1];
        lazy = new long[size];
        for(int i=0; i< size; i++)
            lazy[i] = 0;
        sizeArray = n;
    }

    public void constructTree(int input[]) {
        constructTree(input, 0, sizeArray - 1, 0);
    }

    private void constructTree(int input[], int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructTree(input, low, mid, 2 * pos + 1);
        constructTree(input, mid + 1, high, 2 * pos + 2);
        segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];
    }

    public void addUpdate(int input[], int qlow, int qhigh, long delta) {
        addUpdate(input, qlow, qhigh, 0, sizeArray - 1, delta, 0);
    }

    private void addUpdate(int input[], int qlow, int qhigh, int low, int high, long delta, int pos) {
        if (low > high) {
            return;
        }

        if (lazy[pos] != 0) {
            segTree[pos] += (high - low + 1) * lazy[pos];
            if (low != high) {
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        if (qlow > high || qhigh < low) {
            return;
        }
        if (qlow <= low && qhigh >= high) {
            segTree[pos] += (high - low + 1) * delta;
            if (low != high) {
                lazy[2 * pos + 1] += delta;
                lazy[2 * pos + 2] += delta;
            }
            return;
        }

        int mid = (low + high) / 2;
        addUpdate(input, qlow, qhigh, low, mid, delta, 2 * pos + 1);
        addUpdate(input, qlow, qhigh, mid + 1, high, delta, 2 * pos + 2);
        segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];

    }

    public long querySum(int input[], int qlow, int qhigh) {
        return querySum(input, qlow, qhigh, 0, sizeArray - 1, 0);
    }

    private long querySum(int input[], int qlow, int qhigh, int low, int high, int pos) {
        if (low > high) {
            return 0;
        }

        if (lazy[pos] != 0) {
            segTree[pos] += (high - low + 1) * lazy[pos];
            if (low != high) {
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        if (qlow > high || qhigh < low) {
            return 0;
        }
        if (qlow <= low && qhigh >= high) {
            return segTree[pos];
        }
        int mid = (low + high) / 2;
        return (querySum(input, qlow, qhigh, low, mid, 2 * pos + 1) + querySum(input, qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt(), n, q, c, p; long v;
        in.nextLine();
        String line[];
        for (int t = 0; t < test; t++) {
            line = in.nextLine().split(" ");
            n = Integer.parseInt(line[0]);
            Horrible segment = new Horrible(n);
            int input[] = new int[n];
            for(int i=0; i<n; i++)
                input[i] =0;
            segment.constructTree(input);
            c = Integer.parseInt(line[1]);
            for (int i = 0; i < c; i++) {
                line = in.nextLine().split(" ");
                switch (Integer.parseInt(line[0])) {
                    case 0:
                        p = Integer.parseInt(line[1]);
                        q = Integer.parseInt(line[2]);
                        v = Long.parseLong(line[3]);
                        segment.addUpdate(input, p - 1, q - 1, v);
                        break;
                    case 1:
                        p = Integer.parseInt(line[1]);
                        q = Integer.parseInt(line[2]);
                        System.out.println(segment.querySum(input, p - 1, q - 1));
                        break;
                }

            }

        }
    }
}
