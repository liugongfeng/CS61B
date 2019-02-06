import java.util.HashSet;

public class CTCI {


    public static int[] union(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }

        for (int num : B) {
            set.add(num);
        }

        int[] unionArray = new int[set.size()];
        int index = 0;
        for (int num : set) {
            unionArray[index] = num;
            index ++;
        }
        return unionArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {3,4,5,6};
        int[] c = union(a, b);
        for (int i = 0; i < c.length-1; i++)
            System.out.print(c[i] + " ");

        System.out.println(c[c.length -1]);
    }
}
