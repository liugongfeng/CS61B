import static java.lang.Math.abs;

public class OffByN implements CharacterComparator{

    private int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return abs(y-x) == n;
    }

}
