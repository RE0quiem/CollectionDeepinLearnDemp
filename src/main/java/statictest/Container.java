package statictest;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Container
 * @description
 * @date 2019/10/2 11:38
 * @since JDK 1.8
 */
public class Container {
    public static void main(String[] args) {
        BerylliumShere[] sheres=new BerylliumShere[10];
        for (int i = 0; i < 5; i++) {
            sheres[i]=new BerylliumShere();

        }
        System.out.println(sheres[0]);
    }

}
