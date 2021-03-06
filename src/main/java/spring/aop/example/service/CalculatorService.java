package spring.aop.example.service;

import spring.aop.example.util.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @TrackTime
    public double division(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
