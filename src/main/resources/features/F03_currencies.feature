@smoke
Feature: F03_currencies | users could change the website currency to Euro

  Scenario: user could change products currency to Euro
    Given user changed currency to "Euro"
    Then homepage products are changed to "Euro"