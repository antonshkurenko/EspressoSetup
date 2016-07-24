package io.github.tonyshkurenko.espressosetup.cameraintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import io.github.tonyshkurenko.espressosetup.R;

public class CameraIntentActivity extends AppCompatActivity {

  static final int REQUEST_IMAGE_CAPTURE = 1;
  private ImageView mImageView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera_intent);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    mImageView = (ImageView) findViewById(R.id.image_view);
  }

  // Get the returned bitmap
  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
      final Bundle extras = data.getExtras();
      final Bitmap imageBitmap = (Bitmap) extras.get("data");
      mImageView.setImageBitmap(imageBitmap);
    }
  }

  public void openCameraIntent(View view) {
    final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
  }
}
