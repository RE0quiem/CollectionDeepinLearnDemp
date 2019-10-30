package tarray;

import java.lang.reflect.Array;

/**
 * @Description:
 * @version: 1.0
 * @author: jingzhi.zhan@hand-china.com
 * @date:
 */
public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;
    static final int SIZE=10;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*gia=(Generic<Integer>[]) new Object[SIZE];*/
        /*gia=(Generic<Integer>[]) new Generic[SIZE];*/
        System.out.println(gia.getClass().getSimpleName());
        /*gia[0]= (Generic<Integer>) new Object();*/
        String[] sArray=(String[])Array.newInstance(String.class, 10);
        gia=(Generic<Integer>[])Array.newInstance(Generic.class,SIZE);
    }
}

