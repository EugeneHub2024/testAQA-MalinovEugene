package lesson_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MySeleniumTest extends BaseTest {

    @Test
    @DisplayName("Проверить название блока «Онлайн пополнение без комиссии»")
    public void testNameBlock() {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();

        String expected = "Онлайн пополнение\n" + "без комиссии";
        String actual = paySection.getTitleBlock();
        Assertions.assertEquals(expected, actual, "Ошибка: заголовок не совпадает");
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testIcon() {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();

        List<WebElement> icons = paySection.getIcons();
        Assertions.assertFalse(icons.isEmpty(), "Ошибка: Логотипы платежных систем не найдены на странице!");

        for (WebElement icon : icons) {
            String srcAttribute = icon.getDomAttribute("src");
            Assertions.assertTrue(icon.isDisplayed(), "Логотип не отображается на странице");
            Assertions.assertNotNull(srcAttribute, "Атрибут src отсутствует у элемента");
            Assertions.assertTrue(srcAttribute.contains(".svg"), "Ошибка: файл логотипа не имеет расширения .svg");
        }
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    public void testLink() {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();

        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualLink = paySection.getCurrentLink();
        Assertions.assertEquals(expectedLink, actualLink, "Ошибка: ссылка не совпадает");

        String expected = "Оплата банковской картой";
        String actual = paySection.getTitleBlockPage();
        Assertions.assertEquals(expected, actual, "Ошибка: заголовок не совпадает");
    }

    @DisplayName("Проверить не заполненные поля пункта «Услуги связи»")
    @ParameterizedTest
    @CsvSource({"'Номер телефона', 0", "'Сумма', 1", "'E-mail для отправки чека', 2"})
    public void testInputServiceComm(String expected, int index) {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();
        String actual = paySection.getListPlaceholdersServiceComm()[index];
        Assertions.assertEquals(expected, actual, "Текст поля не совпадает");
    }

    @DisplayName("Проверить не заполненные поля пункта «Домашний интернет»")
    @ParameterizedTest
    @CsvSource({"'Номер абонента', 0", "'Сумма', 1", "'E-mail для отправки чека', 2"})
    public void testInputHomeInternet(String expected, int index) {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();
        paySection.getButtonSelect();
        paySection.getLiHomeInternet();
        String actual = paySection.getListPlaceholdersHomeInternet()[index];
        Assertions.assertEquals(expected, actual, "Текст поля не совпадает");
    }

    @DisplayName("Проверить не заполненные поля пункта «Рассрочка»")
    @ParameterizedTest
    @CsvSource({"'Номер счета на 44', 0", "'Сумма', 1", "'E-mail для отправки чека', 2"})
    public void testInputInstallmentPlan(String expected, int index) {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();
        paySection.getButtonSelect();
        paySection.getLiInstallmentPlan();
        String actual = paySection.getListPlaceholdersInstallmentPlan()[index];
        Assertions.assertEquals(expected, actual, "Текст поля не совпадает");
    }

    @DisplayName("Проверить не заполненные поля пункта «Задолженность»")
    @ParameterizedTest
    @CsvSource({"'Номер счета на 2073', 0", "'Сумма', 1" ,"'E-mail для отправки чека', 2"})
    public void testInputOutstandingDebt(String expected, int index) {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();
        paySection.getButtonSelect();
        paySection.getLiOutstandingDebt();
        String actual = paySection.getListPlaceholdersOutstandingDebt()[index];
        Assertions.assertEquals(expected, actual, "Текст поля не совпадает");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    public void testForm() {
        PaySection paySection = new PaySection(driver);
        paySection.scrollToElement();
        String[] listModText = paySection.getListInputsConnection();

        String expectedPhone = listModText[0];
        String expectedMoney = listModText[1];
        String expectedNumberCard = "Номер карты";
        String expectedValidityPeriod = "Срок действия";
        String expectedInputCVC = "CVC";
        String expectedTextInputName = "Имя и фамилия на карте";

        paySection.switchToPaymentIframe();

        String actualFullPhone = paySection.getFullPhone();
        String actualSumMoney = paySection.getSumMoney();
        String actualButtonSumMoney = paySection.getButtonSumMoney();
        String actualNumberCard = paySection.getTextNumberCard();
        String actualValidityPeriod = paySection.getTextValidityPeriod();
        String actualInputCVC = paySection.getTextInputCVC();
        String actualTextInputName = paySection.getTextInputName();

        Assertions.assertTrue(paySection.formPayFrame().isDisplayed(), "Окно оплаты не загрузилось");
        Assertions.assertEquals("375" + expectedPhone, actualFullPhone, "Номер телефона не совпадает");
        Assertions.assertEquals(expectedMoney, actualSumMoney, "Сумма не совпадает");
        Assertions.assertEquals(expectedMoney, actualButtonSumMoney, "Сумма не совпадает");
        Assertions.assertEquals(expectedNumberCard, actualNumberCard, "Текст поля не совпадает");
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod, "Текст поля не совпадает");
        Assertions.assertEquals(expectedInputCVC, actualInputCVC, "Текст поля не совпадает");
        Assertions.assertEquals(expectedTextInputName, actualTextInputName, "Текст поля не совпадает");
        Assertions.assertFalse(paySection.getListIcons().isEmpty(), "Ошибка: Логотипы платежных систем не найдены на странице!");
        for (WebElement icon : paySection.getListIcons()) {
            String srcAttribute = icon.getDomAttribute("src");
            Assertions.assertTrue(icon.isDisplayed(), "Логотип не отображается на странице");
            Assertions.assertNotNull(srcAttribute, "Атрибут src отсутствует у элемента");
            Assertions.assertTrue(srcAttribute.contains(".svg"), "Ошибка: файл логотипа не имеет расширения .svg");
        }
        paySection.switchToDefaultContent();
    }
}