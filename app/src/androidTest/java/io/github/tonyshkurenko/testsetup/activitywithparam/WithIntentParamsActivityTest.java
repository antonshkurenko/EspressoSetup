package io.github.tonyshkurenko.testsetup.activitywithparam;

import android.content.Intent;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.github.tonyshkurenko.testsetup.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/23/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class WithIntentParamsActivityTest {

  @Rule public ActivityTestRule<WithIntentParamsActivity> mActivityRule =
      new ActivityTestRule<>(WithIntentParamsActivity.class, true, false);

  @Test public void testOpenActivity() throws Exception {

    final Intent intent = new Intent();
    intent.putExtra(WithIntentParamsActivity.ARGS_TEST_STRING,
        WithIntentParamsActivity.DEFAULT_STRING);
    mActivityRule.launchActivity(intent);

    onView(withId(R.id.text_view)).check(
        matches(withText(WithIntentParamsActivity.DEFAULT_STRING)));
  }
}