package fanxing;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Apply
 * @description
 * @date 2019/9/30 21:25
 * @since JDK 1.8
 */
public class Apply {
    public static <T,S extends Iterable<? extends T>> void apply(S seq, Method f,Object ... args) {
        try {
            for (T t : seq) {
                f.invoke(t,args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        System.out.println(this+"rotate");
    }
    public void resize(int newSize) {
        System.out.println(this+"resize"+newSize);
    }
}

class Square extends  Shape{}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type,int size) {
        try {
            for (int i = 0; i < size; i++) {
                add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest{
    public static void main(String[] args) throws NoSuchMethodException {
        ArrayList<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes,Shape.class.getMethod("rotate"));
        ArrayList<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares,Shape.class.getMethod("rotate"));
        System.out.println("------------------");
        Apply.apply(new FilledList<Square>(Square.class,10),Square.class.getMethod("resize",int.class),10);
    }
}