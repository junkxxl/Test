package me.junkxxl.testing.afishaDinamic;

import me.junkxxl.testing.afisha.BasePageWeb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ConcertSchedulePage extends BasePageWeb<WebDriver> {
    static String nameLocation;
    static int count = 1;

    protected ConcertSchedulePage(WebDriver driver) {
        super(driver);
    }

    public void compareConcert() {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1/span[contains (text(),'Концерты')]")));
        String result = webElement.getText();

        Assertions.assertEquals("Концерты в Москве", result);

    }

    public void selectGenre(String s) {
        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()='" + s + "']")));
        webElement.click();

    }

    public void saveNameLocationConcert() {
        if (count < 25) {
            for (int i1 = 0; i1 < count; i1++) {


                List<WebElement> list = (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul//div[@data-test='RESTRICT-TEXT']//span/a[@data-test='LINK']")));
                nameLocation = list.get(i1).getText();
            }
            count++;
        }
    }

    public List<Integer> saveProductIndex() {
        List<Integer> result = new ArrayList<>();
        List<WebElement> webElementList = driver.findElements(By.xpath("//ul//div/a[@data-test='LINK ITEM-URL']"));


        for (int i = 0; i < webElementList.size(); i++) {
            result.add(i + 1);
        }

        return result;
    }


    public void checkingSelectedGenre() {

        WebElement webElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[contains (text(),'Жанр')]")));
        webElement1.click();


        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[@data-test='CHECKBOX SELECTED']/span[contains (text(),'Джаз')]")));
        String result = webElement.getText();

        Assertions.assertEquals("Джаз", result);
    }


    Stream<DynamicNode> checkPage() {

        return Stream.of(dynamicContainer("Тест страницы концертов",
                Stream.of(dynamicTest("Проверка страницы концертов", () -> compareConcert()),
                        dynamicTest("Выбор жанра", () -> selectGenre("Джаз")),
                        dynamicTest("Проверка выбранного жанра", () -> checkingSelectedGenre())
                )));
    }

    Stream<DynamicNode> checkPageOne() {

        return Stream.of(dynamicContainer("Тест страницы концертов",
                Stream.of(dynamicTest("Сохранение названия локации концерта", () -> saveNameLocationConcert())
                )));
    }
}
