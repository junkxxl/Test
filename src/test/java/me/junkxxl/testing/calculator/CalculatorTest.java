package me.junkxxl.testing.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends StartQuit {

    @Test
    void addition() {
        driver.findElementByName("Один").click();
        driver.findElementByName("Плюс").click();
        driver.findElementByName("Пять").click();
        driver.findElementByName("Равно").click();
        Assertions.assertEquals("6", getResult());
    }
    @Test
    void subtraction() {
        driver.findElementByName("Семь").click();
        driver.findElementByName("Минус").click();
        driver.findElementByName("Три").click();
        driver.findElementByName("Равно").click();
        Assertions.assertEquals("4", getResult());
    }

}
