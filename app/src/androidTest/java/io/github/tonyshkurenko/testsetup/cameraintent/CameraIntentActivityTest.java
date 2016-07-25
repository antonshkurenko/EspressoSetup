package io.github.tonyshkurenko.testsetup.cameraintent;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;
import io.github.tonyshkurenko.testsetup.R;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by: Anton Shkurenko (tonyshkurenko)
 * Project: EspressoSetup
 * Date: 7/23/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class CameraIntentActivityTest {

  // IntentsTestRule is an extension of ActivityTestRule. IntentsTestRule sets up Espresso-Intents
  // before each Test is executed to allow stubbing and validation of intents.
  @Rule public IntentsTestRule<CameraIntentActivity> intentsRule =
      new IntentsTestRule<>(CameraIntentActivity.class);

  @Test public void testOpenCameraIntent() throws Exception {

    // Create a bitmap we can use for our simulated camera image
    final Bitmap icon =
        BitmapFactory.decodeResource(InstrumentationRegistry.getTargetContext().getResources(),
            R.mipmap.ic_launcher);

    // Build a result to return from the Camera app
    final Intent resultData = new Intent();
    resultData.putExtra("data", icon);
    final Instrumentation.ActivityResult result =
        new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

    // Stub out the Camera. When an intent is sent to the Camera, this tells Espresso to respond
    // with the ActivityResult we just created
    //intending(toPackage("com.android.camera2")).respondWith(result);
    intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result);

    // Now that we have the stub in place,
    // click on the button in our app that launches into the Camera
    onView(withId(R.id.button)).perform(click());

    // We can also validate that an intent
    // resolving to the "camera" activity has been sent out by our app
    //intended(toPackage("com.android.camera2"));
    intended(hasAction(MediaStore.ACTION_IMAGE_CAPTURE));

    onView(withId(R.id.image_view)).check(matches(withImageBitmap(is(icon))));
  }

  private static Matcher<Object> withImageBitmap(final Matcher<Bitmap> bitmapMatcher) {
    return new BoundedMatcher<Object, ImageView>(ImageView.class) {
      @Override public boolean matchesSafely(ImageView imageView) {
        return bitmapMatcher.matches(((BitmapDrawable) imageView.getDrawable()).getBitmap());
      }

      @Override public void describeTo(Description description) {
        description.appendText("with image bitmap: ");
        bitmapMatcher.describeTo(description);
      }
    };
  }
}