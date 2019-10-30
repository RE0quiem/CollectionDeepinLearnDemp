package covariant;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CovariantReturnTypes
 * @description 普通继承关系的返回类型的参数协变
 * @date 2019/10/29 16:24
 * @since JDK 1.8
 */
class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // DerivedGetter.get()覆盖了OrdinaryGetter.get()

    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        // 调用的DerivedGetter.get()
        Derived result1 = d.get();
        // 也调用的DerivedGetter.get()
        Base result2 = d.get();
    }
}