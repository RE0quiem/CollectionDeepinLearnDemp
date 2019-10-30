package hanoi;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName MyHanoi
 * @description
 * @date 2019/10/28 22:56
 * @since JDK 1.8
 */
public class MyHanoi {
    static int i=0;
    public static void hanoi(int n,String A,String B,String C) {
        i++;
        if (n == 1) {
            System.out.println("从" + A + "移动到" + C);
        } else {
            hanoi(n-1,"A","C","B");
            System.out.println("从" + A + "移动到" + C);
            hanoi(n-1,"B","A","C");
        }
    }

    public static void main(String[] args) {
        hanoi(6,"A","B","C");
        System.out.println(i);
    }
}
