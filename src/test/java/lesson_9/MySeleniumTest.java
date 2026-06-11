package lesson_9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MySeleniumTest extends BaseTest {
    private void scrollToElement(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .scrollByAmount(0, 300)
                .perform();
    }

    @Test
    @DisplayName("Проверить название блока «Онлайн пополнение без комиссии»")
    public void testNameBlock() {
        scrollToElement(getFormPay);
        WebElement titleBlock = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']//h2"));

        String expected = "Онлайн пополнение\n" + "без комиссии";
        Assertions.assertEquals(expected, titleBlock.getText(), "Ошибка: заголовок не совпадает");
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testIcon() {
        scrollToElement(getFormPay);
        List<WebElement> icons = driver.findElements(By.cssSelector(".pay__partners img"));
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
        scrollToElement(getFormPay);
        WebElement getLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a[text()='Подробнее о сервисе']"));
        getLink.click();

        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertEquals(expectedLink, driver.getCurrentUrl(), "Ошибка: ссылка не совпадает");

        String expected = "Оплата банковской картой";
        WebElement titleBlockPage = driver.findElement(By.xpath("//div[@class = 'container-fluid']//h3"));
        Assertions.assertEquals(expected, titleBlockPage.getText(), "Ошибка: заголовок не совпадает");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    public void testForm() {
        scrollToElement(getFormPay);
        WebElement getInputPhone = driver.findElement(By.id("connection-phone"));
        WebElement getInputMoney = driver.findElement(By.id("connection-sum"));
        WebElement getInputMail = driver.findElement(By.id("connection-email"));
        WebElement getButtonSubmit = driver.findElement(By.cssSelector("#pay-connection .button.button__default"));

        getInputPhone.sendKeys("297777777");
        getInputMoney.sendKeys("100");
        getInputMail.sendKeys("hello@render.com");

        String enteredPhone = getInputPhone.getDomProperty("value");
        String enteredMoney = getInputMoney.getDomProperty("value");
        String expectedPhone = enteredPhone.replaceAll("[^0-9]", "");
        double doubleMoney = Double.parseDouble(enteredMoney);
        String expectedMoney = String.format(java.util.Locale.US, "%.2f", doubleMoney);
        String expectedNumberCard = "Номер карты";
        String expectedValidityPeriod = "Срок действия";
        String expectedInputCVC = "CVC";
        String expectedTextInputName = "Имя и фамилия на карте";

        getButtonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentIframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.payment-widget-iframe")));
        driver.switchTo().frame(paymentIframe);

        WebElement formPayFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app-wrapper")));
        Assertions.assertTrue(formPayFrame.isDisplayed(), "Окно оплаты не загрузилось");

        WebElement getFullPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__text span")));
        String actualFullPhone = getFullPhone.getText().replaceAll("[^0-9]", "");
        Assertions.assertEquals("375" + expectedPhone, actualFullPhone, "Номер телефона не совпадает");

        WebElement getSumMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));
        String actualSumMoney = getSumMoney.getText().replaceAll("[^0-9.]", "");
        Assertions.assertEquals(expectedMoney, actualSumMoney, "Сумма не совпадает");

        WebElement getButtonSumMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".colored span")));
        String actualButtonSumMoney = getButtonSumMoney.getText().replaceAll("[^0-9.]", "");
        Assertions.assertEquals(expectedMoney, actualButtonSumMoney, "Сумма не совпадает");

        WebElement getTextNumberCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cc-number + label")));
        String actualNumberCard = getTextNumberCard.getText();
        Assertions.assertEquals(expectedNumberCard, actualNumberCard, "Текст поля не совпадает");

        WebElement getTextValidityPeriod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".date-input + label")));
        String actualValidityPeriod = getTextValidityPeriod.getText();
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod, "Текст поля не совпадает");

        WebElement getTextInputCVC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='cvc'] + label")));
        String actualInputCVC = getTextInputCVC.getText();
        Assertions.assertEquals(expectedInputCVC, actualInputCVC, "Текст поля не совпадает");

        WebElement getTextInputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='holder'] + label")));
        String actualTextInputName = getTextInputName.getText();
        Assertions.assertEquals(expectedTextInputName, actualTextInputName, "Текст поля не совпадает");

        List<WebElement> getListIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".icons-container img")));
        Assertions.assertFalse(getListIcons.isEmpty(), "Ошибка: Логотипы платежных систем не найдены на странице!");
        for (WebElement icon : getListIcons) {
            String srcAttribute = icon.getDomAttribute("src");
            Assertions.assertTrue(icon.isDisplayed(), "Логотип не отображается на странице");
            Assertions.assertNotNull(srcAttribute, "Атрибут src отсутствует у элемента");
            Assertions.assertTrue(srcAttribute.contains(".svg"), "Ошибка: файл логотипа не имеет расширения .svg");
        }

        driver.switchTo().defaultContent();
    }
}
