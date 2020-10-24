package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import pages.AfishaPage;
import pages.MainPage;
import pages.OnlineCinemaPage;

public class OnlineCinemaSteps extends BaseStep {


    public OnlineCinemaSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void moveToOnlineCinema(){
        MainPage mainPage = new MainPage(browsersService);
        mainPage.MoveToAfisha();
        AfishaPage afishaPage = new AfishaPage(browsersService);
        afishaPage.MoveToOnlineCinema();
    }

    public void chooseGenre(String name){
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage(browsersService);
        onlineCinemaPage.openGenreMenu();
        onlineCinemaPage.chooseGenre(name);
    }

    public void switchMenu(String type){
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage(browsersService);
        onlineCinemaPage.switchMenu(type);

    }
}
