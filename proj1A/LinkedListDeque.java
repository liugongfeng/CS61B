public class LinkedListDeque<Item> {

    private class ListNode {
        private Item data;
        private ListNode prev;
        private ListNode next;

        private ListNode(ListNode p, Item d, ListNode n) {
            this.prev = p;
            this.data = d;
            this.next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    /** Create an empty deque. */
    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null) ;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Add an Item type data to the front of deque. */
    public void addFirst(Item data) {
        sentinel.next = new ListNode(sentinel, data, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    /** Add an Item type data to the last of th deque. */
    public void addLast(Item data) {
        sentinel.prev.next = new ListNode(sentinel.prev, data, sentinel);
        sentinel.prev = sentinel.prev.next;
        size ++ ;
    }

    /** Return true if deque is empty*/
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Return the length of the deque. Constant time! */
    public int size() {
        return size;
    }

    /** Print the data of deque. */
    public void printDeque () {
        ListNode node = sentinel;
        while (node.next != sentinel) {
            System.out.print(node.next.data + " ");
            node = node.next;
        }
    }

    /** Remove the first Item type data in deque and return the removed data. */
    public Item removeFirst () {
        if (size == 0) return null;
        else {
            Item first = sentinel.next.data;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size --;
            return first;
        }
    }

    /** Remove the last Item type data in deque and return the removed data. */
    public Item removeLast () {
        if (size == 0)  return null;
        else {
            Item last = sentinel.prev.data;
            sentinel.prev.prev.next = sentinel.prev.next;
            sentinel.prev = sentinel.prev.prev;
            size --;
            return  last;
        }
    }

    /** Get index-th position data. By iterative. */
    public Item get(int index) {
        int length = size;
        ListNode node = sentinel.next;
        if (index > length - 1)  return null;   // Out of range.
        else {
            for (int i = 0; i < index; i++)
                node = node.next;
        }
        return node.data;
    }

    /** Get index-th position data. By recursion. */
    public Item getRecursion(int index) {
        int length = size;
        if (index > length-1) return null;      // Out of range.
        else {
            return getRecursionHelper(sentinel.next, index);
        }
    }
    /** getRecursionHelper*/
    public Item getRecursionHelper(ListNode node, int i) {
        if (i == 0)
            return node.data;
        else
            return getRecursionHelper(node.next, i-1);
    }

    public static void main(String[] args)  {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        list.addFirst(1);
        list.addLast(22);
        list.addLast(333);
        list.addLast(4444);
        list.printDeque();
    }

}
