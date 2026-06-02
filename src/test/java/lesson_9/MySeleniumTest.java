package lesson_9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MySeleniumTest extends BaseTest {
    @Test
    @DisplayName("Проверить название блока «Онлайн пополнение без комиссии»")
    public void testNameBlock() {
        WebElement titleBlock = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']//h2"));

        new Actions(driver).scrollToElement(titleBlock).perform();
        new Actions(driver).scrollByAmount(0, 400).perform();

        String expected = "Онлайн пополнение\n" + "без комиссии";
        Assertions.assertEquals(expected, titleBlock.getText(), "Ошибка: заголовок не совпадает");
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testIcon() {
        List<WebElement> icons = driver.findElements(By.cssSelector(".pay__partners img"));
        Assertions.assertFalse(icons.isEmpty(), "Ошибка: Логотипы платежных систем не найдены на странице!");

        for (WebElement icon : icons) {
            new Actions(driver).scrollToElement(icon).perform();

            String srcAttribute = icon.getDomAttribute("src");
            Assertions.assertTrue(icon.isDisplayed(), "Логотип не отображается на странице");
            Assertions.assertNotNull(srcAttribute, "Атрибут src отсутствует у элемента");
            Assertions.assertTrue(srcAttribute.contains(".svg"), "Ошибка: файл логотипа не имеет расширения .svg");
        }
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    public void testLink() {
        WebElement getLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a[text()='Подробнее о сервисе']"));

        new Actions(driver).scrollToElement(getLink).perform();
        new Actions(driver).scrollByAmount(0, 400).perform();
        getLink.click();

        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertEquals(expectedLink, driver.getCurrentUrl(), "Ошибка: ссылка не совпадает");

        String expected = "Оплата банковской картой";
        WebElement titleBlockPage = driver.findElement(By.xpath("//div[@class = 'container-fluid']//h3"));
        Assertions.assertEquals(expected, titleBlockPage.getText(), "Ошибка: заголовок не совпадает");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    public void testForm() throws InterruptedException {
        WebElement getInputPhone = driver.findElement(By.id("connection-phone"));
        WebElement getInputMoney = driver.findElement(By.id("connection-sum"));
        WebElement getInputMail = driver.findElement(By.id("connection-email"));
        WebElement getButtonSubmit = driver.findElement(By.cssSelector("#pay-connection .button.button__default"));

        new Actions(driver).scrollToElement(getInputPhone).perform();
        new Actions(driver).scrollByAmount(0, 400).perform();

        getInputPhone.sendKeys("297777777");
        getInputMoney.sendKeys("100");
        getInputMail.sendKeys("hello@render.com");
        getButtonSubmit.click();

        Thread.sleep(5000);
    }
}
