package com.arka.e2etest.runner;

import com.arka.e2etest.base.BaseFunctions;
//import com.arka.e2etest.pageobjs.CheckoutPage;
import com.arka.e2etest.utils.ExcelHandler;
import com.arka.e2etest.utils.PropertiesFileReader;
import com.arka.e2etest.utils.TestDataHandler;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/car/renewal/expired/comprehensive/individual/hdfc/hdfc_comprehensive.feature",tags = {"@home_page,@enquiry_with_zoop,@quotes_page"},
		glue = "com/arka/e2etest/stepdefinitions",dryRun = false,
		plugin = {"html:target/cucumber-html-reports/report.html",
						    "json:target/report/cucumber-json.json",
						    "junit:target/cucumber-reports/cucumber-xml.xml",
						    "pretty"}
)

public class CucumberRunner extends BaseFunctions {
	protected static WebDriver driver;
	static PropertiesFileReader obj = new PropertiesFileReader();
	public static TestDataHandler testdata = new TestDataHandler();
	@BeforeClass
	public static void setUp() throws Throwable {
		BaseFunctions.readPropertyFile();
		BaseFunctions.setExtentReport();
		BaseFunctions.setBrowser(BaseFunctions.prop.getProperty("browserName").toString());
		BaseFunctions.getUrl();
		excel();
	}
	public static void excel() throws Exception {
		Properties properties = obj.getProperty();
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(properties.getProperty("testdatafilepath"), properties.getProperty("sheetname"), properties.getProperty("runtestcase"));
		testdata.setTestDataInMap(TestDataInMap);
	}
	@AfterClass
	public static void report() {
		BaseFunctions.extent.flush();
		//BaseFunctions.driver.quit();
	}
}

