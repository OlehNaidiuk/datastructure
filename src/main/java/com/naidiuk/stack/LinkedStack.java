package com.naidiuk.stack;

public class LinkedStack implements StackInterface {
    private Node last;
    private int size;

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        if (size == 1) {
            size--;
            return last.getElement();
        }
        Object lastElement = last.getElement();
        last = last.getLink();
        size--;
        return lastElement;
    }

    public void push(Object object) {
        Node createdNode = new Node();
        createdNode.setElement(object);
        createdNode.setLink(last);
        last = createdNode;
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }
}