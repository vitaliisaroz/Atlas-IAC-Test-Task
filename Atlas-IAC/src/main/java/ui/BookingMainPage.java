package ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BookingMainPage {

    private final SelenideElement searchField = $x("//input[@type='search']");
    private final SelenideElement dateGroup = $x("//div[@class='xp__dates xp__group']");
    private final SelenideElement nextButton = $x("//div[@data-bui-ref='calendar-next']");
    private final SelenideElement startDate = $x("//div[@class='bui-calendar__content']//td[@data-date='2022-12-01']");
    private final SelenideElement endDate = $x("//div[@class='bui-calendar__content']//td[@data-date='2022-12-30']");
    private final SelenideElement searchButton = $x("//button[@class='sb-searchbox__button ']");
    private final SelenideElement dateContainer = $x("//div[@data-testid='searchbox-layout-vertical']");
    private final SelenideElement hotelsList = $x("//div[@data-component='arp-properties-list']");
    private final SelenideElement currencyButton = $x("//button[@class='bui-button bui-button--light bui-button--large']//span[contains(text(), 'UAH')]");
    private final List<SelenideElement> currencyList = $$x("//div[@class='bui-modal__header-slot']//a");
    private final SelenideElement languageButton = $x("//button[@data-tooltip-text='Choose your language']");
    private final List<SelenideElement> languageList = $$x("//div[@class='bui-modal__header-slot']//a");
    private final List<SelenideElement> signInButtons = $$x("//a[@data-google-track='Click/Action: index/header_logged_out_link_box']");
    private final SelenideElement emailInput = $x("//input[@type='email']");
    private final SelenideElement submitButton = $x("//button[@type='submit']");
    private final SelenideElement homePageLogo = $x("//div[@class='_tjGJPY2JTYKalhjuaQs']");
    private final SelenideElement typeOfHotels = $x("//div[@data-testid='webcore-carousel-heading']");

    @Step("Setting required city")
    public void setCity() {
        searchField.sendKeys("New York");
    }

    @Step("Setting required date")
    public void setDate() {
        dateGroup.click();

        for (int i = 0; i <= 4; i++) {
            nextButton.click();
        }

        startDate.click();
        endDate.click();
        searchButton.click();
    }

    @Step("Getting date from container")
    public String getDate() {
        return dateContainer
                .getText()
                .trim();
    }

    @Step("Getting text from hotels cards")
    public String getLocationFromHotelsCards() {
        return hotelsList
                .getText()
                .trim();
    }

    @Step("Switching currency to EUR")
    public void switchCurrencyAndLanguage() {
        currencyButton.click();
        currencyList
                .get(0)
                .click();
        languageButton.click();
        languageList
                .get(0)
                .click();
    }

    @Step("Signing in")
    public void signIn() {
        signInButtons
                .get(1)
                .click();
    }

    @Step("Entering a valid email")
    public void enterEmailAndSubmit(String email) {
        emailInput.sendKeys(email);
        submitButton.click();
    }

    @Step("Go to home page")
    public void goToHomePage() {
        homePageLogo.click();
    }

    @Step("Getting text from recent searches")
    public String recentSearches() {
        return typeOfHotels
                .getText()
                .trim();
    }
}