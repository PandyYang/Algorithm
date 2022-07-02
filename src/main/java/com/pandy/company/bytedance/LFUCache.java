package com.pandy.company.bytedance;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    Node first,last;//双向链表的头尾节点

    int capacity;//大小

    Map<Integer,Node> map = new HashMap<>();//键->节点

    Map<Integer,Node> timeLast = new HashMap<>();//频次对应的最后一个元素

    public LFUCache(int capacity) {
        first = new Node(-1,0,0);
        last = new Node(-1,0,Integer.MAX_VALUE);
        first.next = last;
        last.prev = first;
        this.capacity = capacity;
        timeLast.put(0,first);
    }
    int curr = 0;//当前时间戳，定义为每进来一个元素加1
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.last = ++curr;
        move(node);
        return map.get(key).val;
    }

    /**
     * 添加链接
     * @param prev 前一个节点
     * @param curr 当前节点
     */
    private void addLink(Node prev,Node curr){
        Node next = prev.next;
        curr.prev = prev;
        curr.next = next;
        prev.next = curr;
        next.prev = curr;
    }

    /**
     * 移除链接，注意新节点前后为空的处理
     * @param node 当前节点
     */
    private void removeLink(Node node){
        if(node.prev == null) return;
        Node pre = node.prev;
        Node nex = node.next;
        node.prev = null;
        node.next = null;
        pre.next = nex;
        nex.prev = pre;
    }

    public void put(int key, int value) {
        //0长情况处理（WA1）
        if(capacity==0) return;
        //满容量移除
        if(!map.containsKey(key) && map.size()==capacity){
            Node delNode = first.next;
            removeTime(delNode);
            removeLink(delNode);
            map.remove(delNode.key);
        }

        Node node=map.getOrDefault(key,new Node(key,value,curr));
        node.last = ++curr;
        node.val = value;//注意，如果没有这句，以后节点无法更新值(WA2)
        move(node);
        map.put(key,node);
    }

    private void removeTime(Node node){
        if(timeLast.getOrDefault(node.times,first).key==node.key){
            timeLast.remove(node.times);
            //如果上个节点和移除节点是同一级别，则此操作会生效；否则不同级别，此操作不生效，没有添加新值
            timeLast.put(node.prev.times,node.prev);
        }
    }

    private void move(Node node){
        //假设当前节点是当前次数的最后一个元素，则删除
        removeTime(node);
        node.times++;
        //新的级别如果有过元素，则新元素放在下一级别最后一个
        if(timeLast.containsKey(node.times)){
            removeLink(node);
            Node prev = timeLast.get(node.times);
            addLink(prev,node);
            //旧的级别如果有元素，则放在旧级别最后一个元素的后面
        }else if(timeLast.containsKey(node.times-1)){
            removeLink(node);
            Node prev = timeLast.get(node.times-1);
            addLink(prev,node);
        }

        //当前元素必然是新频次的最后一个元素，替换下一级别最后一个元素
        timeLast.put(node.times,node);
    }

    class Node{
        Node prev;
        Node next;
        int key;//键
        int val;//值
        int times;//频率
        int last;//最后一次的时间

        public Node(int key,int val,int last){
            this.key = key;
            this.val = val;
            this.last = last;
            times = 0;
        }
    }
}
