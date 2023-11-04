package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        modCount++;
        Node<T> newVal = new Node<>(value, null);
        Node<T> last = head;
        if (last == null) {
            head = newVal;
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = newVal;
        }
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.item;
    }

    public void addFirst(T value) {
        modCount++;
        head = new Node<>(value, head);
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T val = head.item;
        Node<T> newHead = head.next;
        head.next = null;
        head.item = null;
        head = newHead;
        size--;
        modCount++;
        return val;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            Node<T> cur = head;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T val = cur.item;
                cur = cur.next;
                return val;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}