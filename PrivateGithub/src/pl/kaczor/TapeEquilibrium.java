package pl.kaczor;

public class TapeEquilibrium {
    public static int solution(int[] A) {
        int[] orderedSum = new int[A.length];
        orderedSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            orderedSum[i] = A[i] + orderedSum[i - 1];
        }

        int[] reversedSum = new int[A.length];
        reversedSum[A.length - 1] = A[A.length - 1];
        for (int j = A.length - 2; j >= 0; j--) {
            reversedSum[j] = reversedSum[j + 1] + A[j];
        }

        int diff = Math.abs(orderedSum[0] - reversedSum[1]);
        for (int i = 1; i < A.length-2; i++) {
            int tmpDiff = Math.abs(orderedSum[i] - reversedSum[i+1]);
            if (tmpDiff < diff)
                diff = tmpDiff;
        }

        return diff;
    }
}
