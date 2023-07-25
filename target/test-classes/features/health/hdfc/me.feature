Feature: health feature testing

  @login_consumer
  Scenario Outline: Login into consumer account
    Given User is landed into the Application successfully
    When  user clicks on the login as "<login_type>"
    When  User enters the mobile or email as "<mobile_number_or_email_id>"
    When  User enters the otp as "<otp>"
    Examples:
      |  mobile_number_or_email_id           |  otp  |login_type|
      | 8838517743|  2345 |Consumer|

  @home_page
  Scenario Outline:
  To validate whether user is landed on the homepage
    Given User landed on the homepage successfully
    When  User select the product as "<productType>"
    When  User select the insured person as "<whom_to_Cover>"
    When  User clicks on Get Quotes button
    Examples:
      | productType |   whom_to_Cover  |
      |  Health     |         Me       |

  @enquiry_page
  Scenario Outline: Enquiry page
    Given  User is landed on the enquiry creation page successfully
    When   User select the sum insured value as "<sum_insured>"
    When   User enter the pincode "<pin_code>" and select the area "<area_name>"
    When   User clicks on the next button
    When   User enters the dob for self as "<dob_self>"
    When   User clicks the submit button

    Examples:
      |  sum_insured| pin_code  |  area_name               |    dob_self   |
      |  3 to 5 Lacs|  600001   | CHENNAI G.P.O. - CHENNAI |   08/08/1996  |

  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    Then   User is collect quotes details
    When   User clicks the buy button as "<product_id>"
    Examples:
      | product_id                                |
      |OW7bTa4WLt9ySWtkrOUaxlinZp9T8hwoL-mQ0_1Jeug|



  @checkout_page
  Scenario Outline: Contact tab
    Given  User is landed on the checkout page
    Then   User verify the quotes page and checkout page premium amount
    When   User enter the address line one "<address1>" and address line two "<address2>"
    When   User enters the proposer dob as "<proposer_dob>"
    When   User enters the pan card number as "<pan_number>"
    When  User enters the email id as "<email_id>"
    When  User enters the mobile number as "<mobile_no>"
    When   User clicks the next button in contact tab
    When   User verify the otp as "<otp>"
    Examples:
      | address1 | address2 |   email_id          | mobile_no     |proposer_dob| pan_number |otp|
      | noor     | hotel    |arunm@mailinator.com |8838517743     | 09/09/1997 | CWJPA6392N |2345|


  @proposer_tab
  Scenario Outline: Proposer tab
    Given  User is navigated to the proposer tab
    When   User enters the self firstname as "<first_name>"
    When   User enters the self lastname as "<last_name>"
    When   User select the self gender as "<gender>"
    When   User enters the nominee firstname as "<nominee_firstName>"
    When   User enters the nominee lastname as "<nominee_lastName>"
    When   User select the nominee relationship as "<nominee_relationship>"
    When   user enters the nominee age as "<nominee_age>"
    When   User clicks the next button in proposer tab
    Examples:
      | first_name | last_name  |gender |nominee_firstName  | nominee_lastName |nominee_relationship  | nominee_age |
      | arun       |pragathish  |Male   |karthick           | a                | Sibling              |     22      |


  @insured_member_tab
  Scenario Outline: Insured member tab
    Given  User is navigated to the insured member tab
    When   User enters the self weight as "<self_weight>"
    When   User select the self height in feet as "<self_feet>"
    When   User select the self height in inch as "<self_inch>"
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|
      |  76         |  6      | 2       |

  @questionnaire_tab
  Scenario: Questionnaire history tab
    Given  User is navigated to the questionnaire tab
    When   User clicks the next button in questionnaire tab
  @checkout_summary_page
  Scenario: Checkout summary page
    Given User is landed on the Checkout Summary page
    When  User is change the premium year
    When  User clicks on the terms and condition checkbox
    When  User clicks on the pay button
    When  User check the vendorURL


 

