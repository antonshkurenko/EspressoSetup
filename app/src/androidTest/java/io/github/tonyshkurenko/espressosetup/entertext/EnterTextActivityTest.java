package io.github.tonyshkurenko.espressosetup.entertext;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.github.tonyshkurenko.espressosetup.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/22/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class EnterTextActivityTest {

  private static final String TEST_STRING = "test string";

  @Rule public ActivityTestRule<EnterTextActivity> mActivityRule =
      new ActivityTestRule<>(EnterTextActivity.class);

  @Test public void performInputText() {

    onView(withId(R.id.edit_text)).perform(typeText(TEST_STRING));

    onView(withId(R.id.text_view)).check(matches(withText(TEST_STRING)));
  }
}