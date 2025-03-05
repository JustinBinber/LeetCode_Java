package 链表;

public class L19_删除链表的倒数第n结点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fake = new ListNode();
            ListNode fast = fake;
            ListNode slow = fake;
            ListNode tem;
            fake.next = head;
            if(head == null) return head;

            for (int i = 0; i <= n; i++){
                fast = fast.next;
            }
            while (fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            tem = slow.next.next;
            slow.next = tem;

            return fake.next;
        }
    }
}
