package io.github.tonyshkurenko.testsetup.dialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import io.github.tonyshkurenko.testsetup.R;

public class DialogActivity extends AppCompatActivity {

  static final String TEST_DIALOG = "test dialog";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  public void showDialog(View view) {
    new AlertDialog.Builder(this).setTitle(TEST_DIALOG).show();
  }
}
