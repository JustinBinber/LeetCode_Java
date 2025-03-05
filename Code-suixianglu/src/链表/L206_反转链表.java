package 链表;

import java.util.Stack;

public class L206_反转链表 {

   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    class Solution0 {
        public ListNode reverseList(ListNode head) {
            ListNode listNode = new ListNode();
            ListNode ans = listNode;
            Stack<ListNode> stack = new Stack<>();
            while (head != null){
                stack.add(head);
                head = head.next;
            }

            while (!stack.isEmpty()){
                ListNode listNode1 = stack.pop();
                listNode1.next = null;
                listNode.next = listNode1;
                listNode = listNode.next;

            }
        return ans.next;

        }
    }

    class Solution {

        ListNode ans = new ListNode();
        ListNode tem = ans;
        public ListNode reverseList(ListNode head) {
            recur(head);
            return tem.next;
        }

        private void recur(ListNode head) {
            if (head == null)
                return;
            recur(head.next);
            head.next = null;
            ans.next = head;
            ans = ans.next;
        }


    }
}
