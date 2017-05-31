package com.winnicki.mentalcalculations.model;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.winnicki.mentalcalculations.R;

import java.util.ArrayList;

public class OperationAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Operation> listOfOperations;
    private ArrayList<String> listOfStrings;

    public OperationAdapter(Context context, ArrayList<Operation> listOfOperations) {
        this.context = context;
        this.listOfOperations = listOfOperations;
        this.listOfStrings = listOfOperationsToListOfStrings(listOfOperations);
    }

    @Override
    public int getCount() {
        return listOfStrings.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfStrings.get(position);
    }

    private Operation getOperation(int i) {
        return listOfOperations.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int columnNumber = (position % 6) + 1;
        int rowNumber = (position / 6);

        if(columnNumber == 1) {
            TextView textView = new TextView(context);
            String str = (String) getItem(position);
            textView.setText(str);
            textView.setTextSize(30);
            textView.setBackgroundResource(R.drawable.left_border);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(new GridView.LayoutParams(200, 200));
            return textView;
        } else if(columnNumber == 4) {
            TextView textView = new TextView(context);
            String str = (String) getItem(position);
            textView.setText(str);
            textView.setTextSize(30);
            textView.setBackgroundResource(R.drawable.top_and_bottom_border);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(new GridView.LayoutParams(200, 200));
            return textView;
        } else if(columnNumber == 5) {
            TextView textView = new TextView(context);
            Operation operation = getOperation(rowNumber);
            textView.setText(operation.getResult());
            textView.setTextSize(30);
            textView.setBackgroundResource(R.drawable.box);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(new GridView.LayoutParams(200, 200));
            return textView;
        } else if(columnNumber == 6) {
            ImageView imageView = new ImageView(context);
            Operation operation = getOperation(rowNumber);

            switch (operation.getMark()) {
                case CORRECT:
                    imageView.setImageResource(R.drawable.correct);
                    break;
                case WRONG:
                    imageView.setImageResource(R.drawable.wrong);
                    break;
                default:
                    imageView.setImageResource(R.drawable.empty);
                    break;
            }
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        } else {
            TextView textView = new TextView(context);
            String str = (String) getItem(position);
            textView.setText(str);
            textView.setTextSize(30);
            textView.setBackgroundResource(R.drawable.top_and_bottom_border);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(new GridView.LayoutParams(200, 200));
            return textView;
        }
    }

    private ArrayList<String> listOfOperationsToListOfStrings(ArrayList<Operation> listOfOperations) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<listOfOperations.size();i++) {
            Operation operation = listOfOperations.get(i);
            arrayList.add(String.valueOf(operation.getFirstOperand()));
            arrayList.add(operation.getOperator());
            arrayList.add(String.valueOf(operation.getSecondOperand()));
            arrayList.add(operation.getEqualSign());
            arrayList.add(operation.getResult());
            arrayList.add(String.valueOf(operation.getMark()));
        }
        return arrayList;
    }
}
