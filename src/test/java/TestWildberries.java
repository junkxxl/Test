import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestWildberries {

    @Test
    void Test1() {
        MainPage mainPage =MainPage.open("http://www.wildberries.ru/");
        mainPage.search("белые тапочки");

        PageProducts product = page(PageProducts.class);
        String id1=product.saveID(1);
        product.clickToProduct();

        SelectedProductPage selectedProduct= page(SelectedProductPage.class);
        selectedProduct.clickProductSize();
        selectedProduct.clickAddBasket();
        selectedProduct.clickGoToBasket();

        BasketPage basketPage=page(BasketPage.class);

        String id2= basketPage.saveProductIDBasket();

        Assertions.assertEquals(id1,id2);





    }


}
