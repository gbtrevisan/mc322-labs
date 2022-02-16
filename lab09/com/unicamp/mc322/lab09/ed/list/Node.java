package com.unicamp.mc322.lab09.ed.list;

import com.unicamp.mc322.lab09.ed.Element;

import java.util.Objects;

public class Node {

    private Element element;
    private Node next;

    public Node(Element element) {
        Objects.requireNonNull(element, "element");
        this.element = element;
        next = null;
    }

    Node getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }

    Element getElement() {
        return element;
    }

    void append(Node node) {
        next = node;
    }

    void tradeElement(Node node) {
        Element toTrade = this.element;
        this.element = node.element;
        node.element = toTrade;
    }

}
