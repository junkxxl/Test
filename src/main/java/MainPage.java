import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.ID, using = "searchInput")
    SelenideElement elementSearch;

    public static MainPage open(String s) {
        Selenide.open(s);
        return page(MainPage.class);
    }

    public MainPage search(String value) {
        elementSearch.shouldBe(visible).setValue(value).pressEnter();
        return this;
    }




    @FindBy(how = How.CSS, using = ".nav-element__burger")
    SelenideElement сatalogButtonElement;


    public MainPage openCatalogsButton() {
        сatalogButtonElement.shouldBe(visible, enabled).click();
        return this;
    }

    public MainPage catalogSelection(String s) {
        $(By.xpath("//ul[@class='menu-burger__main-list']//a[text()='" + s + "']")).shouldBe(visible, enabled).hover();
        return this;
    }

    public MainPage openAllCategories(String categories, String s) {
        $(By.xpath("//div[text()='" + categories + "']/..//a[text()='" + s + "']")).shouldBe(visible, enabled).click();
        return this;
    }

    public MainPage categorySelection(String categories) {
        $(By.xpath("//a[text()='" + categories + "']")).shouldBe(visible, enabled).click();
        return this;
    }
}
