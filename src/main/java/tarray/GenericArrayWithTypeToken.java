package tarray;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @version: 1.0
 * @author: jingzhi.zhan@hand-china.com
 * @date:
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type,int size){
        this.array= (T[])Array.newInstance(type,size);
    }
    public void put(T item,int index) {
        array[index]=item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArray = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] integers = genericArray.rep();
    }

    class Fruit {}
    class Apple extends Fruit {}
    class Jonathan extends Apple {}
    class Orange extends Fruit {}
    @Test
    public void testList() {
        /*List<Fruit> fruitList = new ArrayList<Apple>();*///泛型没有内建的协变，所以无法转型，编译时不通过
    }
    @Test
    public void testList2() {
        /*List<? extends Fruit> fruitList = new ArrayList<Apple>();
        // 编译错误
        fruitList.add(new Apple());
        // 编译错误
        fruitList.add(new Jonathan());
        // 编译错误
        fruitList.add(new Fruit());
        // 编译错误
        fruitList.add(new Object());*///因为，在定义了fruitList之后，编译器只知道容器中的类型是Fruit或者它的子类，
        // 但是具体什么类型却不知道，编译器不知道能不能比配上就都不允许比配了。
        // 类比数组，在编译器的时候数组允许向数组中放Fruit和Orange等非法类型，但是运行时还是会报错，
        // 泛型是将这种检查移到了编译期，协变的过程中丢失了类型信息。
    }
}

