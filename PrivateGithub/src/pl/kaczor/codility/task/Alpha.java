package pl.kaczor.codility.task;

import java.util.Arrays;

public class Alpha {
    public int solution(int[] A) {
        int[] countTab = new int[A.length];
        Arrays.fill(countTab, -1);
        int maxVal = 0;
        for (int i = 0; i < A.length; i++) {
            if (countTab[A[i]] == -1) {
                countTab[A[i]] = i;
            }
            if (maxVal < A[i]) {
                maxVal = A[i];
            }
        }

        int maxIndex = 0;
        for (int i = 0; i <= maxVal; i++) {
            if (countTab[i] > maxIndex) {
                maxIndex = countTab[i];
            }
        }

        return maxIndex;
    }
}
