package com.pandy.company.bytedance;

import com.pandy.common.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 复制带随机指针的链表
 *
 * 本题要求我们对一个特殊的链表进行深拷贝。如果是普通链表，我们可以直接按照遍历的顺序创建链表节点。而本题中因为随机指针的存在，当我们拷贝节点时，「当前节点的随机指针指向的节点」可能还没创建，因此我们需要变换思路。一个可行方案是，我们利用回溯的方式，让每个节点的拷贝操作相互独立。对于当前节点，我们首先要进行拷贝，然后我们进行「当前节点的后继节点」和「当前节点的随机指针指向的节点」拷贝，拷贝完成后将创建的新节点的指针返回，即可完成当前节点的两指针的赋值。
 *
 * 具体地，我们用哈希表记录每一个节点对应新节点的创建情况。遍历该链表的过程中，我们检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」的创建情况。如果这两个节点中的任何一个节点的新节点没有被创建，我们都立刻递归地进行创建。当我们拷贝完成，回溯到当前层时，我们即可完成当前节点的指针赋值。注意一个节点可能被多个其他节点指向，因此我们可能递归地多次尝试拷贝某个节点，为了防止重复拷贝，我们需要首先检查当前节点是否被拷贝过，如果已经拷贝过，我们可以直接从哈希表中取出拷贝后的节点的指针并返回即可。
 *
 * 在实际代码中，我们需要特别判断给定节点为空节点的情况。
 **/
public class CopyRandomList {

    Map<RandomNode, RandomNode> cacheRandomNode = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;
        if (!cacheRandomNode.containsKey(head)) {
            RandomNode headNew = new RandomNode(head.val);
            cacheRandomNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheRandomNode.get(head);
    }
}
