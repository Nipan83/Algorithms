/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestuffs;

import java.util.Scanner;

/**
 *
 * @author Sourav Kumar Paul
 */
public class RWayTrie {
    private static final int R = 256;
    private Node root = new Node();
    private static class Node
    {
        int value;
        Node next[] = new Node[R];
    }
    public void put(String key, int value)
    {
        root = put(root, key, value, 0);
    }
    private Node put(Node root, String key, int value, int d)
    {
        if(root == null)
        {
            root = new Node();
            root.value = -1;
        }
        
        if(d == key.length())
        {
            root.value = value;
            return root;
            
        }
        int c = key.charAt(d);
        
        root.next[c] = put(root.next[c], key, value, d+1);
        return root;
        
    }
    public boolean contains(String key)
    {
        return get(root, key, 0) != null;
    }
    
    private Node get(Node root,String key, int d)
    {
        if(root == null)
            return null;
        if(key.length() == d)
            return root;
        int c = key.charAt(d);
        return get(root.next[c], key, d+1);
        
    }
    public int getValue(String key)
    {
        Node x = get(root, key, 0);
        if(x == null)
            return -1;
        else
            return x.value;
    }
    public void delete(String key)
    {
        root = delete(root, key, 0);
    }
    private Node delete(Node root, String key, int d)
    {
        if(root == null)
        {
            return null;
        }
        if(d == key.length())
        {
            root.value = -1;
            for(int i=0; i<256; i++)
              if(root.next[i] != null)
                  return root;
            return null;
            
        }
        char c = key.charAt(d);
        root.next[c] = delete(root.next[c], key, d+1);
        if(root.value != -1)
            return root;
        for(int i=0; i<256; i++)
              if(root.next[i] != null)
                  return root;
        return null;
    }
    public static void main(String[] args)
    {
        RWayTrie trie = new RWayTrie();
        Scanner in = new Scanner(System.in);
        String line;
        int ctr=0;
        while(true)
        {
            line = in.nextLine();
            if(line.equals("-1"))
                break;
            trie.put(line,ctr++);
        }
        System.out.println("Now find strings:");
        while(true)
        {
            line = in.nextLine();
            if(line.equals("-1"))
                break;
            System.out.println(trie.getValue(line));
        }
        
        System.out.println("Lets delete some things:");
        while(true)
        {
            line = in.nextLine();
            if(line.equals("-1"))
                break;
            trie.delete(line);
        }
          System.out.println("Now find strings:");
        while(true)
        {
            line = in.nextLine();
            if(line.equals("-1"))
                break;
            System.out.println(trie.getValue(line));
        }
    }
}
