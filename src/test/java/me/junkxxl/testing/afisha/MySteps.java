package me.junkxxl.testing.afisha;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;


public class MySteps extends StartQuit {


    @Когда("открыть сайт {string}")
    public void openUrl(String url) {
        MainPage.open(url, driver);
    }

    @И("нажать на вкладку {string}")
    public void clickToExhibitionСategory(String s) {
        MainPage
                .create(driver)
                .clickToExhibitionСategory(s);
    }

    @И("нажать на кнопку {string}")
    public void clickSelectPoster(String s) {

        ExhibitionsPage
                .create(driver)
                .clickSelectPoster(s);

    }

    @И("выбрать выходной день")
    public void clickOnWeekends() {

        ExhibitionsPage
                .create(driver)
                .clickOnWeekends();

    }

    @И("выбрать выставку с местом проведения {string}")
    public void selectExhibition(String s) {

        ExhibitionsPage
                .create(driver)
                .selectExhibition(s);

    }

    @Тогда("место проведение равно {string}")
    public void compareLocation(String s) {

        SelectedExhibitionPage
                .create(driver)
                .compareLocation(s);
    }


    @И("нажать вкладку {string}")
    public void clickExhibitionСategory(String s) {

        SelectedExhibitionPage
                .create(driver)
                .clickExhibitionСategory(s);
    }


    @И("выбрать жанр {string}")
    public void selectGenre(String s) {
        ConcertPage
                .create(driver)
                .selectGenre(s);
    }

    @И("выбрать сортировку {string}")
    public void selectSort(String s) {
        ConcertPage
                .create(driver)
                .selectSort(s);

    }

    @И("выбор ближайшего концерта")
    public void selectConcert() {
        ConcertPage
                .create(driver)
                .selectConcert();
    }

    @И("выбор самого дешевого билета")
    public void selectTicket() {
        SelectedConcertPage
                .create(driver)
                .selectTicket();

    }
}
