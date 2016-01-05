package pl.kaczor.codility.lesssons.timecplx;

public class PermMissingElem {
    public int solution(int[] A) {
        long sum = 0;
        long properSum;
        for (int a : A) {
            sum += a;
        }

        properSum = (long) (A.length + 1) * (A.length + 2) / 2;

        return (int) (properSum - sum);
    }

}
