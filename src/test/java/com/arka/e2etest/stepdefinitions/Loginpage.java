package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.LocatorsMap;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

import static com.arka.e2etest.runner.CucumberRunner.testdata;
import static com.google.common.base.Strings.isNullOrEmpty;

public class Loginpage extends BaseFunctions {
    private static int MAX_TIMEOUT = 160;
    private static int MIN_TIMEOUT = 100;
    JsonNode locatorsMap = LocatorsMap.getlocators();
    @Given("^User is landed into the Application successfully$")
    public void user_is_landed_into_the_Application_successfully() throws Throwable {

        System.out.println("test");
    }
    @When("^user clicks on the login as \"([^\"]*)\"$")
    public void user_clicks_on_the_login_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (arg1.equalsIgnoreCase("posp") || arg1.equalsIgnoreCase("consumer")
                || arg1.equalsIgnoreCase("yes")) {
            System.out.println("Login for Myaccount &POSP");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.className(locatorsMap.get("usermenu").get("locator").textValue())));
            WebElement users = driver.findElement(By.className(locatorsMap.get("usermenu").get("locator").textValue()));
            users.click();
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(users.findElement(By.tagName("ul"))));
            List<WebElement> listofusers = login.findElements(By.tagName("li"));
            for (WebElement subtab : listofusers) {
                if (subtab.getText().equalsIgnoreCase("Login")) {
                    //action.clickAndHold(subtab).build().perform();
                    subtab.click();
                }
            }

            List<WebElement> listofmyacc = driver.findElements(By.xpath("//*[@id='__next']/div[1]/section/div/div/div/div[1]/div/div/div/div[1]/div[1]/span"));
            for (WebElement secondTab : listofmyacc) {

                String value = secondTab.getText();
                System.out.print("value  " + value);

                if (secondTab.getText().equalsIgnoreCase("Consumer") &&
                        "Consumer".equalsIgnoreCase(arg1) ||
                        arg1.equalsIgnoreCase("yes")) {

                    //secondTab.findElement(By.tagName("button")).click();
                    secondTab.click();
                    break;
                } else if (secondTab.getText().equalsIgnoreCase("POSP")
                        && "posp".equalsIgnoreCase(arg1)) {
                    System.out.println("PoSP");
                    //secondTab.findElement(By.tagName("button")).click();
                    secondTab.click();
                    break;

                }
            }
        }
    }

    @When("^User enters the mobile or email as \"([^\"]*)\"$")
    public void user_enters_the_mobile_or_email_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (testData.get("loginAs").equalsIgnoreCase("posp") || testData.get("loginAs").equalsIgnoreCase("consumer")
                || testData.get("loginAs").equalsIgnoreCase("yes")) {
            System.out.println("Enter the MobileNumber");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            if (!isNullOrEmpty(testData.get("Mobile")) || !isNullOrEmpty(testData.get("Email"))) {
                if ("Mobile".equalsIgnoreCase(testData.get("isMobOrEmail"))) {
                    String mobile_no = testData.get("Mobile");
                    if ("consumer".equalsIgnoreCase(testData.get("loginAs"))
                            || "yes".equalsIgnoreCase(testData.get("loginAs"))) {
                        loginwithmobile(mobile_no, driver, wait);
                    } else {
                        loginwithmobile(mobile_no, driver, wait);
                    }

                } else if ("email".equalsIgnoreCase(testData.get("isMobOrEmail"))) {
                    String emailId = testData.get("Email");
                    if ("consumer".equalsIgnoreCase(testData.get("loginAs"))) {
                        loginwithmobile(emailId, driver, wait);
                    } else {
                        loginwithmobile(emailId, driver, wait);
                    }
                }
            } else {
                System.out.println("Check mobilenumber and Email id");
            }
            System.out.println("login Sucess Fully");
        }
        String currenturl="https://monkeycap:monkeycap%40999@nfqa.monkeycap.com/consumer-login";
        //System.out.println(driver.getCurrentUrl());

        if(driver.getCurrentUrl().contains("consumer-login")){
            WebElement icon = driver.findElement(By.className("homeIcon"));
            icon.click();
        }
        else {
            System.out.println("current homeicon url is wrong");
        }
    }

    @When("^User enters the otp as \"([^\"]*)\"$")
    public void user_enters_the_otp_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
//		 if (testData.get("loginAs").equalsIgnoreCase("Consumer") &&
//				 testData.get("loginAs").equalsIgnoreCase("POSP")) {
//				System.out.println("already logged in user");
//
        //if (!testData.get("loginAs").equalsIgnoreCase("yes")) {
        if (testData.get("loginAs").equals("no")) {
            System.out.println("Login for OTP");
            // if (isNullOrEmpty(testData.get("mobileNumber")) ||
            // isNullOrEmpty(testData.get("emailId"))) {
            if ("Mobile".equalsIgnoreCase(testData.get("isMobOrEmail"))) {
                String mobile_no = testData.get("Mobile");
                if ("yes".equalsIgnoreCase(testData.get("loginAs"))) {
                    login(testData,mobile_no, driver, wait);
                } else {
                    login(testData,mobile_no, driver, wait);
                }

            } else if ("email".equalsIgnoreCase(testData.get("isMobOrEmail"))) {
                String emailId = testData.get("Email");
                if ("yes".equalsIgnoreCase(testData.get("loginAs"))) {
                    login(testData,emailId, driver, wait);
                } else {
                    login(testData,emailId, driver, wait);
                }
            }
        }
    }
    private void loginwithmobile(String data, WebDriver driver, WebDriverWait wait) {
        System.out.println("Login with mobile/email ");
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className(locatorsMap.get("otp_input").get("locator").textValue())));
        WebElement loginClass = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("login_otp").get("locator").textValue()))));
        WebElement ele = loginClass.findElement(By.className(locatorsMap.get("otp_input").get("locator").textValue()));
        ele.clear();
        ele.sendKeys(data);
        WebElement sendotp = wait.until(ExpectedConditions.elementToBeClickable(
                loginClass.findElement(By.xpath(locatorsMap.get("send_otp").get("locator").textValue()))));
//        WebElement button = wait
//                .until(ExpectedConditions.elementToBeClickable(sendotp.findElement(By.tagName("button"))));
        exe.executeScript("arguments[0].click();", sendotp);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className(locatorsMap.get("type_otp").get("locator").textValue())));
        WebElement typeotp = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("type_otp").get("locator").textValue()))));
        wait.until(ExpectedConditions.elementToBeClickable(
                        typeotp.findElement(By.className(locatorsMap.get("enter_otp").get("locator").textValue()))))
                .sendKeys("2345");
        WebElement verifyotp = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("verify_otp").get("locator").textValue()))));
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
                verifyotp.findElement(By.className(locatorsMap.get("submit_otp").get("locator").textValue()))));
        exe.executeScript("arguments[0].click();", submit);
    }
    public void login(Map<String, String> testData, String data, WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className(locatorsMap.get("type_otp").get("locator").textValue())));
        WebElement typeotp = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("type_otp").get("locator").textValue()))));
        wait.until(ExpectedConditions.elementToBeClickable(
                        typeotp.findElement(By.className(locatorsMap.get("enter_otp").get("locator").textValue()))))
                .sendKeys("2345");
        WebElement verifyotp = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("verify_otp").get("locator").textValue()))));
        wait.until(ExpectedConditions.elementToBeClickable(
                verifyotp.findElement(By.className(locatorsMap.get("submit_otp").get("locator").textValue())))).click();
    }


}
