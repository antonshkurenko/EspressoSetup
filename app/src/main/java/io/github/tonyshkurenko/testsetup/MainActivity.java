package io.github.tonyshkurenko.testsetup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import io.github.tonyshkurenko.testsetup.activitywithparam.WithIntentParamsActivity;
import io.github.tonyshkurenko.testsetup.cameraintent.CameraIntentActivity;
import io.github.tonyshkurenko.testsetup.dialog.DialogActivity;
import io.github.tonyshkurenko.testsetup.entertext.EnterTextActivity;
import io.github.tonyshkurenko.testsetup.listviewclick.ListItemClickActivity;
import io.github.tonyshkurenko.testsetup.recyclerviewclick.RecyclerViewActivity;
import io.github.tonyshkurenko.testsetup.startnewactivity.StartNewActivity;
import io.github.tonyshkurenko.testsetup.textvisibility.TextVisibilityActivity;

// todo(@tonyshkurenko), 7/24/16: okhttp idling resource
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

  static final Demo[] DEMOS = new Demo[] {
      new Demo("Text visibility activity", TextVisibilityActivity.class),
      new Demo("List item click activity", ListItemClickActivity.class),
      new Demo("Enter text activity", EnterTextActivity.class),
      new Demo("Dialog activity", DialogActivity.class),
      new Demo("Recycler view activity", RecyclerViewActivity.class),
      new Demo("Camera intent activity", CameraIntentActivity.class),
      new Demo("With intent params activity", WithIntentParamsActivity.class,
          WithIntentParamsActivity.DEFAULT_EXTRAS),
      new Demo("Start second activity", StartNewActivity.class)
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ListView listView = (ListView) findViewById(R.id.list_view);

    if (listView != null) {
      listView.setAdapter(
          new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, DEMOS));

      listView.setOnItemClickListener(this);
    }
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    final Demo demo = DEMOS[position];
    final Intent intent = new Intent(this, demo.activity);

    if (demo.extras != null) {
      startActivity(intent.putExtras(demo.extras));
    }

    startActivity(intent);
  }

  static class Demo {
    final String name;
    final Class<? extends Activity> activity;
    final Bundle extras;

    public Demo(String name, Class<? extends Activity> activity) {
      this(name, activity, null);
    }

    public Demo(String name, Class<? extends Activity> activity, Bundle extras) {
      this.name = name;
      this.activity = activity;
      this.extras = extras;
    }

    @Override public String toString() {
      return name;
    }
  }
}
