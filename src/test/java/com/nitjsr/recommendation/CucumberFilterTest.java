package com.nitjsr.recommendation;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class CucumberFilterTest {

    DirectorsFilter dir_filter;
    String movie_id1, movie_id2;

    @Given("^the director names$")
    public void the_director_names(){
        dir_filter = new DirectorsFilter("Fred Cavayé");
    }

    @When("^we have a movie id$")
    public void we_have_a_movie_id(){
        movie_id1 = "3112654";
        movie_id2 = "1571222";
    }

    @Then("^we want to check if given directors are the directors of that movie$")
    public void we_want_to_check_if_given_directors_are_the_directors_of_that_movie(){
        Assert.assertEquals(true, dir_filter.satisfies(movie_id1));
        Assert.assertEquals(false, dir_filter.satisfies(movie_id2));;
    }

}
