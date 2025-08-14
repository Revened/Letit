package main.service;

import org.openqa.selenium.WebElement;

public interface Panel {
    String password = "";
    public void init();
    public void getInfoElements();
    public WebElement getElement(String str);
}
