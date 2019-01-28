public class exceptions {

    public static void checkIfZero(int x) throws Exception {
        if (x == 0)
            throw new Exception("x was zero!");
        System.out.println(x);          // print statement.
    }

    public static int mystery(int x) {
        int counter = 999;      // 0
        try {
            while (true) {
                x = x / 2;
                checkIfZero(x);
                counter++;
                System.out.println("counter is " + counter); // print statement.
            }
        } catch (Exception e) {
            return counter;
        }
    }


    public static void main(String[] args) {
        System.out.println("mystery of 1 is " + mystery(1));
        /**
         * mystery of 1 is [counter]
         * */

        System.out.println("mystery of 6 is " + mystery(6));
        /**output:
         * 3  // counter 1
         * counter is 1
         * 1  // counter 2
         * counter is 2
         * mystery of 6 is [counter]
         * */

    }


}
