package DeepInCollections;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName AbstractInAb
 * @description
 * @date 2019/10/13 19:18
 * @since JDK 1.8
 */
public abstract class AbstractInAb implements  InterfaceAb{
    @Override
    public void test1() {
        smoking();
    }

    private void smoking() {
        throw new UnsupportedOperationException();
    }
}
