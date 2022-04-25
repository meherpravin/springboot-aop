package spring.aop.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  Rest controller
 */
@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/addition")
    public double addition(@RequestParam("firstNumber") double firstNumber, @RequestParam("secondNumber") double secondNumber){
        return calculatorService.addition(firstNumber, secondNumber);
    }

    @GetMapping("/subtraction")
    public double subtraction(@RequestParam("firstNumber") double firstNumber, @RequestParam("secondNumber") double secondNumber){
        return calculatorService.subtraction(firstNumber, secondNumber);
    }

    @GetMapping("/multiplication")
    public double multiplication(@RequestParam("firstNumber") double firstNumber, @RequestParam("secondNumber") double secondNumber){
        return calculatorService.multiplication(firstNumber, secondNumber);
    }

    @GetMapping("/division")
    public double division(@RequestParam("firstNumber") double firstNumber, @RequestParam("secondNumber") double secondNumber){
        return calculatorService.division(firstNumber, secondNumber);
    }
}
