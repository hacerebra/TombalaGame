/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HacerEbraOzdemirTombala;

/**
 *
 * @author hacerebra
 */
// Node class for linked list
class HacerEbraOzdemirNode<T> {

    T data;
    HacerEbraOzdemirNode<T> prev;
    HacerEbraOzdemirNode<T> next;

    // Constructor
    public HacerEbraOzdemirNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Get the next node
    public HacerEbraOzdemirNode<T> getNext() {
        return next;
    }
}
