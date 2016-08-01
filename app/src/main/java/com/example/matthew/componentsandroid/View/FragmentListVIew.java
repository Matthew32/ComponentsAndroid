package com.example.matthew.componentsandroid.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.matthew.componentsandroid.Controller.Adapters.AdapterTestComponent;
import com.example.matthew.componentsandroid.Controller.Persistency;
import com.example.matthew.componentsandroid.Model.TestComponents;
import com.example.matthew.componentsandroid.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matthew on 01/08/2016.
 */
public class FragmentListVIew extends Fragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_view, container, false);
        setResources();
        setResourcesFormat();
        setEvents();
        return v;
    }

    private void setEvents() {

    }

    private void setResourcesFormat() {
        lv.setAdapter(adapter);

        try {
            per.GetTest(lv, adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //load and error...
        Picasso.with(getActivity())
                .load("http://www.gamekyo.com/images_1/6a9c81cec4faf5e8cfbbadd968af27ee20140114192311.jpg")
                .placeholder(R.drawable.dragons_dogma_dark_arisen_action_rpg_105970_1920x1080)
                .error(R.drawable.border)
                .into(iv);
    }

    private void setResources() {
        lv = (ListView) v.findViewById(R.id.am_tv_ps);
        adapter = new AdapterTestComponent(getActivity(), R.layout.item_test, new ArrayList<TestComponents>());
        per = new Persistency(getActivity());
        iv = (ImageView) v.findViewById(R.id.am_iv_image);
    }

    private Persistency per;
    private AdapterTestComponent adapter;
    private ImageView iv;
    private ListView lv;
}
