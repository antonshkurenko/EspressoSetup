package io.github.tonyshkurenko.espressosetup;

import android.app.Activity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/23/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class Utils {

  private Utils() {
    throw new UnsupportedOperationException("No instances");
  }

  public static void checkToast(Activity activity, String toastMessage) {
    onView(withText(toastMessage)).inRoot(withDecorView(not(activity.getWindow().getDecorView())))
        .check(matches(isDisplayed()));
  }
}
