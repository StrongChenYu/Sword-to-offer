package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. 库函数
 * 2. 应该想到用栈的！！！！！但是栈的做法个人觉得并不好
 * 3. 最后就是使用原始解法
 */
public class JZ44 {

    /**
     * 使用最原始的解法
     * 1. 先把所有的串都颠倒一次
     * 2. 再把翻转后的串钟的单词，反转过来
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();

        reverse(chars, 0, chars.length - 1);

        //for debug
        //System.out.println(String.valueOf(chars));


        int left = 0;
        int right = 0;

        /**
         * 直接像滑动窗口类似的双指针
         */
        while (left < chars.length) {
            if (right == chars.length || chars[right] == ' ') {
                //这种情况下说明找到了单词
                reverse(chars,left,right - 1);
                left = right + 1;
                right = left;
            } else {
                right++;
            }
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }


    /**
     * 借助库函数的做法
     * @param str
     * @return
     */
    public String ReverseSentence_BuildFun(String str) {
        if (str == null) return null;
        String[] words = str.split(" ");

        //这里是为了考虑空格的情况
        if (words.length == 0) return str;

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

    @Test
    public void Test() {
        Assert.assertEquals(ReverseSentence("a"),"a");
        Assert.assertEquals(ReverseSentence(""),"");
        Assert.assertEquals(ReverseSentence(null),null);
        Assert.assertEquals(ReverseSentence("  "),"  ");
        Assert.assertEquals(ReverseSentence("nowcoder. a am I"),"I am a nowcoder.");

    }

    public static void main(String[] args) {
        String s = "  ";
        String[] s1 = s.split(" ");
        System.out.println(s1.length);
    }
}
