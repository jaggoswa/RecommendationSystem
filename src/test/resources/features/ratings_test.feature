Feature: Get Recommendations in order
  The user want to get movie recommendations in sorted order of similarity ratings

  Scenario: Ratings, Generate Sorted recommendations
    Given rater id,number of similar raters and minimum raters
    When we have a list of movie id and similarity ratings
    Then we want to check if we are getting correct recommendations in sorted order