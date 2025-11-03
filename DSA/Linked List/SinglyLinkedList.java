/*
notes:
this is a simple singly linked list implementation. 
a node has two parts — data and next pointer which points to the next node. 
the list starts from head and goes on till the last node where next is null. 
functions like addFirst and addLast handle insertion at beginning and end. 
deleteFirst and deleteLast remove nodes from the respective ends by adjusting pointers. 
printList just goes through the list and prints each node’s data. 
getSize() keeps track of total nodes. 
overall it shows how linked lists work internally without using the built-in LinkedList class.
*/

public class SinglyLinkedList {

    Node head;
    private int size;

    SinglyLinkedList() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //! OPERATION-1 (INSERTION)
    // Adding a node at the beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Adding a node at the last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    //! OPERATION-2 (PRINTING)
    // Printing the list
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    //! OPERATION-3 (DELETION)
    // delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    //! OPERATION-4 (GET SIZE)
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.printList();

        list.addLast("D");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());
    }
}


/*

* USING COLLECTIONS LIBRARY

import java.util.*;

class LL {
   public static void main(String args[]) {
       LinkedList<String> list = new LinkedList<String>();
       list.add("is");
       list.add("a");
       list.addLast("list");
       list.addFirst("this");
       list.add(3, "linked");
       System.out.println(list);


       System.out.println(list.get(0));
       System.out.println(list.size());   
       list.remove(3); //index as parameter
       list.removeFirst();
       list.removeLast();
      
       System.out.println(list);
   }
}

 */
