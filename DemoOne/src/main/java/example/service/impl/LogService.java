package example.service.impl;


import example.utils.OnMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 *
 * @Aspect 实现spring aop 切面（Aspect）：
 *         一个关注点的模块化，这个关注点可能会横切多个对象。事务管理是J2EE应用中一个关于横切关注点的很好的例子。
 *         在SpringAOP中，切面可以使用通用类（基于模式的风格） 或者在普通类中以 @Aspect 注解（@AspectJ风格）来实现。
 *
 */
@Component
@Aspect
public class LogService {

    public LogService() {
        System.out.println("Aop");
    }

    /**
     * 方法执行时
     */
    @Pointcut("@annotation(example.utils.OnMethod)")
    public void onMethod() {
    }

    @Before("@annotation(example.utils.OnMethod)")
    public void beforeLog(JoinPoint point){
        System.out.println("调用之前");
    }


    @AfterReturning("onMethod()")
    public void afterLog(){
        System.out.println("调用返回之后");
    }

    /**
     * 方法执行时
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("onMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("切面开始了");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("ddddddddd"+request.getAttribute("START_TIME"));

        String monthRemark = getonMethod(point);
        String monthName = point.getSignature().getDeclaringTypeName();
        String voidName = point.getSignature().getName();
        System.out.println(monthRemark+"|"+monthName+"|"+voidName);
        String operatingcontent = "";
        Object[] method_param = null;
        Object object;
        try {
            method_param = point.getArgs();	//获取方法参数
            //String param=(String) point.proceed(point.getArgs());
            object = point.proceed();

            System.out.println("momoshi"+request.getAttribute("START_TIME"));
            System.out.println("返回结果： "+object);
        } catch (Exception e) {
            // 异常处理记录日志..log.error(e);
            throw e;
        }
        return object;
    }


    /**
     * 抛异常
     * @param point
     * @param ex
     */
    @AfterThrowing(pointcut="onMethod()",throwing = "ex") //* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..)
    public void afterThrowing(JoinPoint point,Exception ex) {
        try{

            System.out.println("发生异常了");
            System.out.println(ex.getMessage());
            System.out.println("异常栈打完了");
//            String monthRemark = getafterMethod(point);
//            if(Pub.outofnull(monthRemark).equals("")){
//                monthRemark=getonMethod(point);
//            }
//            String monthName = point.getSignature().getDeclaringTypeName();
//            String voidName = point.getSignature().getName();
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            TBaseUser user =(TBaseUser)request.getSession().getAttribute("user");
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//            Calendar ca = Calendar.getInstance();
//            String operDate = df.format(ca.getTime());
//            TLoginLog log = new TLoginLog();
//            if(user!=null){
//                log.setUserId(user.getUserid());
//                log.setUserName(user.getUsername());
//                log.setAccount(user.getAccount());
//                log.setOrgCode(Pub.outofnull(user.getOrgCode()));
//            }
//            log.setLogId(DateUtil.getPKid());
//            log.setLoginType("404");
//            log.setLoginStatus(monthRemark);
//            log.setLoginVoid(monthName+"."+voidName);
//            log.setLoginDate(DateUtil.parseDate(operDate,"yyyy-MM-dd HH:mm:ss SSS"));
//            log.setLoginIp(Pub.getIpAddr(request));
//            String message = ex.toString();
//            if(message.length()>800){
//                message=message.substring(0,800);
//            }
//            log.setLoginError(message);
//            this.genericHibernateDao.save(log);
        }catch (Exception e) {
            System.out.println("抓到异常了");
        }
    }


    /**
     * 获取方法名称
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getonMethod(JoinPoint joinPoint) throws Exception {
        Class<?> clazz = joinPoint.getTarget().getClass();
        OnMethod ss = clazz.getAnnotation(OnMethod.class);
        System.out.println("dnk"+ss.dnk());
        String name = joinPoint.getSignature().getName();
        Object[] parameterTypes = joinPoint.getArgs();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(name) && method.getParameterTypes().length == parameterTypes.length) {
                OnMethod methodLog = method.getAnnotation(OnMethod.class);
                if (methodLog != null) {
                    return methodLog.remark();
                }
                break;
            }
        }
        return "";
    }
}

