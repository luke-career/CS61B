import datastructure.Deque;
import datastructure.LinkedListDeque;

public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        char[] items = word.toCharArray();
        Deque<Character> result = new LinkedListDeque<>();
        for(int i = 0; i < items.length; i++){
            result.addLast(items[i]);
        }
        return result;
    }


    public boolean isPalindrome(String word){
        Deque<Character> result = new LinkedListDeque<>();
        if(result.size() > 1){
            if(result.removeFirst() != result.removeLast()){
                return false;
            }
        }
        return true;
    }
}
