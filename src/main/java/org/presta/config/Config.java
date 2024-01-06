package org.presta.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Getter
public class Config {

    private final Properties properties;
    private final String url;
    private final String browser;
    private final String browserAttachScreenshot;
    private final String headlessMode;
    private final String browserTimeout;
    private final String userEmail;
    private final String userPassword;

    public Config () {
        properties = getProperties();
        url = properties.getProperty("url");
        browser = properties.getProperty("browser");
        browserAttachScreenshot = properties.getProperty("browserAttachScreenshot");
        headlessMode = properties.getProperty("headlessMode");
        browserTimeout = properties.getProperty("browserTimeout");
        userEmail = properties.getProperty("userEmail");
        userPassword = properties.getProperty("userPassword");
    }

    private Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load properties file: " + e);
        }
        return prop;
    }
}
