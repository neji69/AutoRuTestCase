package com.github.neji69.AutoRu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecificFabricCarsPage {

    int carAmount;

    public void parseAmountCarStepTwo(){

        Pattern pattern = Pattern.compile("\\d+");
        String symbolAndAmount = $x("//span[contains(text(),'Показать')]").getText();
        symbolAndAmount = symbolAndAmount.replace(" ", "");// мой пример строки
        Matcher matcher = pattern.matcher(symbolAndAmount);
        int start = 0;
        while (matcher.find(start)) {
            String value = symbolAndAmount.substring(matcher.start(), matcher.end());
            carAmount = Integer.parseInt(value);
            start = matcher.end();
        }
    }

    public void compareTheNumberOfCars(int homePageCarAmount){
        assertThat ( homePageCarAmount )
                .as("Сравниваем количество машин на этой странице с предыдущей")
                .isEqualTo(carAmount);
    }





}
