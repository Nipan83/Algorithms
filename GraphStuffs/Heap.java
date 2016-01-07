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
public class Heap {
    private int size;
    private int ptr;
    int array[];
    public Heap(int n)
    {   size = n;
        array = new int[n];
        ptr = 0;
        
    }
    public void insert(int x)
    {
        array[ptr] = x;
        int i = ptr, j;
        ptr++;
        
        while(i>0)
        {
            if(i%2==0)
               j = i/2 -1;
            else j = i/2;
            
            if(array[j] < array[i])
                break;
            swap(array, i ,j);
            i = j;
        }
    }
    public int currentSize()
    {
        return ptr;
    }
    public int peek()
    {
        return array[0];
    }
    public int minHeap()
    {
        int x = array[0];
        
        if(ptr == 0)
            return -1;
        swap(array, ptr-1, 0);
        ptr--;
        int i=0;
        
        while((2*i+2)<ptr)
        {
            int j = min(array,2*i+1, 2*i+2);
            if(array[j] < array[i])
            {
                swap(array,i,j);
                i = j;
            }
            else break;
                  
        }
        if((2*i+1)<ptr)
        {
             if(array[2*i+1] < array[i])
            {
                swap(array,i,2*i+1);
               
            }
        }
        
        
        return x;
    }
    public void show()
    {
        for(int i=0; i<ptr; i++)
            System.out.print(array[i] + " ");
    }
    public static void swap(int array[] , int i, int j)
    {
        int x = array[i];
        array[i] =array[j];
        array[j] =x;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter no of numbers:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),x;
        in.nextLine();
        Heap heap = new Heap(n);
        for(int i=0;i<n; i++)
        {
            x = in.nextInt();
            heap.insert(x);
        }
        heap.show();
        System.out.println();
        for(int i=0; i<n; i++)
            System.out.print(heap.minHeap()+ " ");
               
        heap.show();
        
    }

    private int min(int[] array, int i, int i0) {
    if(array[i] < array[i0])
        return i;
    else return i0;
    }
}
