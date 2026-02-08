package DSA.LinkedList;

class LinkedListInsertion {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    // 1. Insertion at the head
    static void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insertion at the tail
    static void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 3. Insertion at the Kth position (1-based index)
    static void insertAtKthPosition(int data, int k) {
        if (k <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (k == 1) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4. Insertion before the value X
    static void insertBeforeX(int data, int x) {
        if (head == null) return;

        if (head.data == x) {
            insertAtHead(data);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != x) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value X not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    
    // Utility method to print the list
    static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

