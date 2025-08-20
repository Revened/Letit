package main.service.panelModel;

import main.service.CallPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RV3434 extends CallPanel {
    public RV3434(String ip, String login, String password) {
        super(ip, login, password);
    }

    public void init() {
        try {
            WebElement usernameLabel = getElementByName("userName");
            WebElement passwordLabel = getElementByName("password");
            WebElement loginButton = getElementByClassName("login-field-button");

            usernameLabel.sendKeys(login);
            passwordLabel.sendKeys(password);

            loginButton.click();
            waiter(3);
            getInfoElements();
        } catch (Exception e) {

        }
    }

    private static void ttt(ChromeDriver driver) {

        WebElement container = driver.findElement(By.cssSelector("mat-card-content"));

        List<WebElement> sections = container.findElements(By.cssSelector("section"));

        for (WebElement section : sections) {
            //System.out.println(section.getText());                //хуйня
            try {
                String header = section.findElement(By.cssSelector("div.info-header")).getText().trim();
                String data = section.findElement(By.cssSelector("div.info-data")).getText().trim();
                System.out.println(header + ": " + data);
            } catch (Exception e) {
            }
        }
    }

    public List<String> getInfoElements() {

        WebElement form = driver.findElement(By.cssSelector("mat-card-content"));

        List<WebElement> labels = form.findElements(By.cssSelector("section"));
        List<String> panelInfo = find(labels, "Модель", "Серийный","Время работы","MAC","IP" );

        return panelInfo;
    }
    public List<String> find(List<WebElement> labels, String... contain) {
        List<String> list = new ArrayList<>();
        for (WebElement label : labels) {
            try {
                String header = label.findElement(By.cssSelector("div.info-header")).getText().trim();
                String data = label.findElement(By.cssSelector("div.info-data")).getText().trim();
                for (int i = 0; i < contain.length - 1; i++) {
                    if (header.contains(contain[i])) {
                        list.add(header + ": " + data);
                    }
                }
            } catch (Exception e){

            }
        }
        return list;
    }
}

