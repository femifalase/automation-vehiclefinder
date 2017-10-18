Feature: Confirm the details of vehicle

  @Vehicle
  Scenario Outline: check entered vehicle details are correct
    Given a user opens the vehicle homepage
    When the user enters registration number for <vehicle>
    Then display a page with the vehicle information
    Examples:
      | vehicle |
      | 1       |
      | 2       |
      | 3       |