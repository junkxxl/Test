import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;


public class SelectedProductPage {
    @FindBy(how = How.CSS, using = ".j-size:not(.disabled)")
    SelenideElement elementProductSize;

    @FindBy(how = How.XPATH, using = "//button[@class='btn-main' and contains(@data-link, 'addToBasket ')]")
    SelenideElement elementAddBasket;

    @FindBy(how = How.LINK_TEXT, using = "Перейти в корзину")
    SelenideElement elementOpenBasket;


    public SelectedProductPage clickProductSize() {
        elementProductSize.shouldBe(visible).click();
        return this;
    }

    public SelectedProductPage clickAddBasket() {
        elementAddBasket.shouldBe(visible).click();
        return this;
    }

    public SelectedProductPage clickGoToBasket() {
        elementOpenBasket.shouldBe(visible).click();
        return this;
    }
}
