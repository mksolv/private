package pl.kaczor.codility.lesssons.timecplx;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        int result = (Y - X) / D;
        if ((Y - X) % D != 0) {
            result += 1;
        }
        return result;
    }

}
