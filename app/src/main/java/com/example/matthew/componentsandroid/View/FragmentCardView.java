package com.example.matthew.componentsandroid.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matthew.componentsandroid.Controller.Adapters.CardViewAdapter;
import com.example.matthew.componentsandroid.R;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

/**
 * Created by matthew on 03/08/2016.
 */
public class FragmentCardView extends Fragment {
    private View v;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private CardViewAdapter cvAdapter;
    private String[] myDataset = new String[]{"Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.", "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.", "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.", "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.", "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_card_view, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());

        RecyclerView.ItemDecoration itemDecoration = new
                MaterialViewPagerHeaderDecorator();
        mRecyclerView
                .addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        cvAdapter = new CardViewAdapter(myDataset);
        mRecyclerView.setAdapter(cvAdapter);

        return v;
    }

}
