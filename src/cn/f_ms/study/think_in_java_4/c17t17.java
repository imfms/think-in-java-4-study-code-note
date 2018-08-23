package cn.f_ms.study.think_in_java_4;


import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class c17t17 {

    public static void main(String[] args) {

        Map<String, String> strings = new TestMap<>();

        for (int i = 0; i < 10; i++) {
            strings.put(String.valueOf(i), String.valueOf(i));
        }

        Iterator<Map.Entry<String, String>> iterator = strings.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            if (next.getKey().equals("6")) {
                iterator.remove();
            }
        }

         System.out.println(strings);



    }

    private static class TestMap<K, V> extends AbstractMap<K, V> {

        private List<K> keys = new ArrayList<>();
        private List<V> values = new ArrayList<>();

        @Override
        public V put(K key, V value) {

            int keyIndex = keys.indexOf(key);

            V oldValue = null;
            if (keyIndex >= 0) {
                oldValue = values.set(keyIndex, value);
            } else {
                keys.add(key);
                values.add(value);
            }

            return oldValue;
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            return new AbstractSet<Entry<K, V>>() {

                @Override
                public Iterator<Entry<K, V>> iterator() {
                    return new Iterator<Entry<K, V>>() {

                        int currentIndex = -1;

                        @Override
                        public void remove() {
                            keys.remove(currentIndex);
                            values.remove(currentIndex);
                        }

                        @Override
                        public boolean hasNext() {
                            return keys.size() > currentIndex + 1;
                        }

                        @Override
                        public Entry<K, V> next() {
                            currentIndex++;
                            return new Entry<K, V>() {
                                @Override
                                public K getKey() {
                                    return keys.get(currentIndex);
                                }

                                @Override
                                public V getValue() {
                                    return values.get(currentIndex);
                                }

                                @Override
                                public V setValue(V value) {
                                    return values.set(currentIndex, value);
                                }

                                @Override
                                public String toString() {
                                    return String.format("%s : %s", keys.get(currentIndex), values.get(currentIndex));
                                }
                            };
                        }
                    };
                }

                @Override
                public int size() {
                    return keys.size();
                }
            };
        }
    }

}
