package DSA.linkedListProblems;

import java.util.Stack;

public class ReverseListByStack {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("List before Reverse");
        printList(head);
        head = reverseList(head);
        System.out.println("\nList after Reverse");
        printList(head);
    }

    static void printList(Node node) {
        if (node != null) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }

    static Node reverseList(Node head) {
        Stack<Node> nodeStack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.next;
        }

        if(!nodeStack.isEmpty()) {
            head = nodeStack.pop();
            temp = head;
            while(!nodeStack.isEmpty()) {
                temp.next = nodeStack.pop();
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }
}
