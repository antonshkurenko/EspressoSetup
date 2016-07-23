package io.github.tonyshkurenko.espressosetup.activitywithparam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import io.github.tonyshkurenko.espressosetup.R;

public class WithIntentParamsActivity extends AppCompatActivity {

  public static final Bundle DEFAULT_EXTRAS = new Bundle(1);

  static final String ARGS_TEST_STRING = "args_test_string";
  static final String DEFAULT_STRING = "default_string";

  static {
    DEFAULT_EXTRAS.putString(ARGS_TEST_STRING, DEFAULT_STRING);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_with_intent_params);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    final Bundle extras = getIntent().getExtras();

    if (extras == null) {
      finish();
      return;
    }

    final String testString = extras.getString(ARGS_TEST_STRING, "");
    final TextView textView = (TextView) findViewById(R.id.text_view);
    textView.setText(testString);
  }
}
