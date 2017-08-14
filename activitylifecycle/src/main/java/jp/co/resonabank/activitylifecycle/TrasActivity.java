package jp.co.resonabank.activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrasActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onCreate");
        setContentView(R.layout.activity_main);
        EditText myEditText =(EditText) findViewById(R.id.myEditText);
        myEditText.setVisibility(View.GONE);
        Button pop = (Button)findViewById(R.id.btn_pop);
        pop.setOnClickListener(listener);
        pop.setVisibility(View.GONE);
        TextView myTextView = (TextView)findViewById(R.id.myTextView);
        myTextView.setVisibility(View.VISIBLE);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View view){
            AlertDialog dialog = new AlertDialog.Builder(TrasActivity.this)
                    .setTitle("入力して" )
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(new EditText(TrasActivity.this))
                    .setPositiveButton("はい" , null)
                    .setNegativeButton("いいえ" ,  null )
                    .show();
            dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        }

    };
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TrasActivity.ACTIVITY_TAG, "TrasActivity------onDestroy");
    }
}
