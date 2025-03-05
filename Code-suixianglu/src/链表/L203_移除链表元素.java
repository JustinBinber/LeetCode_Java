package 链表;

import java.util.Objects;

public class L203_移除链表元素 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode tem = new ListNode();
            ListNode ans = new ListNode();
            if (head == null) return null;
            while (head.val == val ) {
                if (head.next == null){
                    return null;
                }
                head = head.next;

            }
            ans = head;
            while (Objects.nonNull(head)){
                if (head.next != null && head.next.val == val){
                    tem = head.next.next;
                    head.next = tem;
                }
                else  head = head.next;
            }
            return ans;
        }
    }
}
