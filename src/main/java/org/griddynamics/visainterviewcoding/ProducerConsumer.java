package org.griddynamics.visainterviewcoding;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    static class SharedQueue{
        Queue<Integer> queue=new LinkedList<>();
        int capacity;
        public SharedQueue(int capacity){
            this.capacity=capacity;
        }
        void produce() throws InterruptedException {
            int value=0;
            while ((true)){
                synchronized (this){
                    while (queue.size()==capacity){
                        wait();
                    }
                    System.out.println("Produced "+value );
                    queue.add(value);value++;
                    notify();
                    Thread.sleep(500);
                }
            }
        }
        void consume() throws InterruptedException {
            while (true){
                synchronized (this){
                    while(queue.isEmpty()){
                        wait();
                    }
                    System.out.println("consumed "+queue.peek());
                    queue.remove();
                    notify();
                    Thread.sleep(500);
                }
            }
        }
        public static void main(String[] args){
            SharedQueue buffer= new SharedQueue(5);
            Thread producer=new Thread(()-> {
                try {
                    buffer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread consumer=new Thread(()-> {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            producer.start();
            consumer.start();
        }
    }

}
