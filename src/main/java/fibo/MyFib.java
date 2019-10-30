package fibo;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName MyFib
 * @description
 * @date 2019/10/29 11:19
 * @since JDK 1.8
 */
public class MyFib {
    private static Map<Integer,Integer> map= new TreeMap<>();
    private static int fib(int n) {
        if (n == 1 || n == 2) {
            if (n == 1) {
                if (!map.containsKey(1)) {
                    map.put(1, 1);
                }
            } else {
                if (!map.containsKey(2)) {
                map.put(2, 1);
                }
            }
            return 1;
        }

        int left= fib(n-1);
        if (!map.containsKey(n-1)) {
            map.put(n-1,left);
        }
        int right= fib(n-2);
        if (!map.containsKey(n-2)) {
            map.put(n-2,right);
        }
        return left+right;
    }

    public static void main(String[] args) {
        fib(10);
        System.out.println(map);
    }
}
