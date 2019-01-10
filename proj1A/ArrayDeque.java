
public class ArrayDeque<Item> {

    private int size;
    private int head;
    private int tail;
    private Item[] items;

    /** Create an empty array. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        head = 0;
        tail = 1;
    }

    private void resize(int length) {
        Item[] newArray = (Item[]) new Object[length];
        if (tail > head)
            System.arraycopy(items, head+1, newArray, 0, tail-head-1);
        else if (head == tail)
            System.arraycopy(items, 0, newArray, 0, tail);
        else {
            System.arraycopy(items, head+1, newArray, 0, items.length-head-1);
            System.arraycopy(items, 0, newArray, items.length-head-1, tail);
        }
        head = length - 1;
        tail = size;
        items = newArray;
    }

    /** Add an element to the head in array. */
    public void addFirst(Item item) {
        if (size == items.length)
            resize(2 * size);
        items[head] = item;
        size++;
        head = minusOne(head);
    }

    /** Add an element to the tail in array. */
    public void addLast(Item item) {
        if (size == items.length)
            resize(2 * size);
        items[tail] = item;
        size++;
        tail = plusOne(tail);
    }

    public Item removeFirst() {
        if (isEmpty())
            return null;
        head = plusOne(head);
        size--;
        Item removed = items[head];
        items[head] = null;
        if (items.length > 16 &&  (float)size/items.length < 0.25)
            resize(items.length / 2);
        return removed;
    }

    public Item removeLast() {
        if (isEmpty())
            return null;
        if ( (float)size/items.length < 0.25 && items.length >= 16)
            resize(items.length / 2);
        tail = minusOne(tail);
        size --;
        Item removed = items[tail];
        items[tail] = null;
        return removed;
    }

    public Item get(int index) {
        if (index > head || index < tail)
            return items[index];
        return null;
    }

    public int plusOne(int index) {
        if (index + 1 > items.length - 1)
            return 0;
        return index + 1;
    }

    private int minusOne(int index) {
        if (index - 1 < 0)
            return items.length - 1;
        return index - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = plusOne(head);
        while (i != tail)  {
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
    }

}
