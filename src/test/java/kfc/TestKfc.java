package kfc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestKfc extends StartQuitKFC {

    @Test
    void testAddToBasket() {

        MainPage mainPage = new MainPage(driver);
        mainPage.countrySelection();

        PublicityPage publicityPage = new PublicityPage(driver);

        publicityPage.publicityWait();
        swipeScreen(Direction.LEFT);
        swipeScreen(Direction.LEFT);
        swipeScreen(Direction.LEFT);

        publicityPage.clickOpenMenuWait();
        publicityPage.clickOpenMenu();

        MapPage mapPage = new MapPage(driver);


        mapPage.allowGeolocation();
        driver.navigate().back();
        driver.navigate().back();
        MenuPage menuPage = new MenuPage(driver);

        String nameProduct = "Морковный торт";
        menuPage.selectProduct(nameProduct);

        menuPage.addBasket();
        menuPage.openBasket();
        String nameProductBasket = menuPage.saveProductNameBasket(nameProduct);

        Assertions.assertEquals(nameProduct,nameProductBasket);



    }

}
