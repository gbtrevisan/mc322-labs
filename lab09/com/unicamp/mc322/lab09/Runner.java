package com.unicamp.mc322.lab09;

import com.unicamp.mc322.lab09.ed.list.List;
import com.unicamp.mc322.lab09.ed.queue.PriorityQueue;
import com.unicamp.mc322.lab09.ed.queue.Queue;

public class Runner {

    public static void main(String[] args) {

        Person person1 = new Person("Marcelo", 30, "38923233900");
        Person person2 = new Person("Bianca", 21, "89012323400");
        Person person3 = new Person("Rodrigo", 40, "89012353500");

        List list = new List();

        list.addToBegin(person1);
        list.addToBegin(person2);
        list.add(1, person3);

        System.out.println(list.show());

        Queue queue = new Queue();

        queue.add(person1);
        queue.add(person2);
        queue.add(person3);

        queue.remove();

        System.out.println(queue.show());

        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.add(person1);
        priorityQueue.add(person2);
        priorityQueue.add(person3, true);

        System.out.println(priorityQueue.show());

    }

}
