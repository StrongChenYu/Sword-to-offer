package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Chen Yu
 * @Date 2021/4/18 14:49
 */
public class P71_Simplify_Path {

    public String simplifyPath(String path) {

        String[] splits = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String s : splits) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.removeLast();
                continue;
            }
            stack.addLast(s);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/");
            res.append(stack.removeFirst());
        }

        return res.length() == 0 ? "/" : res.toString();
    }

    @Test
    public void Test() {
        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/", simplifyPath("/../"));
        Assert.assertEquals("/home/foo" , simplifyPath("/home//foo/"));
        Assert.assertEquals("/c" , simplifyPath("/a/./b/../../c/"));
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("bca");
        int n = sb.length();
        while (sb.charAt(n - 1) != 'b') {
            sb.deleteCharAt(n - 1);
            n = sb.length();
        }
        System.out.println(sb.length());
    }
}
