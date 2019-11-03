package containerTest;

import java.util.List;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Tester
 * @description
 * @date 2019/11/3 20:58
 * @since JDK 1.8
 */
public class Tester<C> {
    // todo what use?

    public static int fieldWidth = 8;

    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500
    );

    protected C container;

    private String headLine="";

    private List<Test<C>> tests;

    // todo what use

    private static int sizeWith=5;

    private static String sizeField="%"+sizeWith+"s";

    private TestParam[] paramList=defaultParams;

    protected C initialize(int size) {
        return container;
    }

    private static String stringField() {
        return "%"+fieldWidth+"s";
    }

    private static String numberField() {
        return "%"+fieldWidth+"d";
    }

    public Tester(C container,List<Test<C>> tests) {
        this.container=container;
        this.tests=tests;
        if (container != null) {
            headLine=container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        // todo

        this(container,tests);
        this.paramList=paramList;
    }

    public void setHeadLine(String newHeadLine) {
        headLine=newHeadLine;
    }

    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester<C>(cntnr,tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr,tests,paramList);
    }

    private void displayHeader() {
        int width=fieldWidth*tests.size()+sizeWith;
        int dashLength=width-headLine.length()-1;
        StringBuilder head=new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField,"size");
        for (Test<C> test : tests) {
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField,param.size);
            for (Test<C> test : tests) {
                C kontainer=initialize(param.size);
                long start =System.nanoTime();
                int reps=test.test(kontainer,param);
                long duration=System.nanoTime()-start;
                long timePerRep=duration/reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }
    }
}
