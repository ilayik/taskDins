package ru.com.habr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestHabr {

    public static HabrPage habrPage;
    public static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        habrPage = new HabrPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habrpage"));
    }

    @Test
    public void habrTest() throws InterruptedException {
        //Открытие окна поиска
        habrPage.clickSearchBtn();
        //Ввод "Dins" в поиск
        habrPage.inputSearchField("Dins");
        //Нажатие клавиши Enter
        habrPage.searchFieldEnter();
        //Переход поссылке "Хабы и компании"
        habrPage.clickHrefHubsAndCompany();
        //Переход поссылке "Блог компании DINS"
        habrPage.clickHrefDins();
        //Переход поссылке "Профиль"
        habrPage.clickHrefDinsProfile();
        // Проверка заголовка "О компании"
        habrPage.titleCompanyCheck();
        // Проверка заголовка "Ключевые технологии:"
        habrPage.titleTopTechnologyCheck();
        // Проверка даты основания компании
        habrPage.dateOfCreationCheck();
        //Переход поссылке настройка языка
        habrPage.clickHrefLanguageSettings();
        //Изменения языка интерфейса на английский
        habrPage.clickEnglishLanguageInterface();
        //Нажатие клавиши сохранения настроек языка
        habrPage.clickLanguageSettingsSave();
        Thread.sleep(500);
        //Проверки перевода вкладок
        habrPage.checkTranslateBlog();
        habrPage.checkTranslateNews();
        habrPage.checkTranslateVacancies();
        habrPage.checkTranslateSubscribers();
        habrPage.checkTranslateEmployees();
        habrPage.checkTranslateProfile();
        //Проверка перевода даты основания
        habrPage.checkTranslateDateOfCreation();


    }

    @After
    public void close() {
        driver.quit();
    }
}
