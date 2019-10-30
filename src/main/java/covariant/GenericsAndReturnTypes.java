package covariant;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName GenericsAndReturnTypes
 * @description 自限定的返回类型的参数协变
 * @date 2019/10/29 16:25
 * @since JDK 1.8
 */
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {}

public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result1 = g.get();
        // Also the base type
        GenericGetter result2 = g.get();
    }
}