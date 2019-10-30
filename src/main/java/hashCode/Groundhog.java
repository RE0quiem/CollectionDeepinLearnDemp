package hashCode;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Groundhog
 * @description
 * @date 2019/10/30 15:50
 * @since JDK 1.8
 */
public class Groundhog
{
    //保护类型，继承之后还是保护类型
    protected int number;
    public Groundhog(int n) { number = n; }

    @Override
    public String toString()
    {
        return "Groundhog #" + number;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Groundhog && (number== ((Groundhog) o).number);
    }

    @Override
    public int hashCode() {
        return number;
    }
}
