package com.example.testtask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class TestValidToken {
    private long mTimeStamp = 1549112486075L;

    @Test
    public void testRefreshToken(){
        Calendar currentDate = Calendar.getInstance();
        Calendar lastRequestDate = Calendar.getInstance();
        lastRequestDate.setTimeInMillis(mTimeStamp);
        long dayDifference = currentDate.getTimeInMillis() - lastRequestDate.getTimeInMillis();
        long days = TimeUnit.MILLISECONDS.toDays(dayDifference);
        assertEquals(true,days > 1);
    }
}
