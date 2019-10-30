package hashCode;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName SlowMap
 * @description 手写一个map
 * @date 2019/10/30 16:25
 * @since JDK 1.8
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    List<K> keys = new ArrayList<>();
    List<V> values = new ArrayList<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Map.Entry<K, V>> hashSet = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            hashSet.add(new MapEntry(ki.next(), vi.next()));
        }
        return hashSet;
    }

    class MapEntry implements Map.Entry<K, V> {
        private K k;
        private V v;

        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public MapEntry() {
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            this.v = value;
            return v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) o;
            return Objects.equals(k, mapEntry.k) &&
                    Objects.equals(v, mapEntry.v);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, v);
        }
    }


    @Override
    public V put(K k, V v) {
        if (!keys.contains(k)) {
            keys.add(k);
            values.add(v);
            return null;
        }
        V oldValue = values.get(keys.indexOf(k));
        values.set(keys.indexOf(k), v);
        return oldValue;
    }

    @Override
    public V get(Object k) {
        if (!keys.contains(k)) {
            return null;
        }
        return values.get(keys.indexOf(k));
    }

    @Test
    public void test0() {
        Map<Integer, String> slowMap = new SlowMap<>();
        slowMap.put(1,"a");
        slowMap.put(2,"a");
        slowMap.put(3,"a");
        slowMap.put(4,"a");
        slowMap.put(5,"a");
        slowMap.put(6,"a");
        Set<Entry<Integer, String>> entrySet = slowMap.entrySet();
        for (Entry<Integer, String> integerStringEntry : entrySet) {
            System.out.println(integerStringEntry.getKey()+"===="+integerStringEntry.getValue());
        }
    }
}
