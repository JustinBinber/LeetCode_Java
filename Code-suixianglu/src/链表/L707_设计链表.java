package 链表;

public class L707_设计链表 {


    class MyLinkedList {

        Node head;
        Node tail;
        int lenth = 0;
        Node temNode;

        class Node{
            public int val;
            public Node next;
            Node() {}
            Node(int val) { this.val = val; }
            Node(int val, Node next) { this.val = val; this.next = next; }

        }

        public MyLinkedList() {}

        public Node getNode(int index){
            int tem = 0;

            if (index >= lenth) return null;
            temNode = head;
            while (temNode != null){
                if (tem < index) {
                    temNode = temNode.next;
                    tem++;
                }
                else return temNode;
            }
            return null;
        }

        public int get(int index) {
            Node node = getNode(index);
            if (node == null) return -1;
            return node.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val, head);
            head = node;
            lenth++;
        }

        public void addAtTail(int val) {
            if (tail == null){
                if (head == null){
                    head = new Node(val);
                    tail = head;
                    lenth++;
                    return;
                }
                else {
                    temNode = head;
                    while (temNode != null){
                        if (temNode.next == null) tail = temNode;
                        temNode = temNode.next;
                    }
                }

            }
            Node node = new Node(val);
            tail.next = node;
            tail = tail.next;
            lenth++;
        }
//        public void addAtIndex(int index, int val) {
//            // 修复5: 处理无效索引
//            if (index > lenth) return;
//            if (index <= 0) {
//                addAtHead(val);
//            } else if (index == lenth) {
//                addAtTail(val);
//            } else {
//                Node prev = getNode(index - 1);
//                if (prev != null) {  // 安全校验
//                    prev.next = new Node(val, prev.next);
//                    lenth++;
//                }
//            }
//        }
        public void addAtIndex(int index, int val) {
            if (index > lenth) return;
            else if (index == 0) addAtHead(val);
            else if (index == lenth) addAtTail(val);
            else {
                Node node1 = getNode(index - 1);
                Node node2 = node1.next;
                node1.next = new Node(val,node2);
                lenth++;
            }

        }

        public void deleteAtIndex(int index) {
            if (index >= lenth) return;
            else if (index == 0){
                if (head.next != null) head = head.next;
                else head = new Node();
            }
            else if (lenth > 1 && index == lenth - 1){
                Node node = getNode(index - 1);
                tail = node;
                tail.next = null;
            }
            else {
                Node node = getNode(index - 1);
                node.next = node.next.next;

            }
            lenth--;
        }
    }


}
