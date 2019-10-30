package collection;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName NullPointCollect
 * @description
 * @date 2019/9/29 17:29
 * @since JDK 1.8
 */
public class NullPointCollect {
    @Test
    public void test1() {
        List<String> list=null;
        assert false;
        List<String> collect = list.stream().map(s -> s.concat("1")).collect(Collectors.toList());
    }

    @Test
    public void test2() {
        List<String> list=null;
        List<String> collect = list.stream().map(s -> s.concat("1")).collect(Collectors.toList());
    }
}
