public class MyLinkedList {
    private Node head;
    private int size;

    public void addFirst(int number) {
        this.head = new Node(number);
        size++;
    }
}
