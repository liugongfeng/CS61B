public class DogLaucher {
    public static void main(String[] args) {
        Dog d = new Dog(15);
        Dog d2 = new Dog(100);

//        Dog bigger = Dog.maxDog(d, d2);
//        bigger.makeNoise();
        Dog bigger = d.maxDog(d2);

        d.makeNoise();
    }
}
