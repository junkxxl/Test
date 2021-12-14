import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class TestWildberriesElectronics {


    @ParameterizedTest
    @MethodSource("dataProvider")
    void Test2(String mainPagecatalog, String mainPagecategory, String categoryPagecategory, String catalogPageCategory
            , String CatalogPageSort, String mainPagecatalog2, String mainPagecategorySelect, String CatalogPageSort2) {

        MainPage mainPage = MainPage.open("http://www.wildberries.ru/");
        mainPage.openCatalogsButton().catalogSelection(mainPagecatalog)//"Электроника"
                .openAllCategories(mainPagecategory, "Все категории");//"Смартфоны и телефоны"

        СategoryPage сategoryPage = page(СategoryPage.class);
        сategoryPage.selection(categoryPagecategory);//"Детская электроника"


        CatalogPage catalogPage = page(CatalogPage.class);
        catalogPage.selectCategory(catalogPageCategory)//"3D-ручка"

                .sortSelection(CatalogPageSort);//"Рейтингу"

        String id1 = catalogPage.saveProductID();
        catalogPage.addBasket();

        BasketPage basketPage = page(BasketPage.class);


        mainPage.openCatalogsButton()
                .catalogSelection(mainPagecatalog2)//"Зоотовары"
                .categorySelection(mainPagecategorySelect);//"Для кошек"


        catalogPage.sortSelection(CatalogPageSort2)//"цене"
                .addBasket();
        String id3 = catalogPage.saveProductID();
        catalogPage.openBasket();

        String id2 = basketPage.saveArrayIDBasket(1);
        String id4 = basketPage.saveArrayIDBasket(0);


        Assertions.assertEquals(id1, id2);
        Assertions.assertEquals(id3, id4);


    }

    static List<String[]> dataProvider() {
       String[] s = new String[]{"Электроника","Смартфоны и телефоны","Детская электроника","3D-ручка","рейтингу",
                "Зоотовары","Для кошек","цене",};
        String[] s2 = new String[]{"Электроника","Смартфоны и телефоны","Планшеты","Apple","скидке",
                "Зоотовары","Для собак","рейтингу",};

        List<String[]> listS=new ArrayList<>();
        listS.add(s);
        listS.add(s2);

        return listS;

    }

}