package array;

import java.lang.reflect.Array;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Generated
 * @description
 * @date 2019/10/8 15:04
 * @since JDK 1.8
 */
public class Generated {
    public static <T> T[] array(T[] a,Generator<T> gen) {
        return CollectionData.list(gen,a.length).toArray(a);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a=(T[])Array.newInstance(type, size);
        return CollectionData.list(gen,a.length).toArray(a);
    }
}
