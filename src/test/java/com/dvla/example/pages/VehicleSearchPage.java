package com.dvla.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;


public class VehicleSearchPage extends BasePage {


    public VehicleSearchPage(WebDriver driver) {
        super(driver);
    }

    private final static Logger logger = LoggerFactory.getLogger(VehicleSearchPage.class);
    @FindBy(how = How.ID, using = "Vrm")
    public static WebElement textBar;

    @FindBy(how = How.CSS, using = ".button")
    public static WebElement continueButton;

    public void assertTheVehicleSearchPageHasBeenLoaded(String expectedVehicleSearchPageTitle) {
        assertEquals(expectedVehicleSearchPageTitle, webDriver.getTitle());
    }

    public VehicleConfirmPage enterVehicleRegistrationAndSubmit(String vehicleRegistration) throws InterruptedException {
        textBar.sendKeys(vehicleRegistration);
        continueButton.click();
        Thread.sleep(1000);
        return new VehicleConfirmPage(webDriver);
    }
}

