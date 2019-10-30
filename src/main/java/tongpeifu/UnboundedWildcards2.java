package tongpeifu;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @version: 1.0
 * @author: jingzhi.zhan@hand-china.com
 * @date:
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        assign1(new HashMap(10));
        assign2(new HashMap(10));
        //Unchecked assignment: 'java.util.HashMap' to 'java.util.Map<java.lang.String,?>'
        //why?  注意：这里是当参数为两个的时候，如果都为unbound那么感觉和原始类型没什么区别，但是当为<String,?>传入了原始类型为什莫会转型不清楚以后研究
        assign3(new HashMap(10));
    }
    @Test
    public void test1() {
        assign1(new HashMap<String, Integer>(10));
        assign2(new HashMap<String, Integer>(10));
        assign3(new HashMap<String, Integer>(10));
    }
}

