package me.junkxxl.testing.afishaDinamic;

import me.junkxxl.testing.afisha.BasePageWeb;
import org.junit.jupiter.api.DynamicNode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class MainPage extends BasePageWeb<WebDriver> {


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void clickToOkCookies() {

        WebElement webElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'На сайте')]/../../button[@data-test='BUTTON']")));
        webElement1.click();

    }

    public void clickConcertCategory(String s) {

        WebElement webElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/a[text()='" + s + "']")));
        webElement.sendKeys(Keys.ENTER);

    }


    Stream<DynamicNode> checkPage() {

        return Stream.of(
                dynamicContainer("Тест главной страницы",

                        Stream.of(
                                dynamicTest("Запуск веб драйвера", () -> driver.get("https://www.afisha.ru/")),
                                dynamicTest("Нажать на  подтверждение сохранения Cookies", () -> clickToOkCookies()),
                                dynamicTest("Нажать на категорию концерты", () -> clickConcertCategory("КОНЦЕРТЫ")))
                ),
                dynamicContainer("1й Тест страницы концертов", new ConcertSchedulePage(driver).checkPage()),
                dynamicContainer("2й Тест страницы концертов", Stream.of(dynamicTest("Сохранение локации", () -> new ConcertSchedulePage(driver).saveNameLocationConcert()))),
                dynamicContainer("Тест проверки каждого концерта",

                        Stream.of(driver).map(s -> s.findElements(
                                By.xpath("//ul//div/a[@data-test='LINK ITEM-URL']"))).flatMap(l ->


                                IntStream.range(0, l.size()).
                                        mapToObj(i -> driver.findElements(
                                                By.xpath("//ul//div/a[@data-test='LINK ITEM-URL']")).get(i)).

                                        flatMap(f -> {
                                            f.click();

                                            return Stream.of(
                                                    dynamicContainer("Тест концерта", new SelectedConcertPage(driver).checkPage()),
                                                    dynamicContainer("Тест концертов", new ConcertSchedulePage(driver).checkPageOne()));

                                        })

                        )
                ));
    }
}
