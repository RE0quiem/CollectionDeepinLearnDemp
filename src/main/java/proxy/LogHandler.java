package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jingzhi.zhan01@hand-china.com
 * @version 1.0
 * @ClassName LogHandler
 * @description
 * @date 2019/9/30 16:22
 * @since JDK 1.8
 */
public class LogHandler implements InvocationHandler {
    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {
        this.targetObject=targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start-->>");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        // 方法的返回值
        Object ret = null;
        try {
            /*原对象方法调用前处理日志信息*/
            System.out.println("satrt-->>");

            //调用目标方法
            ret = method.invoke(targetObject, args);
            /*原对象方法调用后处理日志信息*/
            System.out.println("success-->>");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error-->>");
            throw e;
        }
        return ret;
    }
}
