package com.pandy.base.tree;

import com.pandy.common.Node;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private final List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        root4.val = 4;
        root4.left = root2;
        root4.right = root5;
        root2.left = root1;
        root2.right = root3;

        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(root4);
        System.out.println("node = " + node);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        mid(root);

        Node p = list.get(0);
        Node head = p;

        for (int i = 1; i < list.size(); i++) {
            Node q = list.get(i);
            p.right = q;
            q.left = p;
            p = q;
        }

        p.right = head;
        head.left = p;
        return head;
    }

    private void mid(Node root) {
        if (root == null) return;
        mid(root.left);
        list.add(root);
        mid(root.right);
    }
}
