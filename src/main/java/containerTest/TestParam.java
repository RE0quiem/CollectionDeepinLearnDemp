package containerTest;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName TestParam
 * @description
 * @date 2019/11/3 20:47
 * @since JDK 1.8
 */
public class TestParam {
    public final int size;
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    // 第二个版本接收相同类型的列表，但是它的值都在string中。通过这种方式。它可以用来解析命令行参数

    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
