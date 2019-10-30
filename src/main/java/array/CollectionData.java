package array;

import java.util.ArrayList;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CollectionData
 * @description
 * @date 2019/10/8 15:01
 * @since JDK 1.8
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen,int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static<T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen,quantity);
    }
}
