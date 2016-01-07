/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestuffs;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Sourav Kumar Paul
 */
class BST
{
    private Node root;
    private class Node
    {
        int data;
        Node left;
        Node right;
    }
    public BST()
    {
        root = null;
    }
    public void insert(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        root = insert(root, newNode);
    }
    private Node insert(Node root, Node newNode)
    {
        if(root == null)
            return newNode;
        if(root.data > newNode.data)
            root.left = insert(root.left, newNode);
        else
            root.right = insert(root.right, newNode);
        return root;
    }
    public void inorderTraversal()
    {
        inorderTraversal(root);
    }
    private void inorderTraversal(Node root)
    {
        if(root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public void leverlOrderTraversal()
    {
        levelOrderTraversal(root);
    }
    private void levelOrderTraversal(Node root)
    {
        Queue<Node> qu = new LinkedList<Node>();
        Node temp;// = root;
        qu.add(root);
        while(!qu.isEmpty())
        {
            temp = qu.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null)
                qu.add(temp.left);
            if(temp.right != null)
                qu.add(temp.right);
        }
    }
    
}
public class LevelOrderTraversal {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BST tree = new BST();
        tree.insert(6);
        tree.insert(5);
        tree.insert(10);
        tree.insert(2);
        tree.insert(13);
        tree.insert(7);
        tree.insert(3);
        tree.insert(144);
        tree.insert(3333);
        tree.insert(5585858);
        tree.leverlOrderTraversal();
    }
}
