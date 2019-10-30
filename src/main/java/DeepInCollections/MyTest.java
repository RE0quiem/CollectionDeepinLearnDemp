package DeepInCollections;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

class MyTest<T>{
    private Integer count;

    public static void main(String[] args) {
        int a[]=new int[2];
        int[] fanxing = fanxing(a);
    }
    public static<T> T fanxing(T t) {
        int[] test=(int[])t;
        return t;
    }
}


class FlyweightMap extends AbstractMap<String, String> {

    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }

    private static class Entity implements Map.Entry<String,String>{
        int index;

        public Entity(int index) {
            this.index=index;
        }

        @Override
        public String getKey() {
            return null;
        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public String setValue(String value) {
            return null;
        }
    }
}