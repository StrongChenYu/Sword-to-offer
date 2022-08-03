package leetcode.string;

import org.junit.Test;

import java.math.BigInteger;

public class P43_Multiply_Strings {

    public String multiply(String num1, String num2) {
        // 这种傻呗题，神经病
        BigInteger bi1 = new BigInteger(num1);
        BigInteger bi2 = new BigInteger(num2);

        BigInteger multiply = bi1.multiply(bi2);
        return multiply.toString();
    }

}
