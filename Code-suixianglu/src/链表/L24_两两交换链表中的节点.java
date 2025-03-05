package 链表;

public class L24_两两交换链表中的节点 {

   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    class Solution {

        public ListNode swapPairs(ListNode head) {
            ListNode tem;
            ListNode ans = head;
            ListNode pre = head;
            if (head == null) return null;

            if (head.next != null){
                tem = head.next.next;
                ans = head.next;
                ans.next = head;
                head.next = tem;

                pre = head;
                head = head.next;
            }
            while (head != null && head.next != null){
                tem = head.next.next;
                head.next.next = head;
                pre.next = head.next;
                head.next = tem;

                pre = head;
                head = head.next;

            }
            return ans;
        }
    }
}
