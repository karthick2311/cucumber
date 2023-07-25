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
      | productType | whom_to_Cover |
      |  Health     | My Parents    |

  @enquiry_page
  Scenario Outline: Enquiry page
    Given  User is landed on the enquiry creation page successfully
    When   User select the sum insured value as "<sum_insured>"
    When   User enter the pincode "<pin_code>" and select the area "<area_name>"
    When   User clicks on the next button
    When   User enters the dob for father as "<father_dob>"
    When   User enters the dob for mother as "<mother_dob>"
    When   User clicks the submit button

    Examples:
      |  sum_insured| pin_code  |  area_name               |  father_dob  | mother_dob |
      |  3 to 5 Lacs|  600001   | CHENNAI G.P.O. - CHENNAI |  02/02/1970  | 08/10/1971 |

  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    Then   User is collect quotes details
    When   User clicks the buy button as "<product_id>"
    Examples:
      | product_id                                |
      |veK5SHBrTIx6TvUNu9VYc5f8BSlWwGtHVNm_sihW6l8|



  @checkout_page
  Scenario Outline: Contact tab
    Given  User is landed on the checkout page
    Then   User verify the quotes page and checkout page premium amount
    When   User enter the address line one "<address1>" and address line two "<address2>"
    When   User select the city name as "<city_name>"
    When   User select the area name as "<area_name>"
    When   User enters the proposer dob as "<proposer_dob>"
    When   User enters the pan card number as "<pan_number>"
    When   User enters the email id as "<email_id>"
    When   User enters the mobile number as "<mobile_no>"
    When   User select the ID proof "<address_proof>"
    When   User enter the ID proof number "<address_proof_number>"
    When   User clicks the next button in contact tab
    When   User verify the otp as "<otp>"

    Examples:
      | address1 | address2 |   email_id          | mobile_no     |city_name|area_name|proposer_dob   |pan_number  |address_proof    |address_proof_number|otp  |
      | stanley  | hospital |arunm@mailinator.com |8838517743     | Chennai |  Parrys |   20-02-1995  | CWJPA6789N | Driving License | TN012019000276     | 2345|



  @proposer_tab
  Scenario Outline: Proposer tab
    Given  User is navigated to the proposer tab
    When   User enters the self firstname as "<first_name>"
    When   User enters the self lastname as "<last_name>"
    When   User enters the annual income as "<annual_income>"
    When   User enters the aadhaar number as "<aadhar_number>"
    When   User select the self occupation as "<proposer_occupation>"
    When   User select the income source as "<income_source>"
    When   User enters the family member firstname as "<family_member_firstName>"
    When   User enters the family member lastname as "<family_member_lastName>"
    When   User select the family member relationship as "<family_member_relationship>"
    When   User select the  pep question as "<pep>"
    When   User select the address proof "<address_proof>"
    When   User enter the address proof number "<address_proof_number>"
    When   User upload the star address proof
    When   User upload the proposer recent photo proof
    When   User upload the proposer form 60
    When   User enters the nominee firstname as "<nominee_firstName>"
    When   User enters the nominee lastname as "<nominee_lastName>"
    When   User select the nominee relationship as "<nominee_relationship>"
    When   user enters the nominee age as "<nominee_age>"
    When   User clicks the next button in proposer tab
    Examples:
      | first_name | last_name |annual_income  |pep|aadhar_number |income_source|family_member_firstName  | family_member_lastName |family_member_relationship |address_proof     |address_proof_number|pep  |nominee_firstName|nominee_lastName |nominee_relationship|nominee_age |proposer_occupation|
      | arun       |pragathish | 5             |No |307625633466  |Salary       |Mani                     | M                      | Father                    |  Driving License |  TN012019000276    |NO   | Karthick       |       a          |   Brother          |    22      |Business  |


  @insured_member_tab
  Scenario Outline: Insured member tab
    Given  User is navigated to the insured member tab
    When   User enters the mother first name as "<mother_first_name>"
    When   User enters the mother last name as "<mother_last_name>"
    When   User enters the mother weight as "<mother_weight>"
    When   User select the mother height in feet as "<mother_height_feet>"
    When   User select the mother occupation as "<mother_occupation>"
    When   User click the mother collapsetab
    When   User click the father collapsetab
    When   User enters the father first name as "<father_first_name>"
    When   User enters the father last name as "<father_last_name>"
    When   User enters the father weight as "<father_weight>"
    When   User select the father height in feet as "<father_height_feet>"
    When   User select the father occupation as "<father_occupation>"

    When   User clicks the next button in insured member tab
    Examples:
      | mother_first_name |mother_last_name|mother_weight|mother_height_feet|mother_occupation   |father_first_name|father_last_name|father_weight|father_height_feet|father_occupation  |
      |  vanshika         |  a             |61           |  6               |PROFESSIONAL-ENGINEER|kiran            |j               |72           |6                 |PROFESSIONAL-ENGINEER|

  @questionnaire_tab
  Scenario: Questionnaire history tab
    Given  User is navigated to the questionnaire tab
    When   User clicks the next button in questionnaire tab

  @checkout_summary_page
  Scenario: Checkout summary page
    Given  User is landed on the Checkout Summary page
    When  User is change the premium year
    When   User clicks on the terms and condition checkbox
    When   User clicks on the pay button
    Then  User check the vendorURL






