package unit09;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void append(E value) {
        Node<E> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.getNext();
            index--;
        }

        return current.getValue();
    }

    @Override
    public void set(int index, E value) {
        Node<E> current = head;
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        current.setValue(value);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator(head);
    }

    private class NodeIterator implements Iterator<E> {
        private Node<E> node;

        public NodeIterator(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E element = node.getValue();
            node = node.getNext();
            return element;
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public String toString(){
            String rest = this.next == null ? "null" : this.next.toString();
            return this.getValue() + " -> " + rest;
        }
    }
}
