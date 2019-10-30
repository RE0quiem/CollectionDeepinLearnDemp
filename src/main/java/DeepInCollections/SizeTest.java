package DeepInCollections;

import java.util.Arrays;
import java.util.List;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName SizeTest
 * @description
 * @date 2019/10/13 18:12
 * @since JDK 1.8
 */
public class SizeTest {
    public static void main(String[] args) {
        int num[] = {1,2,3};
        List<int[]> list_int = Arrays.asList(num);
        System.out.println(list_int.size());
    }
}


