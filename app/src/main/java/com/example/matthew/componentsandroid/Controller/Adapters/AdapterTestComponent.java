package com.example.matthew.componentsandroid.Controller.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.matthew.componentsandroid.Model.TestComponents;
import com.example.matthew.componentsandroid.R;

import java.util.List;

/**
 * Created by gonde on 30/07/2016.
 */
public class AdapterTestComponent extends ArrayAdapter<TestComponents> {

    public AdapterTestComponent(Context context, int resource) {
        super(context, resource);
    }

    public AdapterTestComponent(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public AdapterTestComponent(Context context, int resource, TestComponents[] objects) {
        super(context, resource, objects);
    }

    public AdapterTestComponent(Context context, int resource, int textViewResourceId, TestComponents[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public AdapterTestComponent(Context context, int resource, List<TestComponents> objects) {
        super(context, resource, objects);
    }

    public AdapterTestComponent(Context context, int resource, int textViewResourceId, List<TestComponents> objects) {
        super(context, resource, textViewResourceId, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_test, parent, false);
        //TextView id = (TextView) rowView.findViewById(R.id.it_tv_asd);
        TextView name = (TextView) rowView.findViewById(R.id.it_tv_name);
        TextView password = (TextView) rowView.findViewById(R.id.it_tv_password);
       // id.setText(getItem(position).getId());
        name.setText(getItem(position).getName());
        password.setText(getItem(position).getPassword());
        return rowView;
    }

}
