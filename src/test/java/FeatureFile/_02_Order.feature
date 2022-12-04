Feature: Login Functionality

  Background:

    Given Naviagate to Luma
    And Enter email and password and click Login button
    Then User should login successfuly

  Scenario: Order Functionality
    And Click product
      | backPack          |
      | addToCart         |
      | shopingCart       |
      | proceedtoCheckout |
      | ratioButton       |
      | nextButton        |
      | checkBox          |
      | checkBox          |
      | placeOrderButton  |

    And Order successfully




















































  # And Fill the form
  # |  streetInput |
  # |  cityInput |
  # |  postcodeInput |
  # |  phoneNumberInput |
  # And Click product
  # | countrySelect |
  # | countryUnitedStatesSelect |
  # | stateSelect |
  # | stateSelectAlabama |
  # | shipHereButton |
  # | ratioButton |
  # | nextButton |
  # | placeOrderButton |



