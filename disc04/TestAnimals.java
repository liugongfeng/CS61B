public class TestAnimals {

    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfeild", 6);
        Dog d = new Dog("Fido", 4);

        a.greet();          // Animal Pluto says: Huh?
        c.greet();          // Cat Gargeild says: Meow!
        d.greet();          // Dog Fido says: WOOF!
        a = c;
        ((Cat) a).greet();  // Cat Garfeild says: Meow!
        a.greet();          // Cat Garfeild says: Meow!
    }

}
