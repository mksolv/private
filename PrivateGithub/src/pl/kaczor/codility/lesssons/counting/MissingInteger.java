package pl.kaczor.codility.lesssons.counting;

public class MissingInteger {
    public int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] foundNumbers = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < A.length + 1 && A[i] > 0) {
                foundNumbers[A[i]] = 1;
            }
        }

        if (min > 1) {
            return 1;
        }
        if (max < 1) {
            return 1;
        }

        for (int i = 1; i < foundNumbers.length; i++) {
            if (foundNumbers[i] == 0) {
                return i;
            }
        }

        return foundNumbers.length;
    }
}
