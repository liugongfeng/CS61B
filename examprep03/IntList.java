public class IntList {
    public int first;
    public IntList rest;

    /**
     * @Override public boolean equals(Object o) { ... }
     * public static IntList list(int... args) { ... }
     */

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) break;
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
            n++;
        }

    }
}
