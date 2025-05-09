package stepdefenitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.drivers.DriverManager;
import com.pages.WebSearchResultsPage;
import com.utilities.HelperUtilities;

import io.cucumber.java.en.Then;

public class SearchPageStepLibrary {

	private WebDriver driver = DriverManager.getDriver();
	private WebSearchResultsPage searchpage = new WebSearchResultsPage(driver);

	@Then("Verify User gets navigated to Search Results Page")
	public void verify_user_gets_navigated_to_search_results_page() {
		HelperUtilities.waitForPageToLoad();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "/searchresults.html";
		Assert.assertEquals(currentURL.contains(expectedURL), true, "Verification of URL");
	}

	@Then("Destination {string} is displayed in Search Results Page")
	public void destination_is_displayed_in_search_results_page(String DestinationInSearchResults) {
			searchpage.getDestinationReturnedText(DestinationInSearchResults).isDisplayed();
	}
}
