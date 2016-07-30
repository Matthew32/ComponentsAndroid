package com.example.matthew.componentsandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.matthew.componentsandroid.Controller.Adapters.AdapterTestComponent;
import com.example.matthew.componentsandroid.Controller.Persistency;
import com.example.matthew.componentsandroid.Model.TestComponents;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonde on 30/07/2016.
 */
public class MainActivity extends AppCompatActivity {
    private Persistency per;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (ListView) findViewById(R.id.am_tv_ps);
        final AdapterTestComponent adapter = new AdapterTestComponent(this, R.layout.item_test, new ArrayList<TestComponents>());
        tv.setAdapter(adapter);
        per = new Persistency(this);

        try {
            per.GetTest(tv, adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        iv = (ImageView) findViewById(R.id.am_iv_image);

        //load and error...
        Picasso.with(this)
                .load("http://vignette3.wikia.nocookie.net/sonic/images/6/64/Sonic_The_Hedgehog_Poster.jpg/revision/latest?cb=20110430152150")
                .placeholder(R.drawable.dragons_dogma_dark_arisen_action_rpg_105970_1920x1080)
                .error(R.drawable.border)
                .into(iv);


        //tv.setAdapter(/*components.get(0).getName()*/);


    }

    private ImageView iv;
    private ListView tv;
}
