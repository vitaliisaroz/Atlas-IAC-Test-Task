package uitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.BookingMainPage;
import utils.TestRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingSignInTest extends TestRunner {

    BookingMainPage bookingMainPage = new BookingMainPage();

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"vitaliisaroz@gmail.com", "Пошук за типом помешкання"}};
    }

    @Test(dataProvider = "data")
    public void BookingTest(String email, String text) {

        bookingMainPage.switchCurrencyAndLanguage();
        bookingMainPage.signIn();
        bookingMainPage.enterEmailAndSubmit(email);
        bookingMainPage.goToHomePage();

        assertThat(bookingMainPage.recentSearches())
                .as("It's not a home page")
                .contains(text);

    }
}