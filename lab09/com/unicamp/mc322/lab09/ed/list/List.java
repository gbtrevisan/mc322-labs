package com.unicamp.mc322.lab09.ed.list;

import com.unicamp.mc322.lab09.ed.Element;

public class List {

    private Node node;

    public List() {
        node = null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addToBegin(Element element) {
        Node newNode = new Node(element);
        newNode.append(node);
        node = newNode;
    }

    private Node getNode(int position) {
        Node current = node;
        int currentPosition = 0;
        while (currentPosition < position && current != null) {
            current = current.getNext();
            currentPosition++;
        }
        return current;
    }

    public void addToEnd(Element element) {
        Node newNode = new Node(element);
        Node lastNode = getNode(size() - 1);
        if (lastNode == null)
            node = newNode;
        else lastNode.append(newNode);
    }

    private void addToPosition(int position, Element element) {
        Node newNode = new Node(element);
        Node before = getNode(position - 1);
        if (before == null) {
            newNode.append(node);
            node = newNode;
        } else {
            newNode.append(before.getNext());
            before.append(newNode);
        }
    }

    public void add(int position, Element element) {
        if (position < size())
            addToPosition(position, element);
        else if (position == size())
            addToEnd(element);
    }

    public Element removeFirst() {
        if (node == null)
            return null;
        if (node.hasNext()) {
            Node first = node;
            node = node.getNext();
            return first.getElement();
        } else return node.getElement();
    }

    public Element removeLast() {
        Node behindLast = getNode(size() - 2);

        if (behindLast != null) {
            Node last = behindLast.getNext();
            behindLast.append(null);
            return last.getElement();
        }

        return null;
    }

    public Element remove(int position) {
        Node node = getNode(position);
        if (node == null)
            return null;
        else return node.getElement();
    }

    public void clear() {
        node = null;
    }

    public int size() {
        int count = 0;
        Node current = node;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public String show() {
        StringBuilder elements = new StringBuilder();
        Node current = node;
        while (current != null) {
            elements.append(current.getElement().show()).append("\n");
            current = current.getNext();
        }
        return elements.toString();
    }

}
