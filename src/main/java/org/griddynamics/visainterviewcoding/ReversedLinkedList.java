package org.griddynamics.visainterviewcoding;

public class ReversedLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static void main(String[] args) {
        // Build sample list: 1 → 2 → 3 → 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.print("Original: ");
        printList(head);

        head = reverse(head);

        System.out.print("Reversed: ");
        printList(head);
    }
    static Node reverse(Node head){
        Node prev=null;
        Node current=head;
        while(current!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    static void printList(Node head){
        while(head!=null){
            System.out.println(head.data+" ");
            head=head.next;
        }
    }
}
