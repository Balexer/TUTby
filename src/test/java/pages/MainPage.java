package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By AFISHA_SELECTOR = By.xpath("//li/a[@title='Афиша']");

    public MainPage(BrowsersService browsersService) {
        super(browsersService);
    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.className("header-logo")).isDisplayed();
    }

    public void MoveToAfisha() {
        browsersService.getWaiters().waitForVisibility(AFISHA_SELECTOR).click();
    }
}
