package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to execute login and logout steps
        String login  =  "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        driver.get(Properties.getBaseAdminUrl());

        Thread.sleep(240);

        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();

        Thread.sleep(240);

        driver.findElement(By.id("employee_infos")).click();
        driver.findElement(By.id("header_logout")).click();
        }
    }

