package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.LocatorsMap;
import com.arka.e2etest.utils.PropertiesFileReader;
import com.arka.e2etest.utils.TestDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.arka.e2etest.runner.CucumberRunner.testdata;
import static org.xhtmlrenderer.util.Util.isNullOrEmpty;


public class Homepage extends BaseFunctions{
    private static int MIN_TIMEOUT = 60;
    private static int MAX_TIMEOUT = 100;
    private static int MAXX_TIMEOUT = 160;
    JsonNode locatorsMap = LocatorsMap.getlocators();
    public static XSSFSheet sheet;
    public static XSSFCell cell;

    @Given("^User landed on the homepage successfully$")
    public void user_landed_on_the_homepage_successfully() throws Throwable {
     //   homePage = new HomePage(BaseFunctions.driver);
     //   Assert.assertTrue(BaseFunctions.elementIsDisplayed(homePage.getLearning_center()));
        test = BaseFunctions.extent.createTest("Home page").info("User landed on the homepage successfully");
    }
    @When("^User select the insured person as \"([^\"]*)\"$")
    public void user_click_the_cover_as(String usercredentials) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (isNullOrEmpty(testData.get("insurenceType"))) {
            getSafeElement();
            //System.out.println("select the insurenceType");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement policydropDown = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("healthpolicydropdown").get("locator").textValue())));
            policydropDown.click();
            WebElement insurertypes = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("insurertypes").get("locator").textValue())));
            WebElement ulElement = insurertypes.findElement(By.tagName("ul"));
            List<WebElement> liElements = wait.until(ExpectedConditions.visibilityOfAllElements(ulElement.findElements(By.tagName("li"))));
            for (WebElement allele : liElements) {
                String insurertype = allele.getText();
                if (insurertype.equalsIgnoreCase(testData.get("insurenceType"))) {
                    allele.click();
                    break;
                }
            }
        }
     test.info("user select the insured person");
    }
    @When("^User clicks on Get Quotes button$")
    public void user_clicks_on_Get_Quotes_button() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
            System.out.println("getQuotes");
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement getQuotes = wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(By.className(locatorsMap.get("getquotes").get("locator").textValue()))));
            exe.executeScript("arguments[0].click();", getQuotes);
            //	getQuotes.click();

        //test.info("user clicks on get quotes button");
    }
    @When("^User select the product as \"([^\"]*)\"$")
    public void user_select_the_product_as(String usercredentials) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
            System.out.println("selectproducts");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement listofProducts = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("listofproducts").get("locator").textValue())));
            listofProducts.click();
            WebElement products = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("products").get("locator").textValue())));
            WebElement ulElement = products.findElement(By.tagName("ul"));
            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            for (WebElement allele : liElements) {
                WebElement alleless = allele.findElement(By.tagName("button"));
                String make = alleless.getText();
                if (make.equalsIgnoreCase(testData.get("category"))) {
                    //if (make.equalsIgnoreCase(usercredentials)) {
                        alleless.click();
                    break;
                } else if (make.equalsIgnoreCase("2 Wheeler") && testData.get("category").equalsIgnoreCase("bike")) {
                    alleless.click();
                    break;
                }
            }

        //test.info("user select the product");
    }

    //car flow steps
    @When("^User enter the car number as \"([^\"]*)\"$")
    public void user_enter_the_car_number_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
            System.out.println("registrationNumber");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            WebElement proposerFirstName =
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locatorsMap.get("car_regno").get("locator").textValue()))));
            proposerFirstName.sendKeys(testData.get("registrationNumber"));
        }

    @Then("^User verify the zoop status$")
    public void user_verify_the_zoop_status() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement KYCVerified=
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorsMap.get("zoop_check").get("locator").textValue()))));
        String expectedvalue=KYCVerified.getText();
        if (expectedvalue.contains("Not in this list? click here")) {
            Assert.assertEquals(true, KYCVerified.isDisplayed());
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


