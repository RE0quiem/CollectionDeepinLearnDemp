package covariant;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName PlainGenericInheritance
 * @description 只是使用普通的泛型通过继承的方式那么方法的参数不同就是overload而不是override，没有入参协变
 * @date 2019/10/29 17:06
 * @since JDK 1.8
 */
class GenericSetter<T> { // Not self-bounded
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base> {
    // @Override // [Compile Error]: Can't override. It's overload not override.

    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        // Compiles: overloaded, not overridden!
        dgs.set(base);
    }
}