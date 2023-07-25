Feature: car insurance renewal

#  @login_consumer
#  Scenario Outline: Login into consumer account
#    Given : User is landed into the Application successfully
#    When  : user clicks on the login button
#    When  : User clicks on consumer login button
#    When  : User enters the email id "<email_id>"
#    When  : User clicks on send otp button
#    When  : User enters the otp as "<otp>"
#    When  : User clicks on verify otp button
#    Then  :User landed on the homepage successfully
#    Examples:
#      |  email_id           |  otp  |
#      | karthick@mailinator.com|  2345 |



  @home_page
  Scenario Outline:To validate whether user is landed on the homepage
    Given User select the product as "<productType>"
    When  User enter the car number as "<car_number>"
    And   User clicks on Get Quotes button
    Then  User verify the zoop status
    Examples:
      | productType | car_number |
      |car         |TN-34-AY-2345|

  @enquiry_with_zoop
  Scenario Outline: Validation of enquiry page with zoop
    Given User edits the zoop manufacturer year as "<manufacturer_year>"
    When  User edits the zoop registration date as "<reg_date>"
    And   User edits the zoop policy expiry date as "<exp_date>"
    And   User clicks the proceed button
    And   User select policy claim status
    And   User select the vehicle ownership change status in zoop flow
    And   User select the value of NCB status in zoop flow
    And   User select the NCB percentage in zoop flow
    Then  User clicks the submit button
    Examples:
      | manufacturer_year | reg_date | exp_date |
      |3223               |3232      |3232      |
  @enquiry_without_zoop

  Scenario Outline: Validation of enquiry page without zoop
    Given User select the vehicle name as "<vehicle_name>"
    When  User select the vehicle fuel type as "<fuel>"
    And   User select the vehicle variant "<vehicle_variant>"
    And   USer select the vehicle manufacturing year "<manufacturer_year>"
    And   User clicks on the next button
    And   User edits the registration date as "<reg_date>"
    And   User clicks on the next button
    And   User select policy claim status
    And   User clicks on the next button
    And   User select the vehicle ownership change status
    And   User clicks on the next button
    And   User select the value of NCB status
    Then  User check the filled register number
    Then  User check the filled vehicle name
    Then  User check the selected vehicle registration date
    Then  User check the selected  date

    Then  User clicks the submit button
    Examples:
      | vehicle_name | fuel | vehicle_variant | reg_date |manufacturer_year|
      |232           |32@#  |3232             |32332     |2332             |
  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    Then   User collects the quotes details
    When   User clicks the buy button as "<product_id>"
    Examples:
      | product_id        |

  @checkout_page
  Scenario Outline: Checkout page
    Given  User enters the pan card number as "<pan_number>"
    When   User enters the dob as "<dob>"
    And    User enters the email id as "<email_id>"
    And    User enters the mobile number as "<mobile_no>"
    Then   User verify the quotes page and checkout page premium amount
    When   User clicks the next button in contact tab
    And    User verify the otp as "<otp>"
    Examples:
      |   email_id          | mobile_no     |pan_number|otp|dob|
      | arunp@mailinator.com |8248036306     |CWJPA7854M|2345|09/09/1997|

  @personal_tab
  Scenario Outline: Personal tab
    Given User enters the first name as "<first_name>"
    When  User enters the last name as "<last_name>"
    And   User upload the photo proof
    Then  User verify the proof upload status
    And   User clicks on the next button
    Examples:
      | first_name | last_name |

  @communication_tab
  Scenario Outline: Communication tab
    Given User enter the pincode "<string>" and select the area "<string>"
    When  User enter the address line one "<address1>" and address line two "<address2>"
    Then  User verify the postal code
    And   User clicks on the next button
    Examples:
      | string | address1 | address2 |

  @vehicle_tab

  Scenario Outline: Vehicle tab
    Given User selects the existing policy insurer
    When  User enters the existing policy number as "<policy_number>"
    And   User enters the engine number as "<engine_number>"
    And   User enters the chassis number as "<chassis_number>"
    And   User enters the existing liability policy start date as "<start_date>"
    And   User enters the existing liability policy end date as "<end_date>"
    And   User clicks on the next button
    Examples:
      | policy_number | engine_number | chassis_number | start_date | end_date |


  @checkout_summary_page
  Scenario: Checkout summary page
    Given  User is landed on the Checkout Summary page
    When   User clicks on the terms and condition checkbox
    And    User clicks on the pay button
    Then   User is redirected to the vendor site
