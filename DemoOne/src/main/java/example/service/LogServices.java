package example.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
public class LogServices {



    public LogServices() {
        System.out.println("Aop");
    }


    /**
     * 方法执行时
     */
    @Pointcut("@annotation(example.service.Person.OnMethod)")
    public void onMethod() {
    }

    /**
     * 方法执行时
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("onMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String monthRemark = getonMethod(point);
        System.out.println("remark是 "+ monthRemark);
        String operatingcontent = "";
        Object[] method_param = null;
        Object object;
        System.out.println("执行切面之前");
        try {
            method_param = point.getArgs();	//获取方法参数
            //String param=(String) point.proceed(point.getArgs());"
            object = point.proceed();
        } catch (Exception e) {
            // 异常处理记录日志..log.error(e);
            throw e;
        }finally {
            System.out.println("执行切面之后");
        }
        return object;
    }


//    /**
//     * 抛异常
//     * @param point
//     * @param ex
//     */
//    @AfterThrowing(pointcut="execution(* com.atsoft..*.*.*.*(..))",throwing = "ex") //* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..)
//    public void afterThrowing(JoinPoint point,Exception ex) {
//        try{
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
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



//    /**
//     * 第一个参数为boolean 的所有方法执行，返回结果
//     * @param point
//     * @param at
//     * @param returnValue
//     * @throws Exception
//     */
//    @AfterReturning(pointcut="execution(* com.atsoft.*.*.*.*(..)) && args(at,..)",returning="returnValue")
//    public void smsInfo(JoinPoint point,boolean at,Object returnValue) throws Exception{
//        //JoinPoint point,
//        String monthRemark = getbooleanMethod(point);
//        String monthName = point.getSignature().getDeclaringTypeName();
//        String voidName = point.getSignature().getName();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String dataId = (String) request.getAttribute("dataId");
//        TBaseUser user =(TBaseUser)request.getSession().getAttribute("user");
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        Calendar ca = Calendar.getInstance();
//        String operDate = df.format(ca.getTime());
//        TLoginLog log = new TLoginLog();
//        log.setLogId(DateUtil.getPKid());
//        if(user!=null){
//            log.setUserId(user.getUserid());
//            log.setUserName(user.getUsername());
//            log.setAccount(user.getAccount());
//            log.setOrgCode(Pub.outofnull(user.getOrgCode()));
//            log.setLoginStatus(monthRemark);
//            log.setLoginVoid(monthName+"."+voidName);
//            log.setLoginDataid(returnValue==null?dataId:returnValue.toString());
//            log.setLoginDate(DateUtil.parseDate(operDate,"yyyy-MM-dd HH:mm:ss SSS"));
//            log.setLoginIp(Pub.getIpAddr(request));
//            this.genericHibernateDao.save(log);
//        }
//    }


    /**
     * 获取方法名称
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getonMethod(JoinPoint joinPoint) throws Exception {
        Class<?> clazz = joinPoint.getTarget().getClass();
        String name = joinPoint.getSignature().getName();
        Object[] parameterTypes = joinPoint.getArgs();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(name) && method.getParameterTypes().length == parameterTypes.length) {
                Person.OnMethod methodLog = method.getAnnotation(Person.OnMethod.class);
                if (methodLog != null) {
                    return methodLog.remark();
                }
                break;
            }
        }
        return "";
    }


//    /**
//     * 获取方法名称
//     * @param joinPoint
//     * @return
//     * @throws Exception
//     */
//    public static String getafterMethod(JoinPoint joinPoint) throws Exception {
//        Class<?> clazz = joinPoint.getTarget().getClass();
//        String name = joinPoint.getSignature().getName();
//        Object[] parameterTypes = joinPoint.getArgs();
//        for (Method method : clazz.getDeclaredMethods()) {
//            if (method.getName().equals(name) && method.getParameterTypes().length == parameterTypes.length) {
//                afterMethod methodLogInfo = method.getAnnotation(afterMethod.class);
//                if (methodLogInfo != null) {
//                    return methodLogInfo.remark();
//                }
//                break;
//            }
//        }
//        return "";
//    }
//
//
//    /**
//     * 获取方法名称
//     * @param joinPoint
//     * @return
//     * @throws Exception
//     */
//    public static String getbooleanMethod(JoinPoint joinPoint) throws Exception {
//        Class<?> clazz = joinPoint.getTarget().getClass();
//        String name = joinPoint.getSignature().getName();
//        Object[] parameterTypes = joinPoint.getArgs();
//        for (Method method : clazz.getDeclaredMethods()) {
//            if (method.getName().equals(name) && method.getParameterTypes().length == parameterTypes.length) {
//                booleanMethod methodLogInfo = method.getAnnotation(booleanMethod.class);
//                if (methodLogInfo != null) {
//                    return methodLogInfo.remark();
//                }
//                break;
//            }
//        }
//        return "";
//    }
}
