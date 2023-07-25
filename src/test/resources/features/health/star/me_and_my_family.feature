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
      | productType | whom_to_Cover  |
      |  Health       | Me and My Family |


  @enquiry_page
  Scenario Outline: Enquiry page
    Given  User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User clicks the submit button

    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|

  @enquiry_with_son1
  Scenario Outline: Enquiry page with one son
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User add the firstson
    When  User enters the dob for firstson as "<dob_firstson>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse| dob_firstson |sum_insured|area_name|gender|
      |  600001   | 08/08/1996 | 06/06/1998  | 11/11/2018 | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|

  @enquiry_with_son1_son2
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the first son
    When  User add the second son
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for first son as "<dob_son1>"
    When  User enters the dob for second son as "<dob_son2>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_son2|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|

  @enquiry_with_son1_daughter1
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the first son
    When  User add the first daughter
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for first son as "<dob_son1>"
    When  User enters the dob for first daughter as "<dob_daughter1>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_daughter1|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|

  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    Then   User is collect quotes details
    When   User clicks the buy button as "<product_id>"
    Examples:
      | product_id |
      |veK5SHBrTIx6TvUNu9VYc5f8BSlWwGtHVNm_sihW6l8|

  @checkout_page
  Scenario Outline: Contact tab
    Given  User is landed on the checkout page
    Then   User verify the quotes page and checkout page premium amount
    When   User enter the address line one "<addressline1>" and address line two "<addressline2>"
    When   User select the city name as "<city_name>"
    When   User select the area name as "<area_name>"
    When   User enters the pan card number as "<pan_number>"
    When   User enters the email id as "<email_id>"
    When   User enters the mobile number as "<mobile_no>"
    When   User select the ID proof "<address_proof>"
    When   User enter the ID proof number "<address_proof_number>"
    When   User clicks the next button in contact tab
    When   User verify the otp as "<otp>"


    Examples:
      | addressline1 | addressline2 |pan_number  |address_proof   |address_proof_number|   email_id           | mobile_no     |city_name|area_name | otp|
      | stanley      | hospital     |CWJPA6785N  |Driving License |   TN012019000276   |arunm@mailinator.com  |8838517743     | Chennai |  Parrys  |2345|

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
    When   User enters the self weight as "<self_weight>"
    When   User select the self height in feet as "<self_feet>"
    When   User select the self height in inch as "<self_inch>"
    When   User click the self collapsetab
    When   User click the spouse collapsetab
    When   User enter the Spouse firstname as "<spouse_firstname>"
    When   User enter the Spouse lastname as "<spouse_lastname>"
    When   User enters the spouse weight as "<spouse_weight>"
    When   User select the spouse height in feet as "<spouse_feet>"
    When   User select the spouse height in inch as "<spouse_inch>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the spouse collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation      |
      |  76         |  6      |     2   |maala           |       kumar   |    56       |    6      |      2    |   PROFESSIONAL-DOCTOR |

  @insuredMember_tab_with_son1
  Scenario Outline: Insured member tab
    Given  User is navigated to the insured member tab
    When   User enters the self weight as "<self_weight>"
    When   User select the self height in feet as "<self_feet>"
    When   User select the self height in inch as "<self_inch>"
    When   User click the self collapsetab
    When   User click the spouse collapsetab
    When   User enter the Spouse firstname as "<spouse_firstname>"
    When   User enter the Spouse lastname as "<spouse_lastname>"
    When   User enters the spouse weight as "<spouse_weight>"
    When   User select the spouse height in feet as "<spouse_feet>"
    When   User select the spouse height in inch as "<spouse_inch>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |


  @insured_member_tab_with_son1_son2
  Scenario Outline: Insured member tab
    Given  User is navigated to the insured member tab
    When   User enters the self weight as "<self_weight>"
    When   User select the self height in feet as "<self_feet>"
    When   User select the self height in inch as "<self_inch>"
    When   User click the self collapsetab
    When   User click the spouse collapsetab
    When   User enter the Spouse firstname as "<spouse_firstname>"
    When   User enter the Spouse lastname as "<spouse_lastname>"
    When   User enters the spouse weight as "<spouse_weight>"
    When   User select the spouse height in feet as "<spouse_feet>"
    When   User select the spouse height in inch as "<spouse_inch>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the firstson collapsetab
    When   User click the secondson collapsetab
    When   User enter the secondson firstname as "<son2_firstname>"
    When   User enter the secondson lastname as "<son2_lastname>"
    When   User enters the secondson weight as "<so2_weight>"
    When   User select the secondson height in feet as "<son2_feet>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the secondson collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|son2_firstname|son2_lastname|so2_weight|son2_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

  @insured_member_tab_with_son1_daugher1
  Scenario Outline: Insured member tab
    Given  User is navigated to the insured member tab
    When   User enters the self weight as "<self_weight>"
    When   User select the self height in feet as "<self_feet>"
    When   User select the self height in inch as "<self_inch>"
    When   User click the self collapsetab
    When   User click the spouse collapsetab
    When   User enter the Spouse firstname as "<spouse_firstname>"
    When   User enter the Spouse lastname as "<spouse_lastname>"
    When   User enters the spouse weight as "<spouse_weight>"
    When   User select the spouse height in feet as "<spouse_feet>"
    When   User select the spouse height in inch as "<spouse_inch>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the firstson collapsetab
    When   User click the firstdaugher collapsetab
    When   User enter the firstdaugher firstname as "<daugher1_firstname>"
    When   User enter the firstdaugher lastname as "<daugher1_lastname>"
    When   User enters the firstdaugher weight as "<daugher1_weight>"
    When   User select the firstdaugher height in feet as "<daugher1_feet>"
    When   User select the spouse occupation as "<spouse_occupation>"
    When   User click the firstdaugher collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|daugher1_firstname|daugher1_lastname|daugher1_weight|daugher1_feet|
      |  76         |  6      |   2     |      maala     |         kumar |    56       |    6      |      2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

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


