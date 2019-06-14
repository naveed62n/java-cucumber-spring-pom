package com.dvla.example.applicationconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesContext {
    @Value("${test.webBrowser}")
    private String webBrowser;

    @Bean("webBrowser")
    public String getWebbrowser() {
        return webBrowser;
    }

    @Value("${homePageUrl}")
    private String homePageUrl;

    @Bean("homePageUrl")
    public String getHomePageUrl() {
        return homePageUrl;
    }
}
