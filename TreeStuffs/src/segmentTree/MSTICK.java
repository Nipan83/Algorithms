/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmentTree;

import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
public class MSTICK {
     private long maxTree[], minTree[];
    private int size, sizeArray;

    public MSTICK(int n) {
        int x = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        size = 2 * x - 1;
        maxTree = new long[2 * x - 1];
        minTree = new long[size];
        
        sizeArray = n;
    }
    public void constructMinTree(int input[]) {
        constructMinTree(input, 0, input.length - 1, 0);
    }

    private void constructMinTree(int input[], int low, int high, int pos) {
        if (low == high) {
            minTree[pos] = input[low];

            return;
        }
        int mid = (high + low) / 2;
        constructMinTree(input, low, mid, 2 * pos + 1);
        constructMinTree(input, mid + 1, high, 2 * pos + 2);
        minTree[pos] = min(minTree[2 * pos + 1], minTree[2 * pos + 2]);

    }
    
    public void constructMaxTree(int input[]) {
        constructMaxTree(input, 0, input.length - 1, 0);
    }

    private void constructMaxTree(int input[], int low, int high, int pos) {
        if (low == high) {
            maxTree[pos] = input[low];

            return;
        }
        int mid = (high + low) / 2;
        constructMaxTree(input, low, mid, 2 * pos + 1);
        constructMaxTree(input, mid + 1, high, 2 * pos + 2);
        maxTree[pos] = max(maxTree[2 * pos + 1], maxTree[2 * pos + 2]);

    }
    
     public long rangeMinQuery(int low, int high) {
        return rangeMinQuery(low, high, 0, sizeArray - 1, 0);
    }

    private long rangeMinQuery(int qlow, int qhigh, int low, int high, int pos) {
       if(low > high)
           return Integer.MAX_VALUE;
        
        if (qlow <= low && qhigh >= high) {
            return minTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return min(rangeMinQuery(qlow, qhigh, low, mid, 2 * pos + 1), rangeMinQuery(qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }
    
    public long rangeMaxQuery(int low, int high) {
        return rangeMaxQuery(low, high, 0, sizeArray - 1, 0);
    }

    private long rangeMaxQuery(int qlow, int qhigh, int low, int high, int pos) {
        if(low > high)
           return Integer.MIN_VALUE;
        if (qlow <= low && qhigh >= high) {
            return maxTree[pos];
        }
        if (qlow > high || qhigh < low) {
            return Integer.MIN_VALUE;
        }
        int mid = (low + high) / 2;
        return max(rangeMaxQuery(qlow, qhigh, low, mid, 2 * pos + 1), rangeMaxQuery(qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int input[] = new int[n];
        for(int i=0; i<n; i++)
            input[i] = in.nextInt();
        in.nextLine();
        MSTICK segment = new MSTICK(n);
        segment.constructMaxTree(input);
        segment.constructMinTree(input);
        int q = in.nextInt();
        
        int l,r;
        long min, max1, max2, max3;long maxOuter,ans;
        long maxInner;
        for(int i=0; i< q; i++)
        {
           in.nextLine();
           l = in.nextInt();
           r = in.nextInt();
           min = segment.rangeMinQuery(l,r);
           max1 = segment.rangeMaxQuery(l, r);
           max2 = segment.rangeMaxQuery(0,l-1);
           max3 = segment.rangeMaxQuery(r+1,n-1);
           maxOuter = (max(max2, max3) + min);
           maxInner = min + (max1 - min)/2;
           ans = max(maxOuter,maxInner);
           if( ans == maxInner)
               if((max1-min) % 2 == 1)
                  System.out.println(ans+".5");
               else
                   System.out.println(ans+".0");
           else
                   System.out.println(ans+".0");
           
        }
        
    }

    private static double max(double maxOuter, double maxInner) {
        if(maxOuter > maxInner)
            return maxOuter;
        else
           return maxInner;
    }
    private static long max(long maxOuter, long maxInner) {
        if(maxOuter > maxInner)
            return maxOuter;
        else
           return maxInner;
    }
    private long min(long minTree, long minTree0) {
        if(minTree < minTree0)
            return minTree;
        else
            return minTree0;
    }
}
