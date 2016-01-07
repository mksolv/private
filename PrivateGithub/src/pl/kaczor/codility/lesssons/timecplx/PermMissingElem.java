package pl.kaczor.codility.lesssons.timecplx;

import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {
        long sum = 0;
        long properSum;
//        for (int a : A) {
//            sum += a;
//        }
        sum = Arrays.stream(A).sum();

        properSum = (long) (A.length + 1) * (A.length + 2) / 2;

        return (int) (properSum - sum);
    }

}
