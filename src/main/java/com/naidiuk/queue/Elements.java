package com.naidiuk.queue;

public class Elements implements Queue {
    private Object[] array;
    private int size;

    public Elements() {
        array = new Object[20];
    }

    public Elements(int size) {
        array = new Object[size];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Object first = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        size--;
        return first;
    }

    public void push(Object object) {
        if (size == array.length) {
            reSize();
        }
        array[size] = object;
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object object : array) {
            result.append(object).append(", ");
        }
        return result.toString();
    }

    private void reSize() {
        Object[] arrayCopy = new Object[size * 2];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
}