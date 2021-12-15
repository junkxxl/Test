import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;



public class TestWildberries extends StartQuit{

    @Test
    void Test1() throws MalformedURLException {

        MainPage mainPage = MainPage.open("http://www.wildberries.ru/", driver);

        mainPage.search("белые тапочки");


        PageProducts product = new PageProducts(driver);
        String id1=product.saveID(1);
        product.clickToProduct();

        SelectedProductPage selectedProduct= new SelectedProductPage(driver);
        selectedProduct.clickProductSize();
        selectedProduct.clickAddBasket();
        selectedProduct.clickGoToBasket();

        BasketPage basketPage=new BasketPage(driver);

        String id2= basketPage.saveProductIDBasket();

        Assertions.assertEquals(id1,id2);

    }

}
