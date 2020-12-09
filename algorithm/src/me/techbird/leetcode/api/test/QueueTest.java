package me.techbird.leetcode.api.test;

import me.techbird.leetcode.api.queue.CircleDeque;
import me.techbird.leetcode.api.queue.CircleQueue;
import me.techbird.leetcode.api.queue.Deque;
import me.techbird.leetcode.api.queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        Deque<Integer> deque = new Deque<Integer>();
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>();
        CircleDeque<Integer> circleDeque = new CircleDeque<Integer>();


//        for (int i = 0; i < 5; i++) {
//            queue.enQueue(i+1);
//        }
//        System.out.println(queue);
//
//        for (int i = 0; i < 2; i++) {
//            queue.deQueue();
//        }
//
//        System.out.println(queue);

//        for (int i = 0; i < 2; i++) {
//            deque.enQueueFront(i+1);
//        }
//        System.out.println(deque);
//        for (int i = 0; i < 2; i++) {
//            deque.enQueueRear(i+10);
//        }
//        System.out.println(deque);
//
//        deque.deQueueFront();
//        deque.deQueueRear();
//        System.out.println(deque);


//        for (int i = 0; i < 10; i++) {
//            circleQueue.enQueue(i);
//        }
//        System.out.println(circleQueue);
//        circleQueue.deQueue();
//        circleQueue.deQueue();
//        System.out.println(circleQueue);
//
//        circleQueue.enQueue(10);
//        circleQueue.enQueue(11);
//        System.out.println(circleQueue);
//
//        circleQueue.enQueue(12);
//        circleQueue.enQueue(13);
//        circleQueue.enQueue(14);
//        circleQueue.enQueue(15);
//        System.out.println(circleQueue);
//            circleQueue.enQueue(i);
//        }


        for (int i = 0; i < 5; i++) {
            circleDeque.enQueueFront(i);
        }
        System.out.println("circleDeque = " + circleDeque);
        for (int i = 5; i < 10; i++) {
            circleDeque.enQueueRear(i);
        }
        System.out.println("circleDeque = " + circleDeque);

        circleDeque.enQueueFront(10);
        System.out.println("circleDeque = " + circleDeque);
        circleDeque.enQueueRear(11);
        System.out.println("circleDeque = " + circleDeque);

        circleDeque.clear();
        System.out.println("circleDeque = " + circleDeque);
    }
}
