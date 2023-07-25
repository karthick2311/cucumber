package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.ExcelHandler;
import com.arka.e2etest.utils.LocatorsMap;
import com.arka.e2etest.utils.PropertiesFileReader;
import com.arka.e2etest.utils.TestDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.xhtmlrenderer.util.Util.isNullOrEmpty;
import static com.arka.e2etest.runner.CucumberRunner.testdata;

public class Enquirypage extends  BaseFunctions{
    private static int MAX_TIMEOUT = 100;
    private static int MAXX_TIMEOUT = 160;
    JsonNode locatorsMap = LocatorsMap.getlocators();

    @Then("^User is landed on the enquiry creation page successfully$")
    public void user_is_landed_on_the_enquiry_creation_page_successfully() throws Throwable {
       // enquiryPage = new EnquiryPage(BaseFunctions.driver);
       // Assert.assertTrue(BaseFunctions.elementIsDisplayed(enquiryPage.getSum_insured()));
        test = BaseFunctions.extent.createTest("Enquiry page").info("User is landed on the Enquiry creation page successfully");
    }
    @When("^User select the sum insured value as \"([^\"]*)\"$")
    public void user_clicks_the_sum_insured_value_as(String usercredentials) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
            System.out.println("select the sumInsured"+testData.get("Occupation"));
        System.out.println("select the sumInsured"+testData.get("sumInsured"));
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement policydropDown = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("enquirysuminsured").get("locator").textValue())));
            policydropDown.click();
            WebElement insurertypes = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("insurertypes").get("locator").textValue())));
            WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            for (WebElement allele : liElements) {
                String insurertype = allele.getText();
                if (insurertype.equalsIgnoreCase(testData.get("sumInsured"))) {
                    allele.click();
                    break;
                }
        }
        test.info("user select the sum insured value");
    }
    @When("^User enter the pincode \"([^\"]*)\" and select the area \"([^\"]*)\"$")
    public void user_enter_the_pincode_and_select_the_area(String arg1, String arg2) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
            System.out.println("select the pincode");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement enquirypincode = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("enquirypincode").get("locator").textValue())));
            enquirypincode.sendKeys(testData.get("pincode"));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            WebElement pincodelist = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("pincodelist").get("locator").textValue())));
            List<WebElement> liElements = pincodelist.findElements(By.tagName("li"));
            for (WebElement allele : liElements) {
                String insurertype = allele.getText();
                System.out.println(insurertype);

                if (insurertype.contains(testData.get("pincodevalue"))) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    WebElement enquirypincode1 = wait.until(ExpectedConditions
                            .visibilityOf(allele));
                    allele.click();
                    break;
                }
            }
        test.info("user enter the pincode and select the area");
    }

    @When("^User clicks on the next button$")
    public void user_clicks_on_the_next_button() throws Throwable {
        System.out.println("Select NextButton");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.className(locatorsMap.get("nextbutton").get("locator").textValue()))));
        js.executeScript("arguments[0].style.border='4px groove red'",next);
        next.click();
        test.info("user clicks on the next button");
    }
    @When("^User add the first son$")
    public void user_add_the_first_son() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
           test.info("user add the first son");
    }

    @When("^User add the second son$")
    public void user_add_the_second_son() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
        test.info("user add the second son");

    }
    @When("^User add the first daughter$")
    public void user_add_the_first_daughter() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addDaughterButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addDaughterButton").get("locator").textValue())));
        addDaughterButton.click();
        test.info("user add the first daughter");

    }
    @When("^User add the second daughter$")
    public void user_add_the_second_daughter() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addDaughterButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addDaughterButton").get("locator").textValue())));
        addDaughterButton.click();
        test.info("user add the second daughter");

    }
    @When("^User enters the dob for first son as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_first_son_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("firstSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for first son");

    }
    @When("^User enters the dob for second son as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_second_son_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("secondSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for second son");

    }

    @When("^User enters the dob for first daughter as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_first_daughter_as(String arg1) throws Throwable {
        System.out.println("select daughterDOB1");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("firstDaughterDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for first daughter");

    }
    @When("^User enters the dob for second daughter as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_second_daughter_as(String arg1) throws Throwable {
        System.out.println("select daughterDOB2");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("secondDaughterDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for second daughter");
    }
    @When("^User enters the dob for father as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_father_as(String arg1) throws Throwable {
        System.out.println("select FatherDOB");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("FatherDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for father");
    }

    @When("^User enters the dob for mother as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_mother_as(String arg1) throws Throwable {
        System.out.println("select motherDOB");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("MotherDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for mother");

    }
    @When("^User add the firstson$")
    public void user_add_the_son() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
    }

    @When("^User add the secondson$")
    public void user_add_the_secondson() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
    }
    @When("^User add the Thirdson$")
    public void user_add_the_thirdson() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
    }
    @When("^User add the fourthson$")
    public void user_add_the_fourthson() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addSonButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addSonButton").get("locator").textValue())));
        addSonButton.click();
    }
    @When("^User add the firstdaughter$")
    public void user_add_the_firstdaughter() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addDaughterButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addDaughterButton").get("locator").textValue())));
        addDaughterButton.click();
    }
    @When("^User add the seconddaughter$")
    public void user_add_the_seconddaughter() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement addDaughterButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("addDaughterButton").get("locator").textValue())));
        addDaughterButton.click();
    }
    @When("^User enters the dob for firstson as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_firstson_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("firstSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
    }
    @When("^User enters the dob for secondson as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_secondson_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("secondSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
    }
    @When("^User enters the dob for thirdson as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_thirdson_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("thirdSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
    }
    @When("^User enters the dob for fourthson as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_fourthson_as(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("fourthSonDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
    }
    @When("^User enters the dob for firstdaughter as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_firstdaughter_as(String arg1) throws Throwable {
        System.out.println("select daughterDOB1");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("firstDaughterDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);    }
    @When("^User enters the dob for seconddaughter as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_seconddaughter_as(String arg1) throws Throwable {
        System.out.println("select daughterDOB2");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("secondDaughterDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
    }
    @When("^User select the self gender as \"([^\"]*)\"$")
    public void user_select_the_self_gender_as(String arg1) throws Throwable {
        if (Strings.isNullOrEmpty(arg1)) {
            System.out.println("select selfGender");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement selfGender = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("selfGender").get("locator").textValue())));
            selfGender.click();
            WebElement genderList = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("pincodelist").get("locator").textValue())));
            List<WebElement> liElements = genderList.findElements(By.tagName("li"));
            for (WebElement allele : liElements) {
                String insurertype = allele.getText();
                if (insurertype.equalsIgnoreCase(arg1)) {
                    System.out.println("insurertype" + insurertype);
                    allele.click();
                    break;
                }
            }
        }        test.info("user select the self gender");
    }

    @When("^User enters the dob for self as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_self_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (!isNullOrEmpty(testData.get("selfDOB"))) {
            System.out.println("select selfDOB");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement selfDOB = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("selfDOB").get("locator").textValue())));
            selfDOB.sendKeys(testData.get("selfDOB"));
        }
        test.info("user enters the dob for self");
    }

    @When("^User enters the dob for spouse as \"([^\"]*)\"$")
    public void user_enters_the_dob_for_spouse_as(String arg1) throws Throwable {
        System.out.println("select selectSpouseDOB");
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("spouseDOB").get("locator").textValue())));
        selfDOB.sendKeys(arg1);
        test.info("user enters the dob for spouse");
    }

    @When("^User clicks the submit button$")
    public void user_clicks_the_submit_button() throws Throwable {
        //enquiryPage.user_click_the_submit_button();
        getSafeElementmin();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement viewmoresubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className(locatorsMap.get("viewmoresubmit").get("locator").textValue())));
        viewmoresubmit.click();
        //test.info("user clicks the submit button");
    }

// car flow step definition

    @Given("^User edits the zoop manufacturer year as \"([^\"]*)\"$")
    public void user_edits_the_zoop_manufacturer_year_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        Calendar calendar = Calendar.getInstance();
        int excelData = Integer.parseInt(testData.get("ManufactureYear")); // convert 0 "Stirng" to year
        int yearfromExcel = (calendar.get(Calendar.YEAR) + excelData); // -1
        String Excelyear = String.valueOf(yearfromExcel);
        System.out.println(Excelyear);
         WebElement manfYear = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("yearOfMFG").get("locator").textValue())));
        manfYear.clear();
            manfYear.sendKeys(Excelyear);

    }
    @When("^User edits the zoop registration date as \"([^\"]*)\"$")
    public void user_edits_the_zoop_registration_date_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("registrationDate").get("locator").textValue())));
        selfDOB.clear();
        selfDOB.sendKeys(testData.get("editregDate"));
    }
    @When("^User edits the zoop policy expiry date as \"([^\"]*)\"$")
    public void user_edits_the_zoop_policy_expiry_date_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement selfDOB = wait.until(ExpectedConditions
                .elementToBeClickable(By.className(locatorsMap.get("policyEndDate").get("locator").textValue())));
        selfDOB.clear();
        selfDOB.sendKeys(testData.get("editpreDate"));
    }

    @When("^User clicks the proceed button$")
    public void user_clicks_the_proceed_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        WebElement viewmoresubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className(locatorsMap.get("continuebtn").get("locator").textValue())));
        viewmoresubmit.click();
    }
    @Given("^User select the vehicle make or model as \"([^\"]*)\"$")
    public void user_select_the_vehicle_make_or_model_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        //WebElement collapstabself=
          //      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("collapstabself").get("locator").textValue()))));
        WebElement collapstabself=driver.findElement(By.xpath("//*[text()=\"Not in this list? click here\"]"));
        if(collapstabself.isDisplayed()){
            System.out.println("this is zoop flow");
        }
        else {
        //if (isNullOrEmpty(testData.get("makeModel"))) {
            System.out.println("Select make Model");
            getSafeElementmin();
            JavascriptExecutor jeh = (JavascriptExecutor) driver;
            WebElement selectMake = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("externalvalue").get("locator").textValue())));
            WebElement externalValue = selectMake
                    .findElement(By.id(locatorsMap.get("input").get("locator").textValue()));
            int strlength = testData.get("makeModel").length();
            int wordlength = testData.get("makeModel").split(" ").length;
            if (wordlength == 3) {
                String makemodel = testData.get("makeModel").substring(0, strlength - 6);
                System.out.println(makemodel);
                externalValue.sendKeys(makemodel);
            } else if (wordlength <= 2) {
                String makemodel = testData.get("makeModel").substring(0, strlength - 3);
                wait.until(ExpectedConditions.elementToBeClickable(externalValue)).sendKeys(makemodel);
                System.out.println(makemodel);
            } else if (wordlength == 4) {
                String makemodel = testData.get("makeModel").substring(0, strlength - 5);
                wait.until(ExpectedConditions.elementToBeClickable(externalValue)).sendKeys(makemodel);
                System.out.println(makemodel);
            } else if (wordlength > 4) {
                String makemodel = testData.get("makeModel").substring(0, strlength - 8);
                wait.until(ExpectedConditions.elementToBeClickable(externalValue)).sendKeys(makemodel);
                System.out.println(makemodel);
            }
            getSafeElementmin();
            WebElement ulElement = wait
                    .until(ExpectedConditions.elementToBeClickable(selectMake.findElement(By.tagName("ul"))));
            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            for (WebElement allele : liElements) {
                WebElement alleless = wait
                        .until(ExpectedConditions.elementToBeClickable(allele.findElement(By.tagName("button"))));
                String make = alleless.getText();
                if (make.equalsIgnoreCase(testData.get("makeModel"))) {
                    // alleless.click();
                    jeh.executeScript("arguments[0].click();", alleless);
                    break;

                }

        }  }

    }

    @When("^User select the vehicle fuel type as \"([^\"]*)\"$")
    public void user_select_the_vehicle_fuel_type_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();

    }

    @When("^User select the vehicle variant \"([^\"]*)\"$")
    public void user_select_the_vehicle_variant(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();

    }

    @When("^USer select the vehicle manufacturing year \"([^\"]*)\"$")
    public void user_select_the_vehicle_manufacturing_year(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();

    }

    @When("^User edits the registration date as \"([^\"]*)\"$")
    public void user_edits_the_registration_date_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();

    }

    @When("^User select policy claim status \"([^\"]*)\"$")
    public void user_select_policy_claim_status(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNoneEmpty(testData.get("claimed"))) {
            System.out.println("select policy Claimed");
            getSafeElementmin();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            if ("yes".equalsIgnoreCase(testData.get("claimed"))) {
                WebElement claimedYes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(locatorsMap.get("policyclaimed").get("locator").textValue())));
                executor.executeScript("arguments[0].click();", claimedYes);
            } else if ("no".equalsIgnoreCase(testData.get("claimed"))) {
                WebElement claimedNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(locatorsMap.get("policynotclaimed").get("locator").textValue())));
                executor.executeScript("arguments[0].click();", claimedNo);
            }
        }
    }
    @When("^User select the vehicle ownership change status in zoop flow \"([^\"]*)\"$")
    public void user_select_the_vehicle_ownership_change_status_in_zoop_flow(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNoneEmpty(testData.get("ownership"))) { // ownership ownershipchanged ownershipnotchanged
            System.out.println("selectOwnership");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
            if ("yes".equalsIgnoreCase(testData.get("ownership"))) {
                WebElement ownershipYes = wait.until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath(locatorsMap.get("ownershipchangedwithzoop").get("locator").textValue()))));
               // WebElement ncbValue = wait.until(ExpectedConditions.elementToBeClickable(ownershipYes.findElement(By.linkText("Yes"))));
                executor.executeScript("arguments[0].click();", ownershipYes);
            } else if ("no".equalsIgnoreCase(testData.get("ownership"))) {
                WebElement ownershipNo = wait.until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath(locatorsMap.get("ownershipnotchanged").get("locator").textValue()))));
                executor.executeScript("arguments[0].click();", ownershipNo);
            }

        }
    }

    @When("^User select the value of NCB status in zoop flow \"([^\"]*)\"$")
    public void user_select_the_value_of_NCB_status_in_zoop_flow(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNotEmpty(testData.get("ncbProtector"))) {
            System.out.println("selectNcbProtector");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            if ("yes".equalsIgnoreCase(testData.get("ncbProtector"))) {
                WebElement ncbvalueLoc = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.xpath(locatorsMap.get("ncbprotectoryeswithzoop").get("locator").textValue()))));
                //WebElement ncbValue = wait.until(ExpectedConditions.elementToBeClickable(ncbvalueLoc.findElement(By.tagName("label"))));
                executor.executeScript("arguments[0].click();", ncbvalueLoc);

            } else if ("no".equalsIgnoreCase(testData.get("ncbProtector"))) { // ncbprotectorno
                WebElement ncbvalueLoc = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.xpath(locatorsMap.get("ncbprotectornowithzoop").get("locator").textValue()))));
                //WebElement ncbValue = wait.until(ExpectedConditions.elementToBeClickable(ncbvalueLoc.findElement(By.tagName("label"))));
                ncbvalueLoc.click();
            }
        }
    }

    @When("^User select the vehicle ownership change status$")
    public void user_select_the_vehicle_ownership_change_status() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNoneEmpty(testData.get("ownership"))) { // ownership ownershipchanged ownershipnotchanged
            System.out.println("selectOwnership");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
            if ("yes".equalsIgnoreCase(testData.get("ownership"))) {
                WebElement ownershipYes = wait.until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.className(locatorsMap.get("ownershipchanged").get("locator").textValue()))));
                executor.executeScript("arguments[0].click();", ownershipYes);
            } else if ("no".equalsIgnoreCase(testData.get("ownership"))) {

                WebElement ownershipNo = wait.until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.className(locatorsMap.get("ownershipnotchanged").get("locator").textValue()))));
                executor.executeScript("arguments[0].click();", ownershipNo);
            }

        }
    }
    @When("^User select the NCB percentage in zoop flow \"([^\"]*)\"$")
    public void user_select_the_NCB_percentage_in_zoop_flow(String arg1) throws Throwable {

    }

    @When("^User select the value of NCB status$")
    public void user_select_the_value_of_NCB_status() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNotEmpty(testData.get("ncbProtector"))) {
            System.out.println("selectNcbProtector");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            if ("yes".equalsIgnoreCase(testData.get("ncbProtector"))) {
                WebElement ncbvalueLoc = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.className(locatorsMap.get("ncbprotectoryes").get("locator").textValue()))));
                WebElement ncbValue = wait.until(ExpectedConditions.elementToBeClickable(ncbvalueLoc.findElement(By.tagName("label"))));
               executor.executeScript("arguments[0].click();", ncbValue);

            } else if ("no".equalsIgnoreCase(testData.get("ncbProtector"))) { // ncbprotectorno
                WebElement ncbvalueLoc = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.className(locatorsMap.get("ncbprotectorno").get("locator").textValue()))));
                WebElement ncbValue = wait.until(ExpectedConditions.elementToBeClickable(ncbvalueLoc.findElement(By.tagName("label"))));
                ncbValue.click();
            }
        }
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
