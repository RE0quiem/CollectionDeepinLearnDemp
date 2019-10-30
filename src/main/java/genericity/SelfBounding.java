package genericity;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName SelfBounded
 * @description
 * @date 2019/10/29 15:55
 * @since JDK 1.8
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
} // It's OK.

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}
// class E extends SelfBounded<D> {} // [Compile error]: Type parameter D is not within its bound

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}