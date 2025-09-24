package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties = new Properties();

    private static final String URL_PROPERTY = "URL";
    private static final String API_URL_PROPERTY = "apiURL";
    private static final String BROWSER_TYPE_PROPERTY = "browserType";
    private static final String HEADLESS_PROPERTY = "headless";
    private static final String TIMEOUT_PROPERTY = "timeout";
    private static final String USERNAME_PROPERTY = "username";
    private static final String PASSWORD_PROPERTY = "password";

    static {
        try (InputStream input = ReadProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getUrl() {
        return properties.getProperty(URL_PROPERTY);
    }

    public static String getApiUrl() {
        return properties.getProperty(API_URL_PROPERTY);
    }

    public static String getBrowserType() {
        return properties.getProperty(BROWSER_TYPE_PROPERTY);
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty(HEADLESS_PROPERTY));
    }



    public static long getTimeout() {
        return Long.parseLong(properties.getProperty(TIMEOUT_PROPERTY));
    }

    public static String getUsername() {
        return properties.getProperty(USERNAME_PROPERTY);
    }

    public static String getPassword() {
        return properties.getProperty(PASSWORD_PROPERTY);
    }
}
