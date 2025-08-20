package main.service.panelModel;

import main.service.CallPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C319 extends CallPanel {
    public C319(String ip, String login, String password) {
        super(ip, login, password);
    }

    public void init() {
        try {
            WebElement usernameLabel = getElementByXpath("//input[@placeholder='Логин']");
            WebElement passwordLabel = getElementByXpath("//input[@placeholder='Пароль']");
            WebElement loginButton = getElementByXpath("//button[text()='Авторизация']");

            usernameLabel.sendKeys(login);
            passwordLabel.sendKeys(password);

            loginButton.click();
            waiter(3);
            getInfoElements();
        } catch (Exception e) {

        }
    }
    public List<String> getInfoElements() {

        WebElement form = driver.findElement(By.className("ak-homepage-device-info"));

        List<WebElement> labels = form.findElements(By.tagName("label"));
        List<String> panelInfo = new ArrayList<>();

        panelInfo.add(find(labels, "Модель"));
        panelInfo.add(find(labels, "оборудован"));
        panelInfo.add(find(labels, "ПО"));
        panelInfo.add(find(labels, "MAC"));
        panelInfo.add(find(labels, "IP"));

        return panelInfo;
    }
    public static String find(List<WebElement> labels, String contain) {
        for (int i = 0; i < labels.size() - 1; i++) {
            if (labels.get(i).getText().contains(contain)) {
                return labels.get(i).getText() + " " + labels.get(i + 1).getText();
            }
        }
        return contain + ": NOT FOUND";
    }
}
