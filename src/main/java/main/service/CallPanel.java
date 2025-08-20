package main.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public abstract class CallPanel implements Panel {

    protected final ChromeDriver driver;
    protected String ip;
    protected String login;
    protected String password;
    private final WebDriverWait wait;

    public CallPanel(String ip, String login, String password) {
        this.ip = ip;
        this.login = login;
        this.password = password;

        driver = new ChromeDriver(new ChromeOptions().addArguments("--ignore-certificate-errors"));
        driver.get("https://" + ip);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        init();
        driver.quit();
    }

    public WebElement getElementById(String str) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(str)));
        } catch (Exception e) {
        }
        return null;
    }
    public WebElement getElementByClassName(String str) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(str)));
        } catch (Exception e) {
        }
        return null;
    }
    public WebElement getElementByName(String str) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(str)));
        } catch (Exception e) {
        }
        return null;
    }
    public WebElement getElementByXpath(String str) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
        } catch (Exception e) {
        }
        return null;
    }
    public List<WebElement> getElementsByCssSelector(String str) {
        try {
            return driver.findElements(By.cssSelector(str));
        } catch (Exception e) {

        }
        return null;
    }
    public List<WebElement> getElementsByTagName(WebElement element, String str) {
        try {
            return element.findElements(By.tagName(str));
        } catch (Exception e) {

        }
        return null;
    }

    public WebElement waiter(int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("qqq")));
        } catch (Exception e) {
            return null;
        }
    }
}
