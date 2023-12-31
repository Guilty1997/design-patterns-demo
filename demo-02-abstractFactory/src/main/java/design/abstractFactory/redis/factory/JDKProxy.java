package design.abstractFactory.redis.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author：HeHongyi
 * @date: 2023/9/3
 * @description: JDK代理类
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
