package SwordToOfferSolution._25_MergeSortedLists;

/*
 * 合并两个单链表
 *
 * 题目描述：
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 例如输入下图中的链表 1 和链表 2，则合并之后的升序链表如链表 3 所示。
 *
 * 链表 1：1->3->5->7
 * 链表 2：2->4->6->8
 * 链表 3：1->2->3->4->5->6->7->8
 *
 * 思路：
 * 1. 如果用迭代的方式实现的话，就先创建一个节点，然后使用两个指针比较大小后将小的加入到新建节点后；
 *    最后如果其中一个链表多出来的话，要全部加入到新建链表的最后。
 * 2. 递归实现。
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeList1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 使用一个额外的节点，方便找到链表的头
        // 在头节点的前面
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        // 假如其中一个链表已经遍历完了，而另一个没有遍历完
        // 则需要确定 cur.next 所指向的节点
        cur.next = (head1 == null) ? head2 : head1;
        // 最后返回的是整个链表的头节点，但这里需要返回的是 dummy 的下一个节点
        return dummy.next;
    }

    // 递归
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode mergedHead;
        if (head1.val < head2.val) {
            mergedHead = head1;
            mergedHead.next = mergeList(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeList(head1, head2.next);
        }
        return mergedHead;
    }
}
