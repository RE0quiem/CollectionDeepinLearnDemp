package proxy;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName UserManagerImpl
 * @description
 * @date 2019/9/30 16:23
 * @since JDK 1.8
 */
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl.addUser");
    }

    @Override
    public void delUser(String userId) {
        System.out.println("UserManagerImpl.delUser");
    }

    @Override
    public String findUser(String userId) {
        System.out.println("UserManagerImpl.findUser");
        return "张三";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.println("UserManagerImpl.modifyUser");

    }
}
