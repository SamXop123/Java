package DSA.LinkedList;

class LinkedListDeletion {

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

    // 1. Deletion of the head
    static void deleteHead() {
        if (head == null) return;
        head = head.next;
    }

    // 2. Deletion of the tail
    static void deleteTail() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // 3. Deletion of the Kth element (1-based index)
    static void deleteKthElement(int k) {
        if (head == null || k <= 0) return;

        if (k == 1) {
            deleteHead();
            return;
        }

        Node temp = head;
        for (int i = 1; i < k - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) return;

        temp.next = temp.next.next;
    }

    // 4. Delete the element with value X
    static void deleteByValue(int x) {
        if (head == null) return;

        if (head.data == x) {
            deleteHead();
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

        temp.next = temp.next.next;
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

