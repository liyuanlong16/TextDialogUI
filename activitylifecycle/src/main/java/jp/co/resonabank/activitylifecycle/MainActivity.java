package jp.co.resonabank.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
/**
 * activity的周期
 * activity的传值跳转
 * 输入框的自动补全AutoCompleteTextView的控件
 * 图片拉伸变形的解决方法
 * 自动播放图片的幻灯片效果(带有下一张 上一张 停止 播放效果)
 * **/

public class MainActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG = "MainActivity";
    private RadioButton manRadioButton, womenRadioButton;
    private EditText myEditText;
    private AutoCompleteTextView inputAutoCompleteTextView;

    private static final String[] AUTOINPUT = new String []{"a","abc","abcd","abcde","ba"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(MainActivity.ACTIVITY_TAG, "MainActivity------onCreate");
        setContentView(R.layout.activity_main);
//        myEditText = (EditText)findViewById(R.id.myEditText);
        Button pop = (Button) findViewById(R.id.btn_pop);
        pop.setOnClickListener(listener);
        manRadioButton = (RadioButton) findViewById(R.id.manRadioButton);
        womenRadioButton = (RadioButton) findViewById(R.id.womenRadioButton);

        inputAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.inputAutoCompleteTextView);
        ArrayAdapter aa = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,AUTOINPUT);
        inputAutoCompleteTextView.setAdapter(aa);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View view) {
            //信息捎带的跳转
            Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
            //采用Intent普通传值的方式
            Bundle bundle = new Bundle();
            bundle.putString("name",inputAutoCompleteTextView.getText().toString());
            if(manRadioButton.isChecked()){
                bundle.putString("sex","男");
            }else{
                bundle.putString("sex","女");
            }
            intent.putExtras(bundle);
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
