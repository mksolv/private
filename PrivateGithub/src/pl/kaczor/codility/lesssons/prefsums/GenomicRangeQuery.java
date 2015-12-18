package pl.kaczor.codility.lesssons.prefsums;

import java.util.Arrays;
import java.util.HashMap;

public class GenomicRangeQuery {

    class Slice {
        private AddableIntegralNumberHashMap<Character, Integer> nuclCounter;

        public Slice() {
            this.nuclCounter = new AddableIntegralNumberHashMap<Character, Integer>();
        }

        public void addNuclSequence(String s) {
            s.chars().forEach(a -> nuclCounter.put((char) a));
        }

        public void addNuclSingle(Character c) {
            nuclCounter.put(c);
        }

        public int getImpactFactor() {
            int result = -1;
            if (nuclCounter.containsKey('A')) {
                result = 1;
            } else if (nuclCounter.containsKey('C')) {
                result = 2;
            } else if (nuclCounter.containsKey('G')) {
                result = 3;
            } else if (nuclCounter.containsKey('T')) {
                result = 4;
            }
            return result;
        }

        public AddableIntegralNumberHashMap<Character, Integer> getNuclCounter() {
            return nuclCounter;
        }

        public void setNuclCounter(AddableIntegralNumberHashMap<Character, Integer> nuclCounter) {
            this.nuclCounter = nuclCounter;
        }

        @Override
        protected Object clone() {
            Slice newSlice = new Slice();
            newSlice.setNuclCounter((AddableIntegralNumberHashMap<Character, Integer>) this.getNuclCounter().clone());
            return newSlice;
        }

        @Override
        public String toString() {
            return nuclCounter.toString();
        }

        public Slice substract(Slice prefix) {
            if (prefix == null) {
                return this;
            }

            Slice result = new Slice();
            for (Character key : this.nuclCounter.keySet()) {
                Integer larger = this.nuclCounter.get(key);
                Integer smaller = prefix.getNuclCounter().get(key);
                Integer diff = (smaller == null) ? larger : larger - smaller;
                if (diff.compareTo(0) > 0) {
                    result.getNuclCounter().put(key, diff);
                }
            }
            return result;
        }

    }

    class AddableIntegralNumberHashMap<K, V extends Integer> extends HashMap<K, V> {
        private static final long serialVersionUID = 1L;

        public void put(K key) {
            V value = this.get(key);
            if (value != null && value instanceof Integer) {
                Integer newValue = (Integer) value + 1;
                super.put(key, (V) newValue);
            } else {
                super.put(key, (V) new Integer(1));
            }
        }
    }

    private int mapNuclToInt(char nucl) {
        switch (nucl) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 0;
        }
    }

    private int impactFactor(int[] slice) {
        for (int i = 1; i < 5; i++) {
            if (slice[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    private int[] substract(int[] sliceWithPrefix, int[] prefix) {
        if (prefix == null) {
            return sliceWithPrefix;
        }

        int[] result = new int[5];
        Arrays.fill(result, 0);
        for (int i = 1; i < 5; i++) {
            result[i] = sliceWithPrefix[i] - prefix[i];
        }
        return result;
    }

    public int[] solution(String S, int[] P, int[] Q) {

        int[][] prefSlices = new int[S.length()][];
        prefSlices[0] = new int[5];
        Arrays.fill(prefSlices[0], 0);
        prefSlices[0][mapNuclToInt(S.charAt(0))] += 1;
        for (int i = 1; i < prefSlices.length; i++) {
            prefSlices[i] = Arrays.copyOf(prefSlices[i - 1], 5);
            prefSlices[i][mapNuclToInt(S.charAt(i))] += 1;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int[] sliceWithPrefix = prefSlices[Q[i]];
            int[] prefix = P[i] > 0 ? prefSlices[P[i] - 1] : null;
            int[] slice = substract(sliceWithPrefix, prefix);
            result[i] = impactFactor(slice);
        }

        /*
         * Slice[] prefixSlices = new Slice[S.length()]; prefixSlices[0] = new Slice();
         * prefixSlices[0].addNuclSingle(S.charAt(0)); for (int i = 1; i < S.length(); i++) { prefixSlices[i] = (Slice)
         * prefixSlices[i - 1].clone(); prefixSlices[i].addNuclSingle(S.charAt(i)); }
         *
         * int[] result = new int[P.length]; for (int i = 0; i < P.length; i++) { Slice sliceWithPrefix =
         * prefixSlices[Q[i]]; Slice prefix = P[i] > 0 ? prefixSlices[P[i] - 1] : null; Slice slice =
         * sliceWithPrefix.substract(prefix); result[i] = slice.getImpactFactor(); }
         */

        return result;
    }
}
