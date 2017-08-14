package jp.co.resonabank.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AdapterViewFlipperTest extends AppCompatActivity {

    int[] imageIds = new int[]
            {
                    R.drawable.yi, R.drawable.er,
                    R.drawable.san, R.drawable.si, R.drawable.wu,
                    R.drawable.liu, R.drawable.seven, R.drawable.eight
            };
    AdapterViewFlipper flipper;
    Button backButton, stopButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_test);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(backLister);

        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(stopLister);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(nextLister);

        // 创建一个BaseAdapter对象，该对象负责提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            // 该方法的返回的View就是代表了每个列表项
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // 创建一个ImageView
                ImageView imageView = new ImageView(AdapterViewFlipperTest.this);
                imageView.setImageResource(imageIds[position]);
                // 设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                // 为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    //
    View.OnClickListener stopLister = new View.OnClickListener() {

        public void onClick(View view) {
            if (stopButton.getText().toString().equals("始める")) {
                // 自動的に開始
                flipper.startFlipping();
                stopButton.setText("止める");
                Toast.makeText(AdapterViewFlipperTest.this, "自動的に開始してる", Toast.LENGTH_SHORT);
            } else {
                // 停止
                flipper.stopFlipping();
                stopButton.setText("始める");
                Toast.makeText(AdapterViewFlipperTest.this, "停止", Toast.LENGTH_SHORT);

            }
        }

    };

    View.OnClickListener backLister = new View.OnClickListener() {

        public void onClick(View view) {
            // 显示上一个组件
            flipper.showPrevious();
            // 停止自动播放
//            flipper.stopFlipping();
        }

    };
    View.OnClickListener nextLister = new View.OnClickListener() {

        public void onClick(View view) {
            // 显示下一个组件。
            flipper.showNext();
            // 停止自动播放
//            flipper.stopFlipping();
        }

    };

    public void prev(View source) {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void next(View source) {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void auto(View source) {
        // 开始自动播放
        flipper.startFlipping();
    }
}
