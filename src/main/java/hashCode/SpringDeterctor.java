package hashCode;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName SpringDeterctor
 * @description
 * @date 2019/10/30 15:51
 * @since JDK 1.8
 */
public class SpringDeterctor {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        //获取type中参数是Int的构造器，这个是反射
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for (int i = 0; i < 10; ++i) {
            //初始化map里面的值，第二个参数是随机产生的两种状况
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println(("map = " + map));
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        //等会我们发现找不到3号
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }

}
