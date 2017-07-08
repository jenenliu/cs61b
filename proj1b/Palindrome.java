/**
 * Created by jenenliu on 2017/7/7.
 */
public class Palindrome implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return x == y;
    }

    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            characters.addLast(word.charAt(i));
        }

        return characters;
    }

    public static Boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);

        if (characterDeque.isEmpty() || characterDeque.size() == 1) {
            return true;
        }

        return isPalindromeRecursive(characterDeque, 0, characterDeque.size()-1, cc);
    }

    private static Boolean isPalindromeRecursive(Deque<Character> characterDeque, int start, int end, CharacterComparator cc) {
        if (start >= end) {
            return true;
        }

        if (!cc.equalChars(characterDeque.get(start), characterDeque.get(end))) {
            return false;
        } else {
            return isPalindromeRecursive(characterDeque, start+1, end-1, cc);
        }
    }
    public static Boolean isPalindromeInteractive(String word) {
        Deque<Character> characterDeque = wordToDeque(word);

        if (characterDeque.isEmpty() || characterDeque.size() == 1) {
            return true;
        }

        int start = 0;
        int end = characterDeque.size() - 1;
        for ( ; start < end; start = start + 1, end = end - 1) {
            if (!characterDeque.get(start).equals(characterDeque.get(end))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);

        if (characterDeque.isEmpty() || characterDeque.size() == 1) {
            return true;
        }

        return recursiveIsPalindrome(characterDeque, 0, characterDeque.size() - 1);
    }

    private static Boolean recursiveIsPalindrome(Deque<Character> characterDeque, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (!characterDeque.get(start).equals(characterDeque.get(end))) {
            return false;
        } else {
            return recursiveIsPalindrome(characterDeque, start+1, end-1);
        }
        }
}
