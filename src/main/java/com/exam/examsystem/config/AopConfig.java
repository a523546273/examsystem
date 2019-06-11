//package com.exam.examsystem.config;
//
//
//import com.exam.examsystem.req.BaseRequest;
//import com.exam.examsystem.resp.ResponseData;
//import com.google.gson.Gson;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//@Aspect
//@Component
//public class AopConfig {
//
//    public AopConfig() {
//
//    }
//
//    @Pointcut(value = "execution(* com.exam.examsystem.controller.*Api.*(..))")
//    public void aspect() {
//
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);
//
//    /**
//     * 登陆黑名单
//     */
//    private static List<String> whiteList = new ArrayList<>(
//            Arrays.asList("addUserCollection", "cancelUserCollection", "batchCancelUserCollection", "updateVerificationState", "searchByPage",
//                    "updateNickname", "updatePhoto", "searchUserInfo", "index", "addUserCompanyRecord", "searchRecordCount"));
//
//
//    @Around("aspect()")
//    public Object serviceAdvice(ProceedingJoinPoint pjp) throws IOException {
//        long startTime = System.currentTimeMillis();
//        String className = pjp.getSignature().getDeclaringTypeName();
//        String methodName = pjp.getSignature().getName();
//
//        Object[] objects = pjp.getArgs();
//        BaseRequest baseRequest = null;
//        if (objects.length != 0) {
//            for (Object object : objects) {
//                if (object instanceof BaseRequest) {
//                    baseRequest = (BaseRequest) object;
//                }
//            }
//
//        }
//
//        Object object = null;
//        ResponseData responseData = new ResponseData();
//
//        try {
//
//            logger.info("--------------开始日志--------------- ");
//            Object[] obj = {baseRequest};
//            logger.info("调用服务:{}.{}的入参为：{}", className, methodName, new Gson().toJson(baseRequest));
//
//            object = pjp.proceed(obj);
//
//            return object;
//
//        } catch (Throwable e) {
//            // TODO: handle exception
//        }
//
//        return null;
//
//
//    }
//}