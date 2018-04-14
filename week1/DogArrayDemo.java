public class DogArrayDemo {
    public static void main(String[] args) {
        /* Create an array of two dogs. */
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(51);


        /* Yipping will result , since dosg[0] has weight 8. */
        dogs[1].makeNoise();

    }
}
