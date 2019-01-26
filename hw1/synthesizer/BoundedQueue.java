package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    /** All methods in interface are public as default, we do not need the key word public. */

    // Return size of the buffer.
    int capacity();

    // return number of items currently in the buffer.
    int fillCount();

    // Add item x to the end.
    void enqueue(T x);

    // delete and return item from the front.
    T dequeue();

    // return (but do not delete) item from the front.
    T peek();

    // is the buffer empty (fillCount equals zero) ?
    default boolean isEmpty() {
        return fillCount() == 0 ;
    }

    // is the buffer full (fillCount is same as capacity) ?
    default boolean isFull() {
        return fillCount() == capacity() ;
    }

}
