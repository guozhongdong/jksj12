package com.gzd.leetcode.doubletail;

import static com.gzd.leetcode.doubletail.Partition_86.ListNode;

/**
 * @author guozhongdong
 * @date 2022/11/18 22:27
 */
public class OddEvenList_328 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        OddEvenList_328 list = new OddEvenList_328();
        ListNode node = list.oddEvenList(listNode);
        System.out.println(node);

    }

    public ListNode oddEvenList(ListNode head) {

        int count = 1;
        ListNode odd = new ListNode(-1);
        ListNode oddRes = odd;
        ListNode even = new ListNode(-1);
        ListNode evenRes = even;
        ListNode cur = head;

        while (cur != null) {
            ListNode curNode = cur.next;
            if (count % 2 == 0) {
                even.next = cur;
                even = even.next;
                even.next = null;
            } else {
                odd.next = cur;
                odd = odd.next;
                odd.next = null;
            }
            count++;
            cur = curNode;
        }
        odd.next = evenRes.next;

        return oddRes.next;
    }

}
