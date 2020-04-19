package com.github.neji69.cucumber.stepdefs;

import com.github.neji69.AutoRu.HomePage;
import com.github.neji69.AutoRu.SpecificFabricCarsPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class AutoRuSteps {


    HomePage homePage = new HomePage();
    SpecificFabricCarsPage specificFabricCarsPage= new SpecificFabricCarsPage();

    @Дано("перейти на {string}")
    public void openUrl(String url) {
        homePage.openPage(url);
        homePage.closePopUp();
        System.out.println();
        System.out.println();
        homePage.parseAmountCars("Honda");
        specificFabricCarsPage.parseAmountCarStepTwo();
        specificFabricCarsPage.compareTheNumberOfCars(homePage.getCarAmount());
        System.out.println();
        System.out.println();

    }


}
