package tests;

import baseEntity.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OnlineCinemaPage;
import steps.OnlineCinemaSteps;

public class UItests extends BaseTest {

    @Parameters("genre")
    @Test
    public void testInTheFilmsTab(String genre) {
        OnlineCinemaSteps onlineCinemaSteps = new OnlineCinemaSteps(browsersService);
        onlineCinemaSteps.moveToOnlineCinema();
        onlineCinemaSteps.chooseGenre(genre);
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage(browsersService);
        Assert.assertEquals(onlineCinemaPage.numberOfFilmsWithTheSelectedGenre(genre), onlineCinemaPage.numberOfFilms(), "Фильмы подобраны не правильно");
    }

    @Parameters({"type","genre"})
    @Test(dependsOnMethods = "testInTheFilmsTab")
    public void testInTheSerialsTab(String type, String genre) {
        OnlineCinemaSteps onlineCinemaSteps = new OnlineCinemaSteps(browsersService);
        onlineCinemaSteps.switchMenu(type);
        onlineCinemaSteps.chooseGenre(genre);
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage(browsersService);
        Assert.assertEquals(onlineCinemaPage.numberOfFilmsWithTheSelectedGenre(genre), onlineCinemaPage.numberOfFilms(), "Сериалы подобраны не правильно");
    }

    @Parameters({"type","genre"})
    @Test(dependsOnMethods = "testInTheSerialsTab")
    public void testInAnimationTab(String type, String genre) {
        OnlineCinemaSteps onlineCinemaSteps = new OnlineCinemaSteps(browsersService);
        onlineCinemaSteps.switchMenu(type);
        onlineCinemaSteps.chooseGenre(genre);
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage(browsersService);
        Assert.assertEquals(onlineCinemaPage.numberOfFilmsWithTheSelectedGenre(genre), onlineCinemaPage.numberOfFilms(), "Мультфильмы подобраны не правильно");
    }
}
