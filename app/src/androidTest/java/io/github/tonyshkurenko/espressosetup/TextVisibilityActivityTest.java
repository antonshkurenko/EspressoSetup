package io.github.tonyshkurenko.espressosetup;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/21/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

@RunWith(AndroidJUnit4.class) @SmallTest public class TextVisibilityActivityTest {

  @Rule public ActivityTestRule<TextVisibilityActivity> mActivityRule =
      new ActivityTestRule<>(TextVisibilityActivity.class);

  @Test public void helloWorldVisibility() {

    onView(withId(R.id.hello_world)).check(matches(isDisplayed()));
    onView(withText("Hello, World!")).check(matches(isDisplayed()));
  }
}