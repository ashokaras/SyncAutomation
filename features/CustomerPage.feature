Feature: Validating customer page

  @customerName
  Scenario Outline: Validate customer name
    Given i login application
    When i navigate to customer page
    Then i validate customer name with '<customerName>' as '<validation>' data
    And i quit browser

    Examples:
    |customerName|validation|
    |ashoklordatgmaildotcom|positive   |
    |a                     |negative   |

  @gstNumber
  Scenario Outline: Validate customer GST number
    Given i login application
    When i navigate to customer page
    Then i validate gst number with '<gstNumber>'
    And i quit browser

    Examples:
      |gstNumber|
      |one|