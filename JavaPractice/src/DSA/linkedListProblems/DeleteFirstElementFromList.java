package DSA.linkedListProblems;

public class DeleteFirstElementFromList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked List:");
        printList(head);

        head = deleteFirst(head);

        System.out.print("\nLinked List after deletion:");
        printList(head);

        Node renew = new Node(1);
        renew.next = head;

        System.out.print("\nLinked List added again:");
        printList(renew);

        renew = deleteByPosition(renew, 2);
        System.out.print("\nLinked List after delete by position:");
        printList(renew);
    }

    private static Node deleteByPosition(Node renew, int position) {
        Node temp = renew;
        Node prev = null;
        if(temp == null) {
            return renew;
        }
        if(position == 1) {
            renew = temp.next;
            return renew;
        }
        for(int i = 1; temp!=null && i<position;i++) {
            prev = temp;
            temp = temp.next;
        }
        if(temp != null) {
            prev.next = temp.next;
        }
        return prev;
    }

    static void printList(Node node) {
        if(node != null) {
            while(node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }

    static Node deleteFirst(Node node) {
        if(node == null) {
            return null;
        }
        node = node.next;
        return node;
    }
}
