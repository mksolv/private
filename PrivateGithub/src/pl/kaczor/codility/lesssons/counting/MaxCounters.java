package pl.kaczor.codility.lesssons.counting;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];

        int base = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                base = max;
            } else {
                if (counters[A[i] - 1] < base) {
                    counters[A[i] - 1] = base;
                }
                counters[A[i] - 1] += 1;
                if (counters[A[i] - 1] > max) {
                    max = counters[A[i] - 1];
                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < base) {
                counters[i] = base;
            }
        }

        return counters;
    }
}
