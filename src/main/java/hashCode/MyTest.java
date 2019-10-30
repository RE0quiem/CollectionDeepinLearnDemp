package hashCode;

import org.junit.Test;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName MyTest
 * @description
 * @date 2019/10/30 16:07
 * @since JDK 1.8
 */
public class MyTest {
    public void myTest() {
        Integer x=1;
        System.out.println(x.equals(null));
    }
    @Test
    public void nullTest() {
        Null test = new NullTest();
        System.out.println(test instanceof Null);
    }
    @Test
    public void test2() {
        String s="false";
        String aa="1";
        char a='a';
        System.out.println(Integer.valueOf(aa));;
        System.out.println(Integer.parseInt(aa));
    }
}
