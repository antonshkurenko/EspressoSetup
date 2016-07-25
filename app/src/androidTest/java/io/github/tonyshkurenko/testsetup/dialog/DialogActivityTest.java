package io.github.tonyshkurenko.testsetup.dialog;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.github.tonyshkurenko.testsetup.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/22/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class DialogActivityTest {

  @Rule public ActivityTestRule<DialogActivity> mActivityRule =
      new ActivityTestRule<>(DialogActivity.class);

  @Test public void testShowDialog() throws Exception {
    onView(withId(R.id.button)).perform(click());

    onView(withText(DialogActivity.TEST_DIALOG)).check(matches(isDisplayed()));
  }
}