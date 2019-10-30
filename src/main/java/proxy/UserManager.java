package proxy;

/**
 * 〈〉
 *
 * @author jingzhi.zhan01@hand-china.com-zjz
 * @create 2019/9/30
 */
public interface UserManager {
    public void addUser(String userId, String userName);

    public void delUser(String userId);

    public String findUser(String userId);

    public void modifyUser(String userId, String userName);
}
