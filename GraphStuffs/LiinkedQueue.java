/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphstuffs;

/**
 *
 * @author Sourav Kumar Paul
 */
public class LiinkedQueue {
    private Node first, last;
    
    public LiinkedQueue()
    {
        first = null;
        last = null;
        
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public void enqueue(int value)
    {
        Node old = last;
        last = new Node();
        last.data = value;
        last.next = null;
        
        if(isEmpty())
            first = last;
        else
        {
            old.next = last;
        }
        
    }
    
    public int dequeue()
    {
        int item = first.data;
        first = first.next;
        if(isEmpty())
            last = null;
        return item;
    }
    
}
