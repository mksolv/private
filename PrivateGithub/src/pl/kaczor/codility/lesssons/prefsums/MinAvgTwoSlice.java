package pl.kaczor.codility.lesssons.prefsums;

public class MinAvgTwoSlice {

    private class Slice {
        int start;
        int length;
        double average;

        public Slice(int start, int length, double average) {
            this.start = start;
            this.length = length;
            this.average = average;
        }
    }

    public int solution(int[] A) {
        int smallestSum = Integer.MAX_VALUE;
        int currentSum = 0;
        int result = 0;
        for (int i = 0; i < A.length - 1; i++) {
            currentSum = A[i] + A[i + 1];
            if (currentSum < smallestSum) {
                smallestSum = currentSum;
                result = i;
            }
        }

        if (smallestSum < 0) {
            Slice resultSlice = new Slice(result, 2, (double) smallestSum / 2);
            Slice expandedSlice = expandSlice(A, resultSlice);
            while (expandedSlice.average < resultSlice.average) {
                resultSlice = expandedSlice;
                expandedSlice = expandSlice(A, resultSlice);
            }
            result = resultSlice.start;
        }

        return result;
    }

    private Slice expandSlice(int[] a, Slice s) {
        int newLength = s.length + 1;
        if (s.start > 0) { // expanding left
            int leftExpandedSum = 0;
            int leftStart = s.start - 1;
            for (int i = leftStart; i < s.start + s.length; i++) {
                leftExpandedSum += a[i];
            }
            double leftAverage = (double) leftExpandedSum / newLength;
            if (leftAverage < s.average) {
                s = new Slice(s.start - 1, s.length + 1, leftAverage);
            }
        }
        if (s.start + s.length < a.length) { // expanding right
            int rightExpandedSum = 0;
            for (int i = s.start; i < s.start + s.length; i++) {
                rightExpandedSum += a[i];
            }
            double rightAverage = (double) rightExpandedSum / newLength;
            if (rightAverage < s.average) {
                s = new Slice(s.start, s.length + 1, rightAverage);
            }

        }
        return s;
    }
}
