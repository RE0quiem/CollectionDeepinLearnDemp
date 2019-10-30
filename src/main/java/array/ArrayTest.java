package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName ArrayTest
 * @description
 * @date 2019/10/8 9:24
 * @since JDK 1.8
 */
public class ArrayTest {
    @Test
    @SuppressWarnings("unchecked")
    public void testArray() {
        List<String>[] ls;
        List[] la=new List[10];
        ls=( List<String>[])la;
    }
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.iterator();

        HashMap<String, String> map = new HashMap<>(10, 0.8F);
        TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.comparator()
        LinkedHashMap<Integer,String > linkedHashMap = new LinkedHashMap<>(16,0.75F,true);
        linkedHashMap.put(1,"A");
        linkedHashMap.put(2,"A");
        linkedHashMap.put(3,"A");
        linkedHashMap.put(4,"A");
        linkedHashMap.put(5,"A");
        linkedHashMap.put(6,"A");
        linkedHashMap.put(7,"A");
        linkedHashMap.put(8,"A");
        linkedHashMap.put(9,"A");
        System.out.println(linkedHashMap);
        Set<Integer> keySet = linkedHashMap.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        for (int i = 1; i < 5; i++) {
            /*iterator.next();*/
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
    }
}


