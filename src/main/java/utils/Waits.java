package utils;

import browserService.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public Waits(WebDriver driver, Duration timeOut) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver) {
        this.driver = driver;
        ReadProperties readProperties = new ReadProperties();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(readProperties.getTimeOut()));
    }

    public boolean isElementDisplayed(By by) {
       try {
           webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
           return true;
       } catch (TimeoutException ex) {
           return false;
       }
    }

    public WebElement getElementBy(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public WebElement isElementClickable(WebElement webElement) {
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public WebElement isElementPresences(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public Boolean isElementToBeSelected(By by) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(by));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean hasAttributeValue(By by) {
        try {
            webDriverWait.until(ExpectedConditions.attributeToBe(by, "Attribute", "Value"));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean hasWebPageTitle(By by) {
        try {
            webDriverWait.until(ExpectedConditions.titleIs("Title"));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public Boolean isAttributeNotEmpty(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, "Attribute"));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public WebDriver isFrameAvailable(WebElement webElement) {
        try {
            return webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public Boolean isElementInvisible(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isJsReturnedValue(By by) {
        try {
            webDriverWait.until(ExpectedConditions.jsReturnsValue("Java Script"));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isNumberOfWindows(int number) {
        try {
            webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(number));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isTextPresentedInElement(By by) {
        try {
            webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, "Some Text"));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
