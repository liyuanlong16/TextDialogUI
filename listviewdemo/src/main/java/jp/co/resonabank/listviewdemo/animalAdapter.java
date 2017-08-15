package jp.co.resonabank.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by smyhvae on 2015/5/7.
 */
public class animalAdapter extends BaseAdapter {
    private LinkedList<Animal> animalLinkedList = null;
    private Context mContext;

    //排版布局ViewHolder重用组件
    ViewHolder viewHolder = null;

    public animalAdapter(LinkedList<Animal> animalLinkedList, Context mContext) {
        this.animalLinkedList = animalLinkedList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return animalLinkedList.size();
    }

    @Override
    public Object getItem(int i) {
        return animalLinkedList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.aName = (EditText) view.findViewById(R.id.aName);
            viewHolder.aSpake = (TextView) view.findViewById(R.id.aSpake);
            viewHolder.aIcon = (ImageView) view.findViewById(R.id.aIcon);
            view.setTag(viewHolder);   //将Holder存储到convertView中
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.aName.setText(animalLinkedList.get(i).getAname());
        viewHolder.aSpake.setText(animalLinkedList.get(i).getaSpake());
        viewHolder.aIcon.setBackgroundResource(animalLinkedList.get(i).getaIcon());
        return view;
    }

    //增加数据的方法
    public void add(Animal a) {

        if (animalLinkedList.size() == 0) {
            animalLinkedList = new LinkedList<>();
        }

        animalLinkedList.add(a);
        notifyDataSetChanged();
    }

    //删除最后一条
    public void removeLast() {
        if (animalLinkedList.size() == 0) {
            animalLinkedList = new LinkedList<>();
            return;
        }

        animalLinkedList.removeLast();
        notifyDataSetChanged();
    }

    //删除指定
    public void remove(int i) {
        if (animalLinkedList.size() != 0) {
            animalLinkedList.remove(i);
            notifyDataSetChanged();
        }
    }

    //update
    public void update( int i, String str) {

        if (animalLinkedList.size() != 0) {
            animalLinkedList.get(i).setAname(str);
            notifyDataSetChanged();
        }

    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    static class ViewHolder {
        ImageView aIcon;
        EditText aName;
        TextView aSpake;
    }

}
