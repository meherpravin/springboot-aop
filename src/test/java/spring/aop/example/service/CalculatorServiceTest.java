package spring.aop.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void invokeAOPStuff() {
        calculatorService.addition(10,30);
        calculatorService.subtraction(30,20);
        calculatorService.multiplication(3,5);
        calculatorService.division(20,5);
    }

}