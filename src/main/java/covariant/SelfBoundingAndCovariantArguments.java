package covariant;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName SelfBoundingAndCovariantArguments
 * @description 自限定参数入参是没有协变的，Setter中有的方法是被注释的那个，传入的参数只能是自己
 * @date 2019/10/29 16:35
 * @since JDK 1.8
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
//    @Override
//    void set(Setter arg);
}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sb1, SelfBoundSetter sb2) {
        s1.set(s2);
        // 编译器不能识别将基类型当做参数传递给set的尝试，因为没有任何方法具有这样的签名。事实上，这个参数已经被覆盖。
        // s1.set(sb1); // [Compile Error]: set(Setter) in SelfBoundSetter<Setter> cannot be applied to (SelfBoundSetter)
        sb1.set(s1);
        sb1.set(sb2);
    }
}