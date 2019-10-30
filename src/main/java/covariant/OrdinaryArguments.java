package covariant;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName OrdinaryArguments
 * @description 在普通的非泛型的继承结构中，方法的参数类型即使是父子关系也算作不同的参数类型，所以如下的例子是方法的重载而非重写
 * @date 2019/10/29 16:30
 * @since JDK 1.8
 */
class OrdinarySetter {
    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {
    // @Override // [Compile Error]: Can't override. It's overload not override!

    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}

// 在非泛型代码中，参数类型不能随子类型发生变化。

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        // 调用DerivedSetter的set
        ds.set(derived);
        // 调用OrdinarySetter的set
        ds.set(base);
    }
}
