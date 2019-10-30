package arrange;

import java.util.Arrays;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Test
 * @description
 * @date 2019/10/29 15:03
 * @since JDK 1.8
 */
public class Test {
    public static void p(int[] a, int index) {
        if (a == null || index < 0) {
            return;
        }
        if (index == (a.length - 1)) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = index; i < a.length; i++) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;

                p(a, index + 1);

                temp = a[i];
                a[i] = a[index];
                a[index] = temp;

            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { 1, 2, 3,4,5 };
        p(a, 0);
    }
}
