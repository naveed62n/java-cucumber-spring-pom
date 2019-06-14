package com.dvla.example.runners;

import com.dvla.example.driverconfig.ChromeDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.dvla.example.applicationconfig.PropertiesContext;


@Configuration
@ContextConfiguration(classes={PropertiesContext.class})
public class CucumberContext {

    @Autowired
    private String webBrowser;

    @Bean("webDriver")
    public WebDriver getWebDriver() {
        WebDriver webDriver = null;
        
        if("chrome".equalsIgnoreCase(webBrowser)){
        	try{
        		webDriver = ChromeDriverConfig.getWebdriver();
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        return webDriver;
    }

    @Bean("wait")
    public WebDriverWait getWebDriverWait() {
    	WebDriverWait wait = null;
    	try{
    		 wait = new WebDriverWait(getWebDriver(), 10);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return wait;
    }

}
