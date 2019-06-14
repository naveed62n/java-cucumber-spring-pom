package com.dvla.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver webDriver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webDriver = driver;
    }
}
