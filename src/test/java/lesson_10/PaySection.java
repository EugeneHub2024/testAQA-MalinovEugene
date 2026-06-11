package lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaySection {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //    Локаторы основные
    private final By formPayLocator = By.cssSelector(".pay .pay__wrapper");
    private final By titleBlockLocator = By.xpath("//div[@class = 'pay__wrapper']//h2");
    private final By iconsLocator = By.cssSelector(".pay__partners img");
    private final By linkLocator = By.xpath("//div[@class='pay__wrapper']//a[text()='Подробнее о сервисе']");
    private final By titleBlockPageLocator = By.xpath("//div[@class = 'container-fluid']//h3");
    private final By phoneServiceCommLocator = By.id("connection-phone");
    private final By moneyServiceCommLocator = By.id("connection-sum");
    private final By mailServiceCommLocator = By.id("connection-email");
    private final By buttonSubmitLocator = By.cssSelector("#pay-connection .button.button__default");
    private final By buttonSelectLocator = By.cssSelector(".select__header");
    private final By LiHomeInternetLocator = By.xpath("//li[@class = 'select__item']//p[text()='Домашний интернет']");
    private final By phoneHomeInternetLocator = By.id("internet-phone");
    private final By moneyHomeInternetLocator = By.id("internet-sum");
    private final By mailHomeInternetLocator = By.id("internet-email");
    private final By LiInstallmentPlanLocator = By.xpath("//li[@class = 'select__item']//p[text()='Рассрочка']");
    private final By numberCheckInstallmentPlanLocator = By.id("score-instalment");
    private final By moneyInstallmentPlanLocator = By.id("instalment-sum");
    private final By mailInstallmentPlanLocator = By.id("instalment-email");
    private final By LiOutstandingDebtLocator = By.xpath("//li[@class = 'select__item']//p[text()='Задолженность']");
    private final By numberCheckOutstandingDebtLocator = By.id("score-arrears");
    private final By moneyOutstandingDebtLocator = By.id("arrears-sum");
    private final By mailOutstandingDebtLocator = By.id("arrears-email");

    //    Локаторы фрейма
    private final By iframeLocator = By.cssSelector("iframe.payment-widget-iframe");
    private final By formPayFrameLocator = By.cssSelector(".app-wrapper");
    private final By fullPhoneLocator = By.cssSelector(".pay-description__text span");
    private final By sumMoneyLocator = By.cssSelector(".pay-description__cost span");
    private final By buttonSumMoneyLocator = By.cssSelector(".colored span");
    private final By textNumberCardLocator = By.cssSelector("#cc-number + label");
    private final By textValidityPeriodLocator = By.cssSelector(".date-input + label");
    private final By textInputCVCLocator = By.cssSelector("input[formcontrolname='cvc'] + label");
    private final By textInputNameLocator = By.cssSelector("input[formcontrolname='holder'] + label");
    private final By ListIconsLocator = By.cssSelector(".icons-container img");

    //    Конструктор
    public PaySection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //    Методы
    //    Скролл блока Онлайн пополнения
    public void scrollToElement() {
        WebElement getFormPay = driver.findElement(formPayLocator);
        new Actions(driver)
                .scrollToElement(getFormPay)
                .scrollByAmount(0, 300)
                .perform();
    }

    //    Тест 1
    public String getTitleBlock() {
        return driver.findElement(titleBlockLocator).getText();
    }

    //    Тест 2
    public List<WebElement> getIcons() {
        return driver.findElements(iconsLocator);
    }

    //    Тест 3
    public String getCurrentLink() {
        driver.findElement(linkLocator).click();
        return driver.getCurrentUrl();
    }

    public String getTitleBlockPage() {
        return driver.findElement(titleBlockPageLocator).getText();
    }

    //    Тест 4
    public String[] getListPlaceholdersServiceComm() {
        return new String[]{
                driver.findElement(phoneServiceCommLocator).getAttribute("placeholder"),
                driver.findElement(moneyServiceCommLocator).getAttribute("placeholder"),
                driver.findElement(mailServiceCommLocator).getAttribute("placeholder")
        };
    }

    //    Тест 5
    public void getButtonSelect() {
        driver.findElement(buttonSelectLocator).click();
    }

    public void getLiHomeInternet() {
        driver.findElement(LiHomeInternetLocator).click();
    }

    public String[] getListPlaceholdersHomeInternet() {
        return new String[]{
                driver.findElement(phoneHomeInternetLocator).getAttribute("placeholder"),
                driver.findElement(moneyHomeInternetLocator).getAttribute("placeholder"),
                driver.findElement(mailHomeInternetLocator).getAttribute("placeholder")
        };
    }

    //    Тест 6
    public void getLiInstallmentPlan() {
        driver.findElement(LiInstallmentPlanLocator).click();
    }

    public String[] getListPlaceholdersInstallmentPlan() {
        return new String[]{
                driver.findElement(numberCheckInstallmentPlanLocator).getAttribute("placeholder"),
                driver.findElement(moneyInstallmentPlanLocator).getAttribute("placeholder"),
                driver.findElement(mailInstallmentPlanLocator).getAttribute("placeholder")
        };
    }

    //    Тест 7
    public void getLiOutstandingDebt() {
        driver.findElement(LiOutstandingDebtLocator).click();
    }

    public String[] getListPlaceholdersOutstandingDebt() {
        return new String[]{
                driver.findElement(numberCheckOutstandingDebtLocator).getAttribute("placeholder"),
                driver.findElement(moneyOutstandingDebtLocator).getAttribute("placeholder"),
                driver.findElement(mailOutstandingDebtLocator).getAttribute("placeholder")
        };
    }

    //    Тест 8
    public String[] getListInputsConnection() {
        WebElement getInputPhone = driver.findElement(phoneServiceCommLocator);
        WebElement getInputMoney = driver.findElement(moneyServiceCommLocator);
        WebElement getInputMail = driver.findElement(mailServiceCommLocator);
        WebElement getButtonSubmit = driver.findElement(buttonSubmitLocator);

        getInputPhone.sendKeys("297777777");
        getInputMoney.sendKeys("100");
        getInputMail.sendKeys("hello@render.com");

        String enteredPhone = getInputPhone.getDomProperty("value");
        String enteredMoney = getInputMoney.getDomProperty("value");

        String expectedPhone = enteredPhone.replaceAll("[^0-9]", "");
        double doubleMoney = Double.parseDouble(enteredMoney);
        String expectedMoney = String.format(java.util.Locale.US, "%.2f", doubleMoney);

        getButtonSubmit.click();

        return new String[]{expectedPhone, expectedMoney};
    }

    public void switchToPaymentIframe() {
        WebElement paymentIframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        driver.switchTo().frame(paymentIframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public WebElement formPayFrame() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formPayFrameLocator));
    }

    public String getFullPhone() {
        WebElement fullPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(fullPhoneLocator));
        return fullPhone.getText().replaceAll("[^0-9]", "");
    }

    public String getSumMoney() {
        WebElement sumMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(sumMoneyLocator));
        return sumMoney.getText().replaceAll("[^0-9.]", "");
    }

    public String getButtonSumMoney() {
        WebElement buttonSumMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSumMoneyLocator));
        return buttonSumMoney.getText().replaceAll("[^0-9.]", "");
    }

    public String getTextNumberCard() {
        WebElement textNumberCard = wait.until(ExpectedConditions.visibilityOfElementLocated(textNumberCardLocator));
        return textNumberCard.getText();
    }

    public String getTextValidityPeriod() {
        WebElement textValidityPeriod = wait.until(ExpectedConditions.visibilityOfElementLocated(textValidityPeriodLocator));
        return textValidityPeriod.getText();
    }

    public String getTextInputCVC() {
        WebElement textInputCVC = wait.until(ExpectedConditions.visibilityOfElementLocated(textInputCVCLocator));
        return textInputCVC.getText();
    }

    public String getTextInputName() {
        WebElement textInputName = wait.until(ExpectedConditions.visibilityOfElementLocated(textInputNameLocator));
        return textInputName.getText();
    }

    public List<WebElement> getListIcons() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ListIconsLocator));
    }
}