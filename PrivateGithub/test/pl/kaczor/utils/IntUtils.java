package pl.kaczor.utils;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class IntUtils {

    public static int[] getConsecutiveIntArray(int size) {
        return getConsecutiveIntArray(size, 0);
    }

    public static int[] getConsecutiveIntArray(int size, int offset) {
        int[] tab = new int[size];
//        Arrays.setAll(tab, new IntUnaryOperator() {
//            @Override
//            public int applyAsInt(int operand) {
//                return operand + offset;
//            }
//        });
        Arrays.setAll(tab, operand -> {
            return operand + offset;
        });
        return tab;
    }

    public static int[] reverseArray(int[] input) {
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            output[i] = input[input.length - 1 - i];
        }

        return output;
    }

    public static int max(int[] tab) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > result) {
                result = tab[i];
            }
        }
        return result;
    }
}
