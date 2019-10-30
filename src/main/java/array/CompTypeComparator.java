package array;

import java.util.Comparator;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CompTypeComparator
 * @description
 * @date 2019/10/8 16:05
 * @since JDK 1.8
 */
public class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return Integer.compare(o1.j,o2.j);
    }
}
