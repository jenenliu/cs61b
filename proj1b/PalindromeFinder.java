/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words");
        OffByOne offByOne = new OffByOne();
        OffByN offByN = new OffByN(4);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, offByN)) {
                System.out.println(word);
            }
        }
    }
} 
