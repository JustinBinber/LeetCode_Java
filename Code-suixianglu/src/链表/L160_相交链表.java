package 链表;

public class L160_相交链表 {

   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode headAbuf = headA;
            ListNode headBbuf = headB;
            int lenA = 0, lenB = 0;
            int idxa = 0, idxB = 0;

            if (headA == null || headB == null) return null;

            while (headAbuf != null){
                headAbuf = headAbuf.next;
                lenA++;
            }

            while (headBbuf != null){
                headBbuf = headBbuf.next;
                lenB++;
            }

            int cha = lenA - lenB;
            if(cha >= 0){
                for (int i = 0; i <= cha - 1; i++){
                    headA = headA.next;
                }
            }
            else {
                for (int i = 0; i <= -cha - 1; i++){
                    headB = headB.next;
                }
            }

            while (headA != null){
                if (headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;



        }
    }
}
