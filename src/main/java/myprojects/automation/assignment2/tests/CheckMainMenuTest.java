package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;


public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to check Main Menu items

        String login = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        driver.get(Properties.getBaseAdminUrl());

        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();

        Thread.sleep(500);

        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='nav-sidebar']/ul/li/a"));
        List<String> list2 = new ArrayList<>();
        System.out.println(list.size());
        for (WebElement a : list) {
            list2.add(a.getAttribute("href"));
        }

        for (String link : list2) {
            driver.get(link);
            System.out.println(driver.findElement(By.cssSelector("*[class*='breadcrumb']")).getText());
            driver.navigate().refresh();
            Thread.sleep(500);

            if (link.equals(driver.getCurrentUrl()))
                System.out.println("Page is correct");
            else
                System.out.println("Page is not correct");

        }
        driver.quit();
    }
}