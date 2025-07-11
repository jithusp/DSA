package org.griddynamics;

import org.w3c.dom.Node;

public class FindMiddleOfLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40 -> 50 -> 60
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(getMiddle(head));
    }
    static int lengthOfNode(Node head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
    static int getMiddle(Node head){
//        int lenght=lengthOfNode(head);
//        int mid=lenght/2;
//        while (mid>0){
//            head=head.next;
//            mid--;
//        }
        Node first=head;
        Node second=head;
        while(first!=null&&second!=null){
            first=first.next;
            second=second.next.next;
        }
        return  first.data;
    }


}
