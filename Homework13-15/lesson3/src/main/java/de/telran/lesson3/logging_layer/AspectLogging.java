package de.telran.lesson3.logging_layer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {
    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);
//    @Pointcut("execution(* de.telran.lesson3.service_layer.jpa.JpaProductService.add(..))")
//    public void addProduct(){}
//
//    @Before("addProduct()")
//    public void beforeAddingProduct(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        //вызван метод add класса JpaProductService с параметром -{Продукт}
//        logger.info(String.format("вызван метод add класса JpaProductService с параметром - %s", args[0]));
//    }

//    @Pointcut("execution(* de.telran.lesson3.service_layer.jpa.JpaProductService.test(..))")
//    public void test(){}
//
//    @Before("test()")
//    public void beforeTest(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Вызван метод test класса JpaProductService с входящим параметром %s.", args[0]));
//    }
//
//    @After("test()")
//    public void afterTest(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Завершил работу метод test класса JpaProductService, новое значение параметра - %s", args[0]));
//    }
//
//    @Pointcut("execution(* de.telran.lesson3.service_layer.jpa.JpaProductService.getById(..))")
//    public void getProductById() {}
//
//    @AfterReturning("getProductById()")
//    public void afterProductReturning(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Метод getById класса JpaProductService успешно вернул продукт с идентификатором %d", args[0]));
//    }
//
//    @AfterThrowing("getProductById()")
//    public void afterThrowingWhileProductReturning(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Метод getById класса JpaProductService вызвал ошибку! Несуществующий идентификатор - %d", args[0]));
//    }
//
//    @Pointcut("execution(* de.telran.lesson3.service_layer.jpa.JpaProductService.getCount(..))")
//    public void getProductsCount() {}

//    @Around("getProductsCount()")
//    public Object aroundGetProductsCount(ProceedingJoinPoint joinPoint) {
//        logger.info("Around getProductsCount()");
//        try {
//            return joinPoint.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Around("getProductsCount()")
//    public Object aroundGetProductsCount(ProceedingJoinPoint joinPoint) {
//        logger.info("Around getProductsCount()");
//        try {
//            logger.info("Действительный результат - " + joinPoint.proceed());
//            logger.info("Подменяем результат и возвращаем -1");
//            return -1;
//        } catch (Throwable e) {
//            logger.error("Тут какая-то ошибка!");
//            throw new RuntimeException(e);
//        }
//    }

    @Pointcut("execution(* de.telran.lesson3.service_layer.jpa.*.*(..))")
    public void method(){}

    @Before("method()")
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        if(args.length!=0) {
            logger.info(String.format("Вызван метод класса " + joinPoint.getSignature().getName()+" JpaProductService с входящим параметром %s.", args[0]));
        }else {
            logger.info(String.format("Вызван метод класса " + joinPoint.getSignature().getName() + " JpaProductService."));
        }
    }

    @After("method()")
    public void afterMethod(JoinPoint joinPoint){
        logger.info(String.format("Завершил работу метод "+ joinPoint.getSignature().getName()+" класса JpaProductService."));
    }
    @AfterReturning("method()")
    public void afterReturningMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if(args.length!=0) {
            logger.info(String.format("Метод " + joinPoint.getSignature().getName() + " класса JpaProductService успешно вернул значение %s", args[0].toString()));
        }
    }

    @AfterThrowing("method()")
    public void afterThrowingMethod(JoinPoint joinPoint) {
        logger.info(String.format("Метод " + joinPoint.getSignature().getName() + " класса JpaProductService вызвал ошибку!"));
    }



}
