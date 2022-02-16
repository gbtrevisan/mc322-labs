package com.unicamp.mc322.lab09.ed.queue;

import com.unicamp.mc322.lab09.ed.Element;
import com.unicamp.mc322.lab09.ed.list.List;

public class Queue {

    private List list;

    public Queue() {
        list = new List();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(Element element) {
        list.addToEnd(element);
    }

    public Element remove() {
        return list.removeFirst();
    }

    public void clear() {
        list = new List();
    }

    public int size() {
        return list.size();
    }

    public String show() {
        return list.show();
    }

}
