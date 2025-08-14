package main.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public abstract class CallPanel implements Panel {

    private ChromeDriver driver;
    private String ip;
    private String login;
    private String password;

    public CallPanel(ChromeDriver driver) {
        this.driver = driver;
        init();
    }

    public WebElement getElement(String str) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(str)));
        } catch (Exception e) {

        }
        return null;
    }

}
