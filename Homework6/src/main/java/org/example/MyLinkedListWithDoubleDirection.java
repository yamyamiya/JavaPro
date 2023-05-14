package org.example;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedListWithDoubleDirection implements Iterable<String> {


    private int size;
    private Node first;
    private Node last;

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.data;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            builder.append(current.data).append(", ");
            current = current.next;
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    public void add(String data) {
        if (isEmpty()) {
            first = new Node(data, null, null);
            last = first;

        } else {

            Node node = new Node(data, last, null);
            last.next = node;
            last = last.next;
        }
        size++;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }


    public class MyIterator implements ListIterator<String> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String result = current.data;
            current = current.next;
            return result;
        }

        @Override
        public boolean hasPrevious() {
            if (current == null && size != 0) {
                return true;
            }
            return current.previous != null;
        }

        @Override
        public String previous() {
            if (current == null && size != 0) {
                current = last;
                return last.data;
            }
            String result = current.previous.data;
            current = current.previous;
            return result;
        }

        @Override
        public int nextIndex() {

            Node node = first;
            int index = 0;
            while (node.next != current) {
                node = node.next;
                index++;
            }
            return index;
        }

        @Override
        public int previousIndex() {
            if (current == first) {
                return -1;
            }
            Node node = first;
            int index = 0;
            while (node != current.previous) {
                node = node.next;
                index++;
            }
            return index;
        }

        @Override
        public void remove() {
            // TODO
        }

        @Override
        public void set(String s) {
            // TODO
        }

        @Override
        public void add(String s) {
            // TODO

        }
    }

    private class Node {
        private String data;
        private Node next;
        private Node previous;

        public Node(String data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;

        }
    }
}


