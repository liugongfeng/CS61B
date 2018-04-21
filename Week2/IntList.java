public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null)
            return 1;
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static IntList sqaure(IntList L) {
        if (L == null) {
            return L;
        }
        else {
            IntList rest = sqaure(L.rest);
            IntList M = new IntList(L.first * L.first, rest);
            return M;
        }
    }

    public static IntList squareMutative(IntList L) {
        IntList B = L;
        while (B != null) {
            B.first *= B.first;
            B = B.rest;
        }
        return L;
    }
    
    
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList B = L;
        while (B != null) {
            B.first = B.first - x;
            B = B.rest;
        }
        return L;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList C = L;
        while (C != null) {
            C.first = C.first - x;
            C = C.rest;
        }
        return L;
    }



    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

//        System.out.println(L.size());
//        System.out.println(L.iterativeSize());
//        System.out.println(L.get(1));
        
//         System.out.println(incrList(L, 3));
//         System.out.println(dincrList(L, 3));


    }
}
