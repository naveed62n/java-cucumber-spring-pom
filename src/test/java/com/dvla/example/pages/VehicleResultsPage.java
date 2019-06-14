package com.dvla.example.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleResultsPage extends BasePage {

    private final static Logger logger = LoggerFactory.getLogger(VehicleResultsPage.class);

    @FindBy(how = How.CSS, using = ".reg-mark")
    public static WebElement vehicleRegText;

    public VehicleResultsPage(WebDriver driver) {
        super(driver);
    }

    public void AssertTheRegistrationDetailsArePresented(String searchedReg){
        Assert.assertEquals(searchedReg, vehicleRegText.getText());

    }

}