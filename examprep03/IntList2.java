/** Remove Duplicates. */

public class IntList2 {
    public int first;
    public IntList2 rest;
    public IntList2 (int f, IntList2 r) {
        this.first = f;
        this.rest = r;
    }

     /** Given a sorted linked list of items - remove duplicates.
      *  For example, given 1 -> 2 -> 2 -> 2-> 3,
      *  Mutate it to become 1 -> 2 -> 3 (destructively)
      * */
     public static void removeDuplicates(IntList2 p) {
         if (p == null) return ;
         IntList2 current = p.rest;
         IntList2 previous = p;
         while ( current != null) {
             if (current.first == previous.first) {
                 previous.rest = current.rest;
                 current = current.rest;
             } else {
                 previous = current;
                 current = current.rest;
             }
         }
     }

}
