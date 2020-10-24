package utils;

import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {
    private WebDriverWait wait;

    public Waiters(WebDriver driver, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
    }

    public Waiters(WebDriver driver) {
        ReadProperties readProperties = new ReadProperties();
        wait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.jsReturnsValue("return (document.readyState == 'complete' && jQuery.active == 0);"));
    }

}
