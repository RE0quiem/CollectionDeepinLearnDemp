package proxy;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName Client
 * @description
 * @date 2019/9/30 16:47
 * @since JDK 1.8
 */
public class Client {
    public static void main(String[] args) {
        LogHandler logHandler=new LogHandler();
        UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
        //UserManager userManager=new UserManagerImpl();
        userManager.addUser("1111", "张三");
        System.out.println("1111"+userManager.findUser("1111"));
    }


}
