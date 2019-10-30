package DeepInCollections;

import java.util.AbstractList;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CountingIntegerList
 * @description
 * @date 2019/10/13 15:50
 * @since JDK 1.8
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {
        this.size= Math.max(size, 0);
    }
    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30).toString());
    }
}
