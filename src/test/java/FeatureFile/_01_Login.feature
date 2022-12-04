Feature: Login Functionality

  Background:
    Given Naviagate to Luma
    And And Click on the element in the Dialog
      | signin |

  Scenario Outline: Negatif Case

    And User sending the keys in Dialog content
      | email    | <email>    |
      | password | <password> |

    And And Click on the element in the Dialog
      | loginButton |

    Then Login unsuccessfuly

    Examples:
      | email           | password       |
      | lkdmvl@mail.com | Abcd1234       |
      | grub6@mail.com  | Passwdfwerword |

  Scenario Outline: Pozitif case

    And User sending the keys in Dialog content
      | email    | <email>    |
      | password | <password> |

    And And Click on the element in the Dialog
      | loginButton |

    Then User should login successfuly
    Examples:
      | email          | password |
      | grub6@mail.com | Abcd1234 |