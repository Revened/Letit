package main.service.panelModel;

import main.service.CallPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class X915S extends CallPanel {
    public X915S(String ip, String login, String password) {
        super(ip, login, password);
    }

    @Override
    public void init() {
        try {
            WebElement usernameLabel = getElementByXpath("//input[@placeholder='User Name']");
            WebElement passwordLabel = getElementByXpath("//input[@placeholder='Password']");
            WebElement loginButton = getElementByXpath("//button[contains(text(), 'Login')]");

            usernameLabel.sendKeys(login);
            passwordLabel.sendKeys(password);

            loginButton.click();
            waiter(3);
            List<String> infoElements = getInfoElements();
        } catch (Exception e) {

        }
    }


    public List<String> getInfoElements() {
        List<WebElement> labels = driver.findElements(By.cssSelector("div.ak-homepage-device-info-item"));
        List<String> panelInfo = new ArrayList<>();

        panelInfo.add(find(labels, "Model"));
        panelInfo.add(find(labels, "Hardware"));
        panelInfo.add(find(labels, "Firmware"));
        panelInfo.add(find(labels, "MAC"));
        panelInfo.add(find(labels, "IP"));

        return panelInfo;
    }
    public String find(List<WebElement> labels, String contain) {
        for (int i = 0; i < labels.size() - 1; i++) {
            if (labels.get(i).getText().contains(contain)) {
                return labels.get(i).getText() ;
            }
        }
        return contain + ": NOT FOUND";
    }
}
