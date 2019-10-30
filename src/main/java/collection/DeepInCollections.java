package collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName DeepInCollections
 * @description
 * @date 2019/10/9 19:03
 * @since JDK 1.8
 */
public class DeepInCollections {
    public static void main(String[] args) {
        List<String> hello = Collections.nCopies(4, new String("hello"));
        System.out.println(hello.getClass().getSimpleName());
        Iterator<String> iterator = hello.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals('q')) {
                iterator.remove();
            }
        }
    }
}

class myIterator implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
