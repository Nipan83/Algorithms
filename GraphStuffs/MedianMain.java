/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
public class MedianMain {
    private Heap heapMin, heapMax;
    public MedianMain(int n)
    {
        heapMin = new Heap(n/2 +2);
        heapMax = new Heap(n/2 +2);
        
    }
    public void findMedian(int x)
    {
        int sizeMin = heapMin.currentSize();
        int sizeMax = heapMax.currentSize();
        int i=0,j=0;
        if(sizeMin == 0)
        {
            heapMin.insert(-1 * x);
        }
        else if(sizeMax == 0)
            heapMax.insert(x);
        else
        {
            if(x < -1*heapMin.peek())
            {
                
                if(sizeMin  <= sizeMax)
                {
                    heapMin.insert(-1*x);
                }
                else
                {
                    int y = -1*heapMin.minHeap();
                    heapMax.insert(y);
                    heapMin.insert(-1*x);
                }
            }
            else if(x > heapMax.peek())
            {
                if(sizeMax  <= sizeMin)
                {
                    heapMax.insert(x);
                }
                else
                {
                    int y = heapMax.minHeap();
                    heapMin.insert(-1*y);
                    heapMax.insert(x);
                }
            }
            else
            {
                if(sizeMax < sizeMin)
                    heapMax.insert(x);
                else 
                    heapMin.insert(-1*x);
            }
        }
        if(heapMin.currentSize() < heapMax.currentSize())
            System.out.print(heapMax.peek());
        else if(heapMin.currentSize() > heapMax.currentSize())
        {
            System.out.print(heapMin.peek()*-1);
        }
        else
        {
            System.out.print(heapMin.peek()*-1+ " " + heapMax.peek());
        }
            
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
       int  n = in.nextInt();
       int x;
       MedianMain median = new MedianMain(n);
        for(int i=0; i<n; i++)
        {
            x = in.nextInt();
            System.out.print("Median : ");
            median.findMedian(x);
            System.out.println();
        }
    }
}
