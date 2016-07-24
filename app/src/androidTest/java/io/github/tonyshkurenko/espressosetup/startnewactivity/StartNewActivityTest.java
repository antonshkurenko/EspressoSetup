package io.github.tonyshkurenko.espressosetup.startnewactivity;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.github.tonyshkurenko.espressosetup.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/24/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class StartNewActivityTest {

  @Rule public ActivityTestRule<StartNewActivity> mActivityRule =
      new ActivityTestRule<>(StartNewActivity.class);

  @Test public void testStartNewActivity() throws Exception {
    onView(withId(R.id.button)).perform(click());

    onView(withId(R.id.text_view)).check(matches(withText(R.string.second_activity)));
  }

  @Test public void testStartNewActivity_backPress() throws Exception {
    onView(withId(R.id.button)).perform(click());

    onView(withId(R.id.text_view)).check(matches(withText(R.string.second_activity)));

    pressBack();

    onView(withId(R.id.button)).check(matches(isDisplayed()));
  }
}