package example.zsltest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zsl on 2018/12/27.
 * 动态代理类
 */
public class DynamicProxy implements InvocationHandler {
    /**需要代理的目标类*/
    private Object target;

    /**
     * 写法固定，aop专用：绑定委托对象并且返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy
     *            target:指定代理的对象
     * @param method
     *            method:要调用的方法
     * @param args
     *           [] agrs:方法调用所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //切面之前执行
        System.out.println("切面之前执行");
        //执行业务
        result = method.invoke(target,args);
        //切面之后执行
        System.out.println("切面之后执行");
        return result;
    }
}
