package array;


import java.util.Arrays;
import java.util.Random;



/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName CompType
 * @description
 * @date 2019/10/8 14:17
 * @since JDK 1.8
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;

    private static int count=1;

    public CompType() {
    }

    public CompType(int i, int j) {
        this.i=i;
        this.j=j;
    }
    @Override
    public String toString() {
        String result="[i="+i+",j="+j+"]";
        if (count++ % 3 == 0) {
            result+="\n";
        }
        return result;
    }
    @Override
    public int compareTo(CompType o) {
        return (Integer.compare(i, o.i));
    }
    private static Random r=new Random(47);
    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a2= Generated.array(new CompType[12],generator());
        //用lambda表达式来代替之前写的匿名内部类  使用的方式是在要使用到这个匿名内部类的地方使用lambda表达式
        CompType[] a= Generated.array(new CompType[12],()->{
            return new CompType(r.nextInt(100),r.nextInt(100));
        });
        System.out.println("befoe sorting:"+ Arrays.toString(a));
        /*Arrays.sort(a);*/
        /*Arrays.sort(a, Collections.reverseOrder());*/
        //这里有个类型推断，a的类型是CompType[]，所以推断出了o1,o2
        Arrays.sort(a,((o1, o2) -> Integer.compare(o1.j,o2.j)));
        System.out.println("after sorting"+Arrays.toString(a));

    }
}
