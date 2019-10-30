package hanoi;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Hanoi2
 * @description
 * @date 2019/10/29 9:09
 * @since JDK 1.8
 */
public class Hanoi2 {
    static int i;
    public static void hanoi(int n,String location1,String location2,String location3) {
        i++;
        if (n == 1) {
            System.out.println(location1+"->"+location3);
        }else{
            hanoi(n-1,location1,location3,location2);
            System.out.println(location1+"->"+location3);
            hanoi(n-1,location2,location1,location3);
        }
    }

    public static void main(String[] args) {
        hanoi(5,"A","B","C");
        System.out.println("一共"+i+"次");
    }
}
