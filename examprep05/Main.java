import java.util.*;

public class Main {

    /*** a) Given an array of integers A and an integer k, return true if any two numbers
     in the array sum up to k, and return false otherwise. How would you do this?
     Give the main idea and what ADT you would use. */
    public boolean twoSum(int[] A, int k) {
        Set<Integer> n = new HashSet<>();
        for (int i: A) {
            if (n.contains(k - i)) {
                return true;
            }
        }
        return false;
    }

    /** b) Find the k most common words in a document. Assume that you can represent
     this as an array of Strings, where each word is an element in the array. You
     might find using multiple data structures useful.  **/
    public static void countTopKwords(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            if (!counts.containsKey(w)) {
                counts.put(w, 1);
            } else {
                counts.put(w, counts.get(w) + 1);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return counts.get(o1) - counts.get(o2) ;
            }
        });

        for (String w : counts.keySet()) {
            pq.add(w);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll());
        }

    }

    /** a) Define a Queue class that implements the push and poll methods of a queue
     ADT using only a Stack class which implements the stack ADT.
     Hint: Try using two stacks */
    public Deque<Item> {
        private Stack<Item> a;
        private Stack<Item> b;

        public Deque() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(Item t) {
            while (! a.isEmpty()) {
                b.push(a.poll());
            }
            a.push(t);
            while (!b.isEmpty()) {
                a.push(b.poll());
            }
        }
        public Item poll() {
            a.poll();
        }
    }

    /** b) Suppose we wanted a data structure SortedStack that takes in integers, and
     maintains them in sorted order. SortedStack supports two operations: push(int i)
     and pop(). Pushing puts an int onto our SortedStack, and popping returns
     the next smallest item in the SortedStack. For example, if we inserted 10, 4, 8,
     2, 14, and 3 into a SortedStack, and then popped everything off, we would get
     2, 3, 4, 8, 10, 14.  **/

    public class SortedStack<Item extends Comparable<Item>> {
        private Stack<Item> a;
        private Stack<Item> b;

        public SortedStack() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(Item t) {
            while (! a.empty() && a.peek().compareTo(t) < 0) {
                b.push(a.poll());
            }
            a.push(t);
            while (! b.empty()) {
                a.push(b.poll());
            }
        }

        public Item poll() {
            return a.poll();
        }


    }

}
