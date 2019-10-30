package map;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName AssociativeArray
 * @description
 * @date 2019/10/29 17:20
 * @since JDK 1.8
 */
@SuppressWarnings("unchecked")
public class AssociativeArray <K,V> {
    private Object[][] pairs;
    private int index;
    private AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    private void put(K key,V value) {
        if(index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{ key, value };
    }
    private V get(K key) {
        for (Object[] pair : pairs) {
            if (pair[0].equals(key)) {
                return (V) pair[1];
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pairs.length; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i < index -1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
