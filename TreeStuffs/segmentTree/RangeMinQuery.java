/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestuffs;

/**
 *
 * @author Sourav Kumar Paul
 */
public class RangeMinQuery {

    private int segTree[], lazy[];
    private int size, sizeArray;

    public RangeMinQuery(int n) {
        int x = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        size = 2 * x - 1;
        segTree = new int[2 * x - 1];
        lazy = new int[size];
        sizeArray = n;
    }

    public void constructTree(int input[]) {
        constructTree(input, 0, input.length - 1, 0);
    }

    private void constructTree(int input[], int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = input[low];

            return;
        }
        int mid = (high + low) / 2;
        constructTree(input, low, mid, 2 * pos + 1);
        constructTree(input, mid + 1, high, 2 * pos + 2);
        segTree[pos] = min(segTree[2 * pos + 1], segTree[2 * pos + 2]);

    }

    public int rangeMinQueryLazy(int low, int high) {
        return rangeMinQueryLazy(low, high, 0, sizeArray - 1, 0);

    }

    private int rangeMinQueryLazy(int qlow, int qhigh, int low, int high, int pos) {
        if(low > high)
            return Integer.MAX_VALUE;
        
        if(lazy[pos] != 0)
        {
            segTree[pos] += lazy[pos];
            if(low != high)
            {
                lazy[2*pos+1] += lazy[pos];
                lazy[2*pos+2] += lazy[pos];
            }
            lazy[pos] = 0;
        }
        
        if(qlow > high || qhigh < low)
            return Integer.MAX_VALUE;
        if(qlow <= low && qhigh >= high)
            return segTree[pos];
        
        int mid = (low + high)/2;
         return min(rangeMinQueryLazy(qlow, qhigh, low, mid, 2 * pos + 1), rangeMinQueryLazy(qlow, qhigh, mid + 1, high, 2 * pos + 2));
   
    }

    public int rangeMinQuery(int low, int high) {
        return rangeMinQuery(low, high, 0, sizeArray - 1, 0);
    }

    private int rangeMinQuery(int qlow, int qhigh, int low, int high, int pos) {
        if (qlow <= low && qhigh >= high) {
            return segTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return min(rangeMinQuery(qlow, qhigh, low, mid, 2 * pos + 1), rangeMinQuery(qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }

    private int min(int segTree, int segTree0) {
        if (segTree < segTree0) {
            return segTree;
        } else {
            return segTree0;
        }
    }

    public void updateSegmentTree(int input[], int index, int delta) {
        input[index] += delta;
        updateSegmentTree(input, index, 0, input.length - 1, delta, 0);
    }

    private void updateSegmentTree(int input[], int index, int low, int high, int delta, int pos) {
        if (index < low || index > high) {
            return;
        }
        if (low == high) {
            System.out.println("pos" + pos);
            segTree[pos] += delta;
            return;
        }
        int mid = (low + high) / 2;
        updateSegmentTree(input, index, low, mid, delta, 2 * pos + 1);
        updateSegmentTree(input, index, mid + 1, high, delta, 2 * pos + 2);
        segTree[pos] = min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }

    public void updateSegmentTreeRangeLazy(int input[], int startRange, int endRange, int delta) {
        updateSegmentTreeRangeLazy(input, startRange, endRange, 0, input.length - 1, delta, 0);
    }

    private void updateSegmentTreeRangeLazy(int input[], int startRange, int endRange, int low, int high, int delta, int pos) {
        if (low > high) {
            return;
        }

        if (lazy[pos] != 0) {
            segTree[pos] += lazy[pos];
            if (low != high) {
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        if (startRange > high || endRange < low) // no overlap
        {
            return;
        }
        if (startRange <= low && endRange >= high) {
            segTree[pos] += delta;
            if (low != high) {
                lazy[2 * pos + 1] += delta;
                lazy[2 * pos + 2] += delta;
            }
            return;
        }
        int mid = (low + high) / 2;
        updateSegmentTreeRangeLazy(input, startRange, endRange, low, mid, delta, 2 * pos + 1);
        updateSegmentTreeRangeLazy(input, startRange, endRange, mid + 1, high, delta, 2 * pos + 2);
        segTree[pos] = min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }

    public void updateSegmentTreeRange(int input[], int startRange, int endRange, int delta) {
        for (int i = startRange; i <= endRange; i++) {
            input[i] += delta;
        }
        updateSegmentTreeRange(input, startRange, endRange, 0, input.length - 1, delta, 0);
    }

    private void updateSegmentTreeRange(int input[], int startRange, int endRange, int low, int high, int delta, int pos) {
        if (startRange > high || endRange < low) {
            return;
        }
        if (low == high) {
            segTree[pos] += delta;
            return;
        }
        int mid = (low + high) / 2;
        updateSegmentTreeRange(input, startRange, endRange, low, mid, delta, 2 * pos + 1);
        updateSegmentTreeRange(input, startRange, endRange, mid + 1, high, delta, 2 * pos + 2);
        segTree[pos] = min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }

    public void printSegTree() {
        for (int i = 0; i < size; i++) {
            System.out.print(segTree[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = {-1, 2, 4, 0};

        RangeMinQuery segmentTree = new RangeMinQuery(array.length);
        segmentTree.constructTree(array);
        segmentTree.printSegTree();
        System.out.println();
       

        segmentTree.updateSegmentTreeRangeLazy(array, 1, 3, 3);
        System.out.println();
        segmentTree.printSegTree();
        segmentTree.updateSegmentTreeRangeLazy(array, 0, 2, 2);
        System.out.println();
        segmentTree.printSegTree();
        System.out.println(segmentTree.rangeMinQueryLazy(0, 2));
        System.out.println(segmentTree.rangeMinQueryLazy(0, 0));
        System.out.println();
        segmentTree.printSegTree();
    }

}
