package com.example.goodcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<OperationClass> ops;
    LayoutInflater inflter;

    public CustomAdapter( Context context , ArrayList<OperationClass> ops )
    {
        this.context = context;
        this.ops = ops;
        inflter = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return ops.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflter.inflate( R.layout.list_view , null );
        TextView date = (TextView)view.findViewById(R.id.date);
        TextView exp = (TextView)view.findViewById(R.id.exp);
        TextView res = (TextView)view.findViewById(R.id.result);

        date.setText(ops.get(i).getTimestamp());
        exp.setText(ops.get(i).getExpression());
        res.setText(ops.get(i).getResult());

        return view;
    }
}
