@smoke
  Feature: F05_hoverCategories | user can hover on the main categories and click on sub categories

    Scenario: user can hover on Electronics menu and go to Cell phones sub category
      Given user hovers on "Electronics" main category
      When user clicks on "Cell phones" sub category
      Then "Cell phones" page is opened