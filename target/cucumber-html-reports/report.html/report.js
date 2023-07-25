$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/car/renewal/expired/comprehensive/individual/hdfc/hdfc_comprehensive.feature");
formatter.feature({
  "line": 1,
  "name": "car insurance renewal",
  "description": "",
  "id": "car-insurance-renewal",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#  @login_consumer"
    },
    {
      "line": 4,
      "value": "#  Scenario Outline: Login into consumer account"
    },
    {
      "line": 5,
      "value": "#    Given : User is landed into the Application successfully"
    },
    {
      "line": 6,
      "value": "#    When  : user clicks on the login button"
    },
    {
      "line": 7,
      "value": "#    When  : User clicks on consumer login button"
    },
    {
      "line": 8,
      "value": "#    When  : User enters the email id \"\u003cemail_id\u003e\""
    },
    {
      "line": 9,
      "value": "#    When  : User clicks on send otp button"
    },
    {
      "line": 10,
      "value": "#    When  : User enters the otp as \"\u003cotp\u003e\""
    },
    {
      "line": 11,
      "value": "#    When  : User clicks on verify otp button"
    },
    {
      "line": 12,
      "value": "#    Then  :User landed on the homepage successfully"
    },
    {
      "line": 13,
      "value": "#    Examples:"
    },
    {
      "line": 14,
      "value": "#      |  email_id           |  otp  |"
    },
    {
      "line": 15,
      "value": "#      | karthick@mailinator.com|  2345 |"
    }
  ],
  "line": 20,
  "name": "To validate whether user is landed on the homepage",
  "description": "",
  "id": "car-insurance-renewal;to-validate-whether-user-is-landed-on-the-homepage",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@home_page"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "User select the product as \"\u003cproductType\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "User enter the car number as \"\u003ccar_number\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User clicks on Get Quotes button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User verify the zoop status",
  "keyword": "Then "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "car-insurance-renewal;to-validate-whether-user-is-landed-on-the-homepage;",
  "rows": [
    {
      "cells": [
        "productType",
        "car_number"
      ],
      "line": 26,
      "id": "car-insurance-renewal;to-validate-whether-user-is-landed-on-the-homepage;;1"
    },
    {
      "cells": [
        "car",
        "TN-34-AY-2345"
      ],
      "line": 27,
      "id": "car-insurance-renewal;to-validate-whether-user-is-landed-on-the-homepage;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 27,
  "name": "To validate whether user is landed on the homepage",
  "description": "",
  "id": "car-insurance-renewal;to-validate-whether-user-is-landed-on-the-homepage;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@home_page"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "User select the product as \"car\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "User enter the car number as \"TN-34-AY-2345\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User clicks on Get Quotes button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User verify the zoop status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "car",
      "offset": 28
    }
  ],
  "location": "Homepage.user_select_the_product_as(String)"
});
formatter.result({
  "duration": 214402666,
  "error_message": "java.lang.NullPointerException\n\tat java.util.Objects.requireNonNull(Objects.java:203)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:106)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:85)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\n\tat com.arka.e2etest.stepdefinitions.Homepage.user_select_the_product_as(Homepage.java:87)\n\tat ✽.Given User select the product as \"car\"(src/test/resources/features/car/renewal/expired/comprehensive/individual/hdfc/hdfc_comprehensive.feature:21)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "TN-34-AY-2345",
      "offset": 30
    }
  ],
  "location": "Homepage.user_enter_the_car_number_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Homepage.user_clicks_on_Get_Quotes_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Homepage.user_verify_the_zoop_status()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 30,
  "name": "Validation of enquiry page with zoop",
  "description": "",
  "id": "car-insurance-renewal;validation-of-enquiry-page-with-zoop",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@enquiry_with_zoop"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "User edits the zoop manufacturer year as \"\u003cmanufacturer_year\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "User edits the zoop registration date as \"\u003creg_date\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User edits the zoop policy expiry date as \"\u003cexp_date\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "User clicks the proceed button",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "User select policy claim status \"\u003cclaimed\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "User select the vehicle ownership change status in zoop flow \"\u003cclaimed\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User select the value of NCB status in zoop flow \"\u003cncb_protector\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "User select the NCB percentage in zoop flow \"\u003cNCB%\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "User clicks the submit button",
  "keyword": "Then "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "car-insurance-renewal;validation-of-enquiry-page-with-zoop;",
  "rows": [
    {
      "cells": [
        "manufacturer_year",
        "reg_date",
        "exp_date",
        "claimed",
        "claimed",
        "ncb_protector",
        "NCB%"
      ],
      "line": 41,
      "id": "car-insurance-renewal;validation-of-enquiry-page-with-zoop;;1"
    },
    {
      "cells": [
        "3223",
        "3232",
        "3232",
        "",
        "",
        "",
        ""
      ],
      "line": 42,
      "id": "car-insurance-renewal;validation-of-enquiry-page-with-zoop;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 42,
  "name": "Validation of enquiry page with zoop",
  "description": "",
  "id": "car-insurance-renewal;validation-of-enquiry-page-with-zoop;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 29,
      "name": "@enquiry_with_zoop"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "User edits the zoop manufacturer year as \"3223\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "User edits the zoop registration date as \"3232\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User edits the zoop policy expiry date as \"3232\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "User clicks the proceed button",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "User select policy claim status \"\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "User select the vehicle ownership change status in zoop flow \"\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User select the value of NCB status in zoop flow \"\"",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "User select the NCB percentage in zoop flow \"\"",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "User clicks the submit button",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3223",
      "offset": 42
    }
  ],
  "location": "Enquirypage.user_edits_the_zoop_manufacturer_year_as(String)"
});
formatter.result({
  "duration": 6704875,
  "error_message": "java.lang.NullPointerException\n\tat java.util.Objects.requireNonNull(Objects.java:203)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:106)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:85)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\n\tat com.arka.e2etest.stepdefinitions.Enquirypage.user_edits_the_zoop_manufacturer_year_as(Enquirypage.java:352)\n\tat ✽.Given User edits the zoop manufacturer year as \"3223\"(src/test/resources/features/car/renewal/expired/comprehensive/individual/hdfc/hdfc_comprehensive.feature:31)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "3232",
      "offset": 42
    }
  ],
  "location": "Enquirypage.user_edits_the_zoop_registration_date_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "3232",
      "offset": 43
    }
  ],
  "location": "Enquirypage.user_edits_the_zoop_policy_expiry_date_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enquirypage.user_clicks_the_proceed_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 33
    }
  ],
  "location": "Enquirypage.user_select_policy_claim_status(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 62
    }
  ],
  "location": "Enquirypage.user_select_the_vehicle_ownership_change_status_in_zoop_flow(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 50
    }
  ],
  "location": "Enquirypage.user_select_the_value_of_NCB_status_in_zoop_flow(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 45
    }
  ],
  "location": "Enquirypage.user_select_the_NCB_percentage_in_zoop_flow(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enquirypage.user_clicks_the_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 70,
  "name": "Quotes page",
  "description": "",
  "id": "car-insurance-renewal;quotes-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 69,
      "name": "@quotes_page"
    }
  ]
});
formatter.step({
  "line": 71,
  "name": "User is landed on the quotes page successfully",
  "keyword": "Given "
});
formatter.step({
  "line": 72,
  "name": "User edit the IDV value as \"\u003cedit_idv\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "User choose the PAOwnerDriver option as \"\u003cis_PAowner_driver\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "User select the policy type as \"\u003cpolicytype\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "User select the vahicleowned by option",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 76,
      "value": "#  And    User select the addon as \"\u003caddon_status\u003e\""
    }
  ],
  "line": 77,
  "name": "User select the multitenure option as \"\u003cpolicy_term\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "User get the quotes details",
  "keyword": "Then "
});
formatter.step({
  "line": 79,
  "name": "User select the compare page",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User click the buy from compare page",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User clicks the motor buy button as \"\u003cproduct_id\u003e\"",
  "keyword": "When "
});
formatter.examples({
  "line": 82,
  "name": "",
  "description": "",
  "id": "car-insurance-renewal;quotes-page;",
  "rows": [
    {
      "cells": [
        "edit_idv",
        "is_PAowner_driver",
        "policytype",
        "addon_status",
        "policy_term",
        "product_id"
      ],
      "line": 83,
      "id": "car-insurance-renewal;quotes-page;;1"
    },
    {
      "cells": [
        "",
        "",
        "",
        "",
        "",
        ""
      ],
      "line": 84,
      "id": "car-insurance-renewal;quotes-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 84,
  "name": "Quotes page",
  "description": "",
  "id": "car-insurance-renewal;quotes-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 69,
      "name": "@quotes_page"
    }
  ]
});
formatter.step({
  "line": 71,
  "name": "User is landed on the quotes page successfully",
  "keyword": "Given "
});
formatter.step({
  "line": 72,
  "name": "User edit the IDV value as \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "User choose the PAOwnerDriver option as \"\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "User select the policy type as \"\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "User select the vahicleowned by option",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 76,
      "value": "#  And    User select the addon as \"\u003caddon_status\u003e\""
    }
  ],
  "line": 77,
  "name": "User select the multitenure option as \"\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "User get the quotes details",
  "keyword": "Then "
});
formatter.step({
  "line": 79,
  "name": "User select the compare page",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User click the buy from compare page",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User clicks the motor buy button as \"\"",
  "matchedColumns": [
    5
  ],
  "keyword": "When "
});
formatter.match({
  "location": "Quotespage.user_is_landed_on_the_quotes_page_successfully()"
});
formatter.result({
  "duration": 6817500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 28
    }
  ],
  "location": "Quotespage.user_edit_the_IDV_value_as(String)"
});
formatter.result({
  "duration": 166458,
  "error_message": "java.lang.NullPointerException\n\tat java.util.Objects.requireNonNull(Objects.java:203)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:106)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:85)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\n\tat com.arka.e2etest.stepdefinitions.Quotespage.user_edit_the_IDV_value_as(Quotespage.java:283)\n\tat ✽.And User edit the IDV value as \"\"(src/test/resources/features/car/renewal/expired/comprehensive/individual/hdfc/hdfc_comprehensive.feature:72)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 41
    }
  ],
  "location": "Quotespage.user_choose_the_PAOwnerDriver_option_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 32
    }
  ],
  "location": "Quotespage.user_select_the_policy_type_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Quotespage.user_select_the_vahicleowned_by_option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 39
    }
  ],
  "location": "Quotespage.user_select_the_multitenure_option_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Quotespage.user_get_the_quotes_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Quotespage.user_select_the_compare_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Quotespage.user_click_the_buy_from_compare_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 37
    }
  ],
  "location": "Quotespage.User_clicks_the_motor_buy_button_as(String)"
});
formatter.result({
  "status": "skipped"
});
});