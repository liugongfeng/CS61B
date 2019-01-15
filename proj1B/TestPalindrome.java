import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.


    @Test
    public void TestIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome("abcba"));
        assertEquals(true, palindrome.isPalindrome("a"));
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(false, palindrome.isPalindrome("Ab"));
        assertEquals(false, palindrome.isPalindrome("AbCba"));

    }

    @Test
    public void TestIsPalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));

        assertFalse(palindrome.isPalindrome("aba", cc));
        assertFalse(palindrome.isPalindrome("aaab", cc));
    }

}
