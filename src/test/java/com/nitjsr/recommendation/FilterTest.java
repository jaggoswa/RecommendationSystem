package com.nitjsr.recommendation;
import org.junit.Assert;

import org.junit.Test;

public class FilterTest {
    @Test
    public void directorFilterTest() {
        DirectorsFilter dir_filter = new DirectorsFilter("Fred Cavayé");
        Assert.assertEquals(true, dir_filter.satisfies("3112654"));
        Assert.assertEquals(false, dir_filter.satisfies("1571222"));
    }
}
