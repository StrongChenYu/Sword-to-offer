package sword_to_offer;

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


    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("a        b");
        System.out.println(replaceSpace(s));
    }
}
