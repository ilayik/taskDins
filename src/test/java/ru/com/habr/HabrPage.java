package ru.com.habr;


import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс для создания и упраления элементами web страницы
 */
@Getter
public class HabrPage {
    private static final Logger logger = LoggerFactory.getLogger(TestHabr.class);

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
        logger.info("Enter pressed in the search field");
    }

    /**
     * Метод для ввода строки поле поиска
     */
    public void inputSearchField(String str) {
        searchField.sendKeys(str);
        logger.info("The search field is filled with " + str);
    }

    /**
     * Метод для нажатия кнопки поиска
     */
    public void clickSearchBtn() {
        searchBtn.click();
        logger.info("Open search field");
    }

    /**
     * Метод для нажатия ссылки "Хабы и Компании"
     */
    public void clickHrefHubsAndCompany() {
        hrefHabsAndCompany.click();
        logger.info("Clicked link \"Хабы и Компании\"");
    }

    /**
     * Метод для нажатия ссылки "Блог компании DINS"
     */
    public void clickHrefDins() {
        hrefDins.click();
        logger.info("Clicked link \"Блог компании DINS\"");
    }

    /**
     * Метод для нажатия ссылки "Профиль"
     */
    public void clickHrefDinsProfile() {
        hrefDinsProfile.click();
        logger.info("Clicked link \"Профиль\"");
    }

    /**
     * Метод для нажатия ссылки настройки языка
     */
    public void clickHrefLanguageSettings() {
        languageSettings.click();
        logger.info("Clicked link language settings");
    }

    /**
     * Метод для нажатия на облость изменения языка интерфейса на английский
     */
    public void clickEnglishLanguageInterface() {
        englishLanguageInterface.click();
        logger.info("Clicked link english language interface");
    }

    /**
     * Метод для нажатия кнопки сохранения изменений языка
     */
    public void clickLanguageSettingsSave() {
        languageSettingsSave.click();
        logger.info("Clicked link english language save");
    }
}
