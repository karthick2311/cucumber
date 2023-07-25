package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.LocatorsMap;
import com.arka.e2etest.utils.PropertiesFileReader;
import com.arka.e2etest.utils.TestDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.arka.e2etest.runner.CucumberRunner.testdata;


public class Checkoutpage extends BaseFunctions {

    private static int MAX_TIMEOUT = 100;
    private static int MAXX_TIMEOUT = 160;
    private static int MIN_TIMEOUT = 100;
    JsonNode locatorsMap = LocatorsMap.getlocators();
    @Given("^User is landed on the checkout page$")
    public void user_is_landed_on_the_checkout_page() throws Throwable {
//        checkoutPage = new CheckoutPage(BaseFunctions.driver);
//        Assert.assertTrue(BaseFunctions.elementIsDisplayed(checkoutPage.getMail()));
        test = BaseFunctions.extent.createTest("Checkout page").info("User is landed on the  checkout page successfully");
    }
    @Then("^User verify the quotes page and checkout page premium amount$")
    public void user_verify_the_quotes_page_and_checkout_page_premium_amount() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("healthCheckout Verification");
        System.out.println("the checkout"+testData);
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement payableamountblock = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("payableAmount").get("locator").textValue())));
        WebElement amountEle = wait.until(ExpectedConditions
                .elementToBeClickable(payableamountblock.findElement(By.className(locatorsMap.get("payableAmountlabel").get("locator").textValue()))));
        String amountText =amountEle.getText();
        String checkouttotalPremium=amountText.replaceAll("[^0-9]", "");
        int quotespremium=Integer.parseInt(testData.get("healthquotesPremium"));
        int cheoutpremium=Integer.parseInt(checkouttotalPremium);
        int diff=cheoutpremium-quotespremium;
        //System.out.println("The diff is "+diff);
        if(diff>5)
        {
            System.out.println("please check premium difference is" +diff+" Rupee!");
            System.out.println("checkoutUrl:" +driver.getCurrentUrl());
            org.testng.Assert.assertEquals("From quotes Premium "+quotespremium, "From checkout Premium "+cheoutpremium,driver.getCurrentUrl());
        }
        else if(diff<=-5)
        {
            System.out.println("please check premium difference is minus" +diff+" Rupee!");
            System.out.println("checkoutUrl:" +driver.getCurrentUrl());
            org.testng.Assert.assertEquals("From quotes Premium "+quotespremium, "From checkout Premium "+cheoutpremium,driver.getCurrentUrl());

        }
        else
        {
            System.out.println("No difference " +diff+" Rupee!");
        }
    }


    @When("^User enter the address line one \"([^\"]*)\" and address line two \"([^\"]*)\"$")
    public void user_enter_the_address_line_one_and_address_line_two(String addresslineone, String addresslinetwo) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("healthContactAddressforstar");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        if(wait.until(ExpectedConditions.urlContains("checkout"))){
           // if (!StringUtils.isNoneEmpty(testData.get("Address1"))
             //       && !StringUtils.isNoneEmpty(testData.get("Address2"))) {

                System.out.println("Fill the Address1 & Address2 details");
                WebElement address1=wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className(locatorsMap.get("communicationaddress1").get("locator").textValue())));
                address1.clear();
                address1.sendKeys(testData.get("Address1"));
                WebElement address2=wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className(locatorsMap.get("communicationaddress2").get("locator").textValue())));
                address2.clear();
               // System.out.println("this is address line two value"+testData.get("Address2"));
                address2.sendKeys(testData.get("Address2"));

            }
        //}
        else {
            System.out.println("Please check url not nagivated to checkoutPage");
        }
        test.info("user enter the address line one and address line two");
    }
    @When("^User select the city name as \"([^\"]*)\"$")
    public void user_select_the_city_name_as(String cityName) throws Throwable {
        // checkoutPage.user_select_the_city(cityName);
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement city=wait.until(ExpectedConditions.elementToBeClickable(
                By.id(locatorsMap.get("aicityid").get("locator").textValue())));
        city.click();
        WebElement citynames = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("citynames").get("locator").textValue())));
        WebElement ulElement = citynames.findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String cityname = allele.getText();
            if (cityname.equalsIgnoreCase(testData.get("startcity"))) {
                allele.click();
                break;
            }
        }
        test.info("user select the city name");
    }

    @When("^User select the area name as \"([^\"]*)\"$")
    public void user_select_the_area_name_as(String areaName) throws Throwable {
        //checkoutPage.user_select_the_area(areaName);
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement Area=wait.until(ExpectedConditions.elementToBeClickable(
                By.id(locatorsMap.get("aiareaid").get("locator").textValue())));
        Area.click();
        WebElement Areanames = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("citynames").get("locator").textValue())));
        WebElement ulElement1 = Areanames.findElement(By.tagName("ul"));
        List<WebElement> liElements1 = ulElement1.findElements(By.tagName("li"));
        for (WebElement allele1 : liElements1) {
            String Areaname = allele1.getText();
            if (Areaname.equalsIgnoreCase(testData.get("startarea"))) {
                allele1.click();
                break;
            }
        }
        test.info("user select the area name");
    }

    @When("^User enters the email id as \"([^\"]*)\"$")
    public void user_enters_the_email_id_as(String mailId) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
       // checkoutPage.user_enter_the_mail_id(mailId);
        if (StringUtils.isNoneEmpty(testData.get("Email"))) {
            System.out.println("health email");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement contactinfoemail=
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("contactinfoemail").get("locator").textValue()))));
            if(contactinfoemail.isEnabled())
            {
                System.out.println("Element is clickable");
                contactinfoemail.clear();
                getSafeElementmin();
                contactinfoemail.sendKeys(testData.get("Email"));
            }
            else
            {
                System.out.println("Element is not clickable");
            }
            //contactinfoemail.clear();
            //	contactinfoemail.sendKeys(testData.get("email"));
        }
        test.info("user enters the email id");
    }

    @When("^User enters the mobile number as \"([^\"]*)\"$")
    public void user_enters_the_mobile_number_as(String mobileNumber) throws Throwable {
       // checkoutPage.user_enter_the_mobile_number(mobileNumber);
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNoneEmpty(testData.get("Mobile"))) {
            System.out.println("healthContactMobile");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement contactinfoMobile=
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("contactmobile").get("locator").textValue()))));
            if(contactinfoMobile.isEnabled())
            {
                System.out.println("Element is clickable");
                contactinfoMobile.clear();
                contactinfoMobile.sendKeys(testData.get("Mobile"));
            }
            else
            {
                System.out.println("Element is not clickable");
            }
            //	contactinfoMobile.clear();
            //	contactinfoMobile.sendKeys(testData.get("mobileNumber"));
        }
        test.info("user enters the mobile number");

    }
    @When("^User select the ID proof \"([^\"]*)\"$")
    public void user_select_the_ID_proof(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        // if (isNullOrEmpty(testData.get("sumInsured"))) {
        System.out.println("select the sumInsured");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        //WebElement policydropDown = wait.until(ExpectedConditions
          //      .elementToBeClickable(By.xpath(locatorsMap.get("aiidprooffield").get("locator").textValue())));
        WebElement policydropDown= driver.findElement(By.xpath("//*[@id=\"aiidproof\"]"));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", policydropDown);
        //yourElement.click();
       // executor.executeScript("arguments[0].click();", policydropDown);
        policydropDown.click();
        WebElement insurertypes= driver.findElement(By.className("MuiPopover-paper"));

       // WebElement insurertypes = wait.until(ExpectedConditions
         //       .elementToBeClickable(By.className(locatorsMap.get("idproofnames").get("locator").textValue())));
        WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String insurertype = allele.getText();
            if (insurertype.equalsIgnoreCase(testData.get("idprooftype"))) {
                allele.click();
                break;
            }
        }
    }
    @When("^User uploads the Identity proof$")
    public void user_uploads_the_Identity_proof() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("verifykyctext").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("✓ KYC Verified.")) {
            //if(KYCVerified.isDisplayed()){
            System.out.println("KYC is verified");
        }else {
            driver.findElement(By.xpath("(//input[@class='Input-sc-1gdxpyt-0 StdUploadButton__StyledInput-sc-1yz1l3p-0 hJuBCm'])[1]")).sendKeys("./src/test/resources/testdata/sample-form16.pdf");
        }
    }
    @When("^User upload the address proof$")
    public void user_upload_the_address_proof() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("verifykyctext").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("✓ KYC Verified.")) {
            //if(KYCVerified.isDisplayed()){
            System.out.println("KYC is verified");
        }else {
            driver.findElement(By.xpath("(//input[@class='Input-sc-1gdxpyt-0 StdUploadButton__StyledInput-sc-1yz1l3p-0 hJuBCm'])[2]")).sendKeys("./src/test/resources/testdata/sample-form16.pdf");
            test.info("user uploads the identity proof");        }
    }
    @When("^User upload the star address proof$")
    public void user_upload_the_star_address_proof() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("verifykyctext").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("✓ KYC Verified.")) {
            //if(KYCVerified.isDisplayed()){
            System.out.println("KYC is verified");
        }else {
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[1]/section[1]/form/div/div[8]/div/div/div[1]/div/div/input")).sendKeys("/Users/karthick/git-projects/latest1/e2etest/src/test/resources/testdata/sample-form16.pdf");
            test.info("user uploads the identity proof");
        }
    }
    @When("^User upload the proposer recent photo proof$")
    public void user_upload_the_proposer_recent_photo_proof() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("verifykyctext").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("✓ KYC Verified.")) {
            //if(KYCVerified.isDisplayed()){
            System.out.println("KYC is verified");
        }else {
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[1]/section[1]/form/div/div[8]/div/div/div[2]/div/div/input")).sendKeys("/Users/karthick/git-projects/latest1/e2etest/src/test/resources/testdata/sample-form16.pdf");
            test.info("user uploads the identity proof");
        }

    }

    @When("^User upload the proposer form (\\d+)$")
    public void user_upload_the_proposer_form(int arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("verifykyctext").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("✓ KYC Verified.")) {
            //if(KYCVerified.isDisplayed()){
            System.out.println("KYC is verified");
        }else {
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[1]/section[1]/form/div/div[8]/div/div/div[3]/div/div/input")).sendKeys("/Users/karthick/git-projects/latest1/e2etest/src/test/resources/testdata/sample-form16.pdf");
            test.info("user uploads the identity proof");
        }
    }
    @When("^User enter the ID proof number \"([^\"]*)\"$")
    public void user_enter_the_ID_proof_number(String arg1) throws Throwable {
       Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        if(wait.until(ExpectedConditions.urlContains("checkout"))){
                //System.out.println("Fill the Address1 & Address2 details");
//                WebElement address1=wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.id(locatorsMap.get("aiidproofnumber").get("locator").textValue())));
            WebElement address= driver.findElement(By.id("aiidproofnumber-label"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", address);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("aiidproofnumber-label"))));
            // address.clear();
            WebElement address1 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"aiidproofnumber\"]")));
            address1.sendKeys(testData.get("idproofnumber"));
        }
    }
    @When("^User clicks the next button in contact tab$")
    public void user_clicks_the_next_button_in_contact_tab() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement veiwMore = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue()))));
        WebElement proceedtoPersonal = wait.until(ExpectedConditions.elementToBeClickable(
                veiwMore.findElement(By.id(locatorsMap.get("proceedtoPersonal").get("locator").textValue()))));
        exe.executeScript("arguments[0].click();", proceedtoPersonal);
        test.info("user clicks the next button in contact tab");

    }



    @When("^User verify the otp as \"([^\"]*)\"$")
    public void user_enters_the_mobile_number_and_otp_as(String arg1) throws Throwable {
        System.out.println("Login with mobile/email ");
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
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


    @Then("^User is loggedin successffully$")
    public void user_is_loggedin_successffully() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement contactinfoemail=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("contactinfoemail").get("locator").textValue()))));
        if(contactinfoemail.isEnabled())
        {
            //System.out.println("user is not loggedin");
            org.testng.Assert.fail("euser is not loggedin");
            contactinfoemail.sendKeys(testData.get("email"));
        }
        else
        {
            System.out.println("user is loggein");
            WebElement contactnextbutton=
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue()))));
            contactnextbutton.click();
        }
    }

    @Then("^User is navigated to the proposer tab$")
    public void user_is_navigated_to_the_proposer_tab() throws Throwable {
        System.out.println("user is navigated to the proposer tab");
        test.info("user is navigated to the proposer tab");
    }

    @When("^User enters the self firstname as \"([^\"]*)\"$")
    public void user_enters_the_self_firstname_as(String firstName) throws Throwable {

        if (StringUtils.isNoneEmpty(firstName)) {
            System.out.println("healthProposerFirstName");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);

            WebElement proposerFirstName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("healthcontactfirstname").get("locator").textValue()))));
            proposerFirstName.sendKeys(firstName);
        }        test.info("user enters the firstname");
    }

    @When("^User enters the self lastname as \"([^\"]*)\"$")
    public void user_enters_the_self_lastname_as(String lastName) throws Throwable {

        if (StringUtils.isNoneEmpty(lastName)) {
            System.out.println("healthProposerLastName");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);

            WebElement proposerLastName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("healthcontactlastname").get("locator").textValue()))));
            proposerLastName.sendKeys(lastName);
        }
        test.info("user enters the lastname");

    }

    @When("^User select the proposer gender as \"([^\"]*)\"$")
    public void user_select_the_proposer_gender_as(String arg1) throws Throwable {
        System.out.println("select selectpropserSelfGender");
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement gender = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("choosePospGender").get("locator").textValue())));
        if (arg1.equalsIgnoreCase("male")) {
            WebElement male = wait.until(ExpectedConditions.elementToBeClickable(gender
                    .findElement(By.className(locatorsMap.get("propserMale").get("locator").textValue()))));
            WebElement ele = male.findElement(By.tagName("input"));
            exe.executeScript("arguments[0].click();", ele);
            exe.executeScript("arguments[0].click();", male);
        } else {
            WebElement female = wait.until(ExpectedConditions.elementToBeClickable(gender
                    .findElement(By.className(locatorsMap.get("propserFemale").get("locator").textValue()))));
            female.findElement(By.tagName("input")).click();
            exe.executeScript("arguments[0].click();", female);
        }
        test.info("user select the proposer gender");

    }
    @When("^User select the marital status as \"([^\"]*)\"$")
    public void user_select_the_marital_status_as(String arg1) throws Throwable {

        System.out.println("select Married Status");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement personaltab = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("personaltab").get("locator").textValue()))));
        if (personaltab.isEnabled()) {
            WebElement Marriedstatusyes = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.className(locatorsMap.get("personalmarriedyes").get("locator").textValue())));
            WebElement Marriedstatusyes1 = wait.until(
                    ExpectedConditions.elementToBeClickable(Marriedstatusyes.findElement(By.tagName("label")).findElement(By.tagName("span"))));
            executor.executeScript("arguments[0].click();", Marriedstatusyes1);
        } else {
            throw new RuntimeException("personal tab not apperead");
        }
        test.info("user select the marital status");

    }
    @When("^User enters the proposer dob as \"([^\"]*)\"$")
    public void user_enters_the_proposer_dob_as(String arg1) throws Throwable {
        System.out.println("select selfDOB");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("healthSelfDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the proposer dob");

    }

    @When("^User enters the annual income as \"([^\"]*)\"$")
    public void user_enters_the_annual_income_as(String annualIncome) throws Throwable {

        if (StringUtils.isNoneEmpty(annualIncome)) {
            System.out.println("healthProposerAnnualIncome");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
//			wait.until(ExpectedConditions.elementToBeClickable(
//					driver.findElement(By.xpath(locatorsMap.get("healthcontactAnnualIncome").get("locator").textValue())))).click();
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(By.xpath(locatorsMap.get("healthcontactAnnualIncome").get("locator").textValue()))));
            if (wait.until(ExpectedConditions.elementToBeClickable(ele)).isEnabled()) {
                ele.sendKeys(annualIncome);
            }
            //	WebElement annual=
            //	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("healthcontactAnnualIncome").get("locator").textValue()))));
            //annual.sendKeys(testData.get("Annualincome"));

        }
        test.info("user enters the annual income");

    }

    @When("^User enters the aadhaar number as \"([^\"]*)\"$")
    public void user_enters_the_aadhaar_number_as(String aatharNumber) throws Throwable {

        if (StringUtils.isNotEmpty(aatharNumber)) {
            System.out.println("Fill PANNumber");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement panloc = wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(By.id(locatorsMap.get("selfAadhar").get("locator").textValue()))));
            panloc.clear();
            panloc.sendKeys(aatharNumber);
        }
        test.info("user enters the aadhaar number");

    }

    @When("^User enters the pan card number as \"([^\"]*)\"$")
    public void user_enters_the_pan_card_number_as(String panNumber) throws Throwable {
       // checkoutPage.user_enter_the_pan_number(panNumber);
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNotEmpty(panNumber)) {
            System.out.println("this is as pan num"+testData.get("PanCard"));
            System.out.println("Select selectOccuption"+testData.get("Occupation"));
            System.out.println("Fill PANNumber");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement panloc = wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(By.xpath(locatorsMap.get("persoanlpanno").get("locator").textValue()))));
            panloc.clear();
            getSafeElementmin();
            panloc.sendKeys(testData.get("PanCard"));

        }
        test.info("user enters the pan card number");
    }

   @When("^User select the self occupation as \"([^\"]*)\"$")
   public void user_select_the_self_occupation_as(String arg1) throws Throwable {
       Map<String, String> testData = testdata.getTestDataInMap();
       JavascriptExecutor executor = (JavascriptExecutor) driver;
       // if (isNullOrEmpty(testData.get("sumInsured"))) {
       System.out.println("select the sumInsured");
       WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
       JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,500)");
       wait.until(ExpectedConditions.visibilityOfElementLocated(
               By.className(locatorsMap.get("selfaiproposeroccupation").get("locator").textValue())));
       WebElement policydropDown = wait.until(ExpectedConditions
               .elementToBeClickable(By.className(locatorsMap.get("selfaiproposeroccupation").get("locator").textValue())));
       //WebElement policydropDown= driver.findElement(By.xpath("//*[@id=\"aiidproof\"]"));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", policydropDown);
       //yourElement.click();
       executor.executeScript("arguments[0].click();", policydropDown);
        policydropDown.click();
       //WebElement insurertypes= driver.findElement(By.className("MuiPopover-paper"));
       WebElement insurertypes = driver
               .findElement(By.xpath(locatorsMap.get("selectoccuption").get("locator").textValue()));
       // WebElement insurertypes = wait.until(ExpectedConditions
       //       .elementToBeClickable(By.className(locatorsMap.get("idproofnames").get("locator").textValue())));
       //WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
       List<WebElement> liElements = insurertypes.findElements(By.tagName("li"));
       for (WebElement allele : liElements) {
           String insurertype = allele.getText();
           if (insurertype.equalsIgnoreCase(testData.get("occupation"))) {
               //if (insurertype.equalsIgnoreCase("Professional")) {
                   allele.click();
               break;
           }
       }
   }
    @When("^User select the insured member occupation \"([^\"]*)\"$")
    public void user_select_the_insured_member_occupation(String insured_member_occupation) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println("select the sumInsured");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className(locatorsMap.get("persoanloccuption").get("locator").textValue())));
        WebElement policydropDown = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("persoanloccuption").get("locator").textValue())));
        //WebElement policydropDown= driver.findElement(By.xpath("//*[@id=\"aiidproof\"]"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", policydropDown);
        //yourElement.click();
        //executor.executeScript("arguments[0].click();", policydropDown);
        policydropDown.click();
        //WebElement insurertypes= driver.findElement(By.className("MuiPopover-paper"));
        WebElement insurertypes = driver
                .findElement(By.xpath(locatorsMap.get("insuredmemberoccuption").get("locator").textValue()));
        // WebElement insurertypes = wait.until(ExpectedConditions
        //       .elementToBeClickable(By.className(locatorsMap.get("idproofnames").get("locator").textValue())));
        //WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
        List<WebElement> liElements = insurertypes.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String insurertype = allele.getText();
            // if (insurertype.equalsIgnoreCase(testData.get("occupation"))) {
            if (insurertype.equalsIgnoreCase(insured_member_occupation)) {
                allele.click();
                break;
            }
        }
    }
    @When("^User select the income source as \"([^\"]*)\"$")
    public void user_select_the_income_source_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor jxe = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement Area=wait.until(ExpectedConditions.elementToBeClickable(
               By.className(locatorsMap.get("self_ai_income_source").get("locator").textValue())));
        Area.click();
        WebElement Areanames = driver
                .findElement(By.xpath(locatorsMap.get("self_ai_income_source_list").get("locator").textValue()));
        List<WebElement> liElements1 = Areanames.findElements(By.tagName("li"));
        for (WebElement allele1 : liElements1) {
            String Areaname = allele1.getText();
            System.out.println("thhkdfjs---------"+testData.get("incomeSource"));
            //if (Areaname.equalsIgnoreCase(testData.get("incomeSource"))) {
                if (Areaname.equalsIgnoreCase("Salary")) {
                    allele1.click();
                break;
            }
        }
    }
    @When("^User enters the nominee firstname as \"([^\"]*)\"$")
    public void user_enters_the_nominee_firstname_as(String nomineeFirstName) throws Throwable {

        if (StringUtils.isNoneEmpty(nomineeFirstName)) {
            System.out.println("healthProposerNomineeFirstname");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);

            WebElement proposerLastName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("proposernomineefirstname").get("locator").textValue()))));
            proposerLastName.sendKeys(nomineeFirstName);
        }
        test.info("user enters the nominee firstname");

    }

    @When("^User enters the nominee lastname as \"([^\"]*)\"$")
    public void user_enters_the_nominee_lastname_as(String nomineeLastName) throws Throwable {

        if (StringUtils.isNoneEmpty(nomineeLastName)) {
            System.out.println("healthProposerNomineeLastname");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);

            WebElement proposerLastName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("proposernomineelastname").get("locator").textValue()))));
            proposerLastName.sendKeys(nomineeLastName);
        }
        test.info("user enters the nominee lastname");

    }
    @When("^User select the nominee relationship as \"([^\"]*)\"$")
    public void user_select_the_nominee_relationship_as(String nominee_relationship) throws Throwable {
       // checkoutPage.user_select_the_nominee_relationship(nomineeRelationship);
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNotEmpty(nominee_relationship)) {
            System.out.println("Choose health Nominee Relationship");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver
                    .findElement(By.className(locatorsMap.get("healthnomineerelationship").get("locator").textValue()))));
            js.executeScript("arguments[0].click();", ele);
            WebElement ele1 = wait.until(ExpectedConditions.visibilityOf(driver
                    .findElement(By.id("ainomineerelationship"))));
            Actions action = new Actions(driver);
            action.moveToElement(ele1).click().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("starnomineerelationship").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("starnomineerelationship").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(nominee_relationship)) {
                    allele.click();
                    break;
                }
            }
        }
        test.info("user select the nominee relationship");
    }

    @When("^User enters the family member firstname as \"([^\"]*)\"$")
    public void user_enters_the_family_member_firstname_as(String nomineeFirstName) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement familymemberfirstname = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("familymember_firstname").get("locator").textValue()))));
        familymemberfirstname.clear();
        familymemberfirstname.sendKeys("karthick");
        test.info("user enters the family member firstname");
    }
    @When("^User enters the family member lastname as \"([^\"]*)\"$")
    public void user_enters_the_family_member_lastname_as(String nomineeLastName) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(locatorsMap.get("familymemberlastname").get("locator").textValue()))));
        WebElement pospFillFatherName = wait.until(ExpectedConditions.visibilityOf(
               driver.findElement(By.xpath(locatorsMap.get("familymemberlastname").get("locator").textValue()))));
        //  pospFillFatherName.clear();
        //pospFillFatherName.sendKeys(testData.get("LastName"));
       // Thread.sleep(5000);
        pospFillFatherName.sendKeys("test");
        test.info("user enters the family member lastname");
    }
    @When("^User select the family member relationship as \"([^\"]*)\"$")
    public void user_select_the_family_member_relationship_as(String nomineeRelationship) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement policydropDown = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("selfaifamilyrelationship").get("locator").textValue())));
        policydropDown.click();
        WebElement insurertypes = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("citynames").get("locator").textValue())));
        WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String insurertype = allele.getText();
            System.out.println("thersdhj"+testData.get("familyMemberRelationship"));
           // if (insurertype.equalsIgnoreCase(testData.get("familyMemberRelationship"))) {
                if (insurertype.equalsIgnoreCase("FATHER")) {
                    allele.click();
                break;
            }
        }
        test.info("user select the family member relationship");
    }
    @When("^User select the  pep question as \"([^\"]*)\"$")
    public void user_select_the_pep_question_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement pepquestion= wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("pepqs").get("locator").textValue()))));
                WebElement Marriedstatusyes = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.className(locatorsMap.get("pepqs").get("locator").textValue())));
                executor.executeScript("arguments[0].click();", Marriedstatusyes);
               Marriedstatusyes.click();
    }
    @When("^User select the address proof \"([^\"]*)\"$")
    public void user_select_the_address_proof(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement policydropDown = wait.until(ExpectedConditions
              .elementToBeClickable(By.xpath(locatorsMap.get("aiaddressprooffield").get("locator").textValue())));
        //WebElement policydropDown= driver.findElement(By.xpath(""));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", policydropDown);
        //yourElement.click();
        // executor.executeScript("arguments[0].click();", policydropDown);
        policydropDown.click();
        WebElement insurertypes= driver.findElement(By.className("MuiPopover-paper"));

        // WebElement insurertypes = wait.until(ExpectedConditions
        //       .elementToBeClickable(By.className(locatorsMap.get("idproofnames").get("locator").textValue())));
        WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String insurertype = allele.getText();
            //if (insurertype.equalsIgnoreCase(testData.get("idprooftype"))) {
                if (insurertype.equalsIgnoreCase("Driving License")) {
                    allele.click();
                break;
            }
        }
    }


    @When("^User enter the address proof number \"([^\"]*)\"$")
    public void user_enter_the_address_proof_number(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement address2=wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("aiaddressproofnumber").get("locator").textValue())));
            //address2.sendKeys(testData.get("addressproofnumber"));
        address2.clear();
        address2.sendKeys("tn6183083092343");
    }

    @When("^user enters the nominee age as \"([^\"]*)\"$")
    public void user_enters_the_nominee_age_as(String nomineeAge) throws Throwable {
        if (StringUtils.isNoneEmpty(nomineeAge)) {
            System.out.println("healthProposer NomineeAge");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement proposerNomineeAge =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locatorsMap.get("propspernomineeAge").get("locator").textValue()))));
            proposerNomineeAge.sendKeys(nomineeAge);
        }        test.info("user enters the nominee age");
    }


    @When("^User clicks the next button in proposer tab$")
    public void user_clicks_the_next_button_in_proposer_tab() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement veiwMore = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue()))));
        WebElement proceedtoPersonal = wait.until(ExpectedConditions.elementToBeClickable(
                veiwMore.findElement(By.id(locatorsMap.get("proceedtoPersonal").get("locator").textValue()))));
        exe.executeScript("arguments[0].click();", proceedtoPersonal);
        test.info("user clicks the next button in contact tab");
        test.info("user clicks the next button in proposer tab");

    }

    @Then("^User is navigated to the insured member tab$")
    public void user_is_navigated_to_the_insured_member_tab() throws Throwable {

        test.info("user is navigated to the insured member tab");

    }


    @When("^User enters the self weight as \"([^\"]*)\"$")
    public void user_enters_the_self_weight_as(String selfweight) throws Throwable {

        if (StringUtils.isNoneEmpty(selfweight)) {
            System.out.println("select selfweight");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement selfWeight =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("selfweight").get("locator").textValue()))));
            selfWeight.sendKeys(selfweight);
        }
        test.info("user enters the self weight");


    }

    @When("^User select the self height in feet as \"([^\"]*)\"$")
    public void user_select_the_height_in_feet( String selfHeightInFeet) throws Throwable {

        if (StringUtils.isNotEmpty(selfHeightInFeet)) {
            System.out.println("Choose selfHeight");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement ele = driver
                    .findElement(By.className(locatorsMap.get("selfaiheightfeet").get("locator").textValue()));
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(selfHeightInFeet)) {
                    allele.click();
                    break;
                }
            }
        }
        test.info("user select the height in feet");
    }
    @When("^User select the self height in inch as \"([^\"]*)\"$")
    public void user_select_the_self_height_in_inch_as(String selfHeightInInch) throws Throwable {
        if (StringUtils.isNotEmpty(selfHeightInInch)) {
            System.out.println("Choose selfHeight");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement ele = driver
                    .findElement(By.xpath(locatorsMap.get("selfinch").get("locator").textValue()));
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(selfHeightInInch)) {
                    allele.click();
                    break;
                }
            }

        }        test.info("user select the self height in inch");

    }
    @When("^User click the self collapsetab$")
    public void user_click_the_self_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabself").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabself").get("locator").textValue())));
        ele.click();
        test.info("user click the self collapsetab");


    }
    @When("^User enter the Spouse firstname as \"([^\"]*)\"$")
    public void user_enter_the_Spouse_firstname_as(String spouseFirstname) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        if (!Strings.isNullOrEmpty(spouseFirstname)) {
            System.out.println("healthSpouseFirstName ");
            //WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement spouseFirstName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("spouseaifirstname").get("locator").textValue()))));
            spouseFirstName.sendKeys(spouseFirstname);
        }

        test.info("user enter the Spouse firstname");


    }

    @When("^User enter the Spouse lastname as \"([^\"]*)\"$")
    public void user_enter_the_Spouse_lastname_as(String spouseLastname) throws Throwable {
        if (!Strings.isNullOrEmpty(spouseLastname)) {
            System.out.println("healthSpouseLastName ");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement spouseFirstName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("spouselastName").get("locator").textValue()))));
            spouseFirstName.sendKeys(spouseLastname);
        }

        test.info("user enter the Spouse lastname");


    }

    @When("^User enters the spouse weight as \"([^\"]*)\"$")
    public void user_enters_the_spouse_weight_as(String spouseWeight) throws Throwable {
        if (!Strings.isNullOrEmpty(spouseWeight)) {
            System.out.println("healthSpouseWeight ");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement spouseFirstName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("spouseweight").get("locator").textValue()))));
            spouseFirstName.sendKeys(spouseWeight);
        }

        test.info("user enters the spouse weight");


    }

    @When("^User select the spouse height in feet as \"([^\"]*)\"$")
    public void user_select_the_spouse_height_in_feet_as(String spouseHeightInFeet) throws Throwable {
        if (StringUtils.isNotEmpty(spouseHeightInFeet)) {
            System.out.println("Choose healthSpouseHeight");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement ele = driver
                    .findElement(By.className(locatorsMap.get("spouseheight").get("locator").textValue()));
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(spouseHeightInFeet)) {
                    allele.click();
                    break;

                }
            }
        }

        test.info("user select the spouse height in feet");


    }

    @When("^User select the spouse height in inch as \"([^\"]*)\"$")
    public void user_select_the_spouse_height_in_inch_as(String spouseHeightInInch) throws Throwable {
        if (StringUtils.isNotEmpty(spouseHeightInInch)) {
            System.out.println("Choose healthSpouseHeight");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement ele = driver
                    .findElement(By.xpath(locatorsMap.get("spouseinch").get("locator").textValue()));
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(spouseHeightInInch)) {
                    allele.click();
                    break;
                }
            }
        }
        test.info("user select the spouse height in inch");


    }

    @When("^User select the spouse occupation as \"([^\"]*)\"$")
    public void user_select_the_spouse_occupation_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println("select the sumInsured");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className(locatorsMap.get("persoanloccuption").get("locator").textValue())));
        WebElement policydropDown = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("persoanloccuption").get("locator").textValue())));
        //WebElement policydropDown= driver.findElement(By.xpath("//*[@id=\"aiidproof\"]"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", policydropDown);
        //yourElement.click();
        executor.executeScript("arguments[0].click();", policydropDown);
        policydropDown.click();
        //WebElement insurertypes= driver.findElement(By.className("MuiPopover-paper"));
        WebElement insurertypes = driver
                .findElement(By.xpath(locatorsMap.get("insuredmemberoccuption").get("locator").textValue()));
        // WebElement insurertypes = wait.until(ExpectedConditions
        //       .elementToBeClickable(By.className(locatorsMap.get("idproofnames").get("locator").textValue())));
        //WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
        List<WebElement> liElements = insurertypes.findElements(By.tagName("li"));
        for (WebElement allele : liElements) {
            String insurertype = allele.getText();
            // if (insurertype.equalsIgnoreCase(testData.get("occupation"))) {
            if (insurertype.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }
        test.info("user select the spouse occupation");


    }
    @When("^User click the spouse collapsetab$")
    public void user_click_the_spouse_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabspouse").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabspouse").get("locator").textValue())));
        ele.click();

        test.info("user click the spouse collapse tab");


    }
    @When("^User click the firstson collapsetab$")
    public void user_click_the_first_son_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabson1").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabson1").get("locator").textValue())));
        ele.click();

        test.info("user click the first son collapse tab");


    }
    @When("^User click the secondson collapsetab$")
    public void user_click_the_second_son_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabson2").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabson2").get("locator").textValue())));
        ele.click();
        test.info("user click the second son collapse tab");

    }
    @When("^User click the thirdson collapsetab$")
    public void user_click_the_third_son_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabson3").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabson3").get("locator").textValue())));
        ele.click();        test.info("user click the third son collapse tab");
    }
    @When("^User click the fourthson collapsetab$")
    public void user_click_the_fourth_son_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabson4").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabson4").get("locator").textValue())));
        ele.click();        test.info("user click the fourth son collapse tab");
    }
    @When("^User click the firstdaugher collapsetab$")
    public void user_click_the_first_daughter_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabdoughter1").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabdoughter1").get("locator").textValue())));
        ele.click();
        test.info("user click the first daughter collapse tab");

    }
    @When("^User click the seconddaugher collapsetab$")
    public void user_click_the_second_daughter_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabdoughter2").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabdoughter2").get("locator").textValue())));
        ele.click();    }
    @When("^User click the thirddaughter collapsetab$")
    public void user_click_the_third_daughter_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabdoughter3").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabdoughter3").get("locator").textValue())));
        ele.click();    }
    @When("^User click the fourthdaugher collapsetab$")
    public void user_click_the_fourth_daughter_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabdoughter4").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabdoughter4").get("locator").textValue())));
        ele.click();
        test.info("user click the second daughter collapse tab");

    }

    @When("^User enter the firstson firstname as \"([^\"]*)\"$")
    public void user_enter_the_first_son_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        //if (isNullOrEmpty(testData.get("son1FirstName"))) {
        System.out.println("select son1FirstName");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son1aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enter the first son firstname");

    }

    @When("^User enter the firstson lastname as \"([^\"]*)\"$")
    public void user_enter_the_first_son_lastname_as(String arg1) throws Throwable {
        System.out.println("select son1LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son1lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enter the first son lastname");
    }

    @When("^User enters the firstson weight as \"([^\"]*)\"$")
    public void user_enter_the_first_son_weight_as(String arg1) throws Throwable {
        System.out.println("select son1Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son1weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the first son weight");
    }

    @When("^User select the firstson height in feet as \"([^\"]*)\"$")
    public void user_select_the_first_son_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son1Height");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("son1aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }
        test.info("user select the first son height in feet");
    }
    @When("^User enter the secondson firstname as \"([^\"]*)\"$")
    public void user_enter_the_second_son_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);

        //   if (isNullOrEmpty(testData.get("son2FirstName"))) {
        System.out.println("select son2FirstName");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son2aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enter the second son firstname");
    }

    @When("^User enter the secondson lastname as \"([^\"]*)\"$")
    public void user_enter_the_second_son_lastname_as(String arg1) throws Throwable {
        System.out.println("select son2LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son2lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the second son lastname");

    }

    @When("^User enters the secondson weight as \"([^\"]*)\"$")
    public void user_enters_the_second_son_weight_as(String arg1) throws Throwable {
        System.out.println("select son2Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son2weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the second son weight");

    }

    @When("^User select the secondson height in feet as \"([^\"]*)\"$")
    public void user_select_the_second_son_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son2Height");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("son2aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }
        test.info("user select the second son height in feet");

    }

    @When("^User enter the thirdson firstname as \"([^\"]*)\"$")
    public void user_enter_the_third_son_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        //  if (isNullOrEmpty(testData.get("son3FirstName"))) {
        System.out.println("select son3FirstName");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son3aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the third son firstname");

    }

    @When("^User enter the thirdson lastname as \"([^\"]*)\"$")
    public void user_enter_the_third_son_lastname_as(String arg1) throws Throwable {
        // if (isNullOrEmpty(testData.get("son3LastName"))) {
        System.out.println("select son3LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son3lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the third son lastname");

    }

    @When("^User enters the thirdson weight as \"([^\"]*)\"$")
    public void user_enters_the_third_son_weight_as(String arg1) throws Throwable {
        System.out.println("select son3Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son3weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the third son weight");

    }

    @When("^User select the thirdson height in feet as \"([^\"]*)\"$")
    public void user_select_the_third_son_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son3Height");
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("son3aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }        test.info("user enter the third son height");

    }

    @When("^User enter the fourthson firstname as \"([^\"]*)\"$")
    public void user_enter_the_fourth_son_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);

        //if (isNullOrEmpty(testData.get("son4FirstName"))) {

        System.out.println("select son4FirstName");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son4aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the fourth son firstname");

    }

    @When("^User enter the fourthson lastname as \"([^\"]*)\"$")
    public void user_enter_the_fourth_son_lastname_as(String arg1) throws Throwable {
        System.out.println("select son4LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son4lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the fourth son lastname");

    }

    @When("^User enters the fourthson weight as \"([^\"]*)\"$")
    public void user_enters_the_fourth_son_weight_as(String arg1) throws Throwable {
        System.out.println("select son4Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("son4weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);        test.info("user enter the fourth son weight");

    }

    @When("^User select the fourthson height in feet as \"([^\"]*)\"$")
    public void user_select_the_fourth_son_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son4Height");
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("son4aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }        test.info("user enter the fourth son height");

    }
    @When("^User enter the firstdaugher firstname as \"([^\"]*)\"$")
    public void user_enter_the_first_daughter_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        // if (isNullOrEmpty(testData.get("daughter1FirstName"))) {
        System.out.println("select daughter1FirstName");
        //WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter1aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enter the first daughter firstname");

    }
    @When("^User enter the firstdaugher lastname as \"([^\"]*)\"$")
    public void user_enter_the_first_daughter_lastname_as(String arg1) throws Throwable {
        System.out.println("select daughter1LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter1lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);

        test.info("user enter the first daughter lastname");

    }

    @When("^User enters the firstdaugher weight as \"([^\"]*)\"$")
    public void user_enters_the_first_daughter_weight_as(String arg1) throws Throwable {
        System.out.println("select daughter1Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter1weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);

        test.info("user enters the first daughter weight");


    }

    @When("^User select the firstdaugher height in feet as \"([^\"]*)\"$")
    public void user_select_the_first_daughter_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son1Height");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("daughter1aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }

        test.info("user select the first daughter height in feet");

    }
    @When("^User enter the seconddaugher firstname as \"([^\"]*)\"$")
    public void user_enter_the_second_daughter_firstname_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        // if (isNullOrEmpty(testData.get("daughter2FirstName"))) {
        System.out.println("select daughter2FirstName");
        //WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter2aifirstname").get("locator").textValue())));
        selfDOB.sendKeys(arg1);

        test.info("user enter the second daughter firstname");


    }
    @When("^User enter the seconddaugher lastname as \"([^\"]*)\"$")
    public void user_enter_the_second_daugther_lastname_as(String arg1) throws Throwable {
        System.out.println("select daughter2LastName");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter2lastName").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enter the second daughter lastname");


    }

    @When("^User enters the seconddaugher weight as \"([^\"]*)\"$")
    public void user_enters_the_second_daughter_weight_as(String arg1) throws Throwable {
        System.out.println("select daughter2Weight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.id(locatorsMap.get("daughter2weight").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the second daughter weight");


    }

    @When("^User select the seconddaugher height in feet as \"([^\"]*)\"$")
    public void user_select_the_second_daughter_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose son2Height");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("daughter2aiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }
        test.info("user select the second daughter height in feet");


    }
    /*@When("^User enter the seconddaugher firstname as \"([^\"]*)\"$")
    public void user_enter_the_thirddaugher_firstname_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter3_firstname(arg1);

    }
    @When("^User enter the seconddaugher lastname as \"([^\"]*)\"$")
    public void user_enter_the_thirddaugher_lastname_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter3_lastname(arg1);

    }

    @When("^User enters the seconddaugher weight as \"([^\"]*)\"$")
    public void user_enters_the_thirddaugher_weight_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter3_weight(arg1);

    }

    @When("^User select the seconddaugher height in feet as \"([^\"]*)\"$")
    public void user_select_the_thirddaugher_height_in_feet_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter3_height(arg1);

    }
    @When("^User enter the seconddaugher firstname as \"([^\"]*)\"$")
    public void user_enter_the_fourthdaugher_firstname_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter4_fristname(arg1);

    }
    @When("^User enter the seconddaugher lastname as \"([^\"]*)\"$")
    public void user_enter_the_fourthdaugher_lastname_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter4_lastname(arg1);

    }

    @When("^User enters the seconddaugher weight as \"([^\"]*)\"$")
    public void user_enters_the_fourthdaugher_weight_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter4_weight(arg1);

    }

    @When("^User select the seconddaugher height in feet as \"([^\"]*)\"$")
    public void user_select_the_fourthdaugher_height_in_feet_as(String arg1) throws Throwable {
        checkoutPage.user_enter_the_daughter4_height(arg1);

    }*/
    @When("^User enters the mother first name as \"([^\"]*)\"$")
    public void user_enters_the_mother_first_name_as(String arg1) throws Throwable {
        System.out.println("mother FirstName ");
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("motheraifirstname").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);
        test.info("user enters the mother first name");

    }

    @When("^User enters the mother last name as \"([^\"]*)\"$")
    public void user_enters_the_mother_last_name_as(String arg1) throws Throwable {
        System.out.println("mother LastName ");
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("motherlastName").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);
        test.info("user enters the mother last name");

    }

    @When("^User enters the mother weight as \"([^\"]*)\"$")
    public void user_enters_the_mother_weight_as(String arg1) throws Throwable {
        System.out.println("mother Weight");
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("motherweight").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);
        test.info("user enters the mother weight");

    }

    @When("^User select the mother height in feet as \"([^\"]*)\"$")
    public void user_select_the_mother_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose motherHeight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("motheraiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;

            }
        }
        test.info("user select the mother height in feet");

    }

//    @When("^User select the mother height in inches as \"([^\"]*)\"$")
//    public void user_select_the_mother_height_in_inches_as(String arg1) throws Throwable {
//        checkoutPage.user_enter_the_mother_inch(arg1);
//
//        test.info("user select the mother height in inches");
//
//    }

    @When("^User select the mother occupation as \"([^\"]*)\"$")
    public void user_select_the_mother_occupation_as(String occupation) throws Throwable {
        if (StringUtils.isNotEmpty(occupation)) {
            System.out.println("Select selectOccuption");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id(locatorsMap.get("persoanloccuption").get("locator").textValue())));
            WebElement ele = driver
                    .findElement(By.id(locatorsMap.get("persoanloccuption").get("locator").textValue()));
            action.moveToElement(ele).build().perform();
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selectspouseoccuption").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selectspouseoccuption").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(occupation)) {
                    allele.click();
                    break;
                }
            }
        }
        test.info("user click the mother occupation");

    }

    @When("^User select the father occupation as \"([^\"]*)\"$")
    public void user_select_the_father_occupation_as(String occupation) throws Throwable {
        if (StringUtils.isNotEmpty(occupation)) {
            System.out.println("Select selectOccuption");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id(locatorsMap.get("persoanloccuption").get("locator").textValue())));
            WebElement ele = driver
                    .findElement(By.id(locatorsMap.get("persoanloccuption").get("locator").textValue()));
            action.moveToElement(ele).build().perform();
            ele.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(locatorsMap.get("selectspouseoccuption").get("locator").textValue())));
            WebElement yearUlLocate = driver
                    .findElement(By.xpath(locatorsMap.get("selectspouseoccuption").get("locator").textValue()));
            List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
            for (WebElement allele : liElement) {
                String yearss = allele.getText();
                if (yearss.equalsIgnoreCase(occupation)) {
                    allele.click();
                    break;
                }
            }
        }
        test.info("user click the father occupation ");

    }

    @When("^User click the father collapsetab$")
    public void user_click_the_father_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabfather").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabfather").get("locator").textValue())));
        ele.click();
        test.info("user click the father collapse tab");

    }

    @When("^User click the mother collapsetab$")
    public void user_click_the_mother_collapse_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.xpath(locatorsMap.get("collapstabmother").get("locator").textValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("collapstabmother").get("locator").textValue())));
        ele.click();
        test.info("user click the mother collapse tab");

    }

    @When("^User enters the father first name as \"([^\"]*)\"$")
    public void user_enters_the_father_first_name_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        WebElement collapstabfather =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("collapstabfather").get("locator").textValue()))));
        if (collapstabfather.isDisplayed()) {
            collapstabfather.click();
        }
        // if(isNullOrEmpty(testData.get("fatherFirstName"))) {
        System.out.println("father FirstName ");
        //WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("fatheraifirstname").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);        test.info("user enters the father first name");

    }

    @When("^User enters the father last name as \"([^\"]*)\"$")
    public void user_enters_the_father_last_name_as(String arg1) throws Throwable {
        System.out.println("father LastName");
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("fatherlastName").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);
        test.info("user enters the father last name");

    }

    @When("^User enters the father weight as \"([^\"]*)\"$")
    public void user_enters_the_father_weight_as(String arg1) throws Throwable {
        System.out.println("father Weight");
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        WebElement spouseFirstName =
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("fatherweight").get("locator").textValue()))));
        spouseFirstName.sendKeys(arg1);
        test.info("user enters the father weight");

    }

    @When("^User select the father height in feet as \"([^\"]*)\"$")
    public void user_select_the_father_height_in_feet_as(String arg1) throws Throwable {
        System.out.println("Choose fatherHeight");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement ele = driver
                .findElement(By.className(locatorsMap.get("fatheraiheightfeet").get("locator").textValue()));
        ele.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locatorsMap.get("selfheight").get("locator").textValue())));
        WebElement yearUlLocate = driver
                .findElement(By.xpath(locatorsMap.get("selfheight").get("locator").textValue()));
        List<WebElement> liElement = yearUlLocate.findElements(By.tagName("li"));
        for (WebElement allele : liElement) {
            String yearss = allele.getText();
            if (yearss.equalsIgnoreCase(arg1)) {
                allele.click();
                break;
            }
        }
        test.info("user select the father height in feet");

    }

//    @When("^User select the father height in inches as \"([^\"]*)\"$")
//    public void user_select_the_father_height_in_inches_as(String arg1) throws Throwable {
//        checkoutPage.user_enter_the_father_inch(arg1);
//
//        test.info("user select the father height in inches");
//
//    }


    @When("^User clicks the next button in insured member tab$")
    public void user_clicks_the_next_button_in_insured_member_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement veiwMore = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue()))));
        WebElement proceedtoPersonal = wait.until(ExpectedConditions.elementToBeClickable(
                veiwMore.findElement(By.id(locatorsMap.get("proceedtoPersonal").get("locator").textValue()))));
        exe.executeScript("arguments[0].click();", proceedtoPersonal);
        test.info("user clicks the next button in contact tab");        test.info("user clicks the next button in insured member tab");
    }


    @Then("^User is navigated to the questionnaire tab$")
    public void user_click_navigated_to_the_questionnaire_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        WebElement productname = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div")));
        String Product=productname.getText();
        if (Product.equalsIgnoreCase("Star Health Comprehensive Floater")) {
            WebElement medicalqs = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[1]/section[1]/form/div/div[6]/div/div[2]/div/div/label[1]")));
            medicalqs.click();
        }
        if (Product.equalsIgnoreCase("Star Health Comprehensive Individual")) {
            WebElement medicalqs = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/section/div[1]/div[1]/section[1]/form/div/div[6]/div/div[2]/div/div/label[1]")));
            medicalqs.click();
        }
        test.info("user is navigated to the medical history tab");
    }

    @When("^User clicks the next button in questionnaire tab$")
    public void user_clicks_the_next_button_in_questionnaire_tab() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement veiwMore = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue()))));
        WebElement proceedtoPersonal = wait.until(ExpectedConditions.elementToBeClickable(
                veiwMore.findElement(By.id(locatorsMap.get("proceedtoPersonal").get("locator").textValue()))));
        exe.executeScript("arguments[0].click();", proceedtoPersonal);
        test.info("user clicks the next button in contact tab");        test.info("user clicks the next button in questionnaire tab");
    }

    private void getSafeElementmin() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
