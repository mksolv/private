package pl.kaczor.codility.lesssons.prefsums;

public class PassingCars {
    public int solution(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                count += 1;
            } else {
                sum += count;
            }
            if (sum > 1_000_000_000) {
                return -1;
            }
        }

        return sum;
    }
}
