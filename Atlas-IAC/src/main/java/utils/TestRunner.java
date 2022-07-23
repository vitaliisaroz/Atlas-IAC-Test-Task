package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.timeout;

public abstract class TestRunner {

    private WebDriver driver;

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        timeout = 8000;
        open("https://www.booking.com/index.en-gb.html");
    }
}