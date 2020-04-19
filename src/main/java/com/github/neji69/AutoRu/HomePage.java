package com.github.neji69.AutoRu;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static String ADRESS = "https://auto.ru";

    private int carAmount;

    private SelenideElement tabMenu;
    private ElementsCollection tabSubMenu;
    private ElementsCollection marks = $$x("//div[@class= 'IndexMarks__col']//a");

    public void openPage(String url) {
        open(url, HomePage.class);
    }


    public int getCarAmount() {
        return carAmount;
    }

    /**
     * Метод проверяет соответствие тайтла открытой страницы
     */
    public void checkOpenPageFromTitle(String title) {
        assertThat(title())
                .as("Открылась страница " + title)
                .contains(title);
    }

    public void closePopUp() {
        SelenideElement modal = $(".Modal_visible .Modal__closer");
        if (modal.isDisplayed()) {
            modal.click();
        }
    }

    public void parseAmountCars(String putNameCarFabric) {

        List<String> testMarks = marks.texts();
        for (int i = 0; i < testMarks.size(); i++) {
            if (testMarks.get(i).contains(putNameCarFabric)) {

                String symbolAndAmount = testMarks.get(i).substring(testMarks.get(i).indexOf('\n'));
                String onlyAmount = symbolAndAmount.replace("\n", "");
                carAmount = Integer.parseInt(onlyAmount);
                marks.get(i).click();
                break;
            }
        }
    }



    public void sort() {

    }
}
