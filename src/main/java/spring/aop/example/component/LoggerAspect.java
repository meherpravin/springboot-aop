package spring.aop.example.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP implementation for calculator service
 */
@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* spring.aop.example.service.CalculatorService.*(..)) and args(firstNumber,secondNumber))")
    public void before(JoinPoint joinPoint, double firstNumber, double secondNumber) {
        //Advice
        logger.info("Before method:" + joinPoint.getSignature());
        logger.info("Input values :: First Number: {}, Second Number:{}", firstNumber, secondNumber);
    }

    @After("execution(* spring.aop.example.service.CalculatorService.*(..)))")
    public void after(JoinPoint joinPoint) {
        //Advice
        logger.info("After method:" + joinPoint.getSignature());
    }
    @AfterReturning(value = "execution(* spring.aop.example.service.CalculatorService.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, double result) {
        logger.info("{} returned with value {}", joinPoint.getSignature().getName(), result);
    }

    @Around("@annotation(spring.aop.example.util.TrackTime)")
    public double around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        double result = (double) joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint.getSignature().getName(), timeTaken);
        return result;
    }


}
