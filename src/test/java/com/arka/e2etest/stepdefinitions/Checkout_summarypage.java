package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.LocatorsMap;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static com.arka.e2etest.runner.CucumberRunner.testdata;

public class Checkout_summarypage extends BaseFunctions{
    private static int MAX_TIMEOUT = 100;
    private static int MAXX_TIMEOUT = 160;
    private static int MIN_TIMEOUT = 100;
    JsonNode locatorsMap = LocatorsMap.getlocators();
    @Given("^User is landed on the Checkout Summary page$")
    public void user_is_landed_on_the_Checkout_Summary_page() throws Throwable {
        //checkoutSummaryPage = new Checkout_summaryPage(BaseFunctions.driver);
        //Assert.assertTrue(BaseFunctions.elementIsDisplayed(checkoutSummaryPage.getLearning_center()));
        test = BaseFunctions.extent.createTest("Checkout page").info("User is landed on the  checkout summary page successfully");
  }
    @When("^User is change the premium year$")
    public void user_is_change_the_premium_year() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (testData.get("premiumYear").equalsIgnoreCase("1")) {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            System.out.println("select premium 1 Year");
            getSafeElement();
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement healthpaymentblock = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("healthpaymentblock").get("locator").textValue())));
            WebElement yearblock1=wait.until(ExpectedConditions
                    .elementToBeClickable(healthpaymentblock.findElement(By.className(locatorsMap.get("yearblock1").get("locator").textValue()))));
            WebElement oneYear = wait.until(ExpectedConditions
                    .elementToBeClickable(yearblock1.findElement(By.className(locatorsMap.get("oneYear").get("locator").textValue()))));
            if(!oneYear.isSelected())
            {
                exe.executeScript("arguments[0].click();", oneYear);

            }else {
                System.out.println("its already selected");
            }
        }if (testData.get("premiumYear").equalsIgnoreCase("2")) {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            System.out.println("select premium 2 Year");
            getSafeElement();
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement healthpaymentblock = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("healthpaymentblock").get("locator").textValue())));
            WebElement yearblock2=wait.until(ExpectedConditions
                    .elementToBeClickable(healthpaymentblock.findElement(By.xpath(locatorsMap.get("yearblock2").get("locator").textValue()))));
            WebElement twoYear = wait.until(ExpectedConditions
                    .elementToBeClickable(yearblock2.findElement(By.className(locatorsMap.get("twoYear").get("locator").textValue()))));
            if(!twoYear.isSelected())
            {
                exe.executeScript("arguments[0].click();", twoYear);

            }else {
                System.out.println("its already selected");
            }
        }if (testData.get("premiumYear").equalsIgnoreCase("3")) {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            System.out.println("select premium 3 Year");
            getSafeElement();
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement healthpaymentblock = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("healthpaymentblock").get("locator").textValue())));
            WebElement yearblock3=wait.until(ExpectedConditions
                    .elementToBeClickable(healthpaymentblock.findElement(By.className(locatorsMap.get("yearblock3").get("locator").textValue()))));
            WebElement threeYear = wait.until(ExpectedConditions
                    .elementToBeClickable(yearblock3.findElement(By.className(locatorsMap.get("threeYear").get("locator").textValue()))));
            if(!threeYear.isSelected())
            {
                System.out.println("LLLL");
                exe.executeScript("arguments[0].click();", threeYear);

            }else {
                System.out.println("its already selected");
            }
        }
    }
    @When("^User clicks on the terms and condition checkbox$")
    public void user_clicks_on_the_terms_and_condition_checkbox() throws Throwable {


        System.out.println("accept Checkoutsummary");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        if (wait.until(ExpectedConditions.urlContains("checkout-summary"))
                && wait.until(ExpectedConditions.titleContains("Checkout Summary"))) {
            //System.out.println(testData.get("testCaseId"));
            System.out.println(driver.getCurrentUrl());
            WebElement accept = wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(By.className(locatorsMap.get("accept").get("locator").textValue()))));
            wait.until(ExpectedConditions.elementToBeClickable(accept.findElement(By.tagName("label"))));
            accept.click();
        }
        test.info("clicks on the terms and condition checkbox");
    }

    @When("^User clicks on the pay button$")
    public void user_clicks_on_the_pay_button() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("Ready to Pay");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        Actions action = new Actions(driver);
        List<WebElement> viewmores = driver
                .findElements(By.className((locatorsMap.get("readytoPay").get("locator").textValue())));
        for (WebElement button : viewmores) {
            if (button.findElement(By.tagName("button")).getText().equals("PAY") || button.findElement(By.tagName("button")).getText().equals("Proceed to KYC Verification")) {
                //if (button.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section/div/div[1]/section[2]/div[2]/div/div/button")).getText().equals("PAY")) {
                System.out.println(button.getText());
                action.clickAndHold(button).build().perform();
                action.click();
                button.click();
            }
        }

        test.info("user clicks on the pay button");
    }
    @Then("^User is redirected to the vendor site$")
    public void user_is_redirected_to_the_vendor_site() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("Check vendor verification url");
        WebDriverWait wait = new WebDriverWait(driver, 80);
        String checkoutsummaryUrl1;
        checkoutsummaryUrl1=driver.getCurrentUrl();
        JavascriptExecutor jxe = (JavascriptExecutor) driver;
        String vendor=testData.get("buyPlanProd");
       /* if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"proceed-button\"]")))).isDisplayed()) {
            WebElement Securemsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("sendanyway").get("locator").textValue())));
            jxe.executeScript("arguments[0].click();", Securemsg);
        }else {
            takesScreenShot(driver,testData);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            WebElement errorInfo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                    By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
            String info = errorInfo.getAttribute("visibility");
            if (!info.equalsIgnoreCase("hidden")) {
                String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl1 + ":::" + errorMessage);
            }}*/
        switch (vendor) {
            case "ITGI_CAR_1":
            case "ITGI_BIKE_1":
                String actualUrl = null;
                String vendorurl = null;
                String checkoutsummaryUrl;
                checkoutsummaryUrl = driver.getCurrentUrl();
                vendorurl = testData.get("vendorUrl");
                try {
                    wait.until(ExpectedConditions.urlContains(vendorurl));
                    if(testData.get("testPaymentFlow").equalsIgnoreCase("TRUE")) {
                        actualUrl = driver.getCurrentUrl();
                        String expectedUrl = testData.get("vendorUrl");
                        if (actualUrl.contains(expectedUrl)) {
                            WebElement gateWay = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath(locatorsMap.get("iffcopayment").get("locator").textValue())));
                            jxe.executeScript("arguments[0].click();", gateWay);
                            WebElement submitPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.id(locatorsMap.get("iffopaymentconfirm").get("locator").textValue())));
                            jxe.executeScript("arguments[0].click();", submitPayment);
                            WebElement confirmsubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.id(locatorsMap.get("iffopaymentsubmit").get("locator").textValue())));
                            jxe.executeScript("arguments[0].click();", confirmsubmit);
                            if (wait.until(ExpectedConditions.urlContains("https://uat.imright.com/insurance/"))) {
                                if (checkoutsummaryUrl.contains("uat")) {
                                    String uaturl = driver.getCurrentUrl();
                                    String stageusername = "imright";
                                    String stagepassword = "imright$987";
                                    String uatboxurl = uaturl.replace("uat.imright.com", "uat.monkeycap.com");
                                    System.out.println("uatboxurl" + uatboxurl);
                                    testData.put("url", uatboxurl);
                                    driver.get(uatboxurl);
                                    break;
                                } else if (checkoutsummaryUrl.contains("stage")) {
                                    String stageurl = driver.getCurrentUrl();
                                    String stageusername = "imright";
                                    String stagepassword = "imright$987";
                                    String stageboxurl = stageurl.replace("uat.imright.com", "stage.monkeycap.com");
                                    System.out.println("stageboxurl" + stageboxurl);
                                    testData.put("url", stageboxurl);
                                    driver.get(stageboxurl);
                                    break;
                                } else if (checkoutsummaryUrl.contains("sandbox")) {
                                    String sandboxurl = driver.getCurrentUrl();
                                    String stageusername = "imright";
                                    String stagepassword = "imright$987";
                                    String sandboxboxurl = sandboxurl.replace("uat.imright.com", "sandbox.arkainsure.com");
                                    System.out.println("sandboxboxurl" + sandboxboxurl);
                                    testData.put("url", sandboxboxurl);
                                    driver.get(sandboxboxurl);
                                    break;
                                } else {
                                    System.out.println("Inside of payment having issue");
                                }
                            } else {
                                System.out.println("vendor having issue");
                            }
                        }
                        takesScreenShot(driver,testData);
                        WebElement errorInfo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                                By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                        String info = errorInfo.getAttribute("visibility");
                        if (!info.equalsIgnoreCase("hidden")) {
                            String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                            org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                        }
                    }
                    else {
                        System.out.println("Before completed the payment gateway");
                    }
                }
                catch(TimeoutException t) {
                    t.printStackTrace();
                    takesScreenShot(driver,testData);
                    WebElement errorInfo = wait.until(ExpectedConditions.visibilityOf(driver
                            .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                    String info = errorInfo.getAttribute("visibility");
                    if (!info.equalsIgnoreCase("hidden")) {
                        String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                        org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                        driver.quit();
                    }
                }
                break;
            case "zA2rB7i0xLRl3tIKd5WUwe9SYTh7yPHgJasqmSvnYgY":

                System.out.println("star");
                getSafeElement();
                getSafeElement();
                checkoutsummaryUrl = driver.getCurrentUrl();
                vendorurl = testData.get("vendorURL");
                try {
                    wait.until(ExpectedConditions.urlContains(("vendorurl")));
                    if(testData.get("testPaymentFlow").equalsIgnoreCase("TRUE")) {
                        actualUrl = driver.getCurrentUrl();
                        System.out.println("inside loop");
                        String expectedUrl = testData.get("vendorURL");
                        if (actualUrl.contains(expectedUrl)) {
                            WebElement temp = wait.until(ExpectedConditions
                                    .elementToBeClickable(driver.findElement(By.xpath("//input[contains(@name,'Button1')]"))));
                            jxe.executeScript("arguments[0].click();", temp);

                        }else {
                            getSafeElement();
                            takesScreenShot(driver, testData);
                            System.out.println("summaryerrorinfo Page"+checkoutsummaryUrl);
                            WebElement errorInfo = wait.until(ExpectedConditions.elementToBeClickable(driver
                                    .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                            String info = errorInfo.getAttribute("visibility");
                            if (!info.equalsIgnoreCase("hidden")) {
                                String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                                org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                                driver.quit();
                            }

                        }
                    }else {
                        System.out.println("Before completed the payment gateway");
                    }
                }
                catch(TimeoutException t)
                {
                    takesScreenShot(driver,testData);
                    WebElement errorInfo = wait.until(ExpectedConditions.elementToBeClickable(driver
                            .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                    String info = errorInfo.getAttribute("visibility");
                    if (!info.equalsIgnoreCase("hidden")) {
                        String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                        org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                        driver.quit();
                    }
                    else if(wait.until(ExpectedConditions.urlContains("checkout-progress")))
                    {
                        takesScreenShot(driver,testData);
                        WebElement inspectionblock=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("inspectionblock").get("locator").textValue()))));
                        WebElement inspectionstatus=wait.until(ExpectedConditions.visibilityOf(inspectionblock.findElement(By.className(locatorsMap.get("inspectionstatus").get("locator").textValue()))));
                        org.testng.Assert.assertEquals(inspectionstatus.getText(), "Inspection has been initiated for your vehicle");
                        driver.quit();
                    }
                    else {
                        getSafeElement();

                    }
                }
                break;
            case "HDFCERGO_CAR_1":
            case "HDFCERGO_BIKE_1":
            case "k3BBqBvhblKB6cmFweCII3s6wZ-oq8ycQx0jcT7KL1Q":
            case "Q48q1Qxs6dDxZClqYkjSCyPMjf_WFeE2NGJXJhwrees":
            case "OW7bTa4WLt9ySWtkrOUaxlinZp9T8hwoL-mQ0_1Jeug":
            case "hJaGNYnE-A0BjRuYROf_79Gk4AA7J-HHGXCjIXpvzzA":
            case "6bU-4Nbb-E2ycVplGwH-b_ZrBjTPyi1XzvtK40y-O-o":

                System.out.println("features/car/hdfc");
                getSafeElement();
                getSafeElement();
                checkoutsummaryUrl = driver.getCurrentUrl();
                vendorurl = testData.get("vendorUrl");
                try {
                    wait.until(ExpectedConditions.urlContains((vendorurl)));
                    if(testData.get("testPaymentFlow").equalsIgnoreCase("TRUE")) {
                        actualUrl = driver.getCurrentUrl();
                        System.out.println("inside loop");
                        String expectedUrl = testData.get("vendorUrl");
                        if (actualUrl.contains(expectedUrl)) {
                            WebElement temp = wait.until(ExpectedConditions
                                    .elementToBeClickable(driver.findElement(By.xpath("//input[contains(@name,'Button1')]"))));
                            jxe.executeScript("arguments[0].click();", temp);
                            WebElement hdfcCardno = wait.until(ExpectedConditions.visibilityOf(
                                    driver.findElement(By.id(locatorsMap.get("hdfcCardno").get("locator").textValue()))));
                            hdfcCardno.sendKeys("12345");
                            WebElement hdfcPinno = wait.until(ExpectedConditions.visibilityOf(
                                    driver.findElement(By.id(locatorsMap.get("hdfcPinno").get("locator").textValue()))));
                            hdfcPinno.sendKeys("123");
                            WebElement temp1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name,'Button1')]"))));
                            jxe.executeScript("arguments[0].click();", temp1);
                            System.out.println("hdfc payment");
                            if (!testData.get("policytype").equalsIgnoreCase("liability")&&wait.until(ExpectedConditions.urlContains("uat.imright.com"))) {
                                System.out.println("inside of redirect page");
                                System.out.println("checkoutsummaryUrl"+checkoutsummaryUrl);
                                if (checkoutsummaryUrl.contains("stage")) {
                                    String uaturl = driver.getCurrentUrl();
                                    String stageusername = "imright";
                                    String stagepassword = "imright$987";
                                    String stageboxurl = uaturl.replace("uat.imright.com", "stage.monkeycap.com")
                                            .replace("http", "https");
                                    testData.put("url", stageboxurl);
                                    driver.get(stageboxurl);
                                } else if (checkoutsummaryUrl.contains("sandbox")) {
                                    String uaturl = driver.getCurrentUrl();
                                    String sandboxuname = "imright";
                                    String sandboxpwd = "imright$999";
                                    String sandboxboxurl = uaturl.replace("uat.imright.com", "sandbox.arkainsure.com")
                                            .replace("http", "https");
                                    testData.put("url", sandboxboxurl);
                                    driver.get(sandboxboxurl);
                                } else if (checkoutsummaryUrl.contains("uat")) {
                                    System.out.println("Second Summit button clicked");
                                    String uaturl = driver.getCurrentUrl();
                                    String uatuserName = "imright";
                                    String uatpassword = "imright$987";
                                    String uatboxurl = uaturl.replace("uat.imright.com", "uat.monkeycap.com").replace("http",
                                            "https");
                                    testData.put("url", uatboxurl);
                                    driver.get(uatboxurl);
                                }else if (checkoutsummaryUrl.contains("monkeycap")) {
                                    String uaturl = driver.getCurrentUrl();
                                    String uatuserName = "monkeycap";
                                    String uatpassword = "monkeycap@999";
                                    String uatboxurl = uaturl.replace("uat.imright.com", "qa.monkeycap.com").replace("http",
                                            "https");
                                    testData.put("url", uatboxurl);
                                    driver.get(uatboxurl);
                                }
                                else {
                                    //	System.out.println("1.Redirecting page having issue");
                                    String uaturl = driver.getCurrentUrl();
                                    String uatuserName = "monkeycap";
                                    String uatpassword = "monkeycap@999";
                                    String uatboxurl = uaturl.replace("uat.imright.com", "qa.monkeycap.com").replace("http",
                                            "https");
                                    testData.put("url", uatboxurl);
                                    driver.get(uatboxurl);
                                }
                                break;
                            }
                            else if(wait.until(ExpectedConditions.urlContains("uat1.symboinsurance.com"))){
                                if (checkoutsummaryUrl.contains("sandbox")) {
                                    String sandboxurl = driver.getCurrentUrl();
                                    String appendsandboxurl = sandboxurl.replace("uat1.symboinsurance.com/product/travel/payment", "sandbox.arkainsure.com/insurance/policy/processed");
                                    System.out.println("uaturl" + appendsandboxurl);
                                    testData.put("url", appendsandboxurl);
                                    driver.get(appendsandboxurl);
                                }else if (checkoutsummaryUrl.contains("uat")) {
                                    String uaturl = driver.getCurrentUrl();
                                    String uatboxurl = uaturl.replace("uat1.symboinsurance.com/product/travel/payment", "uat.monkeycap.com/insurance/policy/processed");
                                    System.out.println("uatboxurl" + uatboxurl);
                                    testData.put("url", uatboxurl);
                                    driver.get(uatboxurl);
                                }else if (checkoutsummaryUrl.contains("stage")) {
                                    String stageurl = driver.getCurrentUrl();
                                    String stageboxurl = stageurl.replace("uat1.symboinsurance.com/product/travel/payment", "stage.monkeycap.com/insurance/policy/processed");
                                    System.out.println("stageboxurl" + stageboxurl);
                                    testData.put("url", stageboxurl);
                                    driver.get(stageboxurl);
                                } else {
                                    System.out.println("2.Redirecting page having issue");
                                }
                            }

                        }else {
                            getSafeElement();
                            takesScreenShot(driver, testData);
                            System.out.println("summaryerrorinfo Page"+checkoutsummaryUrl);
                            WebElement errorInfo = wait.until(ExpectedConditions.elementToBeClickable(driver
                                    .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                            String info = errorInfo.getAttribute("visibility");
                            if (!info.equalsIgnoreCase("hidden")) {
                                String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                                org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                                driver.quit();
                            }

                        }
                    }else {
                        System.out.println("Before completed the payment gateway");
                    }
                }
                catch(TimeoutException t)
                {
                    takesScreenShot(driver,testData);
                    WebElement errorInfo = wait.until(ExpectedConditions.elementToBeClickable(driver
                            .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                    String info = errorInfo.getAttribute("visibility");
                    if (!info.equalsIgnoreCase("hidden")) {
                        String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                        org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                        driver.quit();
                    }
                    else if(wait.until(ExpectedConditions.urlContains("checkout-progress")))
                    {
                        takesScreenShot(driver,testData);
                        WebElement inspectionblock=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("inspectionblock").get("locator").textValue()))));
                        WebElement inspectionstatus=wait.until(ExpectedConditions.visibilityOf(inspectionblock.findElement(By.className(locatorsMap.get("inspectionstatus").get("locator").textValue()))));
                        org.testng.Assert.assertEquals(inspectionstatus.getText(), "Inspection has been initiated for your vehicle");
                        driver.quit();
                    }
                    else {
                        getSafeElement();

                    }
                }
                break;
            default:
                getSafeElement();
                vendorurl = testData.get("vendorURL");
                checkoutsummaryUrl = driver.getCurrentUrl();
                if(testData.get("buyPlanProd").contains("BAGIC")){
                    try {
                        wait.until(ExpectedConditions.urlContains(vendorurl));
                        actualUrl = driver.getCurrentUrl();
                        String expectedUrl = testData.get("vendorURL");
                        if (actualUrl.contains(expectedUrl)) {
                            System.out.println("Before completed the payment gateway");
                            driver.quit();
                            break;
                        } else {
                            takesScreenShot(driver,testData);
                            WebElement errorInfo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                                    By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                            String info = errorInfo.getAttribute("visibility");
                            if (!info.equalsIgnoreCase("hidden")) {
                                String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                                org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                                driver.quit();
                            }
                        }
                    }
                    catch(TimeoutException t)
                    {
                        //	t.printStackTrace();
                        takesScreenShot(driver,testData);
                        WebElement errorInfo = wait.until(ExpectedConditions.visibilityOf(driver
                                .findElement(By.className(locatorsMap.get("summaryerrorinfo").get("locator").textValue()))));
                        String info = errorInfo.getAttribute("visibility");
                        if (!info.equalsIgnoreCase("hidden")) {
                            String errorMessage = errorInfo.findElement(By.tagName("span")).getText();
                            org.testng.Assert.fail("vendor url is having issue::=" + checkoutsummaryUrl + ":::" + errorMessage);
                            driver.quit();
                        }
                    }
                    break;

                }
                System.out.println("Bajaj Before payment is done");
        }
        driver.quit();
    }
    private void takesScreenShot(WebDriver driver, Map<String, String> testData) {

        try {
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File source = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+testData.get("testNo")+"_"+testData.get("category")+"_"+generateTimeStamp()+".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String generateTimeStamp() {
        String timeStamp = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        return timeStamp;
    }

    //Common methods
    public void getSafeElement() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void getSafeElementmin() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


