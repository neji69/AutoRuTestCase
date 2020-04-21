package com.github.neji69.cucumber.stepdefs;

import com.github.neji69.AutoRu.HomePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;

public class AutoRuSteps {

    HomePage homePage = new HomePage();

    @Дано("перейти на {string}")
    public void openUrl(String url) {
        homePage.openPage(url);
        homePage.closePopUp();
    }

    @Тогда("проверить название страницы содержит текст {string}")
    public void checkTextOpenPage(String title) {
        homePage.checkOpenPageFromTitle(title);
    }

    @Затем("сохранить количество объявлений выбранной {word} марки автомобиля и совершить переход кликнув по ней")
    public void saveAmountAndGoToTheModelPage(String carMark) {
        homePage.parseAmountCars(carMark);
    }
}
