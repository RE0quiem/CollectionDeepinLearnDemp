package containerTest;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Test
 * @description
 * @date 2019/11/3 20:41
 * @since JDK 1.8
 */
public abstract class Test<C> {
    /**
     *  :测试的名称
     *
     * @author jingzhi.zhan01@hand-china.com
     * @version 1.0
     * @date 2019/11/3 20:44
     * @param null
     * @return
     * @since JDK 1.8
     */
    String name;
    public Test(String name) {
        this.name=name;
    }

    /**
     * test :
     *
     * @author jingzhi.zhan01@hand-china.com
     * @version 1.0
     * @date 2019/11/3 20:44
     * @param container	待测容器
     * @param tp	保存该待定测试的各种参数，包含size（容器中元素的数量）以及
     *              loops，代表控制该测试的迭代次数
     * @return int
     * @since JDK 1.8
     */
    abstract int test(C container,TestParam tp);
}
