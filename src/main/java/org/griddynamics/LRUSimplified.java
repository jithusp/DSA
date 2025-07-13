package org.griddynamics;

import java.util.HashMap;

public class LRUSimplified {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;

        }
    }
    int capacity;
    HashMap<Integer,Node>map=new HashMap<>();
    Node head, tail;
    LRUSimplified(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    int get(int key){
        if(!map.containsKey(key))return -1;
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    void put(int key, int value){
        if(map.containsKey(key))remove(map.get(key));
        if(map.size()==capacity){
            Node lru=tail.prev;
            remove(lru);
        }
        Node newNode=new Node(key,value);
        insert(newNode);
    }
    void insert(Node node){
        map.put(node.key, node);
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public static void main(String[] args) {
        LRUUsingDoublyLinkedListandHashMap cache = new LRUUsingDoublyLinkedListandHashMap(2);

        cache.put(1, 10); // cache: 1
        cache.put(2, 20); // cache: 2 -> 1
        cache.get(1);     // cache: 1 -> 2
        cache.put(3, 30); // cache: 3 -> 1 (evicts 2)

        cache.printCache(); // Output: (3,30) (1,10)
    }
    public void printCache() {
        LRUSimplified.Node curr = head.next;
        System.out.print("Cache state (MRU -> LRU): ");
        while (curr != tail) {
            System.out.print("(" + curr.key + "," + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }

}
