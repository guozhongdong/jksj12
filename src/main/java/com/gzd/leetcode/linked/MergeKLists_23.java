package com.gzd.leetcode.linked;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 参考题21 ，k个跟两个差不多，
 * 最简单的思路，就是两两合并
 */
public class MergeKLists_23 {

    public static void main(String[] args) {

    }

    /**
     * 暴力合并
     * <p>
     * 执行用时：198 ms, 在所有 Java 提交中击败了7.19%的用户
     * 内存消耗：43.4 MB, 在所有 Java 提交中击败了44.91%的用户
     * 通过测试用例：133 / 133
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        ListNode head1 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode merge = mergeTwo(head1, lists[i]);
            head1 = merge;
        }
        return head1;


    }

    private ListNode mergeTwo(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = mergeTwo(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwo(head1, head2.next);
            return head2;
        }
    }

    /**
     * 分治法
     * 优化一下，直接二分合并，
     * 参考mergeSort
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        int mid = 0 + (n - 0) / 2;

        return null;


    }

    /**
     * 递归三部曲
     * 1、临界值判断
     * 2、每一步具体是要干啥
     * 3、返回值有什么用
     * <p>
     * 1 3 4，
     * 1 5 6，
     * 3 6 8，
     * 2 5 8，
     * 3 6 9
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        // 说明拆分到最小单位了，一个元素，直接返回
        if (left == right) {
            return lists[left];
        }
        // 临界值，说明
        if (left > right) {
            // 0 1 2
            return null;
        }
        int mid = left + (right-left)/2;
        return mergeTwo1(merge(lists,left,mid),merge(lists,mid+1,right));

    }

    private ListNode mergeTwo1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = mergeTwo(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwo(head1, head2.next);
            return head2;
        }
    }

}
