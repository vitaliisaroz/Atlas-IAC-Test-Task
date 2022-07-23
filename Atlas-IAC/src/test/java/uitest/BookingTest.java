package uitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.BookingMainPage;
import utils.TestRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingTest extends TestRunner {

    BookingMainPage bookingMainPage = new BookingMainPage();

    @DataProvider
    public Object[][] dateAndCity() {
        return new Object[][]{
                {"Thursday 1 December 2022", "Friday 30 December 2022", "New York"}};
    }

    @Test(dataProvider = "dateAndCity")
    public void BookingTest(String startDate, String endDate, String city) {

        bookingMainPage.setCity();
        bookingMainPage.setDate();

        assertThat(bookingMainPage.getDate())
                .as("Invalid date selected")
                .contains(startDate)
                .contains(endDate);

        assertThat(bookingMainPage.getLocationFromHotelsCards())
                .as("Invalied city selected")
                .contains(city);

    }
}