public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);

        if (!isEmpty()) {
            newNode.next = this.head;
        }

        this.head = newNode;
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
