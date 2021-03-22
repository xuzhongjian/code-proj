package com.xuzhongjian;

/**
 * 淘汰小孩
 *
 * @author zjxu97 at 3/2/21 11:09 AM
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        ListNode node = build(nums);
        int size = nums.length;
        int k = 3;
        int count = 1;
        ListNode prev = null;
        while (size > k) {
            while (count < k) {
                count++;
                prev = node;
                node = node.next;
            }
            size--;
            System.out.println(node.val);
            prev.next = node.next;
            node.next = null;
            node = prev.next;
            count = 1;
        }
    }

    public static ListNode build(int[] nums) {
        ListNode res = null;
        ListNode cur = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode n = new ListNode(nums[i]);
            if (res == null) {
                res = n;
                cur = n;
            }
            cur.next = n;
            cur = cur.next;
            if (i == nums.length - 1) {
                cur.next = res;
            }
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}