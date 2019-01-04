package cs61b;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /**Implement SLList.insert which takes in an integer x and inserts it at the given
     position. If the position is after the end of the list, insert the new node at the end.
     For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2 */
    public void insert(int item, int position){
        if (position == 0 || first == null) {
            addFirst(item);
            return ;
        }
        IntNode currentNode = first;
        while (position > 1 && currentNode.next != null) {
            position -- ;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }

    /**Add another method to the SLList class that reverses the elements. Do this using
     the existing IntNodes (you should not use new).*/
    public void reverse() {
        IntNode reversed = null;
        IntNode nextNode = first;
        while (nextNode != null) {
            IntNode remainder = nextNode.next;
            nextNode.next = reversed;
            reversed = nextNode;
            nextNode = remainder;
        }
        first = reversed;
    }

    /** Recursion reverse() */
    public void reverseRucursion() {
        first = reverseRecursiveHelper(first);
    }

    public IntNode reverseRecursiveHelper(IntNode front) {
        if (front == null || front.next == null)
            return front;
        else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }


    /** Arrays */
    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1] ;
        position = Math.min(arr.length, position);
        for (int i = 0; i < position; i++)
            result[i] = arr[i];

        result[position] = item;

        for (int i=position; i<arr.length; i++)
            result[i] = arr[i];

        return result;
    }

    /** Reverse on an array [1, 2, 3] should change the array to be [3, 2, 1]. */
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

   /** Write a non-destructive method replicate(int[] arr) that replaces the
    number at index i with arr[i] copies of itself. For example,
    replicate([3, 2, 1]) would return [3, 3, 3, 2, 2, 1]*/
    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int item : arr)
            total += item;
        int[] result = new int[total];
        int i = 0;
        for (int item : arr) {
            for (int j=0; j < item; j++) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        replicate(arr);
    }

}
