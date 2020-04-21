package com.github.neji69.cucumber.stepdefs;

import com.github.neji69.AutoRu.SpecificModelCarPage;
import io.cucumber.java.ru.Тогда;

import static com.github.neji69.AutoRu.SpecificFabricCarsPage.getModelCarAmount;

public class AutoRuStepsSpecificModelCarsPage {

    SpecificModelCarPage specificModelCarPage = new SpecificModelCarPage();

    @Тогда("проверить, что количество обьявлений на текущей странице совпадает с количеством  на предыдущей страницы")
    public void checkAmountModelCar() {
        specificModelCarPage.parseAmountCarModelsStepTwo();
        specificModelCarPage.compareTheNumberOfCars(getModelCarAmount());
    }
}
