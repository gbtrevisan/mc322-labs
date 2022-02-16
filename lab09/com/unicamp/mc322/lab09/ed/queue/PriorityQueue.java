package com.unicamp.mc322.lab09.ed.queue;

import com.unicamp.mc322.lab09.ed.Element;

public class PriorityQueue {

    private Queue queue;
    private Queue priorityQueue;

    public PriorityQueue() {
        queue = new Queue();
        priorityQueue = new Queue();
    }

    public void add(Element element) {
        queue.add(element);
    }

    public void add(Element element, boolean priority) {
        if (priority)
            priorityQueue.add(element);
        else
            add(element);
    }

    public Element remove() {
        if (priorityQueue.isEmpty())
            return queue.remove();
        else
            return priorityQueue.remove();
    }

    public void clear() {
        queue = new Queue();
        priorityQueue = new Queue();
    }

    public int size() {
        return queue.size() + priorityQueue.size();
    }

    public String show() {
        return priorityQueue.show() + queue.show();
    }

}
