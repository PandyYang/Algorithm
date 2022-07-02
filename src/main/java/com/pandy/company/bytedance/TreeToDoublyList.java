package com.pandy.company.bytedance;

import com.pandy.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/2
 **/
public class TreeToDoublyList {

    private List<Node> list = new ArrayList<>();
    public Node treeToDoublyList2(Node root) {
        if(root == null) return null;
        mid(root);

        Node p = list.get(0);
        Node head = p;

        for(int i = 1; i < list.size(); i++) {
            Node q = list.get(i);
            p.right = q;
            q.left = p;
            p = q;
        }

        p.right = head;
        head.left = p;
        return head;
    }

    // 中序遍历节点 即自然顺序
    private void mid(Node root) {
        if(root == null) return;
        mid(root.left);
        list.add(root);
        mid(root.right);
    }



    // 1. 中序，递归，来自解题大佬
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        // 边界值
        if(root == null) return null;
        dfs(root);

        // 题目要求头尾连接
        head.left = pre;
        pre.right = head;
        // 返回头节点
        return head;
    }

    void dfs(Node cur) {
        // 递归结束条件
        if(cur == null) return;
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) head = cur;
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
        else if (pre != null) pre.right = cur;
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }
}
