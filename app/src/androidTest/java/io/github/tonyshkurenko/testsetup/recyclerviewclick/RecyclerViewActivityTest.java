package io.github.tonyshkurenko.testsetup.recyclerviewclick;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.github.tonyshkurenko.testsetup.R;
import io.github.tonyshkurenko.testsetup.Utils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/23/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class RecyclerViewActivityTest {

  @Rule public ActivityTestRule<RecyclerViewActivity> mActivityRule =
      new ActivityTestRule<>(RecyclerViewActivity.class);

  @Test public void onRecyclerViewItemClick() throws Exception {

    onView(withId(R.id.recycler_view)).perform(
        RecyclerViewActions.actionOnItemAtPosition(2, click()));

    final RecyclerViewActivity activity = mActivityRule.getActivity();
    Utils.checkToast(activity, activity.mStringArray[2]);
  }
}