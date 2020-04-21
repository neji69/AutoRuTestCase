package com.github.neji69.AutoRu;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecificFabricCarsPage {

    int carAmount;
    int modelCarAmount;
    private ElementsCollection marks = $$x("//div[@class = 'ListingPopularMMM-module__item']");

    public int getModelCarAmount() {
        return modelCarAmount;
    }

    public void parseAmountCarStepTwo(){

        Pattern pattern = Pattern.compile("\\d+");
        String symbolAndAmount = $x("//span[contains(text(),'Показать')]").getText();
        symbolAndAmount = symbolAndAmount.replace(" ", "");// Убираем пробелы в строке
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

    public void parseAmountModelCars(String putNameCarModels) {

        List<String> testMarks = marks.texts();
        for (int i = 0; i < testMarks.size(); i++) {
            if (testMarks.get(i).contains(putNameCarModels)) {

                String symbolAndAmount = testMarks.get(i).substring(testMarks.get(i).indexOf('\n'));
                String onlyAmount = symbolAndAmount.replace("\n", "");
                modelCarAmount = Integer.parseInt(onlyAmount);
                marks.get(i).find(By.xpath("./a")).click();
                break;
            }
        }
    }



}
