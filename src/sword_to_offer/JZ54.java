package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class JZ54 {

    private final int[] charMap = new int[128];
    private final Queue<Character> charQueue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charMap[ch - 'A']++ == 0) {
            charQueue.offer(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Character CHAR;
        char c;
        while ((CHAR = charQueue.peek()) != null) {
            c = CHAR;
            if (charMap[c - 'a'] == 1) {
                return c;
            } else {
                charQueue.poll();
            }
        }
        return '#';
    }

    @Test
    public void Test() {
        Insert('a');
        Assert.assertEquals(FirstAppearingOnce(),'a');
        Insert('a');
        Assert.assertEquals(FirstAppearingOnce(),'#');
        Insert('o');
        Assert.assertEquals(FirstAppearingOnce(),'o');
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
    }
}
