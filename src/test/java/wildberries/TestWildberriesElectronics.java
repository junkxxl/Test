package wildberries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;


public class TestWildberriesElectronics extends StartQuit {


    static Stream<Arguments> dataProvider() throws MalformedURLException {

        DesiredCapabilities capChrome = new DesiredCapabilities();
        capChrome.setCapability("os", "Windows");
        capChrome.setCapability("os_version", "10");
        capChrome.setCapability("browser", "Chrome");
        capChrome.setCapability("browser_version", "latest");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        capChrome.merge(chromeOptions);

        DesiredCapabilities capFirefox = new DesiredCapabilities();
        capFirefox.setCapability("os", "Windows");
        capFirefox.setCapability("os_version", "10");
        capFirefox.setCapability("browser", "firefox");
        capFirefox.setCapability("browser_version", "latest");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        capFirefox.merge(firefoxOptions);


        return Stream.of(
                Arguments.of("Электроника", "Смартфоны и телефоны", "Детская электроника", "3D-ручка", "рейтингу",
                        "Зоотовары", "Для кошек", "цене", new RemoteWebDriver(new URL(URL), capChrome)),
                Arguments.of("Электроника", "Смартфоны и телефоны", "Детская электроника", "3D-ручка", "рейтингу",
                        "Зоотовары", "Для кошек", "цене", new RemoteWebDriver(new URL(URL), capFirefox))
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void test2(String mainPageCatalog, String mainPageCategory, String categoryPageCategory, String catalogPageCategory
            , String CatalogPageSort, String mainPageCatalog2, String mainPageCategorySelect, String CatalogPageSort2, WebDriver webDriver) throws MalformedURLException, InterruptedException {


        MainPage mainPage = MainPage.open(config.getProperty("url"), webDriver);


        mainPage.openCatalogsButton().catalogSelection(mainPageCatalog)//"Электроника"
                .openAllCategories(mainPageCategory, "Все категории");//"Смартфоны и телефоны"

        СategoryPage сategoryPage = new СategoryPage(webDriver);
        сategoryPage.selection(categoryPageCategory);//"Детская электроника"


        CatalogPage catalogPage = new CatalogPage(webDriver);
        catalogPage.selectCategory(catalogPageCategory)//"3D-ручка"

                .sortSelection(CatalogPageSort);//"Рейтингу"

        String id1 = catalogPage.saveProductID();
        catalogPage.addBasket();

        BasketPage basketPage = new BasketPage(webDriver);


        mainPage.openCatalogsButton()
                .catalogSelection(mainPageCatalog2)//"Зоотовары"
                .categorySelection(mainPageCategorySelect);//"Для кошек"


        catalogPage.sortSelection(CatalogPageSort2)//"цене"
                .addBasket();
        String id3 = catalogPage.saveProductID();
        catalogPage.openBasket();

        String id2 = basketPage.saveArrayIDBasket(1);
        String id4 = basketPage.saveArrayIDBasket(0);


        Assertions.assertEquals(id1, id2);
        Assertions.assertEquals(id3, id4);

        webDriver.quit();
    }
}