package com.nitjsr.recommendation;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class RatingsTest {

    @Test
    public void similarityRatingsTest() {
        FourthRatings ratings = new FourthRatings();
        ArrayList<Rating> expected = new ArrayList<>();
        expected.add(new Rating("1979320",1383.2));
        expected.add(new Rating("1454468",1263.6));
        expected.add(new Rating("1905041",1246.33));
        expected.add(new Rating("1300854",1213.4));
        expected.add(new Rating("1483013",1012.6));
        ArrayList<Rating> actual = ratings.getSimilarRatings("65",6,5);

        assertEquals(expected,actual);
    }
}
