Feature: Open Weather map with city

  Background: Launch the weather report site
    Given the home page of opens Weather map is displayed

  Scenario Outline: 1 Search the forcast with the city name
    When the user searches with <city_name>
    Then the Weather forcaste is displayed for the <city_name> on the page
    Examples:
      | city_name |
      | Dundee    |
      | Edinburgh |
      | Glasgow   |
      | Perth     |
      | Stirling  |

  Scenario Outline: 2 Search to get given no of days forcast for a given location
    When the user searches with <city_name>
    Then the user sees 5 days report
    Examples:
      | city_name |
      | Dundee    |
      | Edinburgh |
      | Glasgow   |
      | Perth     |
      | Stirling  |

  Scenario: 3 search with incorrect cityname
    When the user searches with invalid
    Then the error message "Error retrieving the forecast"

  @Temp1
  Scenario: 4 select a day for summary forcast
    When the user searches with Edinburgh
    Then the user click on EachDay for the sumary forcast


  Scenario: 5 Select a day twice temperature summary for the whole day should be hidden
    And the user searches with Perth
    When the user clicks to hide the summary info
    Then the weather forcast of whole day is not displayed

  Scenario: 6. Check if the temperature is rounded off
    And the user searches with Perth
    Then temperature values should be always displayed as roundedoff
