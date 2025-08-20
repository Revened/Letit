package main.service.panelModel;

import main.service.CallPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C313V2 extends CallPanel {
    public C313V2(String ip, String login, String password) {
        super(ip, login, password);
    }

    public void init() {
        try {
            WebElement usernameLabel = getElementById("username");
            WebElement passwordLabel = getElementById("password");
            WebElement loginButton = getElementById("Login");

            usernameLabel.sendKeys(login);
            passwordLabel.sendKeys(password);

            loginButton.click();
            waiter(3);
            getInfoElements();
        } catch (Exception e) {

        }
    }


    private static void ttt(ChromeDriver driver) {

        WebElement form = driver.findElement(By.name("body_form"));

        List<WebElement> labels = form.findElements(By.tagName("label"));

        for (WebElement label : labels) {
            System.out.println(label.getText());
        }
    }
    public List<String> getInfoElements() {

        WebElement form = driver.findElement(By.name("body_form"));

        List<WebElement> labels = form.findElements(By.tagName("label"));
        List<String> panelInfo = new ArrayList<>();

        panelInfo.add(find(labels, "Модель"));
        panelInfo.add(find(labels, "оборудован"));
        panelInfo.add(find(labels, "прошивк"));
        panelInfo.add(find(labels, "MAC"));
        panelInfo.add(find(labels, "IP-адрес"));

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
