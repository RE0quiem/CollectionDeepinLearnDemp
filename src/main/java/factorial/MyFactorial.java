package factorial;

import org.junit.Test;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName MyFactorial
 * @description
 * @date 2019/10/29 14:10
 * @since JDK 1.8
 */
public class MyFactorial {
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));;
    }
    int i;
    public int printDigital(int n) {
        i=i*10+n%10;
        if (n / 10 == 0) {
            return n;
        }
        return printDigital(n/10);
    }
    @Test
    public void test0() {
        System.out.println(printDigital(601995));;
        System.out.println(i);
    }
}

class PrintDigital{

}
