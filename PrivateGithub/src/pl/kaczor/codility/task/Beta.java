package pl.kaczor.codility.task;

import java.util.Arrays;

/**
 * Kluczem jest tutaj przyjecie odpowiedniej struktury danych - dwuliczbowych przedziaów domknietych &lt;a, b&gt;
 * okreslajacych zasieg oddzialywania kazdego "dysku" (lepiej wyobrazic go sobie jako odcinek na dwuwymiarowej osi). Po
 * przygotowaniu takich przedzialow i ich posortowaniu wystarczy isc po kolei i zliczac ile dalszych w kolejnosci
 * przedzialow ma punkty wspolne z danym.
 *
 * @author mateusz.kaczmarek
 *
 */
public class Beta {

    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Interval b) {
            if (this.getStart() == b.getStart()) {
                return this.getEnd() - b.getEnd();
            } else {
                return this.getStart() - b.getStart();
            }
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public int solution(int[] A) {
        int[] countTab = new int[A.length];
        int intersections = 0;

        Interval[] intervals = new Interval[A.length];

        for (int i = 0; i < A.length; i++) {
            int min = i - A[i];
            if (min < 0) {
                min = 0;
            }
            int max = (A[i] == Integer.MAX_VALUE) ? A[i] : i + A[i];
            if (max > countTab.length - 1) {
                max = countTab.length - 1;
            }
            intervals[i] = new Interval(min, max);
        }

        Arrays.sort(intervals);

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length && intervals[j].getStart() <= intervals[i].getEnd(); j++) {
                intersections += 1;

                if (intersections > 10_000_000) {
                    return -1;
                }
            }
        }

        return intersections;
    }
}
