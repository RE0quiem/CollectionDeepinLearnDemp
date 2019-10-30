package array;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName ArrayGeneric
 * @description
 * @date 2019/10/8 10:21
 * @since JDK 1.8
 */
public class ArrayGeneric<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayGeneric(int size) {
        array=(T[])new Object[size];
    }
    public T[] get() {
        return array;
    }

    public static void main(String[] args) {
        ArrayGeneric<Integer> generic = new ArrayGeneric<>(10);
        Object[] obj= generic.get();
        obj[1]=1.0;
    }
}
