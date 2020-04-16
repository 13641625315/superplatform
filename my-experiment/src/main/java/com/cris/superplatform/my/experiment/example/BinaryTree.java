package com.cris.superplatform.my.experiment.example;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (null == root) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (null == current) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (null == current) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data+" ");
            inOrder(localRoot.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
        binaryTree.buildTree(data);
        binaryTree.inOrder(binaryTree.root);
    }
}

class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}