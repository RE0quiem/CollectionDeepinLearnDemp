package array;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CommonGenerator
 * @description
 * @date 2019/10/8 14:43
 * @since JDK 1.8
 */
public class CommonGenerator<T> implements Generator<T> {
    private Class<T> type;
    public CommonGenerator(Class<T> type) {
        this.type=type;
    }
    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> creat(Class<T> type) {
        return new CommonGenerator<T>(type);
    }
}
