public class SmartArray {
    private int[] elements;
    private int nextFreeIndex;

    public SmartArray() {
        this.elements = new int[4];
        this.nextFreeIndex = 0;
    }

    public void add(int data) {
        if (this.nextFreeIndex == this.elements.length) {
            expand();
        }

        this.elements[nextFreeIndex] = data;

        nextFreeIndex++;

    }

    private void expand() {
        int[] newElements = new int[this.elements.length * 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        this.elements = newElements;
    }
}
