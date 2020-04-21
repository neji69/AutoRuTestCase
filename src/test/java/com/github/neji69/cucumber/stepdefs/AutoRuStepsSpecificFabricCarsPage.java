package com.github.neji69.cucumber.stepdefs;

import com.github.neji69.AutoRu.SpecificFabricCarsPage;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;

import static com.github.neji69.AutoRu.HomePage.getCarAmount;

public class AutoRuStepsSpecificFabricCarsPage {

    SpecificFabricCarsPage specificFabricCarsPage = new SpecificFabricCarsPage();

    @Тогда("проверить, что количество обьявлений совпадает с количеством на предыдущей страницы")
    public void checkAmount() {
        specificFabricCarsPage.parseAmountCarStepTwo();
        specificFabricCarsPage.compareTheNumberOfCars(getCarAmount());
    }

    @Затем("сохранить количество объявлений выбранной {word} модели автомобиля и совершить переход кликнув по ней")
    public void saveAmountAndGoToTheSpecificModelPage(String carModel) {
        specificFabricCarsPage.parseAmountModelCars(carModel);
    }
}
