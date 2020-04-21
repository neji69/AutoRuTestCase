package com.github.neji69.cucumber.stepdefs;

import com.github.neji69.AutoRu.HomePage;
import com.github.neji69.AutoRu.SpecificFabricCarsPage;
import com.github.neji69.AutoRu.SpecificModelCarPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;

public class AutoRuSteps {


    HomePage homePage = new HomePage();
    SpecificFabricCarsPage specificFabricCarsPage = new SpecificFabricCarsPage();
    SpecificModelCarPage specificModelCarPage = new SpecificModelCarPage();

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

    @Тогда("проверить, что количество обьявлений совпадает с количеством на предыдущей страницы")
    public void checkAmount() {
        specificFabricCarsPage.parseAmountCarStepTwo();
        specificFabricCarsPage.compareTheNumberOfCars(homePage.getCarAmount());
    }

    @Затем("сохранить количество объявлений выбранной {word} модели автомобиля и совершить переход кликнув по ней")
    public void saveAmountAndGoToTheSpecificModelPage(String carModel) {
        specificFabricCarsPage.parseAmountModelCars(carModel);
    }

    @Тогда("проверить, что количество обьявлений на текущей странице совпадает с количеством  на предыдущей страницы")
    public void checkAmountModelCar() {
        specificModelCarPage.parseAmountCarModelsStepTwo();
        specificModelCarPage.compareTheNumberOfCars(specificFabricCarsPage.getModelCarAmount());
    }


}
