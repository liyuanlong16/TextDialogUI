package jp.co.resonabank.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText edt;
    private int deleteNum;

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

    }


    //添加一条数据
    View.OnClickListener messageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.addAnimal:
                    //do something
                    mData.add(new Animal((aAdapter.getCount() + 1) + "", "こちらは" + (aAdapter.getCount() + 1), R.drawable.san));
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
            EditText ed = (EditText)view.findViewById(R.id.aName);
            Toast.makeText(MainActivity.this, ed.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    };

    //    View view = null ;
//    int i = 0;
    //長按删除
    AdapterView.OnItemLongClickListener animalListViewLogClickListener = new AdapterView.OnItemLongClickListener() {


        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                    PopupList popupList = new PopupList(view.getContext());
                    popupList.showPopupListWindow(view, i, mRawX, mRawY, popupMenuItemList, new PopupList.PopupListListener() {
                        @Override
                        public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                            return true;//false时 弹框不出现
                        }


                        @Override
                        public void onPopupListClick(View contextView,   int contextPosition, int position) {
                            Toast.makeText(contextView.getContext(), contextPosition + "," + position, Toast.LENGTH_SHORT).show();
                            if (position == 0) {//delete
                                aAdapter.remove(contextPosition);
                            }
                            if(position == 1) {//update
                                //contextView 可以拿到点击的view然后通过view得到控件去进行操作
                                setAlertDialog(contextView,contextPosition);
                            }
                        }
            });

            return true;//false时长按后弹框出现的同时 也执行了单击的响应事件
        }

    };

    private void setAlertDialog(View view,  int contextPosition) {
        edt = new EditText(mcontext);
        EditText ed = (EditText)view.findViewById(R.id.aName);
        edt.setText(ed.getText().toString());
        deleteNum = contextPosition;
        new  AlertDialog.Builder(mcontext)
                .setTitle("请输入" )
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(edt)
                .setPositiveButton("确定", delOn)
                .setNegativeButton("取消" ,  null )
                .show();
    }
    DialogInterface.OnClickListener delOn = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            aAdapter.update(deleteNum,edt.getText().toString());
        }

};
}
