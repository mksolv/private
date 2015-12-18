package pl.kaczor.util;

import java.util.HashMap;

public class AddableIntegralNumberHashMap<K, V extends Number> extends HashMap<K, V> {
    private static final long serialVersionUID = 1L;

    public V put(K key) {
        V value = this.get(key);
        if (value == null) {
            Number newValue;
            if (value instanceof Integer) {
                newValue = (Integer) value + 1;
            } else if (value instanceof Long) {
                newValue = (Long) value + 1;
            } else if (value instanceof Byte) {
                newValue = (Byte) value + 1;
            } else if (value instanceof Short) {
                newValue = (Short) value + 1;
            } else {
                throw new IllegalArgumentException();
            }
            return super.put(key, (V) newValue);
        } else {
            return super.put(key, value);
        }

    }
}
