package com.example.testtask.ui;

import com.example.testtask.R;
import com.example.testtask.ui.activities.NextStepActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NextStepActivityTest {

    @Rule
    public ActivityTestRule<NextStepActivity> mActivityTestRule = new ActivityTestRule<>(NextStepActivity.class);

    @Test
    public void nextStepActivityTest() throws InterruptedException {
        Thread.sleep(2000);
        Espresso.onView(withId(R.id.button_congratulation)).perform(click());
        Thread.sleep(2000);
    }
}
