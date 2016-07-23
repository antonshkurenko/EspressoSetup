package io.github.tonyshkurenko.espressosetup.dialog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import io.github.tonyshkurenko.espressosetup.R;

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
