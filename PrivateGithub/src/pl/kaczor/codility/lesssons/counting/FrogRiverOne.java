package pl.kaczor.codility.lesssons.counting;

import java.util.Arrays;

import pl.kaczor.utils.IntUtils;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        int[] firstOccurances = new int[X + 1];
        Arrays.fill(firstOccurances, -1);
        for (int i = 0; i < A.length; i++) {
            if (firstOccurances[A[i]] == -1) {
                firstOccurances[A[i]] = i;
            }
        }

        int result = -1;
        for (int i = 1; i < firstOccurances.length; i++) {
            if (firstOccurances[i] == -1) {
                return -1;
            }
            if (firstOccurances[i] > result) {
                result = firstOccurances[i];
            }
        }

//        return IntUtils.max(firstOccurances);
        return result;
    }
}
