package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class AfishaPage extends BasePage {

    private final By ONLINE_CINEMA_SELECTOR = By.xpath("//a[@title='Онлайн-кинотеатры']");

    public AfishaPage(BrowsersService browsersService) {
        super(browsersService);
    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.className("name-resource")).isDisplayed();
    }

    public void MoveToOnlineCinema() {
        browsersService.getWaiters().waitForVisibility(ONLINE_CINEMA_SELECTOR).click();
    }
}
