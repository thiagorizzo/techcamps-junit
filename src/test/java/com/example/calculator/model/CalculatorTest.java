package com.example.calculator.model;

import com.example.calculator.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@SpringBootTest(classes = TestApplication.class)
public class CalculatorTest {
    @Autowired
    Calculator calculator;

    @Test
    void sumTest() {
        Double result = calculator.sum(2.0, 5.0);
        assertEquals(7.0, result);
    }

    @Test
    public void numbersNullSumTest() {
        NullPointerException thrown = assertThrowsExactly(
                NullPointerException.class,
                () -> calculator.sum(null, 5.0)
        );

        assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());
    }

    @Test
    void subTest() {
        Double result = calculator.sub(2.0, 5.0);
        assertEquals(-3.0, result);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(9.0, 3.0);
        assertEquals(3.0, result);
    }

    @Test
    public void divisionByZeroTest() {
        NullPointerException thrown = assertThrowsExactly(
                NullPointerException.class,
                () -> calculator.divide(9.0, 0.0)
        );

        assertEquals("Divisão por zero não é permitido.", thrown.getMessage());
    }

    @Test
    void factorialTest() {
        int result = calculator.factorial(6);
        assertEquals(120, result);
    }

    @Test
    void integerToBinaryTest() {
        int result = calculator.integerToBinary(2);
        assertEquals(10, result);
    }

    @Test
    void integerToHexadecimalTest() {
        String result = calculator.integerToHexadecimal(47);
        assertEquals("2f", result);
    }

    @Test
    void calculeDayBetweenDateTest() {
        int result = calculator.calculeDayBetweenDate(LocalDate.of(2020, 3, 15), LocalDate.of(2020, 3, 29));
        assertEquals(14, result);
    }
}
