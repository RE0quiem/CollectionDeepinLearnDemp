package array;

import java.util.Random;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName StringArrayGenerator
 * @description
 * @date 2019/10/8 17:46
 * @since JDK 1.8
 */
public class StringArrayGenerator implements Generator<String>{
    int size=7;
    public StringArrayGenerator(int size) {
        this.size=size;
    }
    public StringArrayGenerator(){};
    public char generatorChar(Generator<Character> generator) {
        Character next = generator.next();
        return (char)next;
    }
    @Override
    public String next() {
        char[] chars=("abcdefghijklmnopqrstuvwxyz"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        Random r=new Random();
        char[] cbf=new char[size];
        for (int i = 0; i < size; i++) {
            char c = generatorChar(() -> {
                int j = r.nextInt(52);
                char cb = chars[j];
                return cb;
            });
            cbf[i]=c;
        }
        return new String(cbf);
    }

    public static void main(String[] args) {
        StringArrayGenerator generator = new StringArrayGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());
        }
    }
}
