package main.service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public interface Panel {
    String password = "";
    public void init();
    public List<String> getInfoElements();
    public WebElement getElementById(String str);
    public WebElement getElementByClassName(String str);
    public WebElement getElementByXpath(String str);
}
