@smoke
  Feature: F04_Search | user can search for products using the search bar

    Scenario Outline: user could search using product name
      Given user enters the "<productName>" in search bar
      When user clicks on search button
      Then search results page opens
      And every product in search page related to "<productName>"
      Examples:
        | productName |
        | book        |
        | laptop      |
        | nike        |

    Scenario Outline: user could search for product using sku
      Given user enters the "<sku>" in search bar
      When user clicks on search button
      And user clicks on the product related to sku
      Then product sku is similar to the search "<sku>"
      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|