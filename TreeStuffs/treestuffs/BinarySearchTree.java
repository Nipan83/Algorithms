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
class Node {

    int data;
    Node left, right;
}

public class BinarySearchTree {

    private Node root;
    private int size,height;
    public BinarySearchTree() {
        root = null;
        size = -1;
        height = -1;
    }

    public void insert(int key) {
        Node newNode = new Node();
        newNode.data = key;
        newNode.left = null;
        newNode.right = null;

        root = insertion(root, newNode);
    }

    private Node insertion(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.data < root.data) {
            root.left = insertion(root.left, newNode);
        } else {
            root.right = insertion(root.right, newNode);
        }
        return root;
    }

    public void delete(int key) {
        root = deletion(root, key);
    }

    private Node deletion(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            root.left = deletion(root.left, key);
        } else if (root.data < key) {
            root.right = deletion(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node predd = findMax(root.left);
            root.data = predd.data;
            root.left = deletion(root.left, predd.data);
        }
        return root;
    }
    
   
    public int size(Node root)
    {
        if(root == null)
            return 0;
        return 1+ size(root.left) + size(root.right);
    }
    
    public int height()
    {
        height =0;
     findHeight(root,0);  
     return height;
    }
    
    private void findHeight(Node root, int ctr)
    {
        if(root == null)
            return ;
        if(ctr > height)
            height = ctr;
        findHeight(root.left, ctr+1);
        findHeight(root.right, ctr+1);
    }
    
    public int select(int i)
    {
        return selectIth(root, i);
    }
    private int selectIth(Node root, int i)
    {
        if(root == null)
            return -1;
        int x = size(root.left);
       // int y = size(root.right);
        
        if( i== x+1)
            return root.data;
        if(i <= x)
            return selectIth(root.left, i);
        if( i> (x+1))
            return selectIth(root.right, i-(x+1));
        return -1;
        
    }
    
    public void inorder() {

        inorderTraversal(root);
        System.out.println();
    }

    public void preorder() {

        preorderTraversal(root);
        System.out.println();
    }

    public void postOrder() {
        postorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");

        }
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

    }

    public Node findPred(Node root) {

        while (root.right != null) {
            root = root.right;
        }
        return root;

    }
    
    public Node findMin(Node root)
    {
        while(root.left != null)
            root = root.left;
        return root;
    }
    public Node findMax(Node root)
    {
        while(root.right != null)
            root = root.right;
        return root;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(8);
        bst.insert(6);
        bst.insert(2);
        System.out.println("Preorder Traversal :");
        bst.preorder();
        System.out.println("Inorder Traversal :");
        bst.inorder();
        System.out.println("PostOrder Traversal :");
        bst.postOrder();
        
        System.out.println("Select 1:"+ bst.select(1));
         System.out.println("Select 5:"+ bst.select(5));
          System.out.println("Select 7:"+ bst.select(7));
           System.out.println("Select 99:"+ bst.select(99));
            System.out.println("Select 0:"+ bst.select(0));
        System.out.println("Height of bst :"+ bst.height());
        bst.delete(3);
        System.out.println("After Deletion Preorder Traversal :");
        bst.preorder();
        System.out.println("Inorder Traversal :");
        bst.inorder();
        System.out.println("PostOrder Traversal :");
        bst.postOrder();
       System.out.println("Height of bst :"+ bst.height());
        System.out.println("Select 7:"+ bst.select(7));
           System.out.println("Select 99:"+ bst.select(99));
            System.out.println("Select 0:"+ bst.select(0));
       

    }
}
