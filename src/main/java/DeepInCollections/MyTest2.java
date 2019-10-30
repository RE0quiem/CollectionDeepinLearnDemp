package DeepInCollections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName MyTest2
 * @description
 * @date 2019/10/22 15:45
 * @since JDK 1.8
 */
public class MyTest2 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Collections.nCopies(10, "hello"));
        strings.add(1,"nihao");
        String[] array = strings.toArray(new String[0]);
        for (String s:array){
            System.out.println(s);
        }
        System.out.println(array.length);
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ListIterator<Integer> integerListIterator = list.listIterator();
        integerListIterator.add(11);
        System.out.println(integerListIterator.next());
        integerListIterator.add(12);
        integerListIterator.next();
        System.out.println(list);
        integerListIterator.remove();
        integerListIterator.next();
        integerListIterator.set(13);
        System.out.println(list);
    }
}
