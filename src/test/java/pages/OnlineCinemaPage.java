package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class OnlineCinemaPage extends BasePage {
    private final String activeMenuSelector = "//div[contains(@class,'active') and contains(@class,'tab-content')]"; //Я написал xpath так, потому что, при переходе на новую вкладку, в элементе "div" в классе добавляется параметр "active" с лишним пробелом
    private final String filmsGenreSelector = "//div[@id='online-cinema']//div[@class='txt']/p[contains(text(),'replace')]";
    private final String genreSelector = activeMenuSelector + "//span[contains(text(),'replace')]";
    private final String genreListSelector = activeMenuSelector + "//button[@title='Жанры']";
    private final String tabMenu = "//a[contains(text(),'replace')]";
    private final By FILMS_SELECTOR = By.cssSelector("#online-cinema .txt");


    public OnlineCinemaPage(BrowsersService browsersService) {
        super(browsersService);
    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.xpath("//h1[@class='title_page']")).isDisplayed();
    }

    public void openGenreMenu() {
        browsersService.getWaiters().waitForVisibility(By.xpath(genreListSelector)).click();
    }

    public void chooseGenre(String genre) {
        String genreName = genreSelector.replace("replace", genre);
        browsersService.getWaiters().waitForVisibility(By.xpath(genreName)).click();
    }

    public Integer numberOfFilmsWithTheSelectedGenre(String genre) {
        browsersService.getWaiters().waitForPageLoad();
        String filmsGenre = filmsGenreSelector.replace("replace", genre);
        return browsersService.getDriver().findElements(By.xpath(filmsGenre)).size();
    }

    public Integer numberOfFilms() {
        browsersService.getWaiters().waitForPageLoad();
        return browsersService.getDriver().findElements(FILMS_SELECTOR).size();
    }

    public void switchMenu(String type) {
        String tmpType = tabMenu.replace("replace", type);
        browsersService.getWaiters().waitForVisibility(By.xpath(tmpType)).click();
    }
}
