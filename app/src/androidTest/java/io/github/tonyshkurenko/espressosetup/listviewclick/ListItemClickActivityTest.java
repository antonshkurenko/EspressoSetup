package io.github.tonyshkurenko.espressosetup.listviewclick;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import io.github.tonyshkurenko.espressosetup.R;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/22/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class ListItemClickActivityTest {

  @Rule public ActivityTestRule<ListItemClickActivity> mActivityRule =
      new ActivityTestRule<>(ListItemClickActivity.class);

  String[] mStringArray;

  @Before public void setUp() {
    mStringArray = mActivityRule.getActivity().mStringArray;
  }

  @Test public void testOnItemClick_byText() throws Exception {
    // Find the adapter position to click based on
    // matching the text by index 2 to the adapter item's text
    onData(allOf(is(instanceOf(String.class)),
        is(mStringArray[2]))) // Use Hamcrest matchers to match item
        .inAdapterView(withId(R.id.list_view)) // Specify the explicit id of the ListView
        .perform(click()); // Standard ViewAction

    onView(withText(mStringArray[2])).inRoot(
        withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
        .check(matches(isDisplayed()));
  }

  @Test public void testOnItemClick_byId() throws Exception {

    // Directly specify the position in the adapter to click on
    onData(anything()) // We are using the position so don't need to specify a data matcher
        .inAdapterView(withId(R.id.list_view)) // Specify the explicit id of the ListView
        .atPosition(2) // Explicitly specify the adapter item to use
        .perform(click()); // Standard ViewAction

    onView(isAssignableFrom(Toolbar.class))
        .check(matches(withToolbarTitle(is(mStringArray[2]))));
  }

  private static ViewInteraction matchToolbarTitle(String title) {
    return onView(isAssignableFrom(Toolbar.class)).check(matches(withToolbarTitle(is(title))));
  }

  private static Matcher<Object> withToolbarTitle(final Matcher<String> textMatcher) {
    return new BoundedMatcher<Object, Toolbar>(Toolbar.class) {
      @Override public boolean matchesSafely(Toolbar toolbar) {
        return textMatcher.matches(toolbar.getTitle());
      }

      @Override public void describeTo(Description description) {
        description.appendText("with toolbar title: ");
        textMatcher.describeTo(description);
      }
    };
  }
}