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
    When  User select the product as "<product_type>"
    When  User select the insured person as "<whom_to_Cover>"
    When  User clicks on Get Quotes button

    Examples:
      | product_type   | whom_to_Cover    |
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
    When  User add the first son
    When  User enters the dob for first son as "<dob_firstson>"
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

  @enquiry_with_son1_son2_son3
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the first son
    When  User add the second son
    When  User add the Thirdson
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstson as "<dob_son1>"
    When  User enters the dob for secondson as "<dob_son2>"
    When  User enters the dob for thirdson as "<dob_son3>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_son2|dob_son3|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|06/09/2016|

  @enquiry_with_son1_son2_son3_son4
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the firstson
    When  User add the secondson
    When  User add the Thirdson
    When  User add the fourthson
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstson as "<dob_son1>"
    When  User enters the dob for secondson as "<dob_son2>"
    When  User enters the dob for thirdson as "<dob_son3>"
    When  User enters the dob for fourthson as "<dob_son4>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_son2|dob_son3|dob_son4|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|06/09/2016|06/09/2016|

  @enquiry_with_daughter1
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the firstson
    When  User add the firstdaughter
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstdaughter as "<dob_daughter1>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_daughter1|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|

  @enquiry_with_daughter1_daughter2
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the firstson
    When  User add the firstdaughter
    When  User add the seconddaughter
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstdaughter as "<dob_daughter1>"
    When  User enters the dob for seconddaughter as "<dob_daughter2>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_daughter1|dob_daughter2|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|

  @enquiry_with_son1_daughter1
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the firstson
    When  User add the firstdaughter
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstson as "<dob_son1>"
    When  User enters the dob for firstdaughter as "<dob_daughter1>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_daughter1|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|

  @enquiry_with_son1_son2_daughter1_daughter2
  Scenario Outline: Enquiry page
    Given User is landed on the enquiry creation page successfully
    When  User select the sum insured value as "<sum_insured>"
    When  User enter the pincode "<pin_code>" and select the area "<area_name>"
    When  User clicks on the next button
    When  User add the firstson
    When  User add the secondson
    When  User add the firstdaughter
    When  User add the second daughter
    When  User select the self gender as "<gender>"
    When  User enters the dob for self as "<dob_self>"
    When  User enters the dob for spouse as "<dob_spouse>"
    When  User enters the dob for firstson as "<dob_son1>"
    When  User enters the dob for secondson as "<dob_son2>"
    When  User enters the dob for firstdaughter as "<dob_daughter1>"
    When  User enters the dob for second daughter as "<dob_daughter2>"
    When  User clicks the submit button
    Examples:
      | pin_code  |  dob_self  | dob_spouse|sum_insured|area_name|gender|dob_son1|dob_daughter1|dob_son2|dob_daughter2|
      |  600001   | 08/08/1996 | 06/06/1998  | 3 to 5 Lacs |CHENNAI G.P.O. - CHENNAI|Male|06/09/2016|06/09/2016|06/09/2016|06/09/2016|


  @quotes_page
  Scenario Outline: Quotes page
    Given  User is landed on the quotes page successfully
    When   User clicks the buy button as "<product_id>"
    Examples:
      | product_id |
      |1DHG1mpfuCb1Z2LYDZN5_vxEXg3BBpKZNFFZi8PrJYs|

  @checkout_page
  Scenario Outline: Checkout page
    Given  User is landed on the checkout page
    When   User enter the address line one "<addressline1>" and address line two "<addressline2>"
    When   User enters the pan card number as "<pan_number>"
    When   User enters the email id as "<email_id>"
    When   User enters the mobile number as "<mobile_no>"
    When   User clicks the next button in contact tab
    When   User verify the otp as "<otp>"

    Examples:
      | addressline1 | addressline2 |   email_id              | mobile_no     |pan_number|otp|
      | stanley      | hospital     |karthitest@mailinator.com|8344307156     |CWJPA6392n|2345|

  @proposer_tab
  Scenario Outline: Proposer tab
    Given  User is navigated to the proposer tab
    When   User enters the self firstname as "<first_name>"
    When   User enters the self lastname as "<last_name>"
    When   User uploads the Identity proof
    When   User upload the address proof
    When   User enters the nominee firstname as "<nominee_firstName>"
    When   User enters the nominee lastname as "<nominee_lastName>"
    When   User select the nominee relationship as "<nominee_relationship>"
    When   user enters the nominee age as "<nominee_age>"
    When   User clicks the next button in proposer tab
    Examples:
      | first_name | last_name |  nominee_firstName | nominee_lastName |   nominee_age |nominee_relationship|
      | arun       |pragathish | karthick           | a                |       22      |   Father           |

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
    When   User click the spouse collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|
      |  76         |  6      | 2       |maala           |       kumar   |    56       |    6      |       2   |
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
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User click the secondson collapsetab
    When   User enter the secondson firstname as "<son2_firstname>"
    When   User enter the secondson lastname as "<son2_lastname>"
    When   User enters the secondson weight as "<so2_weight>"
    When   User select the secondson height in feet as "<son2_feet>"
    When   User click the secondson collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|son2_firstname|son2_lastname|so2_weight|son2_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

  @insured_member_tab_with_son1_son2_son3
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
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User click the secondson collapsetab
    When   User enter the secondson firstname as "<son2_firstname>"
    When   User enter the secondson lastname as "<son2_lastname>"
    When   User enters the secondson weight as "<so2_weight>"
    When   User select the secondson height in feet as "<son2_feet>"
    When   User click the secondson collapsetab
    When   User click the thirdson collapsetab
    When   User enter the thirdson firstname as "<son3_firstname>"
    When   User enter the thirdson lastname as "<son3_lastname>"
    When   User enters the thirdson weight as "<so3_weight>"
    When   User select the thirdson height in feet as "<son3_feet>"
    When   User click the thirdson collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|son2_firstname|son2_lastname|so2_weight|son2_feet|son3_firstname|son3_lastname|so3_weight|son3_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

  @insured_member_tab_with_son1_son2_son3_son4
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
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User click the secondson collapsetab
    When   User enter the secondson firstname as "<son2_firstname>"
    When   User enter the secondson lastname as "<son2_lastname>"
    When   User enters the secondson weight as "<so2_weight>"
    When   User select the secondson height in feet as "<son2_feet>"
    When   User click the secondson collapsetab
    When   User click the thirdson collapsetab
    When   User enter the thirdson firstname as "<son3_firstname>"
    When   User enter the thirdson lastname as "<son3_lastname>"
    When   User enters the thirdson weight as "<so3_weight>"
    When   User select the thirdson height in feet as "<son3_feet>"
    When   User click the thirdson collapsetab
    When   User click the fourthson collapsetab
    When   User enter the fourthson firstname as "<son4_firstname>"
    When   User enter the fourthson lastname as "<son4_lastname>"
    When   User enters the fourthson weight as "<so4_weight>"
    When   User select the fourthson height in feet as "<son4_feet>"
    When   User click the fourthson collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|son2_firstname|son2_lastname|so2_weight|son2_feet|son3_firstname|son3_lastname|so3_weight|son3_feet|son4_firstname|son4_lastname|son4_weight|son4_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

  @insured_member_tab_with_daugher1
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
    When   User click the spouse collapsetab
    When   User click the firstdaugher collapsetab
    When   User enter the firstdaugher firstname as "<daugher1_firstname>"
    When   User enter the firstdaugher lastname as "<daugher1_lastname>"
    When   User enters the firstdaugher weight as "<daugher1_weight>"
    When   User select the firstdaugher height in feet as "<daugher1_feet>"
    When   User click the firstdaugher collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|daugher1_firstname|daugher1_lastname|daugher1_weight|daugher1_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |  karthi|arun         |45        |6        |

  @insured_member_tab_with_daugher1_daughter2
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
    When   User click the spouse collapsetab
    When   User click the firstdaugher collapsetab
    When   User enter the firstdaugher firstname as "<daugher1_firstname>"
    When   User enter the firstdaugher lastname as "<daugher1_lastname>"
    When   User enters the firstdaugher weight as "<daugher1_weight>"
    When   User select the firstdaugher height in feet as "<daugher1_feet>"
    When   User click the firstdaugher collapsetab
    When   User click the seconddaugher collapsetab
    When   User enter the seconddaugher firstname as "<daugher1_firstname>"
    When   User enter the seconddaugher lastname as "<daugher1_lastname>"
    When   User enters the seconddaugher weight as "<daugher1_weight>"
    When   User select the seconddaugher height in feet as "<daugher1_feet>"
    When   User click the seconddaugher collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|daugher1_firstname|daugher1_lastname|daugher1_weight|daugher1_feet|daugher2_firstname|daugher2_lastname|daugher2_weight|daugher2_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |  karthi|arun         |45        |6        |karthi|arun         |45        |6        |

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
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User click the firstdaugher collapsetab
    When   User enter the firstdaugher firstname as "<daugher1_firstname>"
    When   User enter the firstdaugher lastname as "<daugher1_lastname>"
    When   User enters the firstdaugher weight as "<daugher1_weight>"
    When   User select the firstdaugher height in feet as "<daugher1_feet>"
    When   User click the firstdaugher collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|spouse_occupation|son1_firstname|son1_lastname|so1_weight|son1_feet|daugher1_firstname|daugher1_lastname|daugher1_weight|daugher1_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |   PROFESSIONAL-DOCTOR |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

  @insured_member_tab_with_son1_son2_daughter1_daughter2
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
    When   User click the spouse collapsetab
    When   User click the firstson collapsetab
    When   User enter the firstson firstname as "<son1_firstname>"
    When   User enter the firstson lastname as "<son1_lastname>"
    When   User enters the firstson weight as "<so1_weight>"
    When   User select the firstson height in feet as "<son1_feet>"
    When   User click the firstson collapsetab
    When   User click the secondson collapsetab
    When   User enter the secondson firstname as "<son1_firstname>"
    When   User enter the secondson lastname as "<son1_lastname>"
    When   User enters the secondson weight as "<so1_weight>"
    When   User select the secondson height in feet as "<son1_feet>"
    When   User click the secondson collapsetab
    When   User click the firstdaugher collapsetab
    When   User enter the firstdaugher firstname as "<daugher1_firstname>"
    When   User enter the firstdaugher lastname as "<daugher1_lastname>"
    When   User enters the firstdaugher weight as "<daugher1_weight>"
    When   User select the firstdaugher height in feet as "<daugher1_feet>"
    When   User click the firstdaugher collapsetab
    When   User click the seconddaugher collapsetab
    When   User enter the seconddaugher firstname as "<daugher2_firstname>"
    When   User enter the seconddaugher lastname as "<daugher2_lastname>"
    When   User enters the seconddaugher weight as "<daugher2_weight>"
    When   User select the seconddaugher height in feet as "<daugher2_feet>"
    When   User click the seconddaugher collapsetab
    When   User clicks the next button in insured member tab
    Examples:
      | self_weight |self_feet|self_inch|spouse_firstname|spouse_lastname|spouse_weight|spouse_feet|spouse_inch|son1_firstname|son1_lastname|so1_weight|son1_feet|daugher1_firstname|daugher1_lastname|daugher1_weight|daugher1_feet|daugher2_firstname|daugher2_lastname|daugher2_weight|daugher2_feet|
      |  76    |  6    | 2|maala                         |       kumar |    56         |    6       |       2    |karthi|arun         |45        |6        |karthi|arun         |45        |6        |karthi|arun         |45        |6        |

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

