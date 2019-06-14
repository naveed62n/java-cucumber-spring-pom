package com.dvla.example.driverconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverConfig extends EventFiringWebDriver {

    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverConfig.class);

    private static final WebDriver webdriver;

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            webdriver.close();
        }
    };

    static {

        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().deleteAllCookies();
        webdriver.manage().window().maximize();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public ChromeDriverConfig(WebDriver webDriver) {
        super(webdriver);
    }

	public static WebDriver getWebdriver() {
		return webdriver;
	}

    
    
}