package com.dvla.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertEquals;


public class VehicleInformationHomePage extends BasePage{

    private final static Logger logger = LoggerFactory.getLogger(VehicleInformationHomePage.class);

    @FindBy(how = How.CSS, using = "html body.mainstream.js-enabled div#wrapper.transaction.service div.grid-row main#content div.article-container.group div.content-block div.inner section.intro p#get-started.get-started.group a.gem-c-button.govuk-button.govuk-button--start")
    private static WebElement startButton;

    private VehicleSearchPage VehicleSearchPage;

    public VehicleInformationHomePage(WebDriver driver) {
        super(driver);
    }

    public void load(String homePageUrl) throws InterruptedException {
        webDriver.get(homePageUrl);
    }

    public VehicleSearchPage goToSearchPage(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(startButton));
        startButton.click();
        return new VehicleSearchPage(webDriver);
    }


    public void assertTheSearchHomePageHasBeenLoaded(String homePageTitle) {
        assertEquals(homePageTitle,webDriver.getTitle());
    }
}