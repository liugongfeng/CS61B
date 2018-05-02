public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** Thte first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirts() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list*/
    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;

        /** Move p until it reaches the end of the list*/
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }


    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);

        System.out.println(L.size());

    }


    /** SLList class acts as a middle man between user and the naked recursive data structure.
     * Allows us to store meta information about entire list, e.g. size */
}
