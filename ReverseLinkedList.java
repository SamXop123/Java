public class ReverseLinkedList {
    
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    //! Adding a node at the last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    //! PRINTING A LIST 
    public void printList() {
        if(head == null) {
            System.out.println("The list is empty!");
            return;
        }

        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next; 
        }
        System.out.println("Null");
    }

    //! REVERSING A LIST (ITERATIVE WAY)
    public void reverse() {
        if(head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }


    //! REVERSING A LIST (RECURSIVE WAY)
    public Node recursiveReverse(Node head) {
        if(head == null || head.next == null) {
           return head;
       }

       Node newHead = recursiveReverse(head.next);

       head.next.next = head;
       head.next = null;
       return newHead;
    }


    public static void main(String[] args) {
        
        ReverseLinkedList list = new ReverseLinkedList();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        System.out.println("Initial LinkedList:");
        list.printList();
        System.out.println();

        System.out.println("Reversed LinkedList:");
        list.reverse();
        list.printList();
        System.out.println();

        System.out.println("Again intial list:");
        list.reverse();
        list.printList();
        System.out.println();

        System.out.println("Reversing Recursively:");
        list.head = list.recursiveReverse(list.head);
        list.printList();
        System.out.println();
    }
}
