package pl.kaczor.codility.lesssons.prefsums;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int diff = B - A;
        int result = diff / K;
        return (A % K == 0 || B % K == 0 || (K > A && K < B && ( A % K > B % K))) ? result + 1 : result;
    }
}
