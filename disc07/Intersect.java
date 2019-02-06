import java.util.HashSet;

public class Intersect {

    public static int[] intersection(int[] A, int[] B) {
        HashSet<Integer> setOfA = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : A)
            setOfA.add(num);

        for (int num : B)
            if (setOfA.contains(num))
                intersectionSet.add(num);

        int[] returnArray = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            returnArray[index] = num;
            index ++ ;
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {3,4,5,6};
        int[] c = intersection(a, b);

        for (int i = 0; i < c.length-1; i++){
            System.out.print(c[i] + " ");
        }

        System.out.println(c[c.length - 1]);
    }
}
