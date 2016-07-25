package io.github.tonyshkurenko.testsetup.listviewclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import io.github.tonyshkurenko.testsetup.R;

public class ListItemClickActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener {

  String[] mStringArray;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_item_click);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    final ListView listView = (ListView) findViewById(R.id.list_view);

    if (listView != null) {
      mStringArray = getResources().getStringArray(R.array.dummy_data);
      listView.setAdapter(
          new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
              mStringArray));

      listView.setOnItemClickListener(this);
    }
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    final String text = mStringArray[position];

    Toast.makeText(ListItemClickActivity.this, text, Toast.LENGTH_SHORT).show();
    setTitle(text);
  }
}
