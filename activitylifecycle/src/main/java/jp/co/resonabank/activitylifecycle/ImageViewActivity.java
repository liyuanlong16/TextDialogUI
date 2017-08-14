package jp.co.resonabank.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG = "ImageViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onCreate");
        setContentView(R.layout.layout_image_view);

        ImageView transto =(ImageView) findViewById(R.id.transto);
        transto.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View view){
            Intent intent = new Intent(ImageViewActivity.this,AdapterViewFlipperTest.class);
            //采用Intent普通传值的方式
            //跳转Activity
            startActivity(intent);
        }

    };
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ImageViewActivity.ACTIVITY_TAG, "ImageViewActivity------onDestroy");
    }
}
