public interface Deque<Item> {
    /** all methods in interface are public, so we do not need the key word public. */

    /** Add one item to the front of the deque. */
    void addFirst(Item item);

    /** Add  one item to the end of the deque. */
    void addLast(Item item);

    /** Return true if the deque is empty*/
    boolean isEmpty();

    /** Return the size of the deque. */
    int size();

    /** print all elements in the deque. */
    void printDeque();

    /** Delete the first item and return the deleted item. */
    Item removeFirst();

    /** Delete the last item and return the deleted item. */
    Item removeLast();

}
