package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIN;
    private int sizeOUT;

    public T poll() {
        if (sizeIN == 0 && sizeOUT == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (sizeOUT == 0) {
            while (sizeIN != 0) {
                out.push(in.pop());
                sizeIN--;
                sizeOUT++;
            }
        }
        sizeOUT--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        sizeIN++;
    }
}