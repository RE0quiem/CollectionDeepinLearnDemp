package statictest;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName BerylliumShere
 * @description
 * @date 2019/10/2 11:35
 * @since JDK 1.8
 */
public class BerylliumShere {
    private static Long counter;
    private final Long id=counter++;

    @Override
    public String toString() {
        return "BerylliumShere{" +
                "id=" + id +","+
                "count="+counter+
                '}';
    }
}
