package main.service.panelModel;

import main.service.CallPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class S256 extends CallPanel {
    public S256(String ip, String login, String password) {
        super(ip, login, password);
    }

    public void init() {
        try {
            WebElement usernameLabel = getElementByXpath("//input[@placeholder='User Name']");
            WebElement passwordLabel = getElementByXpath("//input[@placeholder='Password']");
            WebElement loginButton = getElementByXpath("//button[contains(text(), 'Login')]");

            usernameLabel.sendKeys(login);
            passwordLabel.sendKeys(password);

            loginButton.click();
            waiter(3);
            getInfoElements();
        } catch (Exception e) {

        }
    }

    private static void ttt(ChromeDriver driver) {

        List<WebElement> infoItems = driver.findElements(By.cssSelector("div.ak-homepage-device-info-item"));

        for (WebElement item : infoItems) {
            // Находим все <label> внутри блока
            List<WebElement> labels = item.findElements(By.tagName("label"));
            for (WebElement label : labels) {
                System.out.println(label.getText());
            }
        }
    }

    public List<String> getInfoElements() {

        List<WebElement> labels = driver.findElements(By.cssSelector("div.ak-homepage-device-info-item"));
        List<String> panelInfo = find(labels, "Model", "Hardware", "Firmware", "MAC", "IP");

        return panelInfo;
    }
    public static List<String> find(List<WebElement> labels, String... contain) {
        List<String> list = new ArrayList<>();
        for (WebElement item : labels) {
            List<WebElement> qqqs = item.findElements(By.tagName("label"));
            String q = qqqs.get(0).getText();
            String w = qqqs.get(1).getText();
            for (int i = 0; i < contain.length - 1; i++) {
                if (q.contains(contain[i])) {
                    list.add(q + ": " + w);
                }
            }
        }
        return list;
    }
}
