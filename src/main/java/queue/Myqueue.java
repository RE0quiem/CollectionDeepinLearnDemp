package queue;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Myqueue
 * @description
 * @date 2019/10/29 15:24
 * @since JDK 1.8
 */
public class Myqueue {
    @Test
    public void test0() {
        PriorityQueue<Stuedent> stuedents = new PriorityQueue<>(((o1, o2) -> {
            if (o1.getScore() == o2.getScore()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getScore() - o2.getScore();
        }));
        stuedents.offer(new Stuedent("dafei", 20));
        stuedents.offer(new Stuedent("will", 17));
        stuedents.offer(new Stuedent("setf", 30));
        stuedents.offer(new Stuedent("bunny", 20));

        //出列
        System.out.println(stuedents.poll());
        System.out.println(stuedents.poll());
        System.out.println(stuedents.poll());
        System.out.println(stuedents.poll());
    }
}


class Stuedent {
    String name;
    int score;

    public Stuedent(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Stuedent{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
