package ru.com.habr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestHabr {

    private static final Logger logger = LoggerFactory.getLogger(TestHabr.class);

    public static HabrPage habrPage;
    public static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        habrPage = new HabrPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habr.page"));
    }

    @After
    public void close() {
        driver.quit();
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
        titleCompanyCheck();
        // Проверка заголовка "Ключевые технологии:"
        titleTopTechnologyCheck();
        // Проверка даты основания компании
        dateOfCreationCheck();
        //Переход поссылке настройка языка
        habrPage.clickHrefLanguageSettings();
        //Изменения языка интерфейса на английский
        habrPage.clickEnglishLanguageInterface();
        //Нажатие клавиши сохранения настроек языка
        habrPage.clickLanguageSettingsSave();
        Thread.sleep(500);
        //Проверки перевода вкладок
        checkTranslateBlog();
        checkTranslateNews();
        checkTranslateVacancies();
        checkTranslateSubscribers();
        checkTranslateEmployees();
        checkTranslateProfile();
        //Проверка перевода даты основания
        checkTranslateDateOfCreation();
    }

    /**
     * Метод для проверки перевода вкладки "Блог"
     */
    private void checkTranslateBlog() {
        String dinsBlogText = habrPage.getHrefDinsBlog().getText();
        Assert.assertEquals("BLOG", dinsBlogText);
        logger.info("BLOG translate correct");
    }

    /**
     * Метод для проверки перевода вкладки "Новости"
     */
    private void checkTranslateNews() {
        String dinsNewsText = habrPage.getHrefDinsNews().getText();
        Assert.assertEquals("NEWS", dinsNewsText);
        logger.info("NEWS translate correct");
    }

    /**
     * Метод для проверки перевода вкладки "Вакансии"
     */
    private void checkTranslateVacancies() {
        String dinsVacanciesText = habrPage.getHrefDinsVacancies().getText();
        Assert.assertEquals("VACANCIES", dinsVacanciesText);
        logger.info("VACANCIES translate correct");
    }

    /**
     * Метод проверки перевода вкладки "Подписчики"
     */
    private void checkTranslateSubscribers() {
        String dinsSubscribersText = habrPage.getHrefDinsSubscribers().getText().substring(0, 11);
        Assert.assertEquals("SUBSCRIBERS", dinsSubscribersText);
        logger.info("SUBSCRIBERS translate correct");
    }

    /**
     * Метод проверки перевода вкладки "Сотрудники"
     */
    private void checkTranslateEmployees() {
        String dinsEmployeesText = habrPage.getHrefDinsEmployees().getText().substring(0, 9);
        Assert.assertEquals("EMPLOYEES", dinsEmployeesText);
        logger.info("EMPLOYEES translate correct");
    }

    /**
     * Метод проверки перевода вкладки "Профиль"
     */
    private void checkTranslateProfile() {
        String dinsEmployeesText = habrPage.getHrefDinsProfile().getText();
        Assert.assertEquals("PROFILE", dinsEmployeesText);
        logger.info("PROFILE translate correct");
    }

    /**
     * Метод проверки перевода даты основания
     */
    private void checkTranslateDateOfCreation() {
        String dateOfCreationText = habrPage.getDateOfCreation().getText();
        Assert.assertEquals("Since 1998", dateOfCreationText);
        logger.info("Creation date translate correct");
    }

    /**
     * Метод для проверки существования заголовка "О компании"
     */
    private void titleCompanyCheck() {
        String titleCompanyText = habrPage.getTitleCompany().getText();
        Assert.assertEquals("О компании", titleCompanyText);
        logger.info("Title \"О компании:\" exists");
    }

    /**
     * Метод для проверки существования заголовка "Ключевые технологии:"
     */
    private void titleTopTechnologyCheck() {
        String titleTopTechnologyText = habrPage.getTitleTopTechnology().getText();
        Assert.assertEquals("Ключевые технологии:", titleTopTechnologyText);
        logger.info("Title \"Ключевые технологии:\" exists");
    }

    /**
     * Метод для проверки даты основания компании
     */
    private void dateOfCreationCheck() {
        String dateOfCreationText = habrPage.getDateOfCreation().getText();
        Assert.assertEquals("1998 год", dateOfCreationText);
        logger.info("Creation date correct");
    }

}
