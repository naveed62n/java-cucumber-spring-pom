package com.dvla.example.stepDefs;

import com.dvla.example.runners.CucumberContext;
import com.dvla.example.applicationconfig.PropertiesContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes={CucumberContext.class, PropertiesContext.class})
public class BaseSteps {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    @Autowired
    public String homePageUrl;



}
