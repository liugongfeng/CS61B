
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /** Not good.
     * Failed in
     *     10
     *    /  \
     *   5    15
     * /  \
     *3   12*/
    public static boolean isBSTBad (TreeNode T) {
        if (T == null)
            return true;
        else if (T.left != null && T.left.val > T.val)
            return false;
        else if (T.right !=null && T.right.val < T.val)
            return false;
        else
            return isBSTBad(T.left) && isBSTBad(T.right);
    }


    public static boolean isBSTGood(TreeNode T) {
        return isBSTHelper(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public static boolean isBSTHelper(TreeNode T, int min, int max) {
        if (T == null)
            return true;
        else if (T.val < min || T.val > max)
            return false;
        else
            return isBSTHelper(T.left, min, T.val) && isBSTHelper(T.right, T.val, max);
    }
    /**
     * (10  MIN_VALUE  MAX_VALUE)
     *  (5  MIN_VALUE 10)      &&      (15  10  MAX_VALUE)
     *  (3  MIN_VALUE 5) && (12 5 10)        &&        true(null)
     *       (true)     &&     (false)              &&        true(null)
     *            false [end]
     *
     * **/


    public static boolean isBST(TreeNode T) {
        return BSTHelper(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean BSTHelper(TreeNode T, int min, int max) {
        if (T == null)
            return true;
        else if (T.val < min || T.val > max)
            return false;
        else
            return BSTHelper(T.left, min, T.val) && BSTHelper(T.right, T.val, max) ;
    }

}
