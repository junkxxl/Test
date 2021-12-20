package kfc;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract class StartQuitKFC {
    protected AndroidDriver driver;

    @BeforeEach
    void start() throws IOException {
        File app = new File("ru.kfc.kfc_delivery_7.3.0_15944.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    public void swipeScreen(Direction dir) {

        System.out.println("swipeScreen(): dir: '" + dir + "'");

        final int ANIMATION_TIME = 300;

        final int PRESS_TIME = 200;

        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;


        Dimension dims = driver.manage().window().getSize();


        PointOption up = PointOption.point(dims.width / 2, edgeBorder);
        PointOption down = PointOption.point(dims.width / 2, dims.height - edgeBorder);
        PointOption right = PointOption.point(dims.width - edgeBorder, dims.height / 2);
        PointOption left = PointOption.point(edgeBorder, dims.height / 2);

        switch (dir) {
            case DOWN:
                pointOptionStart  = up;
                pointOptionEnd = down;
                break;
            case UP:
                pointOptionStart = down;
                pointOptionEnd = up;
                break;
            case LEFT:
                pointOptionStart = right;
                pointOptionEnd = left;
                break;
            case RIGHT:
                pointOptionStart = left;
                pointOptionEnd = right;
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}

