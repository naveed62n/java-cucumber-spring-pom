package com.dvla.example.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VehicleConfirmPage extends BasePage{

    private final static Logger logger = LoggerFactory.getLogger(VehicleConfirmPage.class);

    @FindBy(how = How.CSS, using = ".heading-large")
    public static WebElement pageSummaryText;

    @FindBy(how = How.CSS, using = ".button")
    public static WebElement continueButton;

    @FindBy(how = How.CSS, using = ".reg-mark")
    public static WebElement regNumber;

    @FindBy(how = How.ID, using = "Correct_True")
    public static WebElement confirmYes;

    public VehicleConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void assertTheConfirmationTextIsPresented(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(pageSummaryText));
        Assert.assertEquals("Is this the vehicle you are looking for?", pageSummaryText.getText());
    }

    public void assertTheCorrectRegistrationAsSearchedExists(String vehicleRegSearched) throws InterruptedException {
        Assert.assertEquals(vehicleRegSearched, regNumber.getText());
    }

    public VehicleResultsPage userConfirmsYesAndContinue(){
        confirmYes.click();
        continueButton.click();
        return new VehicleResultsPage(webDriver);
    }
}