package com.arka.e2etest.stepdefinitions;

import com.arka.e2etest.base.BaseFunctions;
import com.arka.e2etest.utils.LocatorsMap;
import com.arka.e2etest.utils.PropertiesFileReader;
import com.arka.e2etest.utils.TestDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static com.arka.e2etest.runner.CucumberRunner.testdata;
import static org.testng.util.Strings.isNullOrEmpty;

public class Quotespage extends BaseFunctions {
    private static int MAX_TIMEOUT = 100;
    private static int MAXX_TIMEOUT = 160;
    private static int MIN_TIMEOUT = 60;
    JsonNode locatorsMap = LocatorsMap.getlocators();

   @Given("^User is landed on the quotes page successfully$")
    public void user_is_landed_on_the_quotes_page_successfully() throws Throwable {
//       quotespage = new QuotesPage(BaseFunctions.driver);
//       Assert.assertTrue(BaseFunctions.elementIsDisplayed(quotespage.getLearning_center()));
       test = BaseFunctions.extent.createTest("Quotes page").info("User is landed on the  quotes page successfully");
   }
    @Then("^User collects the quotes details$")
    public void user_collects_the_quotes_details() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("health Quotesdetails");
        Actions act = new Actions(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String vendorId = null;
        String vendordetails=null;
        WebElement policyDetailsWebElement = null;
        String policydetail=null;
        String CoveredText=null;
        String WaitingPeriodText=null;
        String NotCoveredText=null;
        String AllText=null;
        String AdditionalCoversText=null;
        String AdditionalCoversTexts=null;


        //WebElement AfterpolicyDetailsWebElement = null;
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        if (wait.until(ExpectedConditions.urlContains("/quotes/"))) {
            getSafeElement();
            getSafeElement();
            getSafeElement();
            List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.className(locatorsMap.get("gridouterblock").get("locator").textValue())));
            //System.out.println("The total vendor list is"+findElements.size());
            for (WebElement vendorList : findElements) {
                vendorId = wait
                        .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                By.className(locatorsMap.get("gridinnerblock").get("locator").textValue()))))
                        .getAttribute("id");
                vendordetails = wait
                        .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                By.className(locatorsMap.get("gridinnerblock").get("locator").textValue()))))
                        .getText();
                //System.out.println(vendordetails);
                if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                    policyDetailsWebElement = vendorList;
                    String locator = testData.get("buyPlanProd");
                    String sumAssured = driver.findElement(By
                            .xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 GridPremiumBlock__Policy-sc-1unv6ai-0 cCnvog gridouterblock']//div[2][@id='"+locator+"']//div[2]//div[2]//span")).getText();
                    String premiumAmountCheck = driver.findElement(By
                            .xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 GridPremiumBlock__Policy-sc-1unv6ai-0 cCnvog gridouterblock']//div[2][@id='"+locator+"']//div[2]//div[3]//h4")).getText();
                    String str = premiumAmountCheck.replaceAll("[^0-9]", "");
                    String vendorName  = driver.findElement(By
                            .xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 GridPremiumBlock__Policy-sc-1unv6ai-0 cCnvog gridouterblock']//div[2][@id='"+locator+"']//div[3]//div[1]//label")).getText();
                    String AmbulanceCover  = driver.findElement(By
                            .xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 GridPremiumBlock__Policy-sc-1unv6ai-0 cCnvog gridouterblock']//div[2][@id='"+locator+"']//div[4]//span")).getText();
                    String str2 = AmbulanceCover.replaceAll("[^0-9]", "");
                    //String TenureYears  = driver.findElement(By
                    //	.xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 GridPremiumBlock__Policy-sc-1unv6ai-0 cCnvog gridouterblock']//div[2][@id='"+locator+"']//div[9]//div")).getText();

                    //System.out.println("suminsured"+sumAssured);
                    //System.out.println("Premiumamountcheck"+str);
                    System.out.println("vendorName"+vendorName);
                    //System.out.println("AmbulanceCover"+str2);


                    WebElement plandetails = wait
                            .until(ExpectedConditions.elementToBeClickable(vendorList.findElement(
                                    By.className(locatorsMap.get("PlanDetails").get("locator").textValue()))));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plandetails);
                    executor.executeScript("arguments[0].click();", plandetails);

                    String premium  = driver.findElement(By
                            .xpath("//*[@class='Row-sc-1gzf1pn-0 HealthPremiumBreakupGrid__PolicyTitle-sc-1m2xe3h-4 dywmYe']//div[2]/h4")).getText();
                    String str1 = premium.replaceAll("[^0-9]", "");
                    System.out.println("premium amount is inside"+str1);

                    org.testng.Assert.assertEquals(str, str1);
                    System.out.println("premium amount is displayed correctly");

                    String vendorName1  = driver.findElement(By
                            .xpath("//*[@class='Div__StyledDiv-sc-1k1pj6y-0 gfnlGf Grid-sc-77ibbl-0 gLiixy']")).getText();
                    String vendorNameuppercase=vendorName1.toUpperCase();

                    //System.out.println("Premiumamountcheckinside"+str1);
                    System.out.println("vendorName is"+""+vendorNameuppercase);

                    WebElement closebutton=wait
                            .until(ExpectedConditions.elementToBeClickable(vendorList.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section/div/div[1]/div[4]/div/div/div[3]/div[2]/button/img"))));
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    js.executeScript("arguments[0].click()", closebutton);

                    //	Assertion checking
					/*	Assert.assertEquals(testData.get("checkinsuredamount"), sumAssured);
						System.out.println("SumInsured value is displayed correctly");

						Assert.assertEquals(testData.get("checkpremiumamount"), str);
						System.out.println("premiumamount amount is displayed correctly");

						Assert.assertEquals(testData.get("checkpremiumamount"), str1);
						System.out.println("AfterClicking plandetails the premiumamount amount is displayed correctly");

						Assert.assertEquals(testData.get("checkambulancecover"), str2);
						System.out.println("Ambulancecover is displayed correctly");

						Assert.assertEquals(testData.get("checkvendorname"), vendorNameuppercase);
						System.out.println("VendorName is displayed correctly");

						Assert.assertEquals(testData.get("checkvendorname"), vendorName);
						System.out.println("AfterClicking plandetails the VendorName is displayed correctly");*/

                }}
        }
        if (policyDetailsWebElement != null) {
            WebElement quotespremiumblock = null;
            WebElement quotespremiumamount = null;
            String quotesPremium = null;
            quotespremiumblock = wait.until(ExpectedConditions.visibilityOf(policyDetailsWebElement.findElement(
                    By.className(locatorsMap.get("healthpremiumAmount").get("locator").textValue()))));
            quotesPremium = quotespremiumblock.getText();
            String str = quotesPremium.replaceAll("[^0-9]", "");
            testData.put("healthquotesPremium", str);
            System.out.println("premium amount is"+testData.put("healthquotesPremium", str));

        }
        else
        {
           // testCaseSkipException(driver);

        }
    }
   /* @Test(enabled = false)
    public void testCaseSkipException(WebDriver driver )  {
        System.out.println("expected vendor not avilable at this moment");
        String currentUrl=driver.getCurrentUrl();
        System.out.println("Quotesurl:"+currentUrl);
        driver.quit();
        throw new SkipException("Expected vendor not available quotes url "+ currentUrl);
    }*/
   @When("^User clicks the buy button as \"([^\"]*)\"$")
   public void user_clicks_the_buy_button_as(String arg1) throws Throwable {
       //quotespage.user_click_the_buy_button(arg1);
       Map<String, String> testData = testdata.getTestDataInMap();
       if (!testData.get("isToBeCompared").equalsIgnoreCase("yes")) {
           getSafeElement();
           System.out.println("buyPlan");
           WebDriverWait wait = new WebDriverWait(driver, 200);
           Actions act = new Actions(driver);
           JavascriptExecutor executor = (JavascriptExecutor) driver;
           String vendorId = null;
           WebElement policyDetailsWebElement = null;
           try {
               Thread.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
//           	System.out.println("the values"+locatorsMap.get("gridouterblock"));
           if (wait.until(ExpectedConditions.urlContains("/quotes/"))) {
               List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                       By.className(locatorsMap.get("gridouterblock").get("locator").textValue())));
               //System.out.println("elelelelel"+findElements.size());
               for (WebElement vendorList : findElements) {
                   vendorId = wait
                           .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                   By.className(locatorsMap.get("gridinnerblock").get("locator").textValue()))))
                           .getAttribute("id");

                   if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                       policyDetailsWebElement = vendorList;


                       getSafeElementmin();
                       WebElement parrentBlock = wait
                               .until(ExpectedConditions.elementToBeClickable(vendorList.findElement(
                                       By.className(locatorsMap.get("parrentbuyblock").get("locator").textValue()))));
                       WebElement clickBuy = wait.until(ExpectedConditions.elementToBeClickable(parrentBlock
                               .findElement(By.className(locatorsMap.get("clickbuy").get("locator").textValue()))));
                       //WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(clickBuy
                       //			.findElement(By.className(locatorsMap.get("buybtn").get("locator").textValue()))));
                       WebElement buy=wait.until(ExpectedConditions.elementToBeClickable(clickBuy
                               .findElement(By.className(locatorsMap.get("buybtn").get("locator").textValue()))));
                       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buy);
                       //yourElement.click();
                       executor.executeScript("arguments[0].click();", buy);
                       //	wait.until(ExpectedConditions.elementToBeClickable(buy));
                       System.out.println("clicked");
                   }

               }
           } else {
               org.testng.Assert.fail("Please check not in Quotes Page");
           }
           if (policyDetailsWebElement != null) {
           } else {
               System.out.println("Going to refresh");
               driver.navigate().refresh();
               try {
                   Thread.sleep(9000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               List<WebElement> allElements = driver
                       .findElements(By.className(locatorsMap.get("gridouterblock").get("locator").textValue()));
               getSafeElement();
               for (WebElement vendorList : allElements) {
                   getSafeElementmin();
                   vendorId = wait
                           .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                   By.className(locatorsMap.get("gridinnerblock").get("locator").textValue()))))
                           .getAttribute("id");
                   System.out.println("vendorId=="+vendorId);
                   if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                       policyDetailsWebElement = vendorList;
                       break;

                   }
               }
               if (policyDetailsWebElement != null) {
                   System.out.println("Comming ");
                   WebElement parrentBlock = wait.until(ExpectedConditions
                           .elementToBeClickable(policyDetailsWebElement.findElement(By.className(
                                   locatorsMap.get("parrentbuyblock").get("locator").textValue()))));
                   WebElement clickBuy = wait
                           .until(ExpectedConditions.elementToBeClickable(parrentBlock.findElement(
                                   By.className(locatorsMap.get("clickbuy").get("locator").textValue()))));
                   WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(clickBuy
                           .findElement(By.className(locatorsMap.get("buybtn").get("locator").textValue()))));
                   System.out.println("clicked");
                   executor.executeScript("arguments[0].click();", buy);
               }
              /* else {
                   takesScreenShot(driver, testData);
                   System.out.println(testData.get("testNo") + " after reload actual vendor in quotes page "
                           + vendorId + " expected vendor " + testData.get("buyPlanProd"));
                   System.out.println(driver.getCurrentUrl());
                   testCaseSkipException(driver);
               }*/
           }
       } System.out.println("clickedd"+testData.get("healthquotesPremium"));

   }
   // Car flow stepdefinitions
   @Given("^User edit the IDV value as \"([^\"]*)\"$")
   public void user_edit_the_IDV_value_as(String arg1) throws Throwable {
       Map<String, String> testData = testdata.getTestDataInMap();
       WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
       if (wait.until(ExpectedConditions.urlContains("quotes"))) {
           if (StringUtils.isNotEmpty(testData.get("editIdv"))) {
               getSafeElement();
               getSafeElement();
               getSafeElement();
               System.out.println("editIdv");
               WebElement selectIdv = wait.until(ExpectedConditions.elementToBeClickable(
                       driver.findElement(By.className(locatorsMap.get("selectIDV").get("locator").textValue()))));
               WebElement idvEdit = wait.until(ExpectedConditions.elementToBeClickable(
                       selectIdv.findElement(By.className(locatorsMap.get("editidv").get("locator").textValue()))));
               idvEdit.click();
               WebElement idvinput = wait
                       .until(ExpectedConditions.visibilityOf(idvEdit.findElement(By.tagName("input"))));
               idvinput.sendKeys(testData.get("editIdv"));
               WebElement idvSubmit = wait.until(ExpectedConditions.elementToBeClickable(
                       driver.findElement(By.className(locatorsMap.get("idvsubmit").get("locator").textValue()))));
               idvSubmit.click();
               getSafeElement();
           }
       } else {
           System.out.println("Enquiry page having issue");
       }
   }

    @Given("^User choose the PAOwnerDriver option as \"([^\"]*)\"$")
    public void user_choose_the_PAOwnerDriver_option_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (StringUtils.isNoneEmpty(testData.get("isPAOwnerDriver"))) {
            if (testData.get("isPAOwnerDriver").equalsIgnoreCase("no") && loaderClass(driver)) {
                System.out.println("is PAOwnerDriver");
                JavascriptExecutor exe = (JavascriptExecutor) driver;
                WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
                WebElement inputaddress = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.className(locatorsMap.get("paownerdriver").get("locator").textValue()))));
                System.out.println("inputaddress"+inputaddress.getText());
                WebElement click=inputaddress.findElement(By.tagName("span"));
                exe.executeScript("arguments[0].click();", click);

            }
        }
    }

    @Given("^User select the policy type as \"([^\"]*)\"$")
    public void user_select_the_policy_type_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if (StringUtils.isNotEmpty(testData.get("policytype")) && testData.get("policytype") != null) {
            System.out.println("Enter into policy type");
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            WebElement policyType = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className(locatorsMap.get("policyType").get("locator").textValue())));
            if ("liability".equalsIgnoreCase(testData.get("policytype"))) {
                WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
                        By.className(locatorsMap.get("policyType_liability").get("locator").textValue())));
                executor.executeScript("arguments[0].click();", ele);
                getSafeElement();
                getSafeElement();
            } else if ("odonly".equalsIgnoreCase(testData.get("policytype"))) {
                WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(driver
                        .findElement(By.className(locatorsMap.get("policyType_odonly").get("locator").textValue()))));
                executor.executeScript("arguments[0].click();", ele);
                System.out.println("odonly");
                getSafeElement();
                getSafeElement();
            }
        }
    }

    @Given("^User select the vahicleowned by option$")
    public void user_select_the_vahicleowned_by_option() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("isCompany");
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if ("yes".equalsIgnoreCase(testData.get("isCompany"))) {
            WebElement ele = wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(By.className(locatorsMap.get("companyyes").get("locator").textValue()))));
            // ele.click();
            executor.executeScript("arguments[0].click();", ele);
            getSafeElement();
            getSafeElement();
        } else {
            // WebElement ele = wait.until(ExpectedConditions.visibilityOf(
            // driver.findElement(By.className(locatorsMap.get("companyno").get("locator").textValue()))));
            // ele.click();
            // executor.executeScript("arguments[0].click();", ele);
        }
    }

   /* @Given("^User select the addon as \"([^\"]*)\"$")
    public void user_select_the_addon_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        try {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            if (testData.get("addonstatus").equalsIgnoreCase("yes")) {
                System.out.println("selectaddon");
                getSafeElement();
                if (driver.getCurrentUrl().contains("/quotes/")
                ) {
                    if (!testData.get("category").equalsIgnoreCase("bike")
                            && !testData.get("policytype").equalsIgnoreCase("Liability")) {
                        WebElement showmore = wait.until(ExpectedConditions.visibilityOf(driver
                                .findElement(By.className((locatorsMap.get("showmore").get("locator").textValue())))));
                        exe.executeScript("arguments[0].click();", showmore);
                        //	showmore.click();
                    }
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_ZERO_DEPRICIATION, driver,
                            testData.get("AC-COVER-ZERO_DEPRICIATION"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_24x7_ROADSIDE_ASSISTANCE, driver,
                            testData.get("AC-COVER-24x7_ROADSIDE_ASSISTANCE"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_DRIVER_COVER, driver,
                            testData.get("AC-COVER-DRIVER_COVER"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_ENGINE_PROTECTOR, driver,
                            testData.get("AC-COVER-ENGINE_PROTECTOR"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_NCB_PROTECTION, driver,
                            testData.get("AC-COVER-NCB_PROTECTION"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_DAILY_ALLOWANCE, driver,
                            testData.get("AC-COVER-DAILY_ALLOWANCE"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_INVOICE_COVER, driver,
                            testData.get("AC-COVER-INVOICE_COVER"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_KEY_AND_LOCK_REPLACEMENT, driver,
                            testData.get("AC-COVER-KEY_AND_LOCK_REPLACEMENT"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_CONSUMABLES, driver,
                            testData.get("AC-COVER-CONSUMABLES"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_BAGGAGE_COVER, driver,
                            testData.get("AC-COVER-BAGGAGE_COVER"));
                    checkboxaddon(testData, CarQuotesPageUtils.AC_COVER_COVER_FOR_ROAD_TAX, driver,
                            testData.get("AC-COVER-COVER_FOR_ROAD_TAX"));
                    dropdownaddon(testData, CarQuotesPageUtils.AC_COVER_PASSENGER_COVER, driver,
                            testData.get("AC-COVER-PASSENGER_COVER"), testData.get("AC-COVER-PASSENGER_COVER_VAL"));
                    dropdownaddon(testData, CarQuotesPageUtils.AC_COVER_PA_TO_PAID_DRIVER, driver,
                            testData.get("AC-COVER_PA_TO_PAID_DRIVER"), testData.get("AC-COVER_PA_TO_PAID_DRIVER_VAL"));
                }
                {
                    //	System.out.println("Quotes not loaded properly");
                }
            } else {
                System.out.println("no addon selected");
            }
        } catch (InterruptedException ee) {
            // TODO Auto-generated catch block
            ee.printStackTrace();
        }

    }*/

    @And("^User select the multitenure option as \"([^\"]*)\"$")
    public void user_select_the_multitenure_option_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (isNullOrEmpty(testData.get("policyterm"))) {
            getSafeElement();
            System.out.println("Selcet multiteneure policyterm");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
            System.out.println("selectMultitenure");
            getSafeElementmin();
            getSafeElement();
            for (WebElement vendorList : driver
                    .findElements(By.className(locatorsMap.get("policyouterlist").get("locator").textValue()))) {
                String vendorId = vendorList
                        .findElement(By.className(locatorsMap.get("policyinnerlist").get("locator").textValue()))
                        .getAttribute("id");
                if (vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                    String data = testData.get("policyterm");
                    switch (data) {
                        case "1":
                            WebElement oneyearod = wait.until(ExpectedConditions.visibilityOf(driver
                                    .findElement(By.id(locatorsMap.get("oneyearod").get("locator").textValue()))));
                            executor.executeScript("arguments[0].click();", oneyearod);
                            break;
                        case "2":
                            WebElement twoyearod = wait.until(ExpectedConditions.visibilityOf(driver
                                    .findElement(By.id(locatorsMap.get("twoyearod").get("locator").textValue()))));
                            executor.executeScript("arguments[0].click();", twoyearod);
                            break;
                        case "3":
                            System.out.println("#3 Year");
                            WebElement threeyearod = wait.until(ExpectedConditions.visibilityOf(driver
                                    .findElement(By.id(locatorsMap.get("threeyearod").get("locator").textValue()))));
                            executor.executeScript("arguments[0].click();", threeyearod);
                            break;
                        case "5":
                            System.out.println("#5 Year");
                            WebElement fiveyearod = wait.until(ExpectedConditions.visibilityOf(driver
                                    .findElement(By.id(locatorsMap.get("fiveyearod").get("locator").textValue()))));
                            executor.executeScript("arguments[0].click();", fiveyearod);
                            break;
                        default:
                            System.out.println("Multitenure is not applicable");
                            break;
                    }
                    break;
                }else
                {
                }
            }
        } else {
        }
    }

    @Then("^User get the quotes details$")
    public void user_get_the_quotes_details() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        System.out.println("getquotesdetails");
        getSafeElement();
        getSafeElement();
        getSafeElementmin();
        WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
        String vendorId = null;
        WebElement policyDetailsWebElement = null;
        WebElement quotesrtoblock = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("quotesrtoblock").get("locator").textValue()))));
        WebElement quotesrtodetails = wait.until(ExpectedConditions.visibilityOf(quotesrtoblock
                .findElement(By.className(locatorsMap.get("quotesrtodetails").get("locator").textValue()))));
        String quotesrtocode = quotesrtodetails.getText();
        WebElement quotesvehicledetails = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className(locatorsMap.get("quotesvehicledetails").get("locator").textValue()))));
        WebElement quotesmakemodel = wait.until(ExpectedConditions.visibilityOf(quotesvehicledetails
                .findElement(By.className(locatorsMap.get("quotesmakemodel").get("locator").textValue()))));
        String getmakemodel = quotesmakemodel.getText();
        if (driver.getCurrentUrl().contains("/quotes/")
        ) {
            try {
                List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElements(driver
                        .findElements(By.className(locatorsMap.get("policyouterlist").get("locator").textValue()))));
                for (WebElement vendorList : findElements) {
                    getSafeElementmin();
                    vendorId = wait
                            .until(ExpectedConditions.elementToBeClickable(vendorList.findElement(
                                    By.className(locatorsMap.get("policyinnerlist").get("locator").textValue()))))
                            .getAttribute("id");
                    System.out.println("vendorId----"+vendorId);
                    if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                        policyDetailsWebElement = vendorList;
                    }
                }
            }
            catch(Exception e)
            {
            }
        }
        if (policyDetailsWebElement != null) {
            WebElement quotespremiumblock = null;
            WebElement quotespremiumamount = null;
            String quotesPremium = null;
            quotespremiumblock = wait.until(ExpectedConditions.visibilityOf(policyDetailsWebElement.findElement(
                    By.className(locatorsMap.get("quotespremiumblock").get("locator").textValue()))));
            quotespremiumamount = wait
                    .until(ExpectedConditions.visibilityOf(quotespremiumblock.findElement(By.className(
                            locatorsMap.get("quotespremiumamount").get("locator").textValue()))));
            quotesPremium = quotespremiumamount.getText();
            String str = quotesPremium.replaceAll("[^0-9]", "");
            System.out.println(testData.get("testNo")+"_"+ "else stmt for premium"+quotesPremium);
            testData.put("quotesPremium", str);
        }
        else
        {
            testCaseSkipException(driver);
            driver.quit();

        }
        testData.put("quotesrtocode", quotesrtocode);
        testData.put("quotesmakemodel", getmakemodel);
    }

    @And("^User select the compare page$")
    public void user_select_the_compare_page() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (testData.get("toBeCompared").equalsIgnoreCase("YES")) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
                System.out.println("selectcomparePage");
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                if (testData.containsKey("toBeCompared") && testData.get("toBeCompared") != null
                        && testData.get("toBeCompared").equalsIgnoreCase("YES")) {
                    boolean value = checkPoliciesForCompare(testData, driver, false, false);
                    if (value) {
                        WebElement comparePage = wait.until(ExpectedConditions.elementToBeClickable(driver
                                .findElement(By.className(locatorsMap.get("comparepage").get("locator").textValue()))));
                        WebElement comparenow = wait
                                .until(ExpectedConditions.elementToBeClickable(comparePage.findElement(
                                        By.className(locatorsMap.get("comparebutton").get("locator").textValue()))));
                        executor.executeScript("arguments[0].click();", comparenow);
                    } else {
                        System.out.println("unable to compare");
                    }
                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } else {
        }
    }

    @And("^User click the buy from compare page$")
    public void user_click_the_buy_from_compare_page() throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (testData.get("toBeCompared").equalsIgnoreCase("yes")) {
            System.out.println("buyfromComparePage");
            WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
            List<WebElement> allvendor = driver
                    .findElements(By.className(locatorsMap.get("compareindividual").get("locator").textValue()));
            for (WebElement ele : allvendor) {
                String vendorId = ele.getAttribute("id");
                if (testData.get("buyFromCompareBottom").equals(vendorId)) {
                    WebElement comparebuy = wait
                            .until(ExpectedConditions.elementToBeClickable(ele.findElement(By.id(vendorId))));
                    wait.until(ExpectedConditions.elementToBeClickable(comparebuy)).click();
                }

            }

        } else {
        }
    }
    @Given("^User clicks the motor buy button as \"([^\"]*)\"$")
    public void User_clicks_the_motor_buy_button_as(String arg1) throws Throwable {
        Map<String, String> testData = testdata.getTestDataInMap();
        if (!testData.get("toBeCompared").equalsIgnoreCase("yes")) {
            System.out.println("buyPlan motor");
            WebDriverWait wait = new WebDriverWait(driver, MAXX_TIMEOUT);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            String vendorId = null;
            WebElement policyDetailsWebElement = null;
            if (driver.getCurrentUrl().contains("/quotes/")
            ) {
                getSafeElement();

                List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElements(driver
                        .findElements(By.className(locatorsMap.get("policyouterlist").get("locator").textValue()))));
                for (WebElement vendorList : findElements) {
                    vendorId = wait
                            .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                    By.className(locatorsMap.get("policyinnerlist").get("locator").textValue()))))
                            .getAttribute("id");
                    if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                        policyDetailsWebElement = vendorList;
                    }
                }
            }
            if (policyDetailsWebElement != null) {
                if (testData.get("policytype").equalsIgnoreCase("Liability")) {
                }
                WebElement buy = policyDetailsWebElement
                        .findElement(By.className(locatorsMap.get("clickbuy").get("locator").textValue()));
                executor.executeScript("arguments[0].click();", buy);
            } else {
                System.out.println("Going to refresh");
                driver.navigate().refresh();
                getSafeElement();
                getSafeElement();
                try {
                    Thread.sleep(13000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Refreshed done");
                List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElements(driver
                        .findElements(By.className(locatorsMap.get("policyouterlist").get("locator").textValue()))));
                for (WebElement vendorList : findElements) {
                    vendorId = wait
                            .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                    By.className(locatorsMap.get("policyinnerlist").get("locator").textValue()))))
                            .getAttribute("id");
                    getSafeElementmin();
                    if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(testData.get("buyPlanProd"))) {
                        policyDetailsWebElement = vendorList;
                    }
                }
                if (policyDetailsWebElement != null) {
                    WebElement buy = policyDetailsWebElement
                            .findElement(By.className(locatorsMap.get("clickbuy").get("locator").textValue()));
                    executor.executeScript("arguments[0].click();", buy);
                } else {
                    takesScreenShot(driver, testData);
                    System.out.println(testData.get("testNo") + " after reload actual vendor in quotes page " + vendorId
                            + " expected vendor " + testData.get("buyPlanProd"));
                    System.out.println(driver.getCurrentUrl());
                    testCaseSkipException(driver);
                }
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
    private void takesScreenShot(WebDriver driver, Map<String, String> testData) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File source = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/" + testData.get("testNo") + "_"
                    + testData.get("category") + "_" + generateTimeStamp() + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public String generateTimeStamp() {
        String timeStamp = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        return timeStamp;
    }
    @Test(enabled = false)
    public void testCaseSkipException(WebDriver driver )  {
        System.out.println("expected vendor not avilable at this moment");
        String currentUrl=driver.getCurrentUrl();
        System.out.println("Quotesurl:"+currentUrl);
        driver.quit();
        throw new SkipException("Expected vendor not available quotes url "+ currentUrl);
    }
/**
 * <p>
 * This method used for check policy compare page .
 *</p>
 **/
 public boolean checkPoliciesForCompare(Map<String, String> testData, WebDriver driver,
                                           boolean isErrorSimulationForMin, boolean isErrorSimulationForMax) throws InterruptedException {

        System.out.println("checkPoliciesForCompare");
        int compareCount = 0;
        if (driver.getCurrentUrl().contains("/quotes/")
                && loaderClass(driver)) {
            getSafeElement();
            String product1 = testData.containsKey("compareProd1") ? testData.get("compareProd1") : null;
            String product2 = testData.containsKey("compareProd2") ? testData.get("compareProd2") : null;
            String product3 = testData.containsKey("compareProd3") ? testData.get("compareProd3") : null;
            if (StringUtils.isNotEmpty(product2)) {
                compareCount++;
                clickCompare(testData, driver, product1);
            }
            if (StringUtils.isNotEmpty(product2) && (!isErrorSimulationForMin || compareCount == 0)) {
                compareCount++;
                clickCompare(testData, driver, product2);
            }
            // if (!isErrorSimulationForMin || compareCount == 0) {
            // System.out.println("third loop");
            // compareCount++;
            // clickCompare(testData, driver, product3);
            // }

        }
        if (isCompareCountValid(compareCount)) {
            System.out.println("compareCount=" + compareCount);
            System.out.println("isCompareCountValid true");
            return true;
        } else {
            System.out.println("isCompareCountValid false");
            return false;
        }

    };
    private boolean isCompareCountValid(int compareCount) {
        if (compareCount > 1 && compareCount <= 3) {
            return true;
        }
        return false;
    }
  /**
 *  * <p>
 * This method used for click the compare button.
 *  *</p>
 *  **/
    public void clickCompare(Map<String, String> testData, WebDriver driver, String productCode) {
        String vendorId = null;
        WebElement policyDetailsWebElement = null;
        WebDriverWait wait = new WebDriverWait(driver, MIN_TIMEOUT);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        if (StringUtils.isNotEmpty(productCode)) {
            List<WebElement> findElements = driver
                    .findElements(By.className(locatorsMap.get("policyouterlist").get("locator").textValue()));
            for (WebElement vendorList : findElements) {
                vendorId = wait
                        .until(ExpectedConditions.visibilityOf(vendorList.findElement(
                                By.className(locatorsMap.get("policyinnerlist").get("locator").textValue()))))
                        .getAttribute("id");
                if (StringUtils.isNotEmpty(vendorId) && vendorId.equalsIgnoreCase(productCode)) {
                    policyDetailsWebElement = vendorList;
                }
            }

        }
        if (policyDetailsWebElement != null) {

            WebElement ee = wait.until(ExpectedConditions.visibilityOf(policyDetailsWebElement
                    .findElement(By.className(locatorsMap.get("addcompare").get("locator").textValue()))));
            executor.executeScript("arguments[0].click();", ee);
        } else {
            System.out.println("Expected to compare vendor not avilable quotes page");
        }

    }
    public boolean loaderClass(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        //	WebElement loaderclass = wait.until(ExpectedConditions.visibilityOf(driver
        //			.findElement(By.className(locatorsMap.get("beforeloader").get("locator").textValue()))));
        System.out.println("KDLDLD");
        if( wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.className("loadingclass")))))
        {
            return true;
        }
        return false;

    }
}
