package pl.kaczor.codility.lesssons.prefsums;

/**
 * Najmniejsza srednia moze byc tylko w kawalkach 2-elementowych (jesli oba elementy sa dodatnie) lub 3-elementowych
 * (jesli ktorys z elementow jest ujemny)
 *
 * @author mateusz.kaczmarek
 *
 */
public class MinAvgTwoSlice {

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

        if (A[result] < 0 || A[result + 1] < 0) {
            double smallestAvg = (double) smallestSum / 2;
            double currentAvg;
            for (int i = 0; i < A.length - 2; i++) {
                currentSum = A[i] + A[i + 1] + A[i + 2];
                currentAvg = (double) currentSum / 3;
                if (currentAvg < smallestAvg) {
                    smallestAvg = currentAvg;
                    result = i;
                }
            }
        }

        return result;
    }

}
