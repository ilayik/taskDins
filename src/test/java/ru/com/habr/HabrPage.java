package ru.com.habr;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HabrPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public HabrPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Определение локатора кнопки поиска
     */
    @FindBy(xpath = "//*[@id=\"search-form-btn\"]")
    private WebElement searchBtn;

    /**
     * Определение локатора поля ввода
     */
    @FindBy(xpath = "//*[@id=\"search-form-field\"]")
    private WebElement searchField;

    /**
     * Определение локатора ссылки "Хабы и Компании"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/section/div[1]/div[1]/div/a[2]/h3")
    private WebElement hrefHabsAndCompany;

    /**
     * Определение локатора ссылки "Блог компании DINS"
     */
    @FindBy(xpath = "//*[@id=\"hub_22105\"]/div[1]/div/div/div/a")
    private WebElement hrefDins;

    /**
     * Определение локатора ссылки "Профиль"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div[1]/a[1]")
    private WebElement hrefDinsProfile;

    /**
     * Определение локатора заголовка "О компании"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/dl/dt[1]/h2")
    private WebElement titleCompany;

    /**
     * Определение локатора заголовка "Ключевые технологии:"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/dl/dd[1]/p/b[1]")
    private WebElement titleTopTechnology;

    /**
     * Определение локатора даты основания компании
     */
    @FindBy(xpath = "//*[@id=\"profile-company\"]/div[2]/ul/li[1]/span")
    private WebElement dateOfCreation;

    /**
     * Определение локатора настройки языка
     */
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div[2]/a")
    private WebElement languageSettings;

    /**
     * Определение локатора облости изменения языка интерфейса на английский
     */
    @FindBy(xpath = "//*[@id=\"lang-settings-form\"]/fieldset[1]/div[2]/span/label")
    private WebElement englishLanguageInterface;

    /**
     * Определение локатора кнопки сохранения изменений языка
     */
    @FindBy(xpath = "//*[@id=\"lang-settings-form\"]/div/button")
    private WebElement languageSettingsSave;

    /**
     * Определение локатора ссылки "Блог"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a[2]/h3")
    private WebElement hrefDinsBlog;

    /**
     * Определение локатора ссылки "Новости"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a[3]/h3")
    private WebElement hrefDinsNews;

    /**
     * Определение локатора ссылки "Вакансии"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a[4]/h3")
    private WebElement hrefDinsVacancies;

    /**
     * Определение локатора ссылки "Подписчики"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a[5]/h3")
    private WebElement hrefDinsSubscribers;

    /**
     * Определение локатора ссылки "Сотрудники"
     */
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/a[6]/h3")
    private WebElement hrefDinsEmployees;


    /**
     * Метод для нажатия Enter в поле поиска
     */
    public void searchFieldEnter() {
        searchField.sendKeys(Keys.ENTER);
    }

    /**
     * Метод для ввода строки поле поиска
     */
    public void inputSearchField(String str) {
        searchField.sendKeys(str);
    }

    /**
     * Метод для нажатия кнопки поиска
     */
    public void clickSearchBtn() {
        searchBtn.click();
    }

    /**
     * Метод для нажатия ссылки "Хабы и Компании"
     */
    public void clickHrefHubsAndCompany() {
        hrefHabsAndCompany.click();
    }

    /**
     * Метод для нажатия ссылки "Хабы и Компании"
     */
    public void clickHrefDins() {
        hrefDins.click();
    }

    /**
     * Метод для нажатия ссылки "Профиль"
     */
    public void clickHrefDinsProfile() {
        hrefDinsProfile.click();
    }

    /**
     * Метод для проверки существования заголовка "О компании"
     */
    public void titleCompanyCheck() {
        String titleCompanyText = titleCompany.getText();
        Assert.assertEquals("О компании", titleCompanyText);
    }

    /**
     * Метод для проверки существования заголовка "Ключевые технологии:"
     */
    public void titleTopTechnologyCheck() {
        String titleTopTechnologyText = titleTopTechnology.getText();
        Assert.assertEquals("Ключевые технологии:", titleTopTechnologyText);
    }

    /**
     * Метод для проверки даты основания компании
     */
    public void dateOfCreationCheck() {
        String dateOfCreationText = dateOfCreation.getText();
        Assert.assertEquals("1998 год", dateOfCreationText);
    }

    /**
     * Метод для нажатия ссылки настройки языка
     */
    public void clickHrefLanguageSettings() {
        languageSettings.click();
    }

    /**
     * Метод для нажатия на облость изменения языка интерфейса на английский
     */
    public void clickEnglishLanguageInterface() {
        englishLanguageInterface.click();
    }

    /**
     * Метод для нажатия кнопки сохранения изменений языка
     */
    public void clickLanguageSettingsSave() {
        languageSettingsSave.click();
    }

    /**
     * Метод для проверки перевода вкладки "Блог"
     */
    public void checkTranslateBlog() {
        String dinsBlogText = hrefDinsBlog.getText();
        Assert.assertEquals("BLOG", dinsBlogText);
    }

    /**
     * Метод для проверки перевода вкладки "Новости"
     */
    public void checkTranslateNews() {
        String dinsNewsText = hrefDinsNews.getText();
        Assert.assertEquals("NEWS", dinsNewsText);
    }

    /**
     * Метод для проверки перевода вкладки "Вакансии"
     */
    public void checkTranslateVacancies() {
        String dinsVacanciesText = hrefDinsVacancies.getText();
        Assert.assertEquals("VACANCIES", dinsVacanciesText);
    }

    /**
     * Метод проверки перевода вкладки "Подписчики"
     */
    public void checkTranslateSubscribers() {
        String dinsSubscribersText = hrefDinsSubscribers.getText().substring(0, 11);
        Assert.assertEquals("SUBSCRIBERS", dinsSubscribersText);
    }

    /**
     * Метод проверки перевода вкладки "Сотрудники"
     */
    public void checkTranslateEmployees() {
        String dinsEmployeesText = hrefDinsEmployees.getText().substring(0, 9);
        Assert.assertEquals("EMPLOYEES", dinsEmployeesText);
    }

    /**
     * Метод проверки перевода вкладки "Профиль"
     */
    public void checkTranslateProfile() {
        String dinsEmployeesText = hrefDinsProfile.getText();
        Assert.assertEquals("PROFILE", dinsEmployeesText);
    }

    /**
     * Метод проверки перевода даты основания
     */

    public void checkTranslateDateOfCreation() {
        String dateOfCreationText = dateOfCreation.getText();
        Assert.assertEquals("Since 1998", dateOfCreationText);
    }


}
