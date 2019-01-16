import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> t = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> s = new ArrayDequeSolution<>();

        for (int i=0; i < 30; i++) {
            int f = StdRandom.uniform(3);

            switch (f) {
                case 0:
                    int addNum = StdRandom.uniform(10);
                    t.addFirst(addNum);
                    s.addFirst(addNum);
                    break;

                case 1:
                    addNum = StdRandom.uniform(10);
                    t.addLast(addNum);
                    s.addLast(addNum);
                    break;

                case 2:
                    if (! t.isEmpty()) {
                        int tRamdom = t.removeFirst();
                        int sRamdom = s.removeFirst();
                        assertEquals(tRamdom, sRamdom);
                    }
                    break;

                case 3:
                    if (! s.isEmpty()) {
                        int tRamdom = t.removeLast();
                        int sRamdom = s.removeLast();
                        assertEquals(tRamdom, sRamdom);
                    }
            }

        }
        for (int i = 0; i<s.size(); i++)
            assertEquals(s.get(i), t.get(i));


    }


}
