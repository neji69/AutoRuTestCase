package com.github.neji69.AutoRu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecificModelCarPage {
    private int modelCarAmount;

    /**
     * Метод парсит количество обьявлений с кнопки "Показать ... предложений".
     */
    public void parseAmountCarModelsStepTwo() {
        Pattern pattern = Pattern.compile("\\d+");
        String symbolAndAmount = $x("//span[contains(text(),'Показать')]").getText();
        symbolAndAmount = symbolAndAmount.replace(" ", "");// Убираем пробелы в строке
        Matcher matcher = pattern.matcher(symbolAndAmount);
        int start = 0;
        while (matcher.find(start)) {
            String value = symbolAndAmount.substring(matcher.start(), matcher.end());
            modelCarAmount = Integer.parseInt(value);
            start = matcher.end();
        }
    }

    /**
     * Метод сравнивает количество обьявлений полученных с предыдущей страницы с количеством полученных на этой
     */
    public void compareTheNumberOfCars(int previousPageModelCarAmount) {
        assertThat(previousPageModelCarAmount)
                .as("Сравниваем количество машин на этой странице с предыдущей")
                .isEqualTo(modelCarAmount);
    }
}
