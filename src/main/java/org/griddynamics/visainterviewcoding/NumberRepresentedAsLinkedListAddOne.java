package org.griddynamics.visainterviewcoding;

public class NumberRepresentedAsLinkedListAddOne {

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(6);

        Node head2 = new Node(2);
        head2.next = new Node(1);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(9);

        System.out.print("Before (456): ");
        printList(head1);
        head1 = addOne(head1);
        System.out.print("After  +1   : ");
        printList(head1);

        System.out.print("\nBefore (2169): ");
        printList(head2);
        head2 = addOne(head2);
        System.out.print("After   +1   : ");
        printList(head2);
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    static Node addOne(Node head) {
        System.out.println("\n🔁 Reversing the list before addition:");
        head = reverseNode(head);

        System.out.print("List after reversal: ");
        printList(head);

        Node current = head;
        int carry = 1;
        int step = 1;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;

            System.out.println("➕ Step " + step + ": sum = " + sum +
                    ", updated digit = " + current.data +
                    ", carry = " + carry);

            if (carry == 0) break;

            if (current.next == null && carry != 0) {
                current.next = new Node(0);
                System.out.println("⚠️ Added new node for carry overflow.");
            }

            current = current.next;
            step++;
        }

        System.out.println("🔁 Reversing the list again to restore original order:");
        head = reverseNode(head);
        System.out.print("List after final reversal: ");
        printList(head);

        return head;
    }

    static Node reverseNode(Node head) {
        Node current = head;
        Node prev = null;
        int step = 1;

        System.out.println("\n🔁 STARTING REVERSAL");

        while (current != null) {
            // ➡️ Line A: Save current.next to not lose access
            Node next = current.next;
            System.out.println("🔄 Step " + step);
            System.out.println("  Line A: next = current.next");
            System.out.println("    → next = " + (next != null ? next.data : "null"));

            // ➡️ Line B: Reverse the pointer
            current.next = prev;
            System.out.println("  Line B: current.next = prev");
            System.out.println("    → " + current.data + ".next now points to " + (current.next != null ? current.next.data : "null"));

            // ➡️ Line C: Move prev to current
            prev = current;
            System.out.println("  Line C: prev = current");
            System.out.println("    → prev is now " + prev.data);

            // ➡️ Line D: Move current to next
            current = next;
            System.out.println("  Line D: current = next");
            System.out.println("    → current is now " + (current != null ? current.data : "null"));

            System.out.println("--------------------------------------------------");
            step++;
        }

        System.out.println("✅ Reversal complete. New head = " + (prev != null ? prev.data : "null") + "\n");
        return prev;
    }



}
