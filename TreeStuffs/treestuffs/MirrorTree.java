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
class TreeNode {
    int data;
    TreeNode left, right;
}

public class MirrorTree {
    TreeNode root;
    public MirrorTree()
    {
        root = null;
    }
    public void insert(int value)
    {
        TreeNode node = new TreeNode();
        node.data = value;
        node.left = null;
        node.right = null;
        root = insertion(root, node);
    }
    private TreeNode insertion(TreeNode root, TreeNode newNode)
    {
        if(root == null)
            return newNode;
        if(root.data > newNode.data)
            root.left = insertion(root.left, newNode);
        else
            root.right = insertion(root.right, newNode);
        return root;
       
    }
    public void inorderTraversal()
    {
        
        inTraversal(root);
        System.out.println();
    }
    private void inTraversal(TreeNode root)
    {
        if(root == null)
            return;
        inTraversal(root.left);
        System.out.print(root.data+" ");
        inTraversal(root.right);
    }
    public void mirror()
    {
        convertMirror(root);
        
    }
    private void convertMirror(TreeNode root)
    {
        if(root == null)
            return;
        convertMirror(root.left);
        convertMirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(11);
        tree.inorderTraversal();
        tree.mirror();

       tree.inorderTraversal();
    }
}
