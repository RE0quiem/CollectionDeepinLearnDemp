package tongpeifu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName TestHolderList
 * @description
 * @date 2019/9/18 22:40
 * @since JDK 1.8
 */
public class TestHolderList {
    public void test1(Wildcards.Holder<List<?>> holder) {
        List<?> list = holder.getItem();

    }

    static void test2(Wildcards.Holder<List<?>> holder, List<?> list) {
        holder.set(list);
        List<?> getList = holder.getItem();
        Object o = list.get(1);
        /*System.out.println(o.getClass().getSimpleName());*/
    }

    static void test3() {
        List<Integer> list = Arrays.<Integer>asList(1, 2);
        int [] is=new int[]{1,2};
        List<Integer> list1 = Arrays.asList(1, 2);
        List<String> aaa = Arrays.asList("aaa","bbb");
        Byte[] bytes={1,2,3};
        List<Byte> list2 = Arrays.asList(bytes);

    }
    public static void main(String[] args) {
        Wildcards.Holder<List<?>> holder = new Wildcards.Holder<>();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        test2(holder,list);
    }
}
