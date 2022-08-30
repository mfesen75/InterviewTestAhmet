package com.testifi.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginUtils {

    public static boolean loginState(WebDriver driver) {

        WebElement[] arr = {driver.findElement(By.id(ConfigurationReader.getProperty("homeBtnID"))),
                driver.findElement(By.id(ConfigurationReader.getProperty("petsBtnID"))),
                driver.findElement(By.id(ConfigurationReader.getProperty("storeBtnID")))};

        String[] arrTextActual = {ConfigurationReader.getProperty("homeTabText"),
                                  ConfigurationReader.getProperty("petTabText"),
                                  ConfigurationReader.getProperty("storeTabText")};

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getText().equals(arrTextActual[i])) {
                flag = true;
            } else {
                flag = false;
            }

            if (flag) {
                System.out.println("test passed for: " + arrTextActual[i]);
            } else {
                System.err.println("test has not passed for: " + arrTextActual[i]);

            }
        }
        return flag;
    }


    //Enters given credentials.
    public static void enterCredentials(String Username, String Password, WebDriver driver) {

        driver.findElement(By.id("mat-input-0")).sendKeys(Username);
        driver.findElement(By.id("mat-input-1")).sendKeys(Password);


    }

    //Clicks log in button.
    public static void clickLogIn(WebDriver driver) {

        driver.findElement(By.id(ConfigurationReader.getProperty("loginBtnID"))).click();


    }

    //Checks for error message.
    public static void checkErrorMSG( WebDriver driver) throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//*[text()='Username or password are wrong']")).getText();
        Thread.sleep(1000);
        System.out.println("Error message =  " + text);

    }
    public static void petDisplayed(WebDriver driver){
        String petTab = driver.findElement(By.id(ConfigurationReader.getProperty("petsBtnID"))).getText();
        boolean petTabDisplayed = false;
        if(petTab.equals(ConfigurationReader.getProperty("petTabText"))){
            petTabDisplayed = true;
        }
        System.out.println("PetTab is displayed = "+ petTabDisplayed);
    }
}