package com.winnicki.mentalcalculations.model;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winnicki.mentalcalculations.R;

import java.util.ArrayList;

public class OperationAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> listOfCharacters;

    public OperationAdapter(Context context, ArrayList<String> listOfCharacters) {
        this.context = context;
        this.listOfCharacters = listOfCharacters;
    }

    @Override
    public int getCount() {
        return listOfCharacters.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfCharacters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (position) {
            case 4:
            case 10:
            case 16:
            case 22:
            case 28:
                TextView textView = new TextView(context);
                String character = (String) getItem(position);
                textView.setText(character);
                textView.setTextSize(30);
                textView.setBackgroundResource(R.drawable.box);
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(new GridView.LayoutParams(200, 200));
                return textView;
            case 5:
            case 11:
            case 17:
            case 23:
            case 29:
                ImageView imageView = new ImageView(context);
                String mark = (String)getItem(position);
                if(mark.equals("good")) {
                    imageView.setImageResource(R.drawable.good);
                } else if(mark.equals("bad")) {
                    imageView.setImageResource(R.drawable.wrong);
                } else {
                    imageView.setImageResource(R.drawable.empty);
                }
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            default:
                textView = new TextView(context);
                character = (String) getItem(position);
                textView.setText(character);
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(new GridView.LayoutParams(200, 200));
                return textView;
        }
    }
}
