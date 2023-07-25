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
    And   User select policy claim status "<claimed>"
    And   User select the vehicle ownership change status in zoop flow "<claimed>"
    And   User select the value of NCB status in zoop flow "<ncb_protector>"
    And   User select the NCB percentage in zoop flow "<NCB%>"
    Then  User clicks the submit button
    Examples:
      | manufacturer_year | reg_date | exp_date |claimed|claimed|ncb_protector|NCB%|
      |3223               |3232      |3232      |       |       |             |    |
  @enquiry_without_zoop
  Scenario Outline: Validation of enquiry page without zoop
    Given User select the vehicle name as "<make_model>"
    When  User select the vehicle fuel type as "<fuel_type>"
    And   User select the vehicle variant "<variant>"
    And   USer select the vehicle manufacturing year "<manufacture_year>"
    And   User clicks on the next button
    And   User edits the registration date as "<reg_date>"
    And   User clicks on the next button
    And   User select policy claim status as "<claimed>"
    And   User clicks on the next button
    And   User select the vehicle ownership change status as "<ownership>"
    And   User clicks on the next button
    And   User select the value of NCB status as "<ncb_protector>"
    Then  User check the filled register number
    Then  User check the filled vehicle name
    Then  User check the selected vehicle registration date
    Then  User check the selected  policy expiry date
    Then  User check the selected  policy claim status
    Then  User check the selected  vehicle ownership change status
    Then  User check the selected  NCB value
    Then  User get the enquiry summary details
    Then  User clicks the submit button
    Examples:
      | make_model | fuel_type | variant | manufacture_year |reg_date|claimed|ownership|ncb_protector|
      |232           |32@#  |3232             |32332     |2332             | |         |             |
  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    And    User edit the IDV value as "<edit_idv>"
    And    User choose the PAOwnerDriver option as "<is_PAowner_driver>"
    And    User select the policy type as "<policytype>"
    And    User select the vahicleowned by option
  #  And    User select the addon as "<addon_status>"
    And    User select the multitenure option as "<policy_term>"
    Then   User get the quotes details
    And    User select the compare page
    And    User click the buy from compare page
    When   User clicks the motor buy button as "<product_id>"
    Examples:
      | edit_idv        |is_PAowner_driver|policytype|addon_status|policy_term|product_id|
      |                 |                 |          |            |           |          |
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
      |   email_id          | mobile_no     |pan_number|otp|dob|otp|
      | arunp@mailinator.com |8248036306     |CWJPA7854M|2345|09/09/1997||

  @personal_tab
  Scenario Outline: Personal tab
    Given User verify the KYC status
    When  User enters the first name as "<first_name>"
    And   User enters the last name as "<last_name>"
    And   User select the marital status as "<marital_status>"
    And   User select the gender as "<gender>"
    And   User select the occupation as "<occupation>"
    And   User enters the nominee firstname as "<nominee_firstName>"
    And   User enters the nominee lastname as "<nominee_lastName>"
    And   User select the nominee relationship as "<nominee_relationship>"
    And   user enters the nominee age as "<nominee_age>"
    And   User clicks on the next button
    Examples:
      | first_name | last_name |nominee_firstName  | nominee_lastName |nominee_relationship  | nominee_age |marital_status|gender|occupation|
      |karthick    |a          |karthick           | a                | Sibling              |     22      |yes |           male     |      |
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
    Given User selects the existing policy insurer "<insurer_value>"
    When  User enters the existing policy number as "<policy_number>"
    And   User select the loan provider as "<is_loan_provider>"
    And   User select the loan provider value "<loan_provider_value>"
    And   User enters the engine number as "<engine_number>"
    And   User enters the chassis number as "<chassis_number>"
    And   User clicks on the next button
    Examples:
      | insurer_value | policy_number | is_loan_provider |loan_provider_value|engine_number|chassis_number|
      |               |               |                  |                   |             |              |

  @checkout_summary_page
  Scenario: Checkout summary page
    Given  User is landed on the Checkout Summary page
    Then   User check the summary firstname
    Then   User check the summary gender
    Then   User check the summary occupation
    Then   User check the summary DOB
    Then   User check the summary married status
    Then   User check the summary aadhar
    Then   User check the summary nominee firstname
    Then   User check the summary nominee age
    Then   User check the summary nominee relationship
    Then   User check the summary mobile number
    Then   User check the summary email id
    Then   User check the summary vehicle name
    Then   User check the summary vehicle number
    Then   User check the summary engine and chasis number
    When   User clicks on the terms and condition checkbox
    And    User clicks on the pay button
    Then   User is redirected to the vendor site
