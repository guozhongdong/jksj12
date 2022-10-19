package com.gzd.leetcode.linked;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 经典题
 * 直接合并，
 * 边界条件，两个链表直接遍历，比较大小，知道最长的也遍历完，单的遍历完直接忽略
 * 归并排序也使用到了这种思想
 */
public class MergeTwoLists_21 {

    public static void main(String[] args) {

    }

    /**
     * 迭代法
     * 想好想，考虑好边界情况
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode result1 = new ListNode(-1);
        ListNode result = result1;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                result.next = head1;
                head1 = head1.next;
            } else {
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;
        }
        if (head1 != null) {
            result.next = head1;
        }

        if (head2 != null) {
            result.next = head2;
        }

        return result1.next;
    }


    /**
     * 递归法
     * 这个思路是真牛逼，真没想到
     * 每次操作两个结点，进行判断，把当前小的节点找到，然后传递到下次判断，继续拼接
     * 主要是得考虑边界条件
     * 两个一个为空的情况，
     * <p>
     * <p>
     * 想好想，考虑好边界情况
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        // 先考虑两个边界值
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        // 考虑值大小
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }


    }
}
