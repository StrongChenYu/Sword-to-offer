package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

//replace space to %20
public class JZ2 {

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) return str.toString();

        int pre = str.length() - 1;
        for (int i = 0; i <= pre; i++) {
            if (str.charAt(i) == ' ') str.append("  ");
        }

        int index = str.length() - 1;
        while (pre >= 0 && index >=0 && pre != index) {
            if (str.charAt(pre) == ' ') {
                str.setCharAt(index--, '0');
                str.setCharAt(index--, '2');
                str.setCharAt(index--, '%');
                pre--;
            } else {
                str.setCharAt(index--, str.charAt(pre--));
            }
        }

        return str.toString();
    }

    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("  ");
        }

        int cur = sb.length() - 1;
        int ori = s.length() - 1;

        while (cur != ori) {
            char oriChar = sb.charAt(ori--);
            if (oriChar == ' ') {
                sb.setCharAt(cur--, '0');
                sb.setCharAt(cur--, '2');
                sb.setCharAt(cur--, '%');
            } else {
                sb.setCharAt(cur--, oriChar);
            }
        }

        return sb.toString();
    }

    @Test
    public void Test() {
        Assert.assertEquals(replaceSpace(""), "");
        Assert.assertEquals(replaceSpace(" "), "%20");
        Assert.assertEquals(replaceSpace("a"), "a");
        Assert.assertEquals(replaceSpace("    "), "%20%20%20%20");
        Assert.assertEquals(replaceSpace("a b"), "a%20b");
        Assert.assertEquals(replaceSpace("a b "), "a%20b%20");
    }


    public static void main(String[] args) {

    }
}
