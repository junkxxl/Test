package wildberries;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestWildberries extends StartQuit {


    static Stream<WebDriver> driverProvider() throws IOException {
        URL urlBrowsers = new URL(URL);

        String authString = USERNAME + ":" + AUTOMATE_KEY;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        URL url = new URL("https://api.browserstack.com/automate/browsers.json");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);

        InputStream is = urlConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        Browsers[] browsers = new Gson().fromJson(isr, Browsers[].class);

        return Arrays.stream(browsers).filter(b -> !b.real_mobile).
                filter(b -> b.browser.equals("chrome")).
                filter(b -> b.os.equals("Windows")).
                filter(b -> b.os_version.equals("10")).
                map(b -> new RemoteWebDriver(urlBrowsers, setCapabilities(b.browser, b.browser_version)));

    }

    @ParameterizedTest
    @MethodSource("driverProvider")
    void test1(WebDriver webDriver)  {

        MainPage mainPage = MainPage.open(config.getProperty("url"), webDriver);

        mainPage.search("белые тапочки");

        PageProducts product = new PageProducts(webDriver);
        String id1 = product.saveID(1);
        product.clickToProduct(id1);

        SelectedProductPage selectedProduct = new SelectedProductPage(webDriver);
        selectedProduct.clickProductSize();
        selectedProduct.clickAddBasket();
        selectedProduct.clickGoToBasket();

        BasketPage basketPage = new BasketPage(webDriver);

        String id2 = basketPage.saveProductIDBasket();

        Assertions.assertEquals(id1, id2);

        webDriver.quit();

    }
}
