public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dequeOfWords = new LinkedListDeque<>();
        for (int i = 0; i<word.length(); i++) {
            dequeOfWords.addLast(word.charAt(i));
        }
        return dequeOfWords;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dequeOfWords = wordToDeque(word);
        if (dequeOfWords.size()==1 || dequeOfWords.size() ==0)
            return true;
        else {
            if (dequeOfWords.removeFirst() == dequeOfWords.removeLast() )
                return isPalindrome(word2String(dequeOfWords));
        }
        return false;
    }

    /** Helper function for isPalindrome. */
    private String word2String(Deque d) {
        String s = "";
        while (d.size() > 0) {
            s += d.removeLast();
        }
        return s;
    }


    /** Task 4:Generalized Palindrome and OffByOne. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dequeOfWord = wordToDeque(word);
        if (dequeOfWord.size() == 0 || dequeOfWord.size() == 1)
            return true;
        else {
            if (cc.equalChars(dequeOfWord.removeFirst(), dequeOfWord.removeLast())) {
                return isPalindrome(word2String(dequeOfWord), cc);
            } else {
                return false;
            }
        }

    }

}
