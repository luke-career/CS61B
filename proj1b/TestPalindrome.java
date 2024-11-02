import datastructure.Deque;
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
    }

    @Test
    public void testNoepalindrome(){
        String test1 = "blue";
        Boolean actural = palindrome.isPalindrome(test1);
        assertEquals(true,actural);
    }
    @Test
    public void testOneWord(){
        String test1 = "b";
        Boolean actural = palindrome.isPalindrome(test1);
        assertEquals(true,actural);
    }

    @Test
    public void testIsepalindrome(){
        String test1 = "noon";
        Boolean actural = palindrome.isPalindrome(test1);
        assertEquals(true,actural);
    }

    @Test
    public void testnullepalindrome(){
        String test1 = " ";
        Boolean actural = palindrome.isPalindrome(test1);
        assertEquals(true,actural);
    }





}
