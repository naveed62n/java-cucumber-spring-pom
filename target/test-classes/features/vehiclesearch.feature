Feature: Validate vehicle search

  Scenario: Search vehicle exists
  
    Given the "Get vehicle information from DVLA - GOV.UK" home page is accessible
    When a user clicks the start button
    Then the "Check if a vehicle is taxed and has an MOT" titled page is provided
    When a user submits the vehicle registration from "vehiclesearch.csv" and clicks continue
    Then the vehicle confirmation page is provided
    When the user validates the displayed registration to the search registration from "vehiclesearch.csv"
     And the user confirms registration details yes on the screen and clicks continue
    Then the vehicle details screen is presented with the searched registration details from "vehiclesearch.csv"


