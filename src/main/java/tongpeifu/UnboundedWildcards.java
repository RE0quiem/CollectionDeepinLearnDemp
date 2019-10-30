package tongpeifu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @version: 1.0
 * @author: jingzhi.zhan@hand-china.com
 * @date:
 */
public class UnboundedWildcards {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    @SuppressWarnings("unchecked")
    static void assign1(List list) {
        list1 = list;
        list2 = list;
        //Unchecked assignment: 'java.util.List' to 'java.util.List<? extends java.lang.Object>'
        //注:row type向List<? extends Object>转换的时候是unchecked的 why？-->这个?是代表这个集合中存的是object的子类型所以说传入原始类型。就是相当于传入了<Object>，当然要转型了
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        //注：这里没有warning  <?>是一种确切的类型只不过我们不知到是那种，但是它确实是object的子类型
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        //Unchecked assignment: 'java.util.ArrayList' to 'java.util.List<? extends java.lang.Object>'
        //List<? extends Object> list=new ArrayList();这里传入new ArrayList()，其实就是前面的这条语句，然后把这个引用传到了assign3中,why?会warning，是因为这里是相当于原生类型object转化成? extends Object
        assign3(new ArrayList());

    }
}

