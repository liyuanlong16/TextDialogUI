package jp.co.resonabank.listviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView animalListView = null;
    private animalAdapter aAdapter = null;
    private Context mcontext;
    private List<Animal> mData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalListView =(ListView) findViewById(R.id.animalListView);
        mcontext = MainActivity.this;
        mData = new LinkedList<Animal>();
        mData.add(new Animal("壹","こちらは壹",R.drawable.yi));
        mData.add(new Animal("贰","こちらは贰",R.drawable.er));
        mData.add(new Animal("叁","こちらは叁",R.drawable.san));
        aAdapter = new animalAdapter((LinkedList<Animal>)mData,mcontext);
        animalListView.setAdapter(aAdapter);
        animalListView.setOnItemClickListener(animalListViewListener);
    }

    AdapterView.OnItemClickListener animalListViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this,mData.get(i).getaSpake(),Toast.LENGTH_SHORT).show();
        }
    };

}
