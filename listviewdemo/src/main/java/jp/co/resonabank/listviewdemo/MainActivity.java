package jp.co.resonabank.listviewdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView animalListView = null;
    private animalAdapter aAdapter = null;
    private Context mcontext;
    private List<Animal> mData = null;
    private List<String> popupMenuItemList = new ArrayList<>();

    private float mRawX;
    private float mRawY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalListView = (ListView) findViewById(R.id.animalListView);
        Button addAnimal = (Button) findViewById(R.id.addAnimal);
        addAnimal.setOnClickListener(messageListener);
        Button removeAnimal = (Button) findViewById(R.id.removeAnimal);
        removeAnimal.setOnClickListener(messageListener);
        mcontext = MainActivity.this;
        mData = new LinkedList<Animal>();
        mData.add(new Animal("壹", "こちらは壹", R.drawable.yi));
        mData.add(new Animal("贰", "こちらは贰", R.drawable.er));
        mData.add(new Animal("叁", "こちらは叁", R.drawable.san));
        aAdapter = new animalAdapter((LinkedList<Animal>) mData, mcontext);
        animalListView.setAdapter(aAdapter);

        animalListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mRawX = event.getRawX();
                mRawY = event.getRawY();
                return false;
            }
        });

        animalListView.setOnItemClickListener(animalListViewListener);
        animalListView.setOnItemLongClickListener(animalListViewLogClickListener);

        popupMenuItemList.add("delete");
        popupMenuItemList.add("update");

//        PopupList popupList = new PopupList(this);
//        popupList.bind(animalListView, popupMenuItemList, new PopupList.PopupListListener() {
//            @Override
//            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
//                return true;
//            }
//
//
//            @Override
//            public void onPopupListClick(View contextView, int contextPosition, int position) {
//                Toast.makeText(MainActivity.this, contextPosition + "," + position, Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    //添加一条数据
    View.OnClickListener messageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.addAnimal:
                    //do something
                    aAdapter.add(new Animal((aAdapter.getCount() + 1) + "", "こちらは" + (aAdapter.getCount() + 1), R.drawable.san));
                    break;
                case R.id.removeAnimal:
                    //do something
                    aAdapter.removeLast();
                    break;
            }
        }
    };
    AdapterView.OnItemClickListener animalListViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, mData.get(i).getaSpake(), Toast.LENGTH_SHORT).show();
        }
    };
    //長按删除
    AdapterView.OnItemLongClickListener animalListViewLogClickListener = new AdapterView.OnItemLongClickListener() {


        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


            PopupList popupList = new PopupList(view.getContext());
            popupList.showPopupListWindow(view, i, mRawX, mRawY, popupMenuItemList, new PopupList.PopupListListener() {
                @Override
                public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                    return true;
                }


                @Override
                public void onPopupListClick(View contextView, int contextPosition, int position) {
                    Toast.makeText(contextView.getContext(), contextPosition + "," + position, Toast.LENGTH_SHORT).show();
                    if (position == 0) {//delete
                        aAdapter.remove(contextPosition);
                    }
                }
            });
            return true;
        }

    };

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        float mRawX = event.getX();
//        float mRawY = event.getY();
//
//        return false;
//    }

}
