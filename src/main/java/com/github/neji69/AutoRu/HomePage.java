package com.github.neji69.AutoRu;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static String ADRESS = "https://auto.ru";
    private ElementsCollection marks = $$x("//div[@class= 'IndexMarks__col']//a"); // Коллекция из представленных на странице марок автомобилей

    private static int carAmount;

    public static int getCarAmount() {
        return carAmount;
    }

    /**
     * Метод открывает сайт по переданной ссылке
     */
    public void openPage(String url) {
        open(url, HomePage.class);
    }

    /**
     * Метод проверяет соответствие тайтла открытой страницы
     */
    public void checkOpenPageFromTitle(String title) {
        assertThat(title())
                .as("Открылась страница " + title)
                .contains(title);
    }

    /**
     * Метод закрывает всплывающее окно при входе на сайт
     */
    public void closePopUp() {
        SelenideElement modal = $(".Modal_visible .Modal__closer");
        if (modal.isDisplayed()) {
            modal.click();
        }
    }

    /**
     * Метод сохраняет количество обьявлений по передоному названию марки автомобиля и кликает по ней
     */
    public void parseAmountCars(String putNameCarFabric) {

        List<String> testMarks = marks.texts(); //Передаем в лист по каждой марке текст в формате "markCar\nValue" Пример: "Honda\n1845"
        for (int i = 0; i < testMarks.size(); i++) {
            if (testMarks.get(i).contains(putNameCarFabric)) {

                String symbolAndAmount = testMarks.get(i).substring(testMarks.get(i).indexOf('\n')); //избавляемся от markCar. Остаеться "\nValue". Пример: "\n1845"
                String onlyAmount = symbolAndAmount.replace("\n", ""); //Избавляемся от \n. Остается "Value". Пример "1845"(String формат)
                carAmount = Integer.parseInt(onlyAmount); //Парсим текс в число.
                marks.get(i).click(); //Переходим на страницу выбранной марки
                break;
            }
        }
    }
}
