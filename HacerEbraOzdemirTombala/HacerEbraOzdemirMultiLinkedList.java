/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HacerEbraOzdemirTombala;

/**
 *
 * @author hacerebra
 */
// MultiLinkedList class
class HacerEbraOzdemirMultiLinkedList<T> {

    HacerEbraOzdemirNode<T> head;
    HacerEbraOzdemirNode<T> tail;
    int size;

    // Constructor
    public HacerEbraOzdemirMultiLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add an element to the end of the list
    public void addLast(T data) {
        HacerEbraOzdemirNode<T> newNode = new HacerEbraOzdemirNode<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Check if the list contains a specific element
    public boolean contains(T data) {
        HacerEbraOzdemirNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get the size of the list
    public int size() {
        int count = 0;
        HacerEbraOzdemirNode<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Print the elements of the list
    public void printList() {
        HacerEbraOzdemirNode<T> current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Check if the list is empty
    boolean isEmpty() {
        return size == 0;
    }
}
