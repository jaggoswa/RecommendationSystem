Feature: Director Filter
  The user want to get recommendations of movies from some director

  Scenario: Filters, Director Filter
    Given the director names
    When we have a movie id
    Then we want to check if given directors are the directors of that movie