package hashCode;

import java.util.Random;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Prediction
 * @description
 * @date 2019/10/30 15:51
 * @since JDK 1.8
 */
public class Prediction
{
    private static Random rand = new Random(47);
    //判断产生的数值的范围,nextDouble产生的值在0到1之间
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString()
    {
        if(shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
}
