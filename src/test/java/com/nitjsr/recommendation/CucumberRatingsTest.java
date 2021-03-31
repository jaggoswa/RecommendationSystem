package com.nitjsr.recommendation;

import cucumber.api.java.en.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CucumberRatingsTest {
    String rater_id;
    int numSimilarRaters;
    int minimalRaters;
    ArrayList<Rating> expected;
    FourthRatings ratings;

    @Given("^rater id,number of similar raters and minimum raters$")
    public void rater_id_number_of_similar_raters_and_minimum_raters() {
        rater_id = "65";
        numSimilarRaters = 6;
        minimalRaters = 5;
    }

    @When("^we have a list of movie id and similarity ratings$")
    public void we_have_a_list_of_movie_id_and_similarity_ratings() {
        expected = new ArrayList<>();
        expected.add(new Rating("1979320",1383.2));
        expected.add(new Rating("1454468",1263.6));
        expected.add(new Rating("1905041",1246.33));
        expected.add(new Rating("1300854",1213.4));
        expected.add(new Rating("1483013",1012.6));
    }

    @Then("^we want to check if we are getting correct recommendations in sorted order$")
    public void we_want_to_check_if_we_are_getting_correct_recommendations_in_sorted_order() {
        ratings = new FourthRatings();
        ArrayList<Rating> actual = ratings.getSimilarRatings("65",6,5);
        assertEquals(expected,actual);
    }
}
