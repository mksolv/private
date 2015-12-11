package pl.kaczor.codility.lesssons.counting;

public class PermCheck {
    public int solution(int[] A) {
        int[] foundNumbers = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 < foundNumbers.length) {
                foundNumbers[A[i] - 1] = 1;
            }
        }

        for (int i = 0; i < foundNumbers.length; i++) {
            if (foundNumbers[i] == 0) {
                return 0;
            }
        }
        return 1;
    }
}
