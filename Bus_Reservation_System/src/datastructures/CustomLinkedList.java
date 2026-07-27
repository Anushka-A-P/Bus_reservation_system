package datastructures;

import java.util.function.Predicate;

public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Linear Search Implementation (Member 1 Assignment)
    public T linearSearch(Predicate<T> condition) {
        Node<T> current = head;
        while (current != null) {
            if (condition.test(current.getData())) {
                return current.getData(); // Found
            }
            current = current.getNext();
        }
        return null; // Not found
    }

    // Display all items in the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.println(" -> " + current.getData());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}