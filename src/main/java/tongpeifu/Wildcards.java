package tongpeifu;

import org.junit.Test;

/**
 * @ClassName Wildcards
 * @description
 * @author REquiem
 * @date 2019/9/18 15:10
 * @version 1.0
 * @since JDK 1.8
 */
public class Wildcards {
    static class Holder<T> {
        private T item;

        Holder() {
        }

        Holder(T item) {
            this.item = item;
        }

        void set(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        @Override
        public boolean equals(Object obj) {
            return item.equals(obj);
        }
    }

    static void saveData(Holder holder, Object arg) {
        holder.set(arg);
        Object obj = holder.getItem();
        System.out.println(obj.getClass().getSimpleName() + ": " + obj.toString());
    }

    static void saveDataError(Holder<?> holder, Object arg) {
        // 因为不知道Holder<?>的具体类型是什么，所以我们就不允许往里set数据
        //holder.set(arg)
        Object obj = holder.getItem();
        //System.out.println(obj.getClass().getSimpleName() + ": " + obj.toString());
    }

    static private Holder h1 = new Holder<Long>();
    static private Holder<Long> h2 = new Holder<Long>();
    static private Holder<?> h3 = new Holder<Long>();
    static private Holder<? extends Long> h4 = new Holder<Long>();

    public static void main(String[] args) {
        //说明所有的泛型都可以转换成row type
        saveData(h1, 10);
        //本来这里的h2是long，转换的时候被擦除了，所以这个integer可以放到holder中去
        saveData(h2, 10);
        saveData(h3, 10);
        saveData(h4, 10);
    }

    @Test
    public void test1() {
        //说明这些泛型类型都能够转换成<?>，注意Holder<?> holder2 =Holder holder;
        saveDataError(h1, 5L);
        saveDataError(h2, 6L);
        saveDataError(h3, 7L);
        saveDataError(h4, 8L);
    }


    @Test
    public void test2() {
        Holder holder = new Holder<>(1L);
        CaptureConversion.capterGet(holder);
    }

    @SuppressWarnings("unchecked")
    static void rawArgs(Holder holder, Object arg) {
        //Unchecked call to 'set(T)' as a member of raw type 'tongpeifu.Wildcards.Holder'
        holder.set(arg);
        //相当于直接放入了一个obj
        holder.set(new Wildcards());
        Object obj = holder.getItem();
    }

    static <T> void unboundedArg(Holder<?> holder, Object arg) {
        //holder的容纳类型没有确定，所以不能够添加元素
        //holder.set(arg)
        //这里能够取到obj类型的值
        Object obj = holder.getItem();
        //Incompatible types. Required: T Found: capture<?>
        //类型没有确定，所以T是不成立的
        //T t=holder.getItem()
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.getItem();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.getItem();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //holder.set(arg) err
        return holder.getItem();
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //这里不能够使用T 因为类型不确定
        Object object = holder.getItem();
    }
    @Test
    public void test3() {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;
        //再次说明了当只有一个参数的时候任意的泛型都可以转换为原始类型
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);
        //再次说明了当只有一个参数的时候任意的泛型都可以转换为<?>
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);
        // unchecked warning
        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        //这里擦除了？保留了Long，所以在返回的时候转成了long类型
        Long r4 = exact1(bounded);
        // unchecked warning
        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        // Error 参数错误
        // Long r7 = exact2(unbounded, lng);
        // Error 参数错误
        // Long r8 = exact2(bounded, lng);

        // unchecked warning
        Long r9 = wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        // unchecked warning
        wildSupertype(raw, lng);
        wildSupertype(qualified, lng);
        // Error 参数错误
        // wildSupertype(unbounded,lng);
        // wildSupertype(bounded,lng);
    }
}

/***
 * @Author: zjz
 * @Description:捕获转换技术，如果向一个使用<?>的方法传递原生类型，那么对于编辑器来说，可能会推断出实际的类型参数，使得这个方法可以调用另一个使用确切类型的的方法
 * @Date: 2019/9/17
 **/
class CaptureConversion {
    static <T> void getData(Wildcards.Holder<T> holder) {
        T t = holder.getItem();
        System.out.println(t.getClass().getSimpleName() + ":" + t);
    }

    static void capterGet(Wildcards.Holder<?> holder) {
        getData(holder);
    }
}

