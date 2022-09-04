@smoke
  Feature: F08_Wishlist | user can add products to his wishlist

    Scenario: user can add HTC One M8 Android L 5.0 Lollipop to the wishlist
      Given user clicks on add to wishlist button for product "HTC One M8 Android L 5.0 Lollipop"
      Then success message appears to acknowledge the addition

    Scenario: user can add HTC One M8 Android L 5.0 Lollipop to the wishlist page
      Given user clicks on add to wishlist button for product "HTC One M8 Android L 5.0 Lollipop"
      And user waits for success message to disappear
      And user clicks on wishlist link on top menu
      Then product quantity in wishlist is higher than 0