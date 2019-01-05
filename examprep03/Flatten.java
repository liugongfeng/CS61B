public class Flatten {

    public static int[] flatten(int[][] x) {
        int totalLenghth = 0;
        for (int i = 0; i < x.length; i++)
            totalLenghth += x[i].length;

        int[] a = new int[totalLenghth];
        int index = 0;

        for (int i=0; i<x.length; i++)
            for (int j=0; j<x[i].length; j++) {
                a[index] = x[i][j];
                index ++;
            }
        return a;
    }
}
