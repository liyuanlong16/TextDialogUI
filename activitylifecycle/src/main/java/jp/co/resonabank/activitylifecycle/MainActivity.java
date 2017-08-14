package jp.co.resonabank.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onCreate");
        setContentView(R.layout.activity_main);
        findViewById(R.id.myEditText);
        Button pop = (Button)findViewById(R.id.btn_pop);
        pop.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View view){
//            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("入力して" )
//                    .setIcon(android.R.drawable.ic_dialog_info)
//                    .setView(new EditText(MainActivity.this))
//                    .setPositiveButton("はい" , null)
//                    .setNegativeButton("いいえ" ,  null )
//                    .show();
//            dialog.setCanceledOnTouchOutside(false);// Dialog不消失
            Intent intent = new Intent(MainActivity.this,ImageViewActivity.class);
            //采用Intent普通传值的方式
            //跳转Activity
            startActivity(intent);
        }

    };
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onDestroy");
    }
}
