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
    And   User select the vehicle ownership change status
    And   USer select the value of NCB status
    Then  User clicks the submit button
    Examples:
      | manufacturer_year | reg_date | exp_date |
      |3223               |3232      |3232      |
  @enquiry_without_zoop

  Scenario Outline: Validation of enquiry page without zoop

    Given User select the vehicle name as "<vehicle_name>"
    When  User select the vehicle fuel type as "<fuel>"
    And   User select the vehicle variant "<vehicle_variant>"
    And   USer select the vehicle manufacturing year "manufacturer_year"
    And   User clicks on the next button
    And   User edits the registration date as "<reg_date>"
    And   User clicks on the next button
    And   User select policy claim status
    And   User clicks on the next button
    And   User select the vehicle ownership change status
    And   User clicks on the next button
    And   USer select the value of NCB status
    Then  User clicks the submit button
    Examples:
      | vehicle_name | fuel | vehicle_variant | reg_date |
|232           |32@#  |3232             |32332     |

#  @quotes_page
#  Scenario Outline: Quotes page
#    Given  User is landed on the quotes page successfully
#    Then   User collects the quotes details
#    When   User clicks the buy button as "<product_id>"
#    Examples:
#      | product_id        |
#|9393               |
#
#
#
#
#
#




