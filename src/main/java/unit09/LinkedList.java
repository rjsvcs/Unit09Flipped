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
        return new NodeIterator<>(head);
    }
}
