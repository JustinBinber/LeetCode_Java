package 链表;

public class L142_环形链表II {

   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }


    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fake = new ListNode(0);
            fake.next = head;

            ListNode slow = fake, fast = fake;

            while (fast != null){
                if (fast.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;

                if (slow == fast) break;
            }
            if (fast == null) return null;

            slow = fake;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;

        }
        }
    }
}
