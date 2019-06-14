package com.dvla.example.stepDefs;

import com.dvla.example.services.DataService;
import com.dvla.example.pages.VehicleConfirmPage;
import com.dvla.example.pages.VehicleInformationHomePage;
import com.dvla.example.pages.VehicleResultsPage;
import com.dvla.example.pages.VehicleSearchPage;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class VehicleSearchSteps extends BaseSteps{

    private static final Logger logger = LoggerFactory.getLogger(VehicleSearchSteps.class);
    private VehicleInformationHomePage vehicleInformationHomePage;
    private VehicleSearchPage vehicleSearchPage;
    private VehicleConfirmPage vehicleConfirmPage;
    private VehicleResultsPage vehicleResultsPage;

    @Given("^the \"([^\"]*)\" home page is accessible$")
    public void the_is_accessible(String expectedHomePageTitle) throws Throwable {
        vehicleInformationHomePage = new VehicleInformationHomePage(webDriver);
        vehicleInformationHomePage.load(homePageUrl);
        webDriverWait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
        vehicleInformationHomePage.assertTheSearchHomePageHasBeenLoaded(expectedHomePageTitle);
    }

    @When("^a user clicks the start button$")
    public void a_user_clicks_the_start_button() throws Throwable {
        vehicleSearchPage = vehicleInformationHomePage.goToSearchPage(webDriverWait);
    }

    @Then("^the \"([^\"]*)\" titled page is provided$")
    public void the_titled_page_is_provided(String expectedVehicleSearchPageTitle) throws Throwable {
        webDriverWait.until(ExpectedConditions.titleIs(expectedVehicleSearchPageTitle));
        vehicleSearchPage.assertTheVehicleSearchPageHasBeenLoaded(expectedVehicleSearchPageTitle);
    }

    @When("^a user submits the vehicle registration from \"([^\"]*)\" and clicks continue$")
    public void a_user_submits_the_and_clicks_continue(@Transform(DataService.class) DataTable table) throws Throwable {
        List<String> tableRecords = table.asList(String.class);
        vehicleConfirmPage = vehicleSearchPage.enterVehicleRegistrationAndSubmit(tableRecords.get(0));
    }

    @Then("^the vehicle confirmation page is provided$")
    public void the_vehicle_confirmation_page_is_provided() throws Throwable {
        vehicleConfirmPage.assertTheConfirmationTextIsPresented(webDriverWait);
    }

    @When("^the user validates the displayed registration to the search registration from \"([^\"]*)\"$")
    public void the_user_validates_the_displayed_registration_to_the_search_registration(@Transform(DataService.class) DataTable table) throws Throwable {
        List<String> tableRecords = table.asList(String.class);
        vehicleConfirmPage.assertTheCorrectRegistrationAsSearchedExists(tableRecords.get(0));
    }

    @And("^the user confirms registration details yes on the screen and clicks continue$")
    public void the_user_confirms_registration_details_yes_on_the_clicks_and_clicks_continue() throws Throwable {
        vehicleResultsPage = vehicleConfirmPage.userConfirmsYesAndContinue();
    }

    @Then("^the vehicle details screen is presented with the searched registration details from \"([^\"]*)\"$")
    public void the_vehicle_details_screen_is_presented_with_the_searched_registration_details(@Transform(DataService.class) DataTable table) throws Throwable {
        List<String> tableRecords = table.asList(String.class);
        vehicleResultsPage.AssertTheRegistrationDetailsArePresented(tableRecords.get(0));
    }
}
